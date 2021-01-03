package servlet;
/*
* 用于查询特定歌曲的评论
*
* */
import bean.Comment;
import com.alibaba.fastjson.JSON;
import dao.CommentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/CommentServlet")
public class CommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        System.out.println(method);
        if ("find".equals(method)) {
            // find参数为查找所有的评论集合
            response.setCharacterEncoding("UTF-8");
            String musicId = request.getParameter("musicId");
            System.out.println(musicId);
            CommentDao dao = new CommentDao();
            //
            List<Comment> list = dao.findCommentByMusicId(musicId);
            System.out.println("评论值" + JSON.toJSONString(list));
            response.getWriter().println(JSON.toJSONString(list));
        } else if ("add".equals(method)) {
            // add 为新增评论
            Integer musicId = Integer.parseInt(request.getParameter("musicId"));
            Integer userId = Integer.parseInt(request.getParameter("userId"));
            String commentText = request.getParameter("commentText");
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
            Comment comment = new Comment(null, userId, null, musicId, commentText, date);
            CommentDao dao = new CommentDao();
            dao.addComment(comment);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
