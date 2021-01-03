package servlet;
/*
*   用户注册
*   参数method为check时,是浏览器发送异步请求
*   参数method为add时，是注册提交表单
* */
import bean.User;
import com.alibaba.fastjson.JSON;
import dao.MusicDao;
import dao.UserDao;
import org.omg.PortableInterceptor.INACTIVE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");
        if("check".equals(method)){
            // 查询邮箱是否重复,为false说明有重复的eamil
            boolean flag = false;
            String email = request.getParameter("email");

            UserDao dao = new UserDao();
            User user = null;
            user = dao.findUserByEmail(email);
            if(user == null){
                flag= true;
            }
            System.out.println(JSON.toJSONString(flag));
            response.getWriter().println(JSON.toJSONString(flag));

        }else if("add".equals(method)){
            // 为提交表单的注册
            User user = userPackaging(request);
            UserDao dao = new UserDao();
            dao.save(user);
            response.sendRedirect("login.html");
        }
    }
    // 根据请求封装
    public User userPackaging(HttpServletRequest request){
        String userName = request.getParameter("userName"); //用户名
        String password = request.getParameter("password"); //密码
        String email = request.getParameter("email"); //  邮箱
        //SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        Date createdAt = null;
        Date modifiedAt = null;
        Integer listenTime = 0;
        Boolean isVip = false;
        User user = new User(null,userName,email,password,createdAt,modifiedAt,listenTime,isVip);
        return user;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
