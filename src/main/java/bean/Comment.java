package bean;

import java.util.Date;

/*评论
* */
public class Comment {
    private Integer commentId; //评论id
    private Integer userId; //用户id
    private String userName;// 用户名
    private Integer musicId; //歌曲id
    private String CommentText; // 评论
    private String date;

    public Comment() {
    }

    public Comment(Integer commentId, Integer userId, String userName, Integer musicId, String commentText, String date) {
        this.commentId = commentId;
        this.userId = userId;
        this.userName = userName;
        this.musicId = musicId;
        CommentText = commentText;
        this.date = date;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getMusicId() {
        return musicId;
    }

    public void setMusicId(Integer musicId) {
        this.musicId = musicId;
    }

    public String getCommentText() {
        return CommentText;
    }

    public void setCommentText(String commentText) {
        CommentText = commentText;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
