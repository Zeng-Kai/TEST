package servlet;

import bean.User;
import com.alibaba.fastjson.JSON;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = null;
        UserDao userDao = new UserDao();
        user = userDao.findUserByEmailAndPassword(email,password);
        if(user==null){
            boolean flag = false;
            // 说明没有找到
            response.getWriter().println(JSON.toJSONString(flag));
        }
        else {
            boolean flag = true;
            // 说明找到了，登录成功
            request.getSession().setAttribute("user",user);
            response.getWriter().println(JSON.toJSONString(flag));
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
