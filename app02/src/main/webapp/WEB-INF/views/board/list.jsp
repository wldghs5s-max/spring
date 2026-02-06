<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>헬로월드</title>

</head>
<body>
    <h1>게시글 목록</h1>
    <hr>
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>조회수</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                ${voList}
            </tr>
        </tbody>

    </table>
</body>
</html>