<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
    
    <script src="resources/js/user/storeDetail_menu.js"></script>

    <title>one2one</title>
</head>
<body>

<nav class="navbar navbar-light light_green">

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="btn-group">
        <button type="button" class="btn btn-outline-dark dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <span>서울 특별시 봉천동</span>
        </button>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="#">주소 변경하기</a>
            <a class="dropdown-item" href="#">주소 목록</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">현재 위치 기준</a>
        </div>
    </div>

    <img src="../../icons/shopping-bag-solid.svg" class="cart" alt="no picture">

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
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

<div style="margin-top: 10pt">
    <div class="container-fluid">
        <div class="card card-body">
            <h2>뽀식이네 감자탕&nbsp;<span class="badge badge-primary">OPEN</span></h2>
            <h4>별점 : ★★★★★</h4>
            <h4>전화 : 02)123-4567&nbsp; <i class="fas fa-phone-square"></i></h4>
        </div>
    </div>
    <div class="container-fluid" style="margin-top: 10pt">
        <div class="container-fluid">
            <h5>가게 소개</h5>
            <p>여기에 가게 소개를 적어주시라</p>
            <h5>가게 운영시간</h5>
            <p>여기에 가게 운영시간을 적어주시라</p>
            <h5>휴무일</h5>
            <p>여기에 휴무일을 적어주시라</p>
            <h5>가게 위치</h5>
            <span>여기에 가게 위치를 적어주시라</span>
        </div>
        <div class="card card-body">지도</div>
    </div>
    <hr/>

    <ul class="nav nav-tabs">
        <li class="nav-item text-center" style="width: 50%">
            <a class="nav-link active" href="#">메뉴</a>
        </li>
        <li class="nav-item text-center" style="width: 50%">
            <a class="nav-link" href="#">리뷰</a>
        </li>
    </ul>

    <ul class="list-group list-group-flush">
        <li class="list-group-item">
            <div class="row">
                <div class="col-3">
                    <img src="../../images/dish-food.jpg" width="100%" class="rounded" alt="no picture">
                </div>
                <div class="col-9" style="padding-left: 0">
                    <h5>메뉴이름</h5>
                    <div>
                        정가 : <span>9000원</span>
                        <br/>
                        할인가 : <span>900원</span>&nbsp;&nbsp;<span class="badge badge-primary">90%</span>
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
                    <h5>메뉴이름</h5>
                    <div>
                        정가 : <span>9000원</span>
                        <br/>
                        할인가 : <span>900원</span>&nbsp;&nbsp;<span class="badge badge-primary">90%</span>
                    </div>
                </div>
            </div>
        </li>
    </ul>
    <hr style="margin: 0"/>

    <div style="text-align: center;margin-top: 10pt">
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
        <button type="button" class="btn btn-outline-success btn-block">뒤로가기</button>
    </div>
</div>
<hr/>
<div class="last_block"></div>
</body>
</html>