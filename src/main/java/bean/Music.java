package bean;

import org.omg.PortableInterceptor.INACTIVE;

public class Music {
    private Integer musicId;
    private String musicName;
    private Integer mommentNumber; // 评论数
    private Integer listenNumber; // 被听次数
    private Integer dowmloadNumber; // 下载次数
    private boolean isVipMusic; // 是否为vip歌曲，是为true
    private String tagName; // 标签名，例如 华语、欧美、粤语、
    private String singerName;

    public Music() {
    }


    public Music(Integer musicId, String musicName, Integer mommentNumber, Integer listenNumber, Integer dowmloadNumber, boolean isVipMusic, String tagName, String singerName) {
        this.musicId = musicId;
        this.musicName = musicName;
        this.mommentNumber = mommentNumber;
        this.listenNumber = listenNumber;
        this.dowmloadNumber = dowmloadNumber;
        this.isVipMusic = isVipMusic;
        this.tagName = tagName;
        this.singerName = singerName;
    }
    public Integer getMusicId() {
        return musicId;
    }

    public void setMusicId(Integer musicId) {
        this.musicId = musicId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public Integer getMommentNumber() {
        return mommentNumber;
    }

    public void setMommentNumber(Integer mommentNumber) {
        this.mommentNumber = mommentNumber;
    }

    public Integer getListenNumber() {
        return listenNumber;
    }

    public void setListenNumber(Integer listenNumber) {
        this.listenNumber = listenNumber;
    }

    public Integer getDowmloadNumber() {
        return dowmloadNumber;
    }

    public void setDowmloadNumber(Integer dowmloadNumber) {
        this.dowmloadNumber = dowmloadNumber;
    }

    public boolean isVipMusic() {
        return isVipMusic;
    }

    public void setVipMusic(boolean vipMusic) {
        isVipMusic = vipMusic;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }
}
