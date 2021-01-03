package dao;

import bean.User;
import util.DBUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserDao {
    public User findUserByEmail(String email){
        User user = null;
        String sql  = "select * from tb_user where email=?";
        try {
            user = DBUtil.findOneUser(sql,email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public void save(User user){
        String sql = "insert into tb_user(user_name,email,password,createdAt,modifiedAt,listen_time,is_vip) values(?,?,?,?,?,?,?)";
        try {
            DBUtil.saveAndDelete(sql,user.getUserName(),user.getEmail(),user.getPassword(),user.getCreatedAt(),user.getModifiedAt(),user.getListenTime(),user.isVip());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public User findUserByEmailAndPassword(String email, String password){
        String sql  = "select * from tb_user where email=? and password=?";
        User user = null;
        try {
            user = DBUtil.findOneUser(sql,email,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public void UpdateUserName(String userName, Integer userId){
        String sql = "update tb_user set  user_name=? where user_id=?";
        try {
            DBUtil.saveAndDelete(sql,userName,userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void UpdatePassword(String password,Integer userId){
        String sql = "update tb_user set  password=? where user_id=?";
        try {
            DBUtil.saveAndDelete(sql,password,userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 管理员根据关键字获取用户，关键字可以是用户名，也可以是用户id(扩)
    public List<User> administratorSearchUserKeyWord(String keyWord){
        // 用户名模糊查询
        String sql  = "select * from tb_user where user_name like '%"+keyWord+"%'";
        List<User> list = null;
        try {
            list =  DBUtil.findUserList(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void deleteUser(Integer userId){
        String sql = "delete from tb_user where user_id = ? ";
        try {
            DBUtil.saveAndDelete(sql,userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 通过id，更新用户的账号和密码 管理员操作
    public void updateUserNameAndPassword(Integer userId,String userName, String password){
        String sql = "update tb_user set  user_name=?,password=? where user_id=?";
        try {
            DBUtil.saveAndDelete(sql,userName,password,userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
