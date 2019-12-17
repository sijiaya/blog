package com.soft1841.web.blog.dao;

import com.soft1841.web.blog.entity.User;

import java.util.List;

/**
 * @ClassName UserDAO
 * @Description UserDao数据访问对象接口
 * @Author sj_yao
 * @Date 2019/12/4
 **/
public interface UserDao {
    /**
     * 登录验证
     * @param user
     * @return
     * @throws Exception
     */
    boolean login(User user)throws Exception;


    /**
     * 新增(注册)用户
     * @param user
     * @throws Exception
     */
    int insert(User user)throws Exception;

    /**
     * 根据手机号查找用户
     * @param mobile
     * @return
     * @throws Exception
     */
    User findUserByMobile(String mobile)throws Exception;



    /**
     * 热门用户查询
     * @return
     * @throws Exception
     */
    List<User> selectHotUsers()throws Exception;

    /**
     * 根据用户id查询
     * @return
     * @throws Exception
     */
    List<User> selectById(long id) throws Exception;


    /**
     * 模糊搜索用户
     * @param keywords
     * @return
     * @throws Exception
     */
    List<User> selectByKeywords(String keywords)throws Exception;

    /**
     * 修改用户
     * @param user
     * @throws Exception
     */
    int update(User user)throws Exception;

    /**
     * 检查注册用户是否存在
     * @param user
     * @return
     * @throws Exception
     */
    boolean checkUser(User user)throws Exception;

    /**
     * 查询用户id
     * @param user
     * @return
     * @throws Exception
     */
    String checkId(User user)throws Exception;
}
