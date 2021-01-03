package dao;

import util.DBUtil;

import java.sql.SQLException;

public class CollectDao {
    // 判断用户是否收集了该歌曲
    public boolean isExist(String userId, String musicId){
        boolean flag = false;
        String sql = "select count(*) from tb_collect where user_id=? and music_id=?";
        Integer number = 0;
        try {
            number = DBUtil.searchNumber(sql,userId,musicId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return number>0;
    }
    // add
    public void add(String userId, String musicId){
        String sql = "insert into tb_collect(user_id,music_id) values(?,?)";
        try {
            DBUtil.saveAndDelete(sql,userId,musicId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(String userId, String musicId){

        String sql = "delete from tb_collect where user_id=? and music_id=?";
        try {
            DBUtil.saveAndDelete(sql,userId,musicId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
