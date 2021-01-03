package servlet;
/*CollectServlet用于处理收藏有关的业务
* 当参数为check时，ajax，用于查询用户是否收藏了该歌曲
*....为add时，将未收藏改为收藏
* 当为delete时，将收藏改为未收藏
* */
import bean.Music;
import bean.User;
import com.alibaba.fastjson.JSON;
import dao.CollectDao;
import dao.MusicDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/CollectServlet")
public class CollectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("外部响应");
        String method = request.getParameter("method");
        if("check".equals(method)){
            // 查询用户是否收藏了该歌曲
            String musicId = request.getParameter("musicId");
            String userId = request.getParameter("userId");
            System.out.println(userId+","+musicId);
            CollectDao dao = new CollectDao();
            boolean flag = false;
            flag = dao.isExist(userId,musicId);
            System.out.println("是否收藏？？？"+JSON.toJSONString(flag));
            response.getWriter().println(JSON.toJSONString(flag));
        }else if("add".equals(method)){
            // 将未收藏改为收藏
            String musicId = request.getParameter("musicId");
            String userId = request.getParameter("userId");
            CollectDao dao = new CollectDao();
            dao.add(userId,musicId);

        }else if("delete".equals(method)){
            // 将收藏改为未收藏
            String musicId = request.getParameter("musicId");
            String userId = request.getParameter("userId");
            CollectDao dao = new CollectDao();
            dao.delete(userId,musicId);
        }else if("getMyCollectList".equals(method)){
            System.out.println("内部响应");
            // 查询列表个人收藏列表
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            User user = (User) request.getSession().getAttribute("user");
            Integer userId = user.getUserId();
            MusicDao dao = new MusicDao();
            List<Music> list = dao.getMyCollectList(userId);
            System.out.println("查询个人收藏。。。列表"+JSON.toJSONString(list));
            response.getWriter().println(JSON.toJSONString(list));
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
