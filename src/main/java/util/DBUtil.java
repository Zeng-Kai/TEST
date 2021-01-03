package util;

import bean.Comment;
import bean.Music;
import bean.User;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 工具类
public class DBUtil {
    static String user = "root";
    static String password = "xiao1997";
    static String url = "jdbc:mysql://localhost:3306/music_management?useSSL=false&serverTimezone=UTC";
    //返回连接
    public static Connection getConnection() throws SQLException {
        try{
            //反射
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;

        connection = DriverManager.getConnection(url,user,password);

        return connection;
    }
    // 获取List<Music>
    public static List<Music> secarhMusicByKeyWord(String sql, Object... args) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet re = null;
        Music bean = null;
        List<Music> listBean = new ArrayList<Music>();
        try {
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(sql);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("数据库出问题了");
        }
        // 设置参数
        if(args!=null&&args.length>0){
            for(int i = 0; i < args.length; i++){
                ps.setObject(i+1,args[i]);
            }
        }

        re = ps.executeQuery();
        while(re.next()){
            bean = new Music();
            bean.setMusicId(re.getInt(1));
            bean.setMusicName(re.getString(2));
            bean.setMommentNumber(re.getInt(3));
            bean.setListenNumber(re.getInt(4));
            bean.setDowmloadNumber(re.getInt(5));
            bean.setVipMusic(re.getBoolean(6));
            bean.setTagName(re.getString(7));
            bean.setSingerName(re.getString(8));
            listBean.add(bean);
        }
        connection.close();
        return listBean;
    }

    public static Music findMusicById(String sql, Object... args) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet re = null;
        Music bean = null;
        try {
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(sql);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("数据库出问题了");
        }
        // 设置参数
        if(args!=null&&args.length>0){
            for(int i = 0; i < args.length; i++){
                ps.setObject(i+1,args[i]);
            }
        }

        re = ps.executeQuery();
        while(re.next()){
            bean = new Music();
            bean.setMusicId(re.getInt(1));
            bean.setMusicName(re.getString(2));
            bean.setMommentNumber(re.getInt(3));
            bean.setListenNumber(re.getInt(4));
            bean.setDowmloadNumber(re.getInt(5));
            bean.setVipMusic(re.getBoolean(6));
            bean.setTagName(re.getString(7));
            bean.setSingerName(re.getString(8));
        }
        connection.close();
        return bean;
    }
    // 查询用户,返回单个用户对象
    public static User findOneUser(String sql, Object... args) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet re = null;
        User bean = null;
        try {
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(sql);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("数据库出问题了");
        }
        // 设置参数
        if(args!=null&&args.length>0){
            for(int i = 0; i < args.length; i++){
                ps.setObject(i+1,args[i]);
            }
        }
        re = ps.executeQuery();
        while(re.next()){
            bean = new User();
            bean.setUserId(re.getInt(1));
            bean.setUserName(re.getString(2));
            bean.setEmail(re.getString(3));
            bean.setPassword(re.getString(4));
            bean.setCreatedAt(null);
            bean.setModifiedAt(null);
            bean.setListenTime(re.getInt(7));
            bean.setVip(re.getBoolean(8));
        }
        connection.close();
        return bean;
    }
    public static List<User> findUserList(String sql, Object... args) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet re = null;
        List<User> list = new ArrayList<User>();
        User bean = null;
        try {
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(sql);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("数据库出问题了");
        }
        // 设置参数
        if(args!=null&&args.length>0){
            for(int i = 0; i < args.length; i++){
                ps.setObject(i+1,args[i]);
            }
        }
        re = ps.executeQuery();
        while(re.next()){

            bean = new User();
            list.add(bean);
            bean.setUserId(re.getInt(1));
            bean.setUserName(re.getString(2));
            bean.setEmail(re.getString(3));
            bean.setPassword(re.getString(4));
            bean.setCreatedAt(null);
            bean.setModifiedAt(null);
            bean.setListenTime(re.getInt(7));
            bean.setVip(re.getBoolean(8));
        }
        connection.close();
        return list;
    }
    public static void saveAndDelete(String sql, Object... args) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(sql);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("数据库出问题了");
        }
        // 设置参数
        if(args!=null&&args.length>0){
            for(int i = 0; i < args.length; i++){
                ps.setObject(i+1,args[i]);
            }
        }
        ps.executeUpdate();
        connection.close();
    }
//------------------collect
//    查询个数
    public static Integer searchNumber(String sql, Object... args) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        Integer number = 0;
        ResultSet re = null;
        try {
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(sql);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("数据库出问题了");
        }
        // 设置参数
        if(args!=null&&args.length>0){
            for(int i = 0; i < args.length; i++){
                ps.setObject(i+1,args[i]);
            }
        }
        re = ps.executeQuery();
        while(re.next()){
            number = re.getInt(1);
        }
        connection.close();
        return number;
    }
    // 获取List<Comment>
    public static List<Comment> findListComment(String sql, Object... args) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet re = null;
        Comment bean = null;
        List<Comment> listBean = new ArrayList<Comment>();
        try {
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(sql);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("数据库出问题了");
        }
        // 设置参数
        if(args!=null&&args.length>0){
            for(int i = 0; i < args.length; i++){
                ps.setObject(i+1,args[i]);
            }
        }

        re = ps.executeQuery();
        while(re.next()){
            bean = new Comment();
            bean.setCommentId(re.getInt(1));
            bean.setUserId(re.getInt(2));
            bean.setUserName(re.getString(3));
            bean.setMusicId(re.getInt(4));
            // 将sql.Date转换为util.Date
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(re.getTimestamp(5));
            bean.setDate(date);
            bean.setCommentText(re.getString(6));
            listBean.add(bean);
        }
        connection.close();
        return listBean;
    }

    // 查询，刚插入的最新的id
    public static Integer findNewId(String sql, Object... args) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet re = null;
        Integer newId = null;
        try {
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(sql);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("数据库出问题了");
        }
        // 设置参数
        if(args!=null&&args.length>0){
            for(int i = 0; i < args.length; i++){
                ps.setObject(i+1,args[i]);
            }
        }

        re = ps.executeQuery();
        while(re.next()){
           newId = re.getInt(1);
        }
        connection.close();
        return newId;
    }
}
