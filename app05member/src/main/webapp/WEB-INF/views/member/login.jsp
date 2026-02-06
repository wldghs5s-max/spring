<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>켈로월드</title>
    <script defer src="http://127.0.0.1:8080/js/member/login.js"></script>
</head>
<body>
    <h1>로그인</h1>
    <hr>
    <form action="/member/join" method="post" >
        <input type="text" name="id" placeholder="아이디입력">
        <br>
        <input type="password" name="pw" placeholder="비밀번호">
        <br>
        <input type="submit" value="로그인" onclick="f01(event)">
    </form>


</body>
</html>