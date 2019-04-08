package org.czh.mvcdemo.factory;

import org.czh.mvcdemo.dao.IUserDAO;
import org.czh.mvcdemo.dao.proxy.UserDAOProxy;

public class DAOFactory {
    public static IUserDAO getIUserDAOInstance() {
        return new UserDAOProxy();/*返回代理实例*/
    }
}
