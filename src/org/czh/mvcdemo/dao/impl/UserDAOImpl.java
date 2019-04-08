package org.czh.mvcdemo.dao.impl;

import org.czh.mvcdemo.dao.IUserDAO;
import org.czh.mvcdemo.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl implements IUserDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public UserDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public boolean findLogin(User user) throws Exception {
        boolean flag = false;
        try {
            String sql = "SELECT name FROM user WHERE userid = ? AND password = ?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, user.getUserid());
            this.pstmt.setString(2, user.getPassword());
            ResultSet rs = this.pstmt.executeQuery();
            if (rs.next()) {
                user.setName(rs.getString(1));
                flag = true;
            }
        } catch (Exception e) {
            throw e;
        }finally {
            if (this.pstmt != null) {
                try {
                    this.pstmt.close();
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        return flag;
    }
}
