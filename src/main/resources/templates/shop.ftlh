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


    <#list products as pr>
    <div class="row">
        <div class="col-md-3">
            <figure class="card card-product">
                <div class="img-wrap">
                    <img src="${pr.imagesrc}"><br>
                    <a class="btn-overlay" href="#"><i class="fa fa-search-plus"></i> Quick view</a>
                </div>
                <figcaption class="info-wrap">
                    <h6 class="title text-dots"><a href="#">${pr.productName}</a></h6>
                    <div class="action-wrap">
                        <form action="/cart/add/${pr.getId()}" method="get">
                            <button class="btn btn-primary btn-sm float-right" type="submit"> Order </button>
                        </form>
                        <div class="price-wrap h5">
                            <span class="price-new">${pr.price}</span>
<#--                            <del class="price-old">$1980</del>-->
                        </div> <!-- price-wrap.// -->
                    </div> <!-- action-wrap -->
                </figcaption>
            </figure> <!-- card // -->
        </div>
    </div>
    </#list>



    <div class="container1">
        <div id ="insertuser">
            <h5>Add New User</h5>
            <form action="/logout">
                <button type="submit" class="btn btn-primary">Log out</button>
            </form>
        </div>
    </div>
</div>


</body>
</html>