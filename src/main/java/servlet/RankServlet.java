package servlet;
/*
* RankServlet 用来计算排名，根据rank/*.html传来的参数判断根据那种方式进行排序
 已经现在的技术只能前20行
* */
import bean.Music;
import com.alibaba.fastjson.JSON;
import dao.MusicDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/RankServlet")
public class RankServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // 排序方式
        MusicDao dao  = new MusicDao();
        List<Music> list = null;
        String rankWay = request.getParameter("rankWay");
        if("listenNumber".equals(rankWay)){
            // 按照听歌次数进行排序
            list = dao.rankListenNumber();
        }
        // 将List对象转换为json数组
        System.out.println(JSON.toJSONString(list));
        response.getWriter().println(JSON.toJSONString(list));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
