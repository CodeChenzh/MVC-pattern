package org.czh.mvcdemo.dao.proxy;

import org.czh.mvcdemo.dao.IUserDAO;
import org.czh.mvcdemo.dao.impl.UserDAOImpl;
import org.czh.mvcdemo.dbc.DatabaseConnection;
import org.czh.mvcdemo.vo.User;

public class UserDAOProxy implements IUserDAO {
    private DatabaseConnection dbc = null;
    private IUserDAO dao = null;/*定义DAO接口*/
    public UserDAOProxy() {
        try {
            this.dbc = new DatabaseConnection();/*实例化数据库连接*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dao = new UserDAOImpl(this.dbc.getConnection());
    }

    public boolean findLogin(User user) throws Exception {
        boolean flag = false;
        try {
            flag = this.dao.findLogin(user);/*调用真实主题*/
        } catch (Exception e) {
            throw e;   /*throw要么和try-catch语句一起用，放在try中，要么和throws一起用，不能单独使用*/
        } finally {
           this.dbc.close();
        }
        return flag;
    }
}
