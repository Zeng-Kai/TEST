package servlet;

// 根据关键字查询音乐
import bean.Music;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import dao.MusicDao;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
// 将java转化json需要引入的包
import com.alibaba.fastjson.JSON;
@WebServlet(urlPatterns = "/SearchServlet")
public class SearchServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // 关键字
        String keyWord = request.getParameter("keyWord");
        System.out.println("关键字"+keyWord);
        MusicDao dao = new MusicDao();
        List<Music> listMusic = null;
        listMusic = dao.secarhMusicByKeyWord(keyWord);

        for (Music music:listMusic) {
            System.out.println(music.getMusicName());
        }
        // 将List对象转换为json数组
        System.out.println(JSON.toJSONString(listMusic));
        response.getWriter().println(JSON.toJSONString(listMusic));
    }
}
