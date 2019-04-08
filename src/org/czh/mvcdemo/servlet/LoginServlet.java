package org.czh.mvcdemo.servlet;
/*用servlet完成控制层*/
import org.czh.mvcdemo.factory.DAOFactory;
import org.czh.mvcdemo.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "Servlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);/*调用doGet操作*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "index.jsp";
        String userid = request.getParameter("userid");/*接收userid内容*/
        String userpass = request.getParameter("userpass");/*接收userpass内容*/
        List<String> info = new ArrayList<>();/*保存所有返回信息*/
        if (userid == null || "".equals(userid)) {
            info.add("用户id不能为空");/*增加错误信息1*/
        }
        if (userpass == null || "".equals(userpass)) {      /*先判断是不是对象，如果是，再判断是不是空字符串*/
            info.add("用户密码不能为空");/*增加错误信息*/
        }
        if (info.size() == 0) {/*用户名和密码验证通过*/
            User user = new User();/*实例化VO*/
            user.setUserid(userid);/*设置userid*/
            user.setPassword(userpass);/*设置password*/
            try {
                if (DAOFactory.getIUserDAOInstance().findLogin(user)) {/*验证通过*/
                    info.add("用户登录成功，欢迎" + user.getName() + "光临！");
                } else {
                    info.add("用户登录失败，错误的用户名或密码！");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute("info", info);/*保存错误信息*/
            request.getRequestDispatcher(path).forward(request, response);/*跳转*/
        }
    }
}
