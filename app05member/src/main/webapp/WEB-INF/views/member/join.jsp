<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>켈로월드</title>
    <script defer src="http://127.0.0.1:8080/js/member/join.js"></script>
</head>
<body>
    <h1>회원가입</h1>
    <hr>
    <form action="/member/join" method="post" >
        <input type="text" name="id" placeholder="아이디입력">
        <br>
        <input type="password" name="pw" placeholder="비밀번호">
        <br>
        <input type="text" name="nick" placeholder="닉네임">
        <br>
        <input type="submit" value="회원가입" onclick="f01(event)">
    </form>


</body>
</html>