<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>헬로월드</title>

</head>
<body>
<h1>HOME ~ !</h1>
<h3>${empty loginMemberVo ? "게스트" : loginMemberVo.nick}님 환영합니다.</h3>
</body>
</html>