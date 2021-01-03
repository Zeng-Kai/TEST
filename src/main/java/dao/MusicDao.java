package dao;

import bean.Music;
import util.DBUtil;

import java.sql.SQLException;
import java.util.List;

public class MusicDao {
    // 根据关键字寻找歌曲，并返回一个列表
    public List<Music> secarhMusicByKeyWord(String keyWord)  {
        String sql = "select * from tb_music where music_name like '%"+keyWord+"%'";
        List<Music> list = null;

        try {
            list = DBUtil.secarhMusicByKeyWord(sql,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    // 根据音乐的id，返回音乐music对象
    public Music findMusicById(Integer musicId) throws SQLException {
        String sql ="select * from tb_music where music_id = ?";
        Music music = null;
        music = DBUtil.findMusicById(sql,musicId);
        return music;
    }
    // 根据听歌次数多少进行排序
    public List<Music> rankListenNumber()  {
        String sql = "select * from tb_music ORDER BY listen_number DESC limit 2;";
        List<Music> list = null;

        try {
            list = DBUtil.secarhMusicByKeyWord(sql,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    // 查询收藏
    public List<Music> getMyCollectList(Integer userId){
        String sql = "select tb_collect.music_id,music_name,momment_number,listen_number,dowmload_number,is_vip_music,tag_name,singer_name from tb_music,tb_collect where user_id=? and tb_music.music_id = tb_collect.music_id";
        List<Music> list = null;
        try {
            list = DBUtil.secarhMusicByKeyWord(sql,userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    // 管理员进行删除音乐
    public void deleteMusic(Integer musicId){
        String sql = "delete from tb_music where music_id = ? ";
        try {
            DBUtil.saveAndDelete(sql,musicId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 更新歌曲操作
    public void updateMusic(Integer musicId,String musicName, String singerName){
        String sql = "update tb_music set  music_name=?,singer_name=? where music_id=?";
        try {
            DBUtil.saveAndDelete(sql,musicName,singerName,musicId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 新增音乐操作，音乐名 歌手名,并返回插入的id
    public Integer addMusic(String musicName, String singerName){
        // 插入
        String sql = "INSERT  INTO tb_music (music_name,singer_name) VALUES(?,?)";
        // 查询
        String sql2 = "select max(music_id) from tb_music";
        Integer newId = null;
        try {
            DBUtil.saveAndDelete(sql,musicName,singerName);
            newId = DBUtil.findNewId(sql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newId;
    }
}
