<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script src="${pageContext.request.contextPath}/resources/js/store/orderList.js"></script>


<title>Order History</title>
</head>
<body>
	<nav class="navbar navbar-light light_green">

		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div>
			<h5 class="up_down_center">STORE MANAGE</h5>
		</div>

		<img src="${pageContext.request.contextPath}/resources/icons/home-solid.svg" class="home" alt="no picture">

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="#">내정보 보기</a></li>
				<li class="nav-item active"><a class="nav-link" href="#">주문 내역</a></li>
				<li class="nav-item"><a class="nav-link" href="#">1:1 문의</a></li>
				<li class="nav-item"><a class="nav-link" href="#"> </a></li>
				<li class="nav-item"><a class="nav-link" href="#"> </a></li>
				<li class="nav-item"><a class="nav-link" href="#">로그아웃</a></li>
			</ul>
		</div>
	</nav>

	<div>
		<div class="container-fluid">
			<div class="text-center" style="margin-top: 25pt; margin-bottom: 25px;">
				<img src="${pageContext.request.contextPath}/resources/images/1인의만찬.png" class="img-fluid img-title" alt="no title" />
				<h4 style="margin-top: 10pt;">주문 내역</h4>
			</div>
		</div>

		<hr style="margin: 0" />

		<ul class="nav nav-tabs">
			<li class="nav-item text-center nav_two"><a class="nav-link" style="color: green; font-size: 20px; font-weight: bold;" href="${pageContext.request.contextPath}/sm/WAIT/1/order">주문대기</a></li>
			<li class="nav-item text-center nav_two"><a class="nav-link" style="color: green; font-size: 20px; font-weight: bold;" href="${pageContext.request.contextPath}/sm/COMP/1/order">수령완료</a></li>
		</ul>

		<c:if test="${empty map}">
			주문 내역이 비어있습니다.
		</c:if>

		<c:if test="${not empty map}">
			<c:forEach items="${map}" var="entry" varStatus="i">
				<div class="orderClass" data-orderid=<c:out value="${entry.key.orderId}"/>>
					<ul class="list-group list-group-flush">
						<li class="list-group-item">
							<div style="color: green; font-weight: bold;">
								주문번호 : <span id="orderId"><c:out value="${entry.key.orderId}" /></span><br />
							</div> 주문자명 : <span><c:out value="${entry.key.userName}" /></span><br /> 주문일시 : <span><c:out value="${entry.key.order_order_date}" /></span><br /> 주문메뉴(수량) : <c:forEach items="${entry.value}" var="menu" varStatus="i">
								<c:out value="${menu.menuName}" />
								(<c:out value="${menu.amount}" />) /
							</c:forEach>

							<div style="margin-top: 5pt" id="pickupDate" data-pickupDate="${entry.key.order_pickup_date}">
								<button id="storeDetail" class="btn btn-outline-success btn-sm" style="width: 32%">상세보기</button>
								<button id="cancelOrder" class="btn btn-outline-success btn-sm" style="width: 32%;">주문취소</button>
								<button id="receiptComplete" class="btn btn-outline-success btn-sm" style="width: 32%">수령완료</button>
							</div>
						</li>
					</ul>
				</div>
			</c:forEach>
		</c:if>
	</div>

	<hr style="margin-top: 0" />

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
	<hr />
	<div class="last_block"></div>
</body>
</html>