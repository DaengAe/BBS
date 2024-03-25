<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>로그인</title>
</head>
<body>

<h3> 로그인 </h3>
${error}
<form action="login.do" method="post">
	ID : <input type="text"  name="id" /><br>
	 비밀번호 : <input type="password"  name="passwd" ><br>
  <input type="submit"  value="로그인" />
  <input type="hidden" name="job" value="login" />
</form>
</body>
</html>