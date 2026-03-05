<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>세미</title>
    <script defer src="/js/board/insert.js"></script>
</head>
<body>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<main>
    <h1>게시글 작성</h1>
    <form>
        <input type="text" name="title" placeholder="제목을 입력하세요">
        <br>
        <textarea name="content" placeholder="내용을 입력하세요"></textarea>
        <br>
        <input type="button" value="작성하기" onclick="insert();">
    </form>
</main>

</body>
</html>