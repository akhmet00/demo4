<!DOCTYPE html>
<html lang="zxx">

<head>
    <base href="/">
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Manga shop</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- Css Styles -->

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/elegant-icons.css">
    <link rel="stylesheet" href="css/nice-select.css">
    <link rel="stylesheet" href="css/jquery-ui.min.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/slicknav.min.css">
    <link rel="stylesheet" href="css/style.css">

    <style>
        a {
            color: #7fad39;
        }
        a:hover {
            color: black;
        }
    </style>
</head>

<body>
<!-- Header Section Begin -->
<header class="header">
    <div class="header__top">
        <div class="container">
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="header__logo">
                    <a href="index.flth"><img src="../../../../../../Downloads/ogani/img/logo.png" alt=""></a>
                </div>
            </div>
            <div class="col-lg-6">
                <nav class="header__menu">
                    <ul>
                        <li class="active"><a href="/index">Home</a></li>
                        <li><a href="/cart">Shopping cart</a></li>
                        <li><a href="#">Pages</a>
                            <ul class="header__menu__dropdown">
                                <li><a href="../../../../../../Downloads/ogani/shop-details.html">Shop Details</a></li>
                                <li><a href="/cart">Shoping Cart</a></li>
                                <li><a href="../../../../../../Downloads/ogani/checkout.html">Check Out</a></li>
                                <li><a href="../../../../../../Downloads/ogani/blog-details.html">Blog Details</a></li>
                            </ul>
                        </li>
                        <li><a href="../../../../../../Downloads/ogani/blog.html">Blog</a></li>
                        <li><a href="../../../../../../Downloads/ogani/contact.html">Contact</a></li>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-3">
                <div class="header__cart">
                    <ul>
                        <li><a href="/cart"><i class="fa fa-shopping-bag"></i> <span>${count}</span></a></li>
                    </ul>
                    <div class="header__cart__price"><h6>Total price: <span>$${totalPrice}</span></div>
                </div>
            </div>
        </div>
        <div class="humberger__open">
            <i class="fa fa-bars"></i>
        </div>
    </div>
</header>
<!-- Header Section End -->

<!-- Hero Section Begin -->
<section class="hero">
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="hero__categories">
                    <div class="hero__categories__all">
                        <i class="fa fa-bars"></i>
                        <span>All categories</span>
                    </div>
                    <ul>
                        <form action="/index" method="get"><li><input type="hidden" name="keyword" value="manga"><button style="background-color: Transparent; outline: none; border: none; " type="submit">Manga</button></li></form>
                        <form action="/index" method="get"><li><input type="hidden" name="keyword"  value="manhua"><button style="background-color: Transparent; outline: none; border: none; " type="submit">Korean manga(manhua)</button></li></form>
                        <form action="/index" method="get"><li><input type="hidden" name="keyword"  value="manga"><button style="background-color: Transparent; outline: none; border: none; " type="submit">some shit</button></li></form>
                    </ul>
                </div>
            </div>
            <form action="/index/filter" method="get">
                <a>Choose category:</a><br>
                <select name = "category" required>
                    <option value = "">Select</option>
                    <option value = "Manga">Manga</option>
                    <option value = "Manhua">Manhua</option>
                </select>
                <input type="text" name="min" placeholder="Min. price" value="10" required>
                <input type="text" name="max" placeholder="Max. price" value="10000" required>
                <button style="color: #7fad39; outline: none; border: none" type="submit">Apply filter</button>
            </form>
            <div class="col-lg-9">
                <div class="hero__search">
                    <div class="hero__search__form">
                        <form action="/index/search" method="get">
                            <div class="hero__search__categories">
                                All Categories
                                <span class="arrow_carrot-down"></span>
                            </div>
                                <input type="text" name="keyword" placeholder="What do you need?">
                                <button type="submit" class="site-btn">SEARCH</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Hero Section End -->

