package com.soft1841.web.blog.dao.Impl;

import com.soft1841.web.blog.dao.UserDao;
import com.soft1841.web.blog.entity.User;
import com.soft1841.web.blog.factory.DaoFactory;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;


/**
 * @ClassName UserDaoImplTest
 * @Description TODO
 * @Author sj_yao
 * @Date 2019/12/5
 **/
public class UserDaoImplTest {
    private UserDao userDao = DaoFactory.getUserDaoInstance();

    @Test
    public void insert() throws Exception {
        User user =new User("13434344327","333");
        userDao.insert(user);
    }

    @Test
    public void findUserByMobile() throws Exception{
        User user = userDao.findUserByMobile("18296437674");
        System.out.println("根据手机号查找用户"+user);
    }

    @Test
    public void selectHotUsers() throws Exception {
        List<User> userList = userDao.selectHotUsers();
        userList.forEach(System.out::println);
    }

    @Test
    public void selectById() throws Exception{
        List<User> userList = userDao.selectById(3);
        System.out.println("根据用户id查询："+userList);
    }
//
//    @Test
//    public void selectByPage() throws Exception{
//    }

    @Test
    public void selectByKeywords() throws Exception{
        List<User> userList = userDao.selectByKeywords("小");
        System.out.println("通过关键字查询个数："+userList.size());
    }

    @Test
    public void update() throws Exception{
        User user = new User();
        user.setMobile("17826352842");
        user.setNickname("嗯嗯嗯");
        user.setPassword("111");
        user.setIntroduction("first");
        userDao.update(user);
    }
}
