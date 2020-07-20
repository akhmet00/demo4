<#import "/spring.ftl" as spring/>
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

    <link rel="stylesheet" href="<@spring.url 'resources/css/style.css'/>"/>
    <link rel="stylesheet" href="<@spring.url 'resources/css/bootstrap.min.css'/>"/>
    <link rel="stylesheet" href="<@spring.url 'resources/css/font-awesome.min.css'/>"/>
    <link rel="stylesheet" href="<@spring.url 'resources/css/elegant-icons.css'/>"/>
    <link rel="stylesheet" href="<@spring.url 'resources/css/nice-select.css'/>"/>
    <link rel="stylesheet" href="<@spring.url 'resources/css/jquery-ui.min.css'/>"/>
    <link rel="stylesheet" href="<@spring.url 'resources/css/owl.carousel.min.css'/>"/>
    <link rel="stylesheet" href="<@spring.url 'resources/css/slicknav.min.css'/>"/>

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
            <div class="row">
                <div class="col-lg-6">
                    <div class="header__top__left">
                        <ul>
                            <li><i class="fa fa-envelope"></i> email@mail.com</li>
                            <li>Free Shipping for all Orders!</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="header__top__right">
                        <div class="header__top__right__social">
                            <a href="https://www.facebook.com"><i class="fa fa-facebook"></i></a>
                            <a href="https://www.instagram.com"><i class="fa fa-instagram"></i></a>
                            <a href="https://twitter.com/explore"><i class="fa fa-twitter"></i></a>
                            <a href="https://www.pinterest.com"><i class="fa fa-pinterest"></i></a>
                        </div>
                        <div class="header__top__right__auth">
                            <#assign known=Session.SPRING_SECURITY_CONTEXT??>
                            <#if known>
                                <a>Logged in as: ${user.getName()}</a>
                                <a href="/logout"><i class="fa fa-sign-out">Logout</i></a>
                            <#else>
                                <a href="/login"><i class="fa fa-user"></i> Login</a>
                            </#if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="header__logo">
                    <a href="/index"><img style="width: 100px" src="<@spring.url 'resources/images/logo.png'/>"></a>
                </div>
            </div>
            <div class="col-lg-6">
                <nav class="header__menu">
                    <ul>
                        <li class="active"><a href="/index">Home</a></li>
                        <li><a href="/cart">Shopping cart</a></li>
                        <li><a href="#">Pages</a>
                            <ul class="header__menu__dropdown">
                                <li><a href="/shop-details">Shop Details</a></li>
                                <li><a href="/cart">Shoping Cart</a></li>
                                <li><a href="/contacts">Contacts</a></li>
                            </ul>
                        </li>
                        <li><a href="/contacts">Contacts</a></li>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-3">
                <div class="header__cart">
                    <ul>
                        <li><a href="/cart"><i class="fa fa-shopping-cart"></i> <span>${count}</span></a></li>
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

<section class="hero">
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="hero__categories">
                    <div class="hero__categories__all">
                        <i class="fa fa-bars"></i>
                        <span>Filters</span>
                    </div>
                    <ul style="padding-right: 40px">
                        <form action="/index/filter" method="get">
                            <a>Choose category:</a><br>
                            <li><select class="form-control form-control-sm" name = "category" required >
                                    <option value = "">Select</option>
                                    <option value = "Manga">Manga</option>
                                    <option value = "Manhua">Manhua</option>
                                </select></li>
                            <br>
                            <a>Min price:</a>
                            <li><input class="form-control form-control-sm" type="text" name="min" placeholder="Min. price" value="10" required></li>
                            <a>Max price:</a>
                            <li><input class="form-control form-control-sm" type="text" name="max" placeholder="Max. price" value="100000" required></li><br>
                            <button style="color: #7fad39; outline: none; border: none"  type="submit">Apply filter</button>
                        </form>
                    </ul>
                </div>
            </div>
            <div class="col-lg-9">
                <div class="hero__search">
                    <div class="hero__search__form">
                        <form action="/index/search" method="get">
                            <div class="hero__search__categories">
                                Search
                            </div>
                            <input type="text" name="keyword" placeholder="What do you need?">
                            <button type="submit" class="site-btn">SEARCH</button>
                        </form>
                    </div>
                    <div style="margin-right: 450px; margin-top: 70px" class="hero__search__phone">
                        <div class="hero__search__phone__icon">
                            <i class="fa fa-phone"></i>
                        </div>
                        <div class="hero__search__phone__text">
                            <h5>+7777.777.77.77</h5>
                            <span>support 24/7 time</span>
                        </div>
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
        <div style="margin-left: 100px; margin-top: -100px" class="row featured__filter">
            <#list products.content as pr>
                <div style="border-style: solid; border-width: thin; height: 430px;  margin: 15px;" class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg">
                            <img src="${pr.imagesrc}">
                        </div>
                        <div class="featured__item__text">
                            <h5><a href="/product/${pr.getId()}">${pr.productName}</a></h5>
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
                        <a href="/index"><img style="width: 200px" src="<@spring.url 'resources/images/logo.png'/>"></a>
                    </div>
                    <ul>
                        <li>Address: <a href="/contacts">Kazakhstan, Almaty</a></li>
                        <li>Phone: +7777.777.77.77</li>
                        <li>Email: email@mail.com</li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                <div class="footer__widget">
                    <h6>Useful Links</h6>
                    <ul>
                        <li><a href="/shop-details">About Us</a></li>
                        <li><a href="/contacts">Contacts</a></li>
                        <li><a href="https://www.dhl.com/kz-ru/home.html">Delivery information</a></li>
                        <li><a href="https://www.instagram.com/?hl=ru">Instagram</a></li>
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
                        <a href="https://www.facebook.com"><i class="fa fa-facebook"></i></a>
                        <a href="https://www.instagram.com"><i class="fa fa-instagram"></i></a>
                        <a href="https://twitter.com/explore"><i class="fa fa-twitter"></i></a>
                        <a href="https://www.pinterest.com"><i class="fa fa-pinterest"></i></a>
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
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- Footer Section End -->




</body>

</html>