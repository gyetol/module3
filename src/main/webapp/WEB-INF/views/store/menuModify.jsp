<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%
	String path = "../menu/";
%>
<html>
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

    <title>Menu</title>
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

    <img src="../../icons/home-solid.svg" class="home" alt="home">

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">ë´ì ë³´ ë³´ê¸°</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">ì£¼ë¬¸ ë´ì­</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">1:1 ë¬¸ì</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#"> </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#"> </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">ë¡ê·¸ìì</a>
            </li>
        </ul>
    </div>
</nav>
<div class="container-fluid" style="margin-top: 15pt">
    <div class="text-center">
        <img src="../../images/1ì¸ìë§ì°¬.png" class="img-fluid img-title" alt="no title"/>
        <h2>ë©ë´ ì ë³´ ìì </h2>
    </div>
</div>
<hr/>

<div class="container-fluid">
    <form class="container-fluid text-left">

        <div class="form-group">
            <label for="menuName">ë©ë´ëª</label>
            <input type="text" class="form-control" id="menuName"/>
        </div>

        <div class="form-group">
            <label for="menuAmount">ì¬ê³  ìë</label>
            <input type="text" class="form-control" id="menuAmount">
        </div>

        <div class="form-group">
            <label for="exampleFormControlInput1">ë©ë´ ì¬ì§ ì²¨ë¶</label>
            <img src="../../images/table-cafe.jpg" width="100%" class="rounded" alt="no picture">
            <div id="emailCheckLabel">
                <input type="file" id="exampleFormControlInput1">
            </div>
        </div>

        <div class="form-group">
            <label for="inputKind">ì ê³µë°©ì</label>
            <select id="inputKind" class="form-control">
                <option>ëìë½</option>
                <option>ì¡°ë¦¬í¤í¸</option>
                <option>ìì ì¡°ë¦¬ì</option>
            </select>
        </div>

        <div class="form-group">
            <label for="menuMoney">ë©ë´ ê°ê²©</label>
            <input type="text" class="form-control margin_up" placeholder="ìì¸ì£¼ì" id="menuMoney"/>
        </div>

        <div class="form-group">
            <label for="tag">ë©ë´ íê·¸</label>
            <input type="tel" class="form-control" id="tag">
        </div>

        <div class="form-group">
            <label for="menuDes">ë©ë´ ì¤ëª</label>
            <textarea class="form-control" id="menuDes" placeholder="ë©ë´ì ëí´ì ì¤ëªí´ì£¼ì¸ì." rows="5"></textarea>
        </div>


        <div class="form-group" style="margin-bottom: 40pt">
            <label for="inputContent">ë©ë´ ì ì ì¬í­</label>
            <textarea class="form-control" id="inputContent" placeholder="ì¬ë£, ì¬ë£ ìì°ì§ ìë ë¥´ê¸° ì ë°ìíì ëí´ ì ì´ì£¼ì¸ì."
                      rows="5"></textarea>
        </div>

        <button type="button" class="btn btn-success two_button">ë©ë´ ìì  ìë£</button>
        <button type="button" class="btn btn-success two_button float-right">ë©ë´ ìì  ì·¨ìíê¸°</button>
    </form>
</div>
<hr/>
<div class="last_block"></div>
</body>
</html>