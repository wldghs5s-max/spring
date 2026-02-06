package com.kh.app01.member;

public class MemberVo {

    private String no;
    private String id;
    private String pw;
    private String nick;
    private String createdAt;
    private String updatedAt;
    private String quitYn;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getQuitYn() {
        return quitYn;
    }

    public void setQuitYn(String quitYn) {
        this.quitYn = quitYn;
    }

    public MemberVo(String no, String id, String pw, String nick, String createdAt, String updatedAt, String quitYn) {
        this.no = no;
        this.id = id;
        this.pw = pw;
        this.nick = nick;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.quitYn = quitYn;
    }

    public MemberVo() {
    }

    @Override
    public String toString() {
        return "MemberVo{" +
                "no='" + no + '\'' +
                ", id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", nick='" + nick + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", quitYn='" + quitYn + '\'' +
                '}';
    }
}


























