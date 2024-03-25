<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 뷰포트 -->
<meta name="viewport" content="width=device-width" initial-scale="1">
<!-- 스타일시트 참조  -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<style>
img {
    width: 50px;
    position: absolute;
    top: 0px;
    left: 10px;
}
.center{
 margin: 0 auto;
 width: 900px;
 display: block;
}
</style>

<title>정보통신학과</title>
</head>
<body>
	<%
	//로그인 한사람이면 userID라는 변수에 해당 아이디를 저장. 그렇지 않으면 null값 저장.
	
		String userID = null;
		if (session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
		}
	%>
	<!-- 네비게이션 -->
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expaned="false">
				<span class="icon-bar"></span><span class="icon-bar"></span><span
					class="icon-bar"></span>
			</button>
			<a href="main.jsp"><img src="symbol.gif" alt="로고"></a>
			<a class="navbar-brand" href="main.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;정보통신학과</a>
			</div>

				<%
					//로그인 안된경우
					if(userID == null) {
				%>
				<div class="collaspe navbar-collapse"
				id="#bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="main.jsp">메인</a></li>
					<li><a href="bbs.jsp">게시판</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">접속하기<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li class="active"><a href="login.jsp">로그인</a></li>
							<li><a href="join.jsp">회원가입</a></li>
						</ul></li>
				</ul>
				</div>
				<div class="container">
				<div class="row">
				<h1>로그인이 필요합니다.</h1>
					<ul>
						<li> 회원가입 시 이용 가능합니다.
						<li> 홈페이지를 이용하려면 로그인을 해주세요.
					</ul>

				</div>
				</div>
				<%
					//로그인 된경우
					} else {
				%>
				<div class="collaspe navbar-collapse"
				id="#bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="main.jsp">메인</a></li>
					<li><a href="bbs.jsp">게시판</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">회원관리<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="logoutAction.jsp">로그아웃</a></li>
						</ul></li>
				</ul>
				</div>
				<div class="container">
				<div class="row">
				<h1>로그인 완료!</h1>
					<ul>
						<li> 게시판 이용이 가능합니다.
						<li> 상단의 게시판 탭을 클릭해주세요.
					</ul>
				
				</div>
				</div>
				<%
					}
				%>
		
	</nav>
	
	<!-- 애니매이션 담당 JQUERY -->
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	
	<center>
			<video class="center" src="Comp1.mp4" type="video/mp4" loop autoplay muted>
			</video>
	</center>
</body>
</html>