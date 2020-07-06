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

    <h5>User list</h5>
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
                            <form action="/admin/products/delete/" method="post">
                                <button class="btn btn-danger btn-sm" type="submit">Delete</button>
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

    <form action="/admin/products/new" method="get">
        <button type="submit" class="btn btn-primary">Add product</button>
    </form>

</div>
<div class="col-sm-7" id="postResultDiv">
</div>

</body>
</html>