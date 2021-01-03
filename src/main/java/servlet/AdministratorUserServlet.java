package servlet;
/*
* 管理员操作用户事件
*
* */
import bean.User;
import com.alibaba.fastjson.JSON;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/AdministratorUserServlet")
public class AdministratorUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // 关键字可以是用户名
        String method = request.getParameter("method");
        if("findUserListByKeyWord".equals(method)){
            String keyWord = request.getParameter("keyWord");
            System.out.println(keyWord);
            UserDao dao = new UserDao();
            List<User> list = dao.administratorSearchUserKeyWord(keyWord);
            // 将List对象转换为json数组
            System.out.println(JSON.toJSONString(list));
            response.getWriter().println(JSON.toJSONString(list));
        }else if("delete".equals(method)){
            // 删除操作
            Integer userId = Integer.parseInt(request.getParameter("userId"));
            UserDao dao = new UserDao();
            System.out.println(userId);
            dao.deleteUser(userId);
            // 必须要响应一下，因为前端有刷新操作
            response.getWriter().println(JSON.toJSONString("hello"));
        }else if("update".equals(method)){
            // 修改用户资料操作
            Integer userId = Integer.parseInt(request.getParameter("userId"));
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            UserDao dao = new UserDao();
            // 更改用户名和密码
            dao.updateUserNameAndPassword(userId,userName,password);
            response.getWriter().println(JSON.toJSONString("hello"));
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
