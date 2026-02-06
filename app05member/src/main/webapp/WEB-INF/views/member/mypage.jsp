<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>켈로월드</title>
    <script defer src="http://127.0.0.1:8080/js/member/mypage.js"></script>
</head>
<body>
    <h1>회원가입</h1>
    <hr>
    <form action="/member/mypage" method="post" >
        <input type="text" name="nick" placeholder="변경할닉네임">
        <br>
        <input type="submit" value="수정하기" onclick="f01(event)">
    </form>
    <br>
    <button onclick="f02()">탈퇴하기</button>


</body>
</html>