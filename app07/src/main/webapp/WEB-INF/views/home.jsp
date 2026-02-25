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

<%--    <form action="http://127.0.0.1:8080/test" method="post" enctype="multipart/form-data">--%>
        <input type="file" name="f">
        <br>
<%--        <input type="submit" value="제출">--%>
        <input type="button" value="제출" onclick="f01();" multiple>
<%--    </form>--%>
        <script>
            function f01(){
                const fileList = document.querySelector("input[name=f]").files;
                const file = fileList[0];

                const fd = new FormData();
                fd.append("f", file);
                fetch(`http://127.0.0.1:8080/test`,{
                    method : "post",
                    body : fd,
                });
            }
        </script>
</body>
</html>