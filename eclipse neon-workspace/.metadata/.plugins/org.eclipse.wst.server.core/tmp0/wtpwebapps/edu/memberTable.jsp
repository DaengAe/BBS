<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.sql.*"%>
<%

Class.forName("oracle.jdbc.driver.OracleDriver");

String url = "jdbc:oracle:thin:@localhost:1521:xe";

Connection conn = DriverManager.getConnection(url, "scott", "tiger");

Statement stmt = conn.createStatement();

stmt.executeUpdate("create table bbs(bbsid number primary key not null, bbstitle varchar2(50), userid varchar2(20), bbsdate timestamp default SYSDATE, bbscontents varchar2(1024), bbsavailable number)");

out.print("member 테이블이 생성 되었습니다.");


stmt.close();
conn.close();

%>