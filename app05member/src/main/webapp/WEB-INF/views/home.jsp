<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>켈로월드</title>

</head>
<body>
<h1>HOME ~ !</h1>

<h2>${empty loginMemberVo ? "GUEST" : loginMemberVo.nick}님 환영합니다.</h2>
</body>
</html>