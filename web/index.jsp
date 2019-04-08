<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
 <%--
  Created by IntelliJ IDEA.
  User: Chenzh
  Date: 2019/2/25
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <script language="JavaScript">
    function vaildate(f) {
      if (!(/^\w{5,15}$/.test(f.userid.value))) {
        alert("用户ID必须是5-15位！");
        f.userid.focus();
        return false;
      }
      if (!(/^\w{5,15}$/.test(f.userpass.value))) {
        alert("密码必须是5-15位！");
        f.userid.focus();
        return false;
      }
      return true;
    }
  </script>
  <body>
   <h2>用户登录程序</h2>
  <%
    request.setCharacterEncoding("GBK");/*乱码处理*/
  %>
  <%
    List<String> info = (List<String>) request.getAttribute("info");/*取得属性*/
    if (info != null) {
      Iterator<String> iter = info.iterator();
      while (iter.hasNext()) {
  %>
   <h4><%=iter.next()%></h4>
  <%
      }
    }
  %>
  <form action="LoginServlet" method="post" onsubmit="return vaildate(this)">
    用户ID：<input type="text" name = "userid"><br/>
    密&nbsp;&nbsp;码<input type="password" name="userpass"><br/>
    <input type="submit" value="登录">
    <input type="reset" value="重置">
  </form>
  </body>
</html>
