<%--
  Created by IntelliJ IDEA.
  User: 11980
  Date: 2020/02/08
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改文件名</title>
</head>
<body>
<div style="text-align: center; font-size: large">
    <form action="ChangeName">
        输入文件夹的路径：<input type="text" name="filePath"/>
        <br>
        输入标准文件名(班级-姓名-学号-XXX)：<input type="text" name="fileName"/>
        <br>
        <input type="submit" value="提交"/>
    </form>
</div>
</body>
</html>