<!-- Featured Section Begin -->
<section class="featured spad">
    <div class="container">
        <div class="row featured__filter">
            <#list products.content as pr>
                <div style="border-style: solid; border-width: thin;  margin: 10px" class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg">
                            <img src="${pr.imagesrc}">
                        </div>
                        <div class="featured__item__text">
                            <h5><a href="#">${pr.productName}</a></h5>
                            <h6>Category: ${pr.type}</h6>
                            <h5>$${pr.price}</h5>
                        </div>
                        <form action="/cart/add/${pr.getId()}">
                            <button style="outline: none; border: none;" class="primary-btn" type="submit">Order</button>
                        </form>
                    </div>
                </div>
            </#list>
        </div>
    </div>
    <br>
    <#if products.getTotalPages() gt 7>
        <#assign
        totalPages = products.getTotalPages()
        pageNumber = products.getNumber() + 1

        head = (pageNumber > 4)?then([1, -1], [1, 2, 3])
        tail = (pageNumber < totalPages - 3)?then([-1, totalPages], [totalPages - 2, totalPages - 1, totalPages])
        bodyBefore = (pageNumber > 4 && pageNumber < totalPages - 1)?then([pageNumber - 2, pageNumber - 1], [])
        bodyAfter = (pageNumber > 2 && pageNumber < totalPages - 3)?then([pageNumber + 1, pageNumber + 2], [])

        body = head + bodyBefore + (pageNumber > 3 && pageNumber < totalPages - 2)?then([pageNumber], []) + bodyAfter + tail
        >
    <#else>
        <#assign body = 1..products.getTotalPages()>
    </#if>
    <ul class="pagination justify-content-center">
        <li class="page-item disabled">
            <a class="page-link"  tabindex="-1">Pages</a>
        </li>
        <#list body as p>
            <#if (p-1) == products.getNumber()>
                <li class="page-item active">
                    <a style="background-color:#7fad39; border-color: #7fad39" class="page-link">${p}</a>
                </li>
            <#else>
                <li class="page-item">
                    <a style="color:black" class="page-link" href="${url}&page=${p-1}&size=${products.getSize()}">${p}</a>
                </li>
            </#if>
        </#list>

    </ul>
    <br>
    <ul class="pagination justify-content-center">
        <li class="page-item disabled">
            <a class="page-link" tabindex="-1">Elements On Page</a>
        </li>
        <#list  [5, 10, 25, 50] as c>
            <#if c == products.getSize()>
                <li class="page-item active">
                    <a style="background-color:#7fad39; border-color: #7fad39" class="page-link">${c}</a>
                </li>
            <#else>
                <li class="page-item">
                    <a style="color:black" class="page-link" href="${url}&page=${products.getNumber()}&size=${c}">${c}</a>
                </li>
            </#if>
        </#list>

    </ul>

</section>

<!-- Featured Section End -->




<!-- Footer Section Begin -->
<footer class="footer spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-6 col-sm-6">
                <div class="footer__about">
                    <div class="footer__about__logo">
                        <a href="index.flth"><img src="../../../../../../Downloads/ogani/img/logo.png" alt=""></a>
                    </div>
                    <ul>
                        <li>Address: her vam a ne address</li>
                        <li>Phone: +7777.777.77.77</li>
                        <li>Email: email@mail.com</li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                <div class="footer__widget">
                    <h6>Useful Links</h6>
                    <ul>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">About Our Shop</a></li>
                        <li><a href="#">Secure Shopping</a></li>
                        <li><a href="#">Delivery infomation</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Our Sitemap</a></li>
                    </ul>
                    <ul>
                        <li><a href="#">Who We Are</a></li>
                        <li><a href="#">Our Services</a></li>
                        <li><a href="#">Projects</a></li>
                        <li><a href="#">Contact</a></li>
                        <li><a href="#">Innovation</a></li>
                        <li><a href="#">Testimonials</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4 col-md-12">
                <div class="footer__widget">
                    <h6>Join Our Newsletter Now</h6>
                    <p>Get E-mail updates about our latest shop and special offers.</p>
                    <form action="#">
                        <input type="text" placeholder="Enter your mail">
                        <button type="submit" class="site-btn">Subscribe</button>
                    </form>
                    <div class="footer__widget__social">
                        <a href="#"><i class="fa fa-facebook"></i></a>
                        <a href="#"><i class="fa fa-instagram"></i></a>
                        <a href="#"><i class="fa fa-twitter"></i></a>
                        <a href="#"><i class="fa fa-pinterest"></i></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="footer__copyright">
                    <div class="footer__copyright__text"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>
                    <div class="footer__copyright__payment"><img src="../../../../../../Downloads/ogani/img/payment-item.png" alt=""></div>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- Footer Section End -->

<!-- Js Plugins -->
<script src="../../../../../../Downloads/ogani/js/jquery-3.3.1.min.js"></script>
<script src="../../../../../../Downloads/ogani/js/bootstrap.min.js"></script>
<script src="../../../../../../Downloads/ogani/js/jquery.nice-select.min.js"></script>
<script src="../../../../../../Downloads/ogani/js/jquery-ui.min.js"></script>
<script src="../../../../../../Downloads/ogani/js/jquery.slicknav.js"></script>
<script src="../../../../../../Downloads/ogani/js/mixitup.min.js"></script>
<script src="../../../../../../Downloads/ogani/js/owl.carousel.min.js"></script>
<script src="../../../../../../Downloads/ogani/js/main.js"></script>



</body>

</html>