<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

    <title>Q&A</title>
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
            <li class="nav-item">
                <a class="nav-link" href="#">내정보 보기</a>
            </li>
            <li class="nav-item active">
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
    <div class="container-fluid text-center" style="margin-top: 15pt">
        <img src="${pageContext.request.contextPath}/resources/images/1인의만찬.png" class="img-fluid img-title" alt="no title" style="margin: auto;"/>
        <h4>문의 내역</h4>
    </div>

    <c:if test="${type eq 'ALL'}">
        <ul class="nav nav-tabs">
            <li class="nav-item text-center nav_five">
                <a class="nav-link active" href="#">ALL</a>
            </li>
            <li class="nav-item text-center nav_five">
                <a class="nav-link" href="#">문의</a>
            </li>
            <li class="nav-item text-center nav_five">
                <a class="nav-link" href="#">건의</a>
            </li>
            <li class="nav-item text-center nav_five">
                <a class="nav-link" href="#">신고</a>
            </li>
            <li class="nav-item text-center nav_five">
                <a class="nav-link" href="#">답변완료</a>
            </li>
        </ul>
    </c:if>
    <c:if test="${type eq 'QUE'}">
        <ul class="nav nav-tabs">
            <li class="nav-item text-center nav_five">
                <a class="nav-link" href="#">ALL</a>
            </li>
            <li class="nav-item text-center nav_five">
                <a class="nav-link active" href="#">문의</a>
            </li>
            <li class="nav-item text-center nav_five">
                <a class="nav-link" href="#">건의</a>
            </li>
            <li class="nav-item text-center nav_five">
                <a class="nav-link" href="#">신고</a>
            </li>
            <li class="nav-item text-center nav_five">
                <a class="nav-link" href="#">답변완료</a>
            </li>
        </ul>
    </c:if>
    <c:if test="${type eq 'REQ'}">
        <ul class="nav nav-tabs">
            <li class="nav-item text-center nav_five">
                <a class="nav-link" href="#">ALL</a>
            </li>
            <li class="nav-item text-center nav_five">
                <a class="nav-link" href="#">문의</a>
            </li>
            <li class="nav-item text-center nav_five">
                <a class="nav-link active" href="#">건의</a>
            </li>
            <li class="nav-item text-center nav_five">
                <a class="nav-link" href="#">신고</a>
            </li>
            <li class="nav-item text-center nav_five">
                <a class="nav-link" href="#">답변완료</a>
            </li>
        </ul>
    </c:if>
    <c:if test="${type eq 'REP'}">
        <ul class="nav nav-tabs">
            <li class="nav-item text-center nav_five">
                <a class="nav-link" href="#">ALL</a>
            </li>
            <li class="nav-item text-center nav_five">
                <a class="nav-link" href="#">문의</a>
            </li>
            <li class="nav-item text-center nav_five">
                <a class="nav-link" href="#">건의</a>
            </li>
            <li class="nav-item text-center nav_five">
                <a class="nav-link active" href="#">신고</a>
            </li>
            <li class="nav-item text-center nav_five">
                <a class="nav-link" href="#">답변완료</a>
            </li>
        </ul>
    </c:if>
    <c:if test="${type eq 'DON'}">
        <ul class="nav nav-tabs">
            <li class="nav-item text-center nav_five">
                <a class="nav-link" href="#">ALL</a>
            </li>
            <li class="nav-item text-center nav_five">
                <a class="nav-link" href="#">문의</a>
            </li>
            <li class="nav-item text-center nav_five">
                <a class="nav-link" href="#">건의</a>
            </li>
            <li class="nav-item text-center nav_five">
                <a class="nav-link" href="#">신고</a>
            </li>
            <li class="nav-item text-center nav_five">
                <a class="nav-link active" href="#">답변완료</a>
            </li>
        </ul>
    </c:if>

    <ul class="list-group list-group-flush">
        <c:if test="${empty list}">
            <div class="text-center">
                등록된 문의가 없습니다.
            </div>
        </c:if>
        <c:if test="${!empty list}">
            <c:forEach var="vo" items="${list}">
                <li class="list-group-item">
                    <h5><span><c:out value="${vo.title}"></c:out></span>&nbsp;&nbsp;
                        <c:if test="${!empty vo.answerDate}">
                            <span class="badge badge-primary">답변완료</span>
                        </c:if>
                        <c:if test="${empty vo.answerDate}">
                            <span class="badge badge-danger">답변대기</span>
                        </c:if>
                    </h5>
                    문의 유형 : <span><c:out value="${vo.type.name}"></c:out></span>
                    <br/>
                    문의 날짜 : <span><c:out value="${vo.questionDate}"></c:out></span>
                    <button class="btn btn-outline-success btn-sm btn-block" style="margin-top: 5pt">문의 상세</button>
                </li>
            </c:forEach>
        </c:if>
    </ul>

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
        <button type="button" class="btn btn-outline-success two_button">문의작성</button>
        <button type="button" class="btn btn-outline-success float-right two_button">뒤로가기</button>
    </div>
</div>
<hr/>
<div class="last_block"></div>
</body>
</html>