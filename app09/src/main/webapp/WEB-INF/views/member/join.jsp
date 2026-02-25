<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>헬로월드</title>

</head>
<body>
<h1>회원가입</h1>
<hr>

<form action="http://localhost:80/member/join" method="post" enctype="multipart/form-data">
    <input type="text" name="id">
    <br>
    <input type="password" name="pw">
    <br>
    <input type="text" name="nick">
    <br>
    <input type="file" name="f" >
    <br>
    <input type="button" value="회원가입" onclick="join();">
</form>
</body>
</html>