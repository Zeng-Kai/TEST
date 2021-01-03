package dao;

import bean.Comment;
import util.DBUtil;

import java.sql.SQLException;
import java.util.List;

public class CommentDao {
    public List<Comment> findCommentByMusicId(String musicId){
        List<Comment> list = null;
        // 因为要有用户名名字，所以要用到多表查询
        String sql ="select momment_id,tb_comment.user_id,user_name,music_id,comment_time,comment_text from tb_comment,tb_user where tb_comment.user_id=tb_user.user_id and music_id=? ";
        try {
            list= DBUtil.findListComment(sql,musicId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void addComment(Comment comment){
        String sql = "insert into tb_comment(user_id,music_id,comment_time,comment_text) values(?,?,?,?)";
        try {
            DBUtil.saveAndDelete(sql,comment.getUserId(),comment.getMusicId(),comment.getDate(),comment.getCommentText());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
