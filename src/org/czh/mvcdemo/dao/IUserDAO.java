package org.czh.mvcdemo.dao;

import org.czh.mvcdemo.vo.User;
/*登录验证*/
public interface IUserDAO {

    public boolean findLogin(User user) throws Exception;
}
