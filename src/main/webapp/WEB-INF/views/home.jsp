<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--전체-->
<div class="container-fluid">
    <!--한행-->
    <div class="row" style="text-align: center;">
        <!--첫번째 블록-->
        <div style="width: 80%; margin: 20pt auto auto;">
            <!--로고 이미지-->
            <img src="../../images/1인의만찬.png" width="70%" class="img-fluid" alt="no title"/>
            <!--로그인 입력 폼-->
            <form style="text-align: left; margin-bottom: 15pt">
                <!--이메일 입력란-->
                <div class="form-group">
                    <!--라벨의 for와 이메일의 id가 일치해야함-->
                    <label for="user_email">이메일</label>
                    <input type="email" name="email" class="form-control" placeholder="name@example.com" id="user_email">
                </div>
                <!--비밀번호 입력란-->
                <div class="form-group">
                    <!--라벨의 for와 이메일의 id가 일치해야함-->
                    <label for="user_password">비밀번호</label>
                    <input type="password" class="form-control" id="user_password">
                </div>
                <!--전송 버튼-->
                <button type="submit" class="btn btn-success btn-block" id="login_button">로그인</button>
            </form>

            <button type="button" class="btn btn-outline-success btn-block" id="password_button">비밀번호 찾기</button>
            <button type="button" class="btn btn-outline-success btn-block" id="register_button">회원가입하기</button>
        </div>
    </div>
</div>
<div class="last_block"></div>
</body>
</html>
