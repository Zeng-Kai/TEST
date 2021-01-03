package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(urlPatterns = "/testServlet")
public class testServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        addMp3(16);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    // 将本地路径更新到服务端MP3
    void addMp3(Integer musicId) throws IOException {
        //获取文件
        File file1= new File("G:\\WebProject\\musicSystem\\src\\main\\webapp\\music\\mid"+musicId+".mp3");
        // 并更新本地服务器
        // 如果文件不存在
        File file2= new File("G:\\WebProject\\musicSystem\\src\\main\\webapp\\music\\mid1.mp3");
        if(!file1.exists()){
            file1.createNewFile();
        }
        FileInputStream in = new FileInputStream(file2);
        byte[] bytes = new byte[1024];
        FileOutputStream out = new FileOutputStream(file1);
        while(in.read(bytes)!=-1){
            out.write(bytes);
        }
        out.close();
        in.close();
    }
    void updateMp3(){
        File f = new File("G:\\WebProject\\musicSystem\\src\\main\\webapp\\music\n");
        // 并更新本地服务器
    }
    void deleteMp3(){
        File f = new File("G:\\WebProject\\musicSystem\\src\\main\\webapp\\music\n");
        //并更新本地服务器
    }
}
