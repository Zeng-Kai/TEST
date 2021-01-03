package servlet;
/*
用户点击指定的音乐，然后传音乐id到这个servlet，然后数据库，根据music的id查询
 */
import bean.Music;
import dao.MusicDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/PlayMusicServlet")
public class PlayMusicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Integer musicId = Integer.parseInt(request.getParameter("musicId"));
        Music music = null;
        MusicDao dao = new MusicDao();
        try {
            music = dao.findMusicById(musicId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("music",music);
        /*每次播放都要将播放量+1
        *
        *
        *
        * */
        request.getRequestDispatcher("play.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
