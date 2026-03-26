<%@ page import="java.lang.reflect.Member" %>
<%@ page import="com.kh.app.member.MemberVo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>세미</title>
    <script defer src="/js/board/detail.js"></script>
</head>
<body>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<main>
    <h1>게시글 상세조회</h1>
    <form>
        <label>작성자 닉네임 : </label><span id="writerNick"></span>
        <br>
        <label>조회수 : </label><span id="hit"></span>
        <br>
        <label>좋아요 : </label><span id="likeCount"></span>
        <br>
        <label>작성일시 : </label><span id="createdAt"></span>
        <br>
        <input type="text" name="title" placeholder="제목을 입력하세요" readonly> 
        <br>
        <textarea name="content" placeholder="내용을 입력하세요" readonly></textarea>
        <input type="button" value="수정하기" onclick="moveToEditPage();">
     
        
<%--        <input type="text" name="title" placeholder="제목을 입력하세요"> --%>
<%--        <br>--%>
<%--        <textarea name="content" placeholder="내용을 입력하세요"></textarea>--%>
<%--        <br>--%>
<%--        <input type="button" value="수정하기" onclick="edit();">--%>
<%--        <input type="button" value="삭제하기" onclick="del();">--%>
    </form>
    <hr>
    <div id="reply-area">
        <div id="reply-insert-area">
            <textarea name="reply-content" placeholder="댓글을 입력하세요"></textarea>
            <button onclick="insertReply();">댓글등록</button>
            <button onclick="like();" id="btn-like">🤍</button>
        </div>
        <div id="reply-list-area">
            
        </div>
    </div>
</main>

</body>
</html>