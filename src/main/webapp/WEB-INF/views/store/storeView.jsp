<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>

<!DOCTYPE html>
<%
	String path = "../storeView/";
%>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
            integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
            crossorigin="anonymous"></script>

    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <link rel="stylesheet" href="../../css/dinner41.css">

    <title>Store</title>
</head>

<body>
<nav class="navbar navbar-light light_green" style="background-color: aquamarine">

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div>
        <h5 class="up_down_center">STORE MANAGE</h5>
    </div>

    <img src="../../icons/home-solid.svg" class="home" alt="no picture">

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">내정보 보기</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">주문 내역</a>
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


<div class="container-fluid text-center" style="margin-top: 15pt">
    <img src="../../images/1인의만찬.png" class="img-fluid img-title" alt="no title"/>
    <h2>매장 상세</h2>
</div>

<hr style="margin-top: 0"/>

<div class="container-fluid">

    <div class="text-center" style="margin-bottom: 20pt">
        <img src="../../images/sweet-restaurant.jpg" width="90%" class="rounded" alt="no picture">
    </div>

    <div class="container-fluid text-left">
        <div class="form-group">
            <label for="storeNumber">사업자 번호</label>
            <div id="storeNumber" class="card card-body">
                2013061307
            </div>
        </div>

        <div class="form-group">
            <label for="storeName">매장명</label>
            <div id="storeName" class="card card-body">
                뽀식이네 감자탕
            </div>
        </div>

        <div class="form-group">
            <label for="storeCategory">매장 대표 카테고리</label>
            <div id="storeCategory" class="card card-body">
                한식
            </div>
        </div>

        <div class="form-group">
            <label for="address">매장주소</label>
            <div id="address" class="card card-body">
                서울특별시 관악구 봉천동...
            </div>
        </div>

        <div class="form-group">
            <label for="phoneNumber">매장 전화번호</label>
            <div id="phoneNumber" class="card card-body">
                02-123-4567
            </div>
        </div>

        <div class="form-group">
            <label for="storeTime">매장 운영 시간</label>
            <div id="storeTime" class="card card-body">
                오후 9시붜터 12시까지
            </div>
        </div>

        <div class="form-group">
            <label for="inputContent">매장 설명</label>
            <div id="inputContent" class="card card-body">
                매우 맛있는 해장국을 판답니다.
            </div>
        </div>

        <div class="margin_first">
            <button type="button" class="btn btn-success two_button">매장 수정 하기</button>
            <button type="button" class="btn btn-success two_button float-right">매장 페점 하기</button>
        </div>
    </div>
</div>

<hr/>

<div class="last_block"></div>
</body>
</html>