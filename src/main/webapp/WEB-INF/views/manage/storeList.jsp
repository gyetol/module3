<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/dinner41.css">

    <title>Store</title>
</head>

<body>
<nav class="navbar navbar-light light_green">

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div>
        <h5 class="up_down_center">MANAGER</h5>
    </div>

    <img src="${pageContext.request.contextPath}/resources/icons/home-solid.svg" class="home" alt="no picture">

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item"><a class="nav-link" href="#">내정보 보기</a></li>
            <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/ALL/1/qna">1:1 문의</a></li>
            <li class="nav-item"><a class="nav-link" href="#"> </a></li>
            <li class="nav-item"><a class="nav-link" href="#"> </a></li>
            <li class="nav-item"><a class="nav-link" href="#">로그아웃</a></li>
        </ul>
    </div>
</nav>

<div>
    <form class="form-inline">
        <div class="col-3" style="padding: 3pt;">
            <select class="form-control" style="width: 100%">
                <option>매장명</option>
            </select>
        </div>
        <div class="col-9" style="padding: 3pt 3pt 3pt 0;">
            <input class="form-control" type="search" placeholder="검색어를 입력해주세요" style="width: inherit"
                   id="search_input"/>
        </div>
    </form>
</div>

<ul class="nav nav-tabs">
    <c:if test="${type eq 'all-'}">
        <li class="nav-item text-center nav_three"><a href="${pageContext.request.contextPath}/ad/all-/all-/1/store"
                                                      class="nav-link active">ALL</a></li>
        <li class="nav-item text-center nav_three"><a href="${pageContext.request.contextPath}/ad/신청/all-/1/store"
                                                      class="nav-link">승인 대기</a></li>
        <li class="nav-item text-center nav_three"><a href="${pageContext.request.contextPath}/ad/승인/all-/1/store"
                                                      class="nav-link">승인 완료</a></li>
    </c:if>
    <c:if test="${type eq '신청'}">
        <li class="nav-item text-center nav_three"><a href="${pageContext.request.contextPath}/ad/all-/all-/1/store"
                                                      class="nav-link">ALL</a></li>
        <li class="nav-item text-center nav_three"><a href="${pageContext.request.contextPath}/ad/신청/all-/1/store"
                                                      class="nav-link active">승인 대기</a></li>
        <li class="nav-item text-center nav_three"><a href="${pageContext.request.contextPath}/ad/승인/all-/1/store"
                                                      class="nav-link">승인 완료</a></li>
    </c:if>
    <c:if test="${type eq '승인'}">
        <li class="nav-item text-center nav_three"><a href="${pageContext.request.contextPath}/ad/all-/all-/1/store"
                                                      class="nav-link">ALL</a></li>
        <li class="nav-item text-center nav_three"><a href="${pageContext.request.contextPath}/ad/신청/all-/1/store"
                                                      class="nav-link">승인 대기</a></li>
        <li class="nav-item text-center nav_three"><a href="${pageContext.request.contextPath}/ad/승인/all-/1/store"
                                                      class="nav-link active">승인 완료</a></li>
    </c:if>
</ul>

<div>

    <c:if test="${empty stores}">
        등록된 매장이 없습니다.
    </c:if>

    <c:if test="${not empty stores}">
        <c:forEach items="${stores}" var="store" varStatus="i">
            <div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-3">
                                <img src="${pageContext.request.contextPath}/resources/images/dish-food.jpg"
                                     width="100%" class="rounded" alt="no picture">
                            </div>
                            <div class="col-9" style="padding-left: 0">
                                <h5>
                                    <c:out value="${store.name}"/>&nbsp;&nbsp;
                                    <c:if test="${store.state.name eq '승인'}">
                                        <span class="badge badge-primary">
                                            <c:out value="${store.state.name}"/>
                                        </span>
                                    </c:if>
                                    <c:if test="${store.state.name eq '신청'}">
                                        <span class="badge badge-danger">
                                            <c:out value="${store.state.name}"/>
                                        </span>
                                    </c:if>
                                </h5>
                                매장 전화번호 : <span><c:out value="${store.phone}"/></span> <br/>
                                위치 : <span><c:out value="${store.address}"/></span>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </c:forEach>
    </c:if>

    <hr style="margin-top: 0"/>

    <div style="text-align: center">
        <div class="btn-group" role="group">
            <button type="button" class="btn btn-success"><<</button>
            <button type="button" class="btn btn-success" disabled>1</button>
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