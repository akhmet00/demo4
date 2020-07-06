<!Doctype html>
<html>
<head>
    <title>MyBatis</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <style>
        .container{
            margin-top: 10px;
            max-width: 750px;
            margin-right: 350px;
        }
        .container1 {
            margin-top: 10px;
            max-width:750px;
        }
    </style>

</head>
<body>

<div class="container">

    <div class="container1">
        <div id ="insertuser">
            <h5>Add New Product</h5>
            <form action="/admin/products/new" method="post"  id="insert_form">
                Product name:<br/>
                <input type="text" class="form-control" name="productName" required/>
                <br/>
                Price:<br/>
                <input type="text" class="form-control" name="price" required/>
                <br/>
                Quantity:<br/>
                <input type="text" class="form-control" name="quantity" required/>
                <br/>
                Photo:<br/>
                <input type="file" class="form-control" name="photo" required/>
                <br/>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form><br>
        </div>
    </div>
</div>
<div class="col-sm-7" id="postResultDiv">
</div>

</body>
</html>