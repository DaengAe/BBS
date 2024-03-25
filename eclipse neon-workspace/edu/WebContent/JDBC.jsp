<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.sql.*"%>
<%

Class.forName("oracle.jdbc.driver.OracleDriver");

String url = "jdbc:oracle:thin:@localhost:1521:xe";

Connection conn = DriverManager.getConnection(url, "scott", "tiger");

Statement stmt = conn.createStatement();

// stmt.executeUpdate("create membertable(userid varchar2(20), userpassword varchar2(20), username varchar2(20), usergender varchar2(20), usermail varchar2(20))");

/*
stmt.executeUpdate("insert into test values('aa', '11')");
stmt.executeUpdate("insert into test values('bb', '22')");
stmt.executeUpdate("insert into test values('cc', '33')");
*/

ResultSet rs = stmt.executeQuery("select * from test");

while (rs.next()){
	out.print("<br>" + rs.getString("id") + ":" + rs.getString(2));
}

stmt.close();
conn.close();

%>
OK

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>