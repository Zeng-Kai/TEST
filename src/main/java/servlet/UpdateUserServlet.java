package servlet;
/*
* 用于修改用户名、密码
* */
import bean.User;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");

        if("userName".equals(method)){

            // 修改用户名
            String userName =  request.getParameter("userName");
            User user = (User) request.getSession().getAttribute("user");
            Integer userId = user.getUserId() ;
            UserDao dao = new UserDao();

            // dao层
            dao.UpdateUserName(userName,userId);
            // 改变了用户名，session也要进行改变
            user.setUserName(userName);
            request.getSession().setAttribute("user",user);
        }else if("password".equals(method)){
            // 修改密码
            String password =  request.getParameter("password");
            User user = (User) request.getSession().getAttribute("user");
            Integer userId = user.getUserId() ;

            UserDao dao = new UserDao();

            dao.UpdatePassword(password,userId);
            // 改变了密码，session也要进行改变
            user.setPassword(password);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
