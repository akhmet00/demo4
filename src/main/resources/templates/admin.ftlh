<!Doctype html>
<html>
<head>
    <title>Main</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <style>
        img {
            width: 200px; /* You can set the dimensions to whatever you want */
            height: 200px;
            object-fit: cover;
        }

    </style>
</head>
<body>

<div class="container">

    <h5>Admin panel</h5>

    <div class="container1">
        <div id ="insertuser">
            <h5>Product editor</h5>
            <form action="/admin/products">
                <button type="submit" class="btn btn-primary">Products</button>
            </form>
        </div>
    </div>
    <div class="container1">
        <div id ="insertuser">
            <h5>User editor</h5>
            <form action="/admin/users">
                <button type="submit" class="btn btn-primary">Users</button>
            </form>
        </div>
    </div>


    <div class="container1">
        <div id ="insertuser">
            <form action="/logout">
                <button type="submit" class="btn btn-primary">Log out</button>
            </form>
        </div>
    </div>
</div>


</body>
</html>