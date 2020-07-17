package com.example.demo.Controller;

import com.example.demo.model.Products;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.PersistenceException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductRestController {

    private static final Logger logger = LoggerFactory.getLogger(ProductRestController.class);

    @Autowired
    private  ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }


    @RequestMapping(value = "/admin/products", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Products>> listAllProducts() {
        List<Products> products;

        try {
            products = productRepository.findAll();
        } catch (PersistenceException e) {
            return new ResponseEntity<>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (products.isEmpty()) {
            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/products/new/file", method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity newFile(@RequestParam("file") MultipartFile file) throws IOException {
        Path root = Paths.get("src/main/webapp/resources/images");
        File convertFile = new File(root+"/"+file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        logger.debug(String.format("File with name: %s successfully added to directory: %s", file.getOriginalFilename(), root));
        return ResponseEntity.ok("File added successfully");
    }

    @RequestMapping(value = "/admin/products/new", method = RequestMethod.POST,
                    consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity newProduct(@RequestBody Products products,
                                     BindingResult bindingResult,
                                     Model model){
        if (bindingResult.hasErrors()) {
            logger.error(String.valueOf(bindingResult.getFieldError()));
        }
        productService.save(products);
        logger.debug(String.format("Product with id: %s successfully created.", products.getId()));
        Map<Object, Object> response = new HashMap<>();
        response.put("products", products);
        return ResponseEntity.ok(response);

    }


    @RequestMapping(value = "/admin/products/edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Products> editProducts(@PathVariable("id") long id,
                                                 @RequestBody Products products)
    {
        try {
            productService.edit(id,products);
            logger.debug(String.format("Product with id: %s successfully edited",id));
        } catch (PersistenceException e) {
            return new ResponseEntity<>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @RequestMapping(value = "/admin/products/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Products> deleteProduct(@PathVariable("id") long id)
    {
        try {
            Products products = productService.findById(id);

            if (products == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            productService.delete(id);
            logger.debug(String.format("Product with if: %s successfully deleted",id));
        } catch (PersistenceException e) {
            return new ResponseEntity<>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
