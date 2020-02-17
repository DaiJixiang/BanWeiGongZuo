<%--
  Created by IntelliJ IDEA.
  User: 11980
  Date: 2020/02/06
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="Bean.Students" %>
<%@ page import="java.util.List" %>
<html>
  <head>
    <title>纸质档使用页面</title>
      <style>
          .person{
              width: 15%;
              float: left;
          }
          .person_check{
              width: 40px;
              height: 60px;
              font-size: small;
          }
      </style>
      <script>
          function visible(i) {
              document.getElementById("div" + i).style.display = "none";
          }
      </script>
  </head>
  <body>
<div>
    <a href="1.jsp">返回主页面</a>
</div>
  <%
    int i = 0;
    List<Students> students = (List<Students>)request.getAttribute("students");
    for (Students s:students){
//      System.out.println(s.getName()+s.getNumber());
      i++;
  %>
  <div id="div<%=i%>" class="person">
      <div style="float: left">
          <input class="person_check" name="<%=i%>" value="确认" type="button" onclick="visible(<%=i%>)"/>
      </div>
      <table border="1">
          <tr><td><%=s.getName()%></td></tr>
          <tr><td><%=s.getNumber()%></td></tr>
      </table>
  </div>
  <%
    }
  %>
  </body>
</html>
