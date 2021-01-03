package servlet;
/*
* 管理员对音乐操作
*
* */
import bean.Music;
import com.alibaba.fastjson.JSON;
import dao.MusicDao;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.List;
@MultipartConfig()
@WebServlet(urlPatterns = "/AdministratorMusicServlet")
public class AdministratorMusicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");
        if("findUserListByKeyWord".equals(method)){
            String keyWord = request.getParameter("keyWord");
            System.out.println(keyWord);
            MusicDao dao = new MusicDao();
            List<Music> list = dao.secarhMusicByKeyWord(keyWord);
            // 将List对象转换为json数组
            System.out.println(JSON.toJSONString(list));
            response.getWriter().println(JSON.toJSONString(list));
        }else if("delete".equals(method)){
            Integer musicId = Integer.parseInt(request.getParameter("musicId"));
            MusicDao dao = new MusicDao();
            dao.deleteMusic(musicId);
            response.getWriter().println(JSON.toJSONString("hello"));
        }else if("update".equals(method)){ // 修改歌曲
            System.out.println("进入咯，修改歌曲");
            Integer musicId = Integer.parseInt(request.getParameter("musicId"));
            String musicName = request.getParameter("musicName");
            String singerName = request.getParameter("singerName");
            MusicDao dao = new MusicDao();
            dao.updateMusic(musicId,musicName,singerName);
            updatePictuer(request);
            updateAudio(request);
            response.getWriter().println(JSON.toJSONString("hello"));
        }else if("add".equals(method)){ // 新增歌曲
            String musicName = request.getParameter("musicName");
            String singerName = request.getParameter("singerName");
            MusicDao dao = new MusicDao();
            Integer musicId =  dao.addMusic(musicName,singerName);
            updatePictuer(request,musicId);
            updateAudio(request,musicId);
            response.getWriter().println(JSON.toJSONString("hello"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }


    // 更新本地照片和服务器照片
    public void updatePictuer(HttpServletRequest request) throws IOException, ServletException {
        Part part = request.getPart("musicPhoto");
        Integer musicId = Integer.parseInt(request.getParameter("musicId"));
        // 保存到本地
        File file1= new File("G:\\WebProject\\musicSystem\\src\\main\\webapp\\images\\mid"+musicId+".png");
        if(!file1.exists()){
            //如果文件不存在说明业务是新建歌曲，创建图片，如果存在则是修改歌曲
            file1.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(file1);
        // 获取上传文件的输出流
        InputStream in= part.getInputStream();
        byte[] bytes = new byte[1024];
        while((in.read(bytes))!=-1){
            System.out.println("123");
            out.write(bytes);
        }
        in.close();
        out.close();
        //---------------以上义务是保存到本地,重新部署可以找到
        //上传到服务器文件路径
        part.write(request.getSession().getServletContext().getRealPath("images")+"\\mid"+musicId+".png");
    }
    //更新本地音频和服务器音频
    public void updateAudio(HttpServletRequest request) throws IOException, ServletException {
        Part part = request.getPart("musicAudio");
        Integer musicId = Integer.parseInt(request.getParameter("musicId"));
        // 保存到本地
        File file1= new File("G:\\WebProject\\musicSystem\\src\\main\\webapp\\music\\mid"+musicId+".mp3");
        if(!file1.exists()){
            //如果文件不存在说明业务是新建歌曲，创建图片，如果存在则是修改歌曲
            file1.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(file1);
        // 获取上传文件的输出流
        InputStream in= part.getInputStream();
        byte[] bytes = new byte[1024];
        while((in.read(bytes))!=-1){
            System.out.println("123");
            out.write(bytes);
        }
        in.close();
        out.close();
        //---------------以上义务是保存到本地,重新部署可以找到
        // 上传到服务器文件路径
        part.write(request.getSession().getServletContext().getRealPath("music")+"\\mid"+musicId+".mp3");
    }
    // 新增本地/服务器照片
    public void updatePictuer(HttpServletRequest request,Integer musicId) throws IOException, ServletException {
        Part part = request.getPart("musicPhoto");
        // 保存到本地
        File file1= new File("G:\\WebProject\\musicSystem\\src\\main\\webapp\\images\\mid"+musicId+".png");
        if(!file1.exists()){
            //如果文件不存在说明业务是新建歌曲，创建图片，如果存在则是修改歌曲
            file1.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(file1);
        // 获取上传文件的输出流
        InputStream in= part.getInputStream();
        byte[] bytes = new byte[1024];
        while((in.read(bytes))!=-1){
            System.out.println("123");
            out.write(bytes);
        }
        in.close();
        out.close();
        //---------------以上义务是保存到本地,重新部署可以找到
        //上传到服务器文件路径
        part.write(request.getSession().getServletContext().getRealPath("images")+"\\mid"+musicId+".png");
    }
    //更新本地音频和服务器音频
    public void updateAudio(HttpServletRequest request,Integer musicId) throws IOException, ServletException {
        Part part = request.getPart("musicAudio");
        // 保存到本地
        File file1= new File("G:\\WebProject\\musicSystem\\src\\main\\webapp\\music\\mid"+musicId+".mp3");
        if(!file1.exists()){
            //如果文件不存在说明业务是新建歌曲，创建图片，如果存在则是修改歌曲
            file1.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(file1);
        // 获取上传文件的输出流
        InputStream in= part.getInputStream();
        byte[] bytes = new byte[1024];
        while((in.read(bytes))!=-1){
            System.out.println("123");
            out.write(bytes);
        }
        in.close();
        out.close();
        //---------------以上义务是保存到本地,重新部署可以找到
        // 上传到服务器文件路径
        part.write(request.getSession().getServletContext().getRealPath("music")+"\\mid"+musicId+".mp3");
    }
}
