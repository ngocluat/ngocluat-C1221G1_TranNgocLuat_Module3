<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 16/04/2022
  Time: 12:46 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        <%@include file="/css/furamaCss.css"%>
        /*body {*/
        /*    background-image: url("https://vnreview.vn/image/21/50/31/2150318.jpg");*/
        /*    background-position: right bottom, left top;*/
        /*    background-repeat: repeat, repeat;*/
        /*    width: 100%;*/
        /*    background-size: cover;*/


            /* Please ❤ this if you like it! */


        @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700;800;900&display=swap');

        body{
            font-family: 'Montserrat', sans-serif;
            font-weight: 300;
            font-size: 15px;
            line-height: 1.7;
            color: #ececee;
            background-color: #1f2029;
            overflow: hidden;
            background-image: url('https://s3-us-west-2.amazonaws.com/s.cdpn.io/1462889/pat-back.svg');
            background-position: center;
            background-repeat: repeat;
            background-size: 4%;
            height: 100vh;
            width: 100%;
        }
        .section-center{
            position: absolute;
            top: 50%;
            left: 0;
            display: block;
            width: 100%;
            padding: 0;
            margin: 0;
            z-index: 6;
            text-align: center;
            transform: translateY(-50%);
        }
        h1{
            font-family: 'Montserrat', sans-serif;
            font-weight: 800;
            font-size: 7vw;
            line-height: 1;
            color: #ffeba7;
            text-align: center;
            -webkit-text-stroke: 2px #ffeba7;
            text-stroke: 2px #ffeba7;
            -webkit-text-fill-color: transparent;
            text-fill-color: transparent;
            color: transparent;
        }

        [type="checkbox"]:checked,
        [type="checkbox"]:not(:checked){
            position: absolute;
            left: -9999px;
        }
        .menu-icon:checked + label,
        .menu-icon:not(:checked) + label{
            position: fixed;
            top: 63px;
            right: 75px;
            display: block;
            width: 30px;
            height: 30px;
            padding: 0;
            margin: 0;
            cursor: pointer;
            z-index: 10;
        }
        .menu-icon:checked + label:before,
        .menu-icon:not(:checked) + label:before{
            position: absolute;
            content: '';
            display: block;
            width: 30px;
            height: 20px;
            z-index: 20;
            top: 0;
            left: 0;
            border-top: 2px solid #ececee;
            border-bottom: 2px solid #ececee;
            transition: border-width 100ms 1500ms ease,
            top 100ms 1600ms cubic-bezier(0.23, 1, 0.32, 1),
            height 100ms 1600ms cubic-bezier(0.23, 1, 0.32, 1),
            background-color 200ms ease,
            transform 200ms cubic-bezier(0.23, 1, 0.32, 1);
        }
        .menu-icon:checked + label:after,
        .menu-icon:not(:checked) + label:after{
            position: absolute;
            content: '';
            display: block;
            width: 22px;
            height: 2px;
            z-index: 20;
            top: 10px;
            right: 4px;
            background-color: #ececee;
            margin-top: -1px;
            transition: width 100ms 1750ms ease,
            right 100ms 1750ms ease,
            margin-top 100ms ease,
            transform 200ms cubic-bezier(0.23, 1, 0.32, 1);
        }
        .menu-icon:checked + label:before{
            top: 10px;
            transform: rotate(45deg);
            height: 2px;
            background-color: #ececee;
            border-width: 0;
            transition: border-width 100ms 340ms ease,
            top 100ms 300ms cubic-bezier(0.23, 1, 0.32, 1),
            height 100ms 300ms cubic-bezier(0.23, 1, 0.32, 1),
            background-color 200ms 500ms ease,
            transform 200ms 1700ms cubic-bezier(0.23, 1, 0.32, 1);
        }
        .menu-icon:checked + label:after{
            width: 30px;
            margin-top: 0;
            right: 0;
            transform: rotate(-45deg);
            transition: width 100ms ease,
            right 100ms ease,
            margin-top 100ms 500ms ease,
            transform 200ms 1700ms cubic-bezier(0.23, 1, 0.32, 1);
        }

        .nav{
            position: fixed;
            top: 33px;
            right: 50px;
            display: block;
            width: 80px;
            height: 80px;
            padding: 0;
            margin: 0;
            z-index: 9;
            overflow: hidden;
            box-shadow: 0 8px 30px 0 rgba(0,0,0,0.3);
            background-color: #353746;
            animation: border-transform 7s linear infinite;
            transition: top 350ms 1100ms cubic-bezier(0.23, 1, 0.32, 1),
            right 350ms 1100ms cubic-bezier(0.23, 1, 0.32, 1),
            transform 250ms 1100ms ease,
            width 650ms 400ms cubic-bezier(0.23, 1, 0.32, 1),
            height 650ms 400ms cubic-bezier(0.23, 1, 0.32, 1);
        }
        @keyframes border-transform{
            0%,100% { border-radius: 63% 37% 54% 46% / 55% 48% 52% 45%; }
            14% { border-radius: 40% 60% 54% 46% / 49% 60% 40% 51%; }
            28% { border-radius: 54% 46% 38% 62% / 49% 70% 30% 51%; }
            42% { border-radius: 61% 39% 55% 45% / 61% 38% 62% 39%; }
            56% { border-radius: 61% 39% 67% 33% / 70% 50% 50% 30%; }
            70% { border-radius: 50% 50% 34% 66% / 56% 68% 32% 44%; }
            84% { border-radius: 46% 54% 50% 50% / 35% 61% 39% 65%; }
        }

        .menu-icon:checked ~ .nav {
            animation-play-state: paused;
            top: 50%;
            right: 50%;
            transform: translate(50%, -50%);
            width: 200%;
            height: 200%;
            transition: top 350ms 700ms cubic-bezier(0.23, 1, 0.32, 1),
            right 350ms 700ms cubic-bezier(0.23, 1, 0.32, 1),
            transform 250ms 700ms ease,
            width 750ms 1000ms cubic-bezier(0.23, 1, 0.32, 1),
            height 750ms 1000ms cubic-bezier(0.23, 1, 0.32, 1);
        }

        .nav ul{
            position: absolute;
            top: 50%;
            left: 0;
            display: block;
            width: 100%;
            padding: 0;
            margin: 0;
            z-index: 6;
            text-align: center;
            transform: translateY(-50%);
            list-style: none;
        }
        .nav ul li{
            position: relative;
            display: block;
            width: 100%;
            padding: 0;
            margin: 10px 0;
            text-align: center;
            list-style: none;
            pointer-events: none;
            opacity: 0;
            visibility: hidden;
            transform: translateY(30px);
            transition: all 250ms linear;
        }
        .nav ul li:nth-child(1){
            transition-delay: 200ms;
        }
        .nav ul li:nth-child(2){
            transition-delay: 150ms;
        }
        .nav ul li:nth-child(3){
            transition-delay: 100ms;
        }
        .nav ul li:nth-child(4){
            transition-delay: 50ms;
        }
        .nav ul li a{
            font-family: 'Montserrat', sans-serif;
            font-size: 9vh;
            text-transform: uppercase;
            line-height: 1.2;
            font-weight: 800;
            display: inline-block;
            position: relative;
            color: #ececee;
            transition: all 250ms linear;
        }
        .nav ul li a:hover{
            text-decoration: none;
            color: #ffeba7;
        }
        .nav ul li a:after{
            display: block;
            position: absolute;
            top: 50%;
            content: '';
            height: 2vh;
            margin-top: -1vh;
            width: 0;
            left: 0;
            background-color: #353746;
            opacity: 0.8;
            transition: width 250ms linear;
        }
        .nav ul li a:hover:after{
            width: 100%;
        }


        .menu-icon:checked ~ .nav  ul li {
            pointer-events: auto;
            visibility: visible;
            opacity: 1;
            transform: translateY(0);
            transition: opacity 350ms ease,
            transform 250ms ease;
        }
        .menu-icon:checked ~ .nav ul li:nth-child(1){
            transition-delay: 1400ms;
        }
        .menu-icon:checked ~ .nav ul li:nth-child(2){
            transition-delay: 1480ms;
        }
        .menu-icon:checked ~ .nav ul li:nth-child(3){
            transition-delay: 1560ms;
        }
        .menu-icon:checked ~ .nav ul li:nth-child(4){
            transition-delay: 1640ms;
        }



        .logo {
            position: absolute;
            top: 60px;
            left: 50px;
            display: block;
            z-index: 11;
            transition: all 250ms linear;
        }
        .logo img {
            height: 26px;
            width: auto;
            display: block;
        }



        @media screen and (max-width: 991px) {
            .menu-icon:checked + label,
            .menu-icon:not(:checked) + label{
                right: 55px;
            }
            .logo {
                left: 30px;
            }
            .nav{
                right: 30px;
            }
            h1{
                font-size: 9vw;
                -webkit-text-stroke: 2px transparent;
                text-stroke: 2px transparent;
                -webkit-text-fill-color: #ffeba7;
                text-fill-color: #ffeba7;
                color: #ffeba7;
            }
            .nav ul li a{
                font-size: 8vh;
            }
        }



    </style>
</head>
<body>

<%--head--%>
<div >
    <div class="fixed">
        <div class="">
            <img class="header-img"
                 src="https://scontent.fdad3-5.fna.fbcdn.net/v/t39.30808-6/272874617_670365003964733_1655890499248135785_n.jpg?_nc_cat=102&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=wpta7yUuHfkAX_ttLpt&_nc_ht=scontent.fdad3-5.fna&oh=00_AT9jKQkp3pG0vbyHRkrDmqrQM2zEFAzcgDDg9DBSNGgr0Q&oe=625FC7E9"
                 alt="">
            <h3>Trần Ngọc Luật</h3>
            <h4><a href="../index.jsp">Đăng Xuất</a></h4>
        </div>

        <nav class=" navbar-furama navbar navbar-expand-lg navbar-light ">
            <a class="navbar-brand" href="#">Home</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/employee">Employee <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/customer">Customer</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link" href="/service" id="navbarDropdown" role="button"
                           aria-expanded="false">
                            Sevice
                        </a>

                    </li>
                    <li class="nav-item">
                        <a href="/contract" class="nav-link ">Contract</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
    </div>
</div>
<div>
    <a href="https://front.codes/" class="logo" target="_blank">
        <img src="https://assets.codepen.io/1462889/fcy.png" alt="">
    </a>

    <input class="menu-icon" type="checkbox" id="menu-icon" name="menu-icon"/>
    <label for="menu-icon"></label>
    <nav class="nav">
        <ul class="pt-5">
            <li><a href="/customer">Customer</a></li>
            <li><a href="/employee">Employee</a></li>
            <li><a href="#">Contract</a></li>
            <li><a href="/service">Service</a></li>
        </ul>
    </nav>

    <div class="section-center">
        <h1 class="mb-0">Welcome to Furama</h1>
    </div>
</div>

<%--body--%>
<div class="margin body-left">
    <div>
        <div class="padding-body-left">
            <h5><a href="#">
                <button type="button" class="btn btn-outline-success">Item One</button>
            </a></h5>
        </div>
        <div class="padding-body-left">
            <h5><a href="#">
                <button type="button" class="btn btn-outline-success">Item Two</button>
            </a></h5>
        </div>
        <div class="padding-body-left">
            <h5><a href="#">
                <button type="button" class="btn btn-outline-success">Item Three</button>
            </a></h5>
        </div>

        <div><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></div>

    </div>
    <%--body--%>
    <div class="body">


    </div>

</div>


<%--// Footer--%>
<div style="clear: both">



    <footer class="bg-dark text-center text-white">
        <!-- Grid container -->
        <div class="container p-4">
            <!-- Section: Social media -->
            <section class="mb-4">
                <!-- Facebook -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-facebook-f"></i
                ></a>

                <!-- Twitter -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-twitter"></i
                ></a>

                <!-- Google -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-google"></i
                ></a>

                <!-- Instagram -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-instagram"></i
                ></a>

                <!-- Linkedin -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-linkedin-in"></i
                ></a>

                <!-- Github -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                ><i class="fab fa-github"></i
                ></a>
            </section>
            <!-- Section: Social media -->

            <!-- Section: Form -->
            <section class="">
                <form action="">
                    <!--Grid row-->
                    <div class="row d-flex justify-content-center">
                        <!--Grid column-->
                        <div class="col-auto">
                            <p class="pt-2">
                                <strong>Sign up for our newsletter</strong>
                            </p>
                        </div>
                        <!--Grid column-->

                        <!--Grid column-->
                        <div class="col-md-5 col-12">
                            <!-- Email input -->
                            <div class="form-outline form-white mb-4">
                                <input type="email" id="form5Example21" class="form-control"/>
                                <label class="form-label" for="form5Example21">Email address</label>
                            </div>
                        </div>
                        <!--Grid column-->

                        <!--Grid column-->
                        <div class="col-auto">
                            <!-- Submit button -->
                            <button type="submit" class="btn btn-outline-light mb-4">
                                Subscribe
                            </button>
                        </div>
                        <!--Grid column-->
                    </div>
                    <!--Grid row-->
                </form>
            </section>
            <!-- Section: Form -->

            <!-- Section: Text -->
            <section class="mb-4">
                <p>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Sunt distinctio earum
                    repellat quaerat voluptatibus placeat nam, commodi optio pariatur est quia magnam
                    eum harum corrupti dicta, aliquam sequi voluptate quas.
                </p>
            </section>
            <!-- Section: Text -->

            <!-- Section: Links -->
            <section class="">
                <!--Grid row-->
                <div class="row">
                    <!--Grid column-->
                    <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
                        <h5 class="text-uppercase">Links</h5>

                        <ul class="list-unstyled mb-0">
                            <li>
                                <a href="#!" class="text-white">Link 1</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Link 2</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Link 3</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Link 4</a>
                            </li>
                        </ul>
                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
                        <h5 class="text-uppercase">Links</h5>

                        <ul class="list-unstyled mb-0">
                            <li>
                                <a href="#!" class="text-white">Link 1</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Link 2</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Link 3</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Link 4</a>
                            </li>
                        </ul>
                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
                        <h5 class="text-uppercase">Links</h5>

                        <ul class="list-unstyled mb-0">
                            <li>
                                <a href="#!" class="text-white">Link 1</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Link 2</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Link 3</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Link 4</a>
                            </li>
                        </ul>
                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
                        <h5 class="text-uppercase">Links</h5>

                        <ul class="list-unstyled mb-0">
                            <li>
                                <a href="#!" class="text-white">Link 1</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Link 2</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Link 3</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Link 4</a>
                            </li>
                        </ul>
                    </div>
                    <!--Grid column-->
                </div>
                <!--Grid row-->
            </section>
            <!-- Section: Links -->
        </div>
        <!-- Grid container -->

        <!-- Copyright -->
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            © 2020 Copyright:
            <a class="text-white" href="https://mdbootstrap.com/">MDBootstrap.com</a>
        </div>
        <!-- Copyright -->
    </footer>
    <!-- Footer -->
</div>

</body>
</html>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
