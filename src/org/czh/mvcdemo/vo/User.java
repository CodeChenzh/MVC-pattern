package org.czh.mvcdemo.vo;
/*VO类，有属性，set和get方法组成*/
public class User {
    private String userid;/*对应userid列*/
    private String name;/*对应name列*/
    private String password;/*对应password列*/

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
