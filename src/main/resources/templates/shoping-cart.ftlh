<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>

<head>
    <base href="/" />
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
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li><a href="/index">Home</a></li>
                            <li class="active"><a href="/cart">Shopping cart</a></li>
                            <li><a href="#">Pages</a>
                                <ul class="header__menu__dropdown">
                                    <li><a href="/shop-details">Shop Details</a></li>
                                    <li class="active"><a href="/cart">Shoping Cart</a></li>
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
                        <div class="header__cart__price"><h6>Total price: <span>$${totalPrice}</span></div><br>
                        <ul>
                            <li style="margin-right: -20px"><a><i class="fa fa-money"></i></a></li>
                        </ul>
                        <div class="header__cart__price"><h6>You have: <span>$${money.getMoney()}</span></div><br>
                    </div>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->

    <!-- Shoping Cart Section Begin -->
    <section class="shoping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__table">
                        <#if products?has_content>
                        <table>
                            <thead>
                                <tr>
                                    <th class="shoping__product">Products</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <#list  products as pr,prc>
                            <tbody>
                                <tr>
                                    <td class="shoping__cart__item">
                                        <img style="width: 100px" src="${pr.imagesrc}" alt="">
                                        <h5>${pr.productName}</h5>
                                    </td>
                                    <td class="shoping__cart__price">
                                       $${pr.price}
                                    </td>

                                    <td class="shoping__cart__quantity">

                                        <div class="quantity">

                                            <div class="pro-qty">
                                              <input type="text" value="${prc}">

                                            </div>

                                        </div>

                                    </td>

                                    <td class="shoping__cart__total">
                                        $${pr.price*prc}
                                    </td>
                                    <td class="shoping__cart__item__close">
                                        <form action="/cart/remove/${pr.getId()}" method="get">

                                            <button type="submit"></button>
                                        </form>
                                    </td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                            <div class="col-lg-12">
                                <div class="shoping__cart__btns">
                                    <form action="/cart/clear" method="get"><button style="margin: 10px"  type="submit" class="btn btn-info">
                                            Clear Cart</button></form>
                                </div>
                            </div>
                            <#else>
                            <h1>Cart is empty</h1><br>
                        </#if>
                        <a href="/index" class="primary-btn cart-btn">CONTINUE SHOPPING</a><br>

                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <div class="shoping__continue">
                        <div class="shoping__discount">
                            <h5>Discount Codes</h5>
                            <form action="#">
                                <input type="text" placeholder="Enter your coupon code">
                                <button type="submit" class="site-btn">APPLY COUPON</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="shoping__checkout">
                        <h5>Cart Total</h5>
                        <ul>

                            <li>Total <span>$${totalPrice}</span></li>

                        </ul>
                        <form action="/cart/checkout" method="get">
                        <button style="outline: none; border:none" class="primary-btn">PROCEED TO CHECKOUT</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shoping Cart Section End -->

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