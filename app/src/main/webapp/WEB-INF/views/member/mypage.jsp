<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>세미</title>
    <script defer src="/js/member/mypage.js"></script>
</head>
<body>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<main>
    <h1>마이페이지</h1>
    <form>
        <input type="text" name="id" placeholder="아이디입력" value="${loginMemberVo.id}" readonly>
        <br>
        <input type="password" name="pw" placeholder="비밀번호">
        <br>
        <input type="password" name="pw2" placeholder="비밀번호 확인">
        <br>
        <span id="pwMatchResult"></span>
        <br>
        <input type="text" name="nick" placeholder="닉네임" value="${loginMemberVo.nick}">
        <br>
        <div id="hobby-area">
            
        </div>
        
        <br>
        <label>프로필 사진 : </label>
        <input type="file" name="profile">
        <br>
        <input type="button" value="정보수정" onclick="edit();">
        <input type="button" value="탈퇴하기" onclick="quit();">
    </form>
</main>

</body>
</html>