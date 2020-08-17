<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <link rel="stylesheet" href="../../css/dinner41.css">

    <title>store</title>
</head>

<body>
<nav class="navbar navbar-light light_green">

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <!--사용자 위치-->
    <div class="btn-group">
        <button type="button" class="btn btn-outline-dark dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                aria-expanded="false">
            <span>서울특별시 봉천동</span>
        </button>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="#">주소 변경하기</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">현재 위치 기준</a>
        </div>
    </div>

    <!--장바구니 아이콘-->
    <img src="../../icons/shopping-bag-solid.svg" class="cart" alt="no picture">

    <!--메뉴-->
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">내정보 보기</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">결제내역</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">1:1 문의</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#"> </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#"> </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">로그아웃</a>
            </li>
        </ul>
    </div>
</nav>

<div>
    <form class="form-inline">
        <div class="col-3" style="padding: 3pt;">
            <select class="form-control" >
                <option>거리순</option>
            </select>
        </div>
        <div class="col-9" style="padding: 3pt 3pt 3pt 0;">
            <input class="form-control" type="search" placeholder="검색어를 입력해주세요" style="width: inherit" id="search_input"/>
        </div>
    </form>
</div>

<hr style="margin: 0"/>

<div>
    <div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">
                <div class="row">
                    <div class="col-3">
                        <img src="../../images/dish-food.jpg" width="100%" class="rounded" alt="no picture">
                    </div>
                    <div class="col-9" style="padding-left: 0">
                        <h5>식당이름&nbsp;&nbsp;<span class="badge badge-primary">300m</span></h5>
                        <div>
                            평점 : <span>★★★★★</span>
                            <br/>
                            대표메뉴 : <span>까르보나라 스파게티</span>
                        </div>
                    </div>
                </div>
            </li>

            <li class="list-group-item">
                <div class="row">
                    <div class="col-3">
                        <img src="../../images/dish-food.jpg" width="100%" class="rounded" alt="no picture">
                    </div>
                    <div class="col-9" style="padding-left: 0">
                        <h5>식당이름&nbsp;&nbsp;<span class="badge badge-primary">300m</span></h5>
                        <div>
                            평점 : <span>★★★★★</span>
                            <br/>
                            대표메뉴 : <span>까르보나라 스파게티</span>

                        </div>
                    </div>
                </div>
            </li>

            <li class="list-group-item">
                <div class="row">
                    <div class="col-3">
                        <img src="../../images/dish-food.jpg" width="100%" class="rounded" alt="no picture">
                    </div>
                    <div class="col-9" style="padding-left: 0">
                        <h5>식당이름&nbsp;&nbsp;<span class="badge badge-primary">300m</span></h5>
                        <div>
                            평점 : <span>★★★★★</span>
                            <br/>
                            대표메뉴 : <span>까르보나라 스파게티</span>

                        </div>
                    </div>
                </div>
            </li>

            <li class="list-group-item">
                <div class="row">
                    <div class="col-3">
                        <img src="../../images/dish-food.jpg" width="100%" class="rounded" alt="no picture">
                    </div>
                    <div class="col-9" style="padding-left: 0">
                        <h5>식당이름&nbsp;&nbsp;<span class="badge badge-primary">300m</span></h5>
                        <div>
                            평점 : <span>★★★★★</span>
                            <br/>
                            대표메뉴 : <span>까르보나라 스파게티</span>

                        </div>
                    </div>
                </div>
            </li>

            <li class="list-group-item">
                <div class="row">
                    <div class="col-3">
                        <img src="../../images/dish-food.jpg" width="100%" class="rounded" alt="no picture">
                    </div>
                    <div class="col-9" style="padding-left: 0">
                        <h5>식당이름&nbsp;&nbsp;<span class="badge badge-primary">300m</span></h5>
                        <div>
                            평점 : <span>★★★★★</span>
                            <br/>
                            대표메뉴 : <span>까르보나라 스파게티</span>

                        </div>
                    </div>
                </div>
            </li>

        </ul>
    </div>
    <hr style="margin-top: 0"/>
    <div style="text-align: center">
        <div class="btn-group" role="group">
            <button type="button" class="btn btn-success"><<</button>
            <button type="button" class="btn btn-success">1</button>
            <button type="button" class="btn btn-success">2</button>
            <button type="button" class="btn btn-success">3</button>
            <button type="button" class="btn btn-success">4</button>
            <button type="button" class="btn btn-success">>></button>
        </div>
    </div>
    <div class="container-fluid margin_first">
        <button type="button" class="btn btn-outline-success btn-block" >뒤로가기</button>
    </div>
</div>
<hr/>
<div class="last_block"></div>
</body>
</html>