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

    <h5>Products list</h5>
    <#list products as pr,prc>
    <div class="container mb-4">
        <div class="row">
            <div class="col-12">
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th scope="col"> </th>
                            <th scope="col">Product</th>
                            <th scope="col">Available</th>
                            <th scope="col" class="text-center">Quantity</th>
                            <th scope="col" class="text-right">Price</th>
                            <th> </th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><img src="${pr.imagesrc}" /> </td>
                            <td>${pr.productName}</td>
                            <td>Yes</td>
                            <td>${pr.quantity}</td>-->
                            <td class="text-right">${pr.price}</td>
                            <td class="text-right">
                            <form action="/cart/remove/${pr.id}/" method="get">
                                <button class="btn btn-sm btn-danger" type="submit">Delete</button>
                            </form>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    </#list>
    <form action="/cart/clear" method="get">
        <button class="btn btn-primary" type="submit">Clear Cart</button>
    </form>


    <div class="container1">
        <div id ="insertuser">
            <form action="/shop">
                <button type="submit" class="btn btn-primary">Shop</button>
            </form>
            <form action="/logout">
                <button type="submit" class="btn btn-primary">Log out</button>
            </form>
        </div>
    </div>
</div>


</body>
</html>