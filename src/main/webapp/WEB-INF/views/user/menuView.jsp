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

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/dinner41.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/user/menuView.js"></script>

<title>Menu</title>
</head>

<body>

	<nav class="navbar navbar-light light_green" style="background-color: aquamarine">
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<!--사용자 위치-->
		<div class="btn-group">
			<button type="button" class="btn btn-outline-dark dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<span>서울특별시 봉천동</span>
			</button>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="#">주소 변경하기</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="#">현재 위치 기준</a>
			</div>
		</div>

		<!--장바구니 아이콘-->
		<a href="${pageContext.request.contextPath}/gm/cart"><img src="${pageContext.request.contextPath}/resources/icons/shopping-bag-solid.svg" class="cart" alt="no picture">
		</a>

		<!--메뉴-->
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="#">내정보 보기</a></li>
				<li class="nav-item"><a class="nav-link" href="#">주문 내역</a></li>
				<li class="nav-item"><a class="nav-link" href="#">1:1 문의</a></li>
				<li class="nav-item"><a class="nav-link" href="#"> </a></li>
				<li class="nav-item"><a class="nav-link" href="#"> </a></li>
				<li class="nav-item"><a class="nav-link" href="#">로그아웃</a></li>
			</ul>
		</div>
	</nav>

	<!-- storeId, menuId가 data로 세팅되어야함 -->
	<div class="container-fluid" data-storeId="1" data-menuId="4">
		<div class="container-fluid">
			<div class="card card-body" style="margin-top: 15pt; margin-bottom: 15pt;">
				<img src="../../categoryImages/chicken.png" width="100%" class="rounded" alt="no picture">
			</div>

			<div class="form-group">
				<label for="menuName">메뉴명</label>
				<div class="card card-body" id="menuName">닭강정(대)</div>
			</div>

			<div class="form-group">
				<label for="menuAmount">최대 수량</label>
				<div class="card card-body" id="menuAmount">2</div>
			</div>

			<div class="form-group" style="margin-bottom: 20pt">
				<label for="inputKind">제공방식</label>
				<div class="card card-body" id="inputKind">제공방식을 여기에 입력하시오</div>
			</div>

			<div class="form-group">
				<label for="menuMoney">메뉴 가격</label>
				<div class="card card-body" id="menuMoney">2000</div>
			</div>

			<div class="form-group">
				<label for="menuDes">메뉴 설명</label>
				<div class="card card-body" id="menuDes">여기에 메뉴설명을 입력하시오</div>
			</div>

			<div class="form-group" style="margin-bottom: 40pt">
				<label for="inputContent">메뉴 유의 사항</label>
				<div class="card card-body" id="inputContent">여기에 메뉴설명을 입력하시오</div>
			</div>

			<button type="button" class="btn btn-success two_button" id="insertCart">장바구니에 넣기</button>
			<button type="button" class="btn btn-success two_button float-right">뒤로가기</button>
		</div>
	</div>
	<hr />
	<div class="last_block"></div>
</body>
</html>