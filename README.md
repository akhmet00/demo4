# demo4

# mysql table create

```mysql
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `imagesrc` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```
# Insert products

```mysql
INSERT INTO `` (`id`,`product_name`,`price`,`imagesrc`,`type`) VALUES (1,'Naruto',1040,'images/image.jpg','manga');
INSERT INTO `` (`id`,`product_name`,`price`,`imagesrc`,`type`) VALUES (2,'One Piece',2000,'images/image.jpg','manga');
INSERT INTO `` (`id`,`product_name`,`price`,`imagesrc`,`type`) VALUES (3,'OreGairu',2500,'images/image.jpg','manga');
INSERT INTO `` (`id`,`product_name`,`price`,`imagesrc`,`type`) VALUES (4,'Tower of God',1500,'images/image.jpg','manhua');
INSERT INTO `` (`id`,`product_name`,`price`,`imagesrc`,`type`) VALUES (5,'WindBreaker',1760,'images/image.jpg','manhua');
INSERT INTO `` (`id`,`product_name`,`price`,`imagesrc`,`type`) VALUES (6,'Owari no Seraph',1600,'images/image.jpg','manga');
INSERT INTO `` (`id`,`product_name`,`price`,`imagesrc`,`type`) VALUES (7,'Seraph of the End',1100,'images/image.jpg','manga');
INSERT INTO `` (`id`,`product_name`,`price`,`imagesrc`,`type`) VALUES (8,'Secret love',2100,'images/image.jpg','manhua');
INSERT INTO `` (`id`,`product_name`,`price`,`imagesrc`,`type`) VALUES (9,'Fairy Tail',2150,'images/image.jpg','manga');
INSERT INTO `` (`id`,`product_name`,`price`,`imagesrc`,`type`) VALUES (10,'Dragonball',3500,'images/image.jpg','manga');
INSERT INTO `` (`id`,`product_name`,`price`,`imagesrc`,`type`) VALUES (11,'White blood',780,'images/image.jpg','manhua');
INSERT INTO `` (`id`,`product_name`,`price`,`imagesrc`,`type`) VALUES (12,'Nan Hao',970,'images/image.jpg','manhua');
```
# Users table create

```mysql
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roles` varchar(45) DEFAULT 'ROLE_USER',
  `active` tinyint DEFAULT NULL,
  `companyname` varchar(45) DEFAULT NULL,
  `money` int DEFAULT '10000',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```
```mysql
INSERT INTO `` (`id`,`user_name`,`password`,`roles`,`active`,`companyname`,`money`) VALUES (1,'kek','$2a$12$uavs/zM.p87UmXsVV.eNR.1hvD6XHImUB98OStJYksrjTVzs/IhyG','ROLE_ADMIN',1,'gexabyte',10000);
INSERT INTO `` (`id`,`user_name`,`password`,`roles`,`active`,`companyname`,`money`) VALUES (9,'we','$2a$08$9xOkCMKOQiIZGOEQXk7xrObcTyS5VkswpyImzf2p1SJeB7EcO2QZq','ROLE_USER',1,'agindata',10000);
```

# login - password - are same

## edit schema name at application properties file






# REST

to login make POST request /restlogin 
body: 
```json
{
"userName":"kek",
"password":"kek"
}
```
Copy bearer token and add key to header

Key: Authorization Value: Bearer_'token'

![GitHub Logo](https://sun9-40.userapi.com/c857424/v857424764/2206e8/W6dwwvKMb9g.jpg)


# Output all products
/admin/products method GET
# Output all users
/admin/users method GET

# Add new product 
/admin/producst/new method POST
Body:
```json
 {
        "productName": "Naruto",
        "type": "manga",
        "price": 1040,
        "imagesrc": "images/image.jpg"
    }
```
# Delete product by id
/admin/products/delete/{id} method DELETE

# Edit product by id
/admin/products/edit/{id} method PUT
   Body:
```json
 {
        "id": id,
        "productName": "Naruto",
        "type": "manga",
        "price": 1040,
        "imagesrc": "images/image.jpg"
    }
```
    
  # User controller
  # Output all users
  /admin/users method GET
  
 # Add new user
  /admin/users/new method POST
  Body:
```json
  {
        "userName": "test",
        "password": "test",
        "active": true,
        "roles": "ROLE_ADMIN",
        "companyname": "gexabyte",
        "money": 10000
    }
 ```
  
  # Delete user 
  /admin/users/delete/{id} method DELETE
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  # Preview
  
 ![GitHub Logo](https://sun9-69.userapi.com/c857424/v857424764/2206f2/A2l2lxsiBDU.jpg)
 
 ![GitHub Logo](https://sun9-45.userapi.com/c857424/v857424764/2206fc/YDlk-RE51kg.jpg)
 
 ![GitHub Logo](https://sun9-7.userapi.com/c857424/v857424764/220706/5He7l6pvCWU.jpg)
  
  
