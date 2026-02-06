<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>헬로월드</title>
    <script defer src="http://127.0.0.1:8080/js/home.js"></script>

</head>
<body>
    <%@ include file="/WEB-INF/views/common/layout.jsp" %>
    <main>
        <h1>HOME ~ !</h1>
        <h3>${empty loginMemberVo ? "게스트" : loginMemberVo.nick}님 환영합니다!</h3>

        <hr>
        <h3>회원가입</h3>
        <form id="joinForm">
            <input type="text" name="id" placeholder="아이디">
            <br>
            <input type="password" name="pw" placeholder="비밀번호">
            <br>
            <input type="text" name="nick" placeholder="닉네임">
            <br>
            <input type="button" onclick="join();" value="회원가입">
        </form>
        <hr>
        <hr>
         <h3>로그인</h3>
         <form id="loginForm">
             <input type="text" name="id" placeholder="아이디">
             <br>
             <input type="password" name="pw" placeholder="비밀번호">
             <br>
             <input type="button" onclick="login();" value="로그인">
         </form>
         <hr>
                 <h3>닉네임변경</h3>
        <form id="editForm">
            <input type="text" name="nick" placeholder="닉네임">
            <br>
            <input type="button" onclick="editNick();" value="닉네임변경">
        </form>
        <hr>
        <button onclick="quit();">현재로그인 계정 탈퇴하기</button>
    </main>
</body>
</html>