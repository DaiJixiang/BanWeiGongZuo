<%@ page import="java.util.List" %>
<%@ page import="Bean.Students" %><%--
  Created by IntelliJ IDEA.
  User: 11980
  Date: 2020/02/08
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结果展示</title>
    <style>
        .person{
            width: 15%;
            float: left;
            text-align: center;
            margin: 0;
        }
        .person table{
            text-align: center;
        }
        .tab{
            margin-top: 20px;
            margin-bottom: 20px;
            width: 100%;
            float: left;
            text-align: center;
            border-top: solid black 3px;
            border-bottom: solid black 3px;
        }
    </style>
</head>
<body>
<%
    List<Students> unhandStudents = (List<Students>) request.getAttribute("unhandStudents");
    List<Students> handedStudents = (List<Students>) request.getAttribute("handedStudents");
%>
<div class="tab" align="center">
    已交名单<a href="1.jsp">返回主页面</a>
</div>
        <%
            int a=0;
            for (Students s : handedStudents) {
                a++;
        %>
    <div class="person">
        <table border="1">
            <tr><td width="50px"><%=s.getName()%></td><td width="50px"><%=s.getNumber()%></td></tr>
        </table>
    </div>
        <%
            }
        %>
<div class="tab">
        一共<%=a%>人
</div>
<div class="tab" align="center">
    未交名单
</div>
        <%
            int b=0;
            for (Students s : unhandStudents) {
                b++;
        %>
        <div class="person">
            <table border="1">
                <tr><td width="50px"><%=s.getName()%></td><td width="50px"><%=s.getNumber()%></td></tr>
            </table>
        </div>
        <%
            }
        %>
<div class="tab">
    一共<%=b%>人
</div>
</body>
</html>
