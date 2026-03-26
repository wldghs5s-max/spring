<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>세미</title>
    <script defer src="/js/board/list.js"></script>
</head>
<body>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<main>
    <h1>게시글 목록</h1>
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>조회수</th>
            </tr>
        </thead>
        <tbody></tbody>
    </table>
    <input type="button" value="글쓰기" onclick="location.href=`/board/insert`">
    <div id="page-area"></div>
</main>

</body>
</html>