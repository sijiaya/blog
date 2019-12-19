package com.soft1841.web.blog.dao.Impl;

import com.soft1841.web.blog.dao.UserDao;
import com.soft1841.web.blog.entity.User;
import com.soft1841.web.blog.util.DataBaseConnection;
import com.soft1841.web.blog.util.DbUtil;
import com.soft1841.web.blog.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserDaoImpl
 * @Description UserDao数据访问对象接口实现类
 * @Author sj_yao
 * @Date 2019/12/4
 **/
public class UserDaoImpl extends JDBCUtil implements UserDao {
    @Override
    public boolean login(User user) throws Exception {
        Boolean flag= null;
        String sql = "SELECT * FROM db_space.t_user WHERE mobile = ? AND password = ?";
        DataBaseConnection dbc = new DataBaseConnection();
        try {
            PreparedStatement pst = dbc.getConnection().prepareStatement(sql);
            pst.setString(1,user.getMobile());
            pst.setString(2,user.getPassword());
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                flag = true;
                user.setMobile(rs.getString("mobile"));
                user.setPassword(rs.getString("password"));
            }
            rs.close();
            pst.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.close();
        }
        return flag;
    }


    @Override
    public int insert(User user) throws Exception {
        Connection conn = DbUtil.getConnection();
        String sql = "INSERT INTO db_space.t_user (mobile,password) VALUES (?,?) ";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, user.getMobile());
        pst.setString(2, user.getPassword());
        int n =pst.executeUpdate();
        DbUtil.close(conn,pst);
        return n;
    }

    @Override
    public User findUserByMobile(String mobile) throws Exception {
        Connection conn = DbUtil.getConnection();
        String sql ="SELECT * FROM db_space.t_user WHERE mobile = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,mobile);
        ResultSet rs = pst.executeQuery();
        List<User> userList = convert(rs);
        User user = null;
        if (userList.size()!=0){
            user = userList.get(0);
        }
        DbUtil.close(conn,pst,rs);
        return user;
    }

    @Override
    public List<User> selectHotUsers() throws Exception {
        Connection conn = DbUtil.getConnection();
        String sql = "SELECT * FROM db_space.t_user ORDER BY fans DESC LIMIT 20";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        List<User> userList = convert(rs);
        DbUtil.close(conn,pst,rs);
        return userList;
    }

    @Override
    public List<User> selectById(long id) throws Exception {
        Connection conn = DbUtil.getConnection();
        String sql = "SELECT * FROM db_space.t_user WHERE id = ?";
        PreparedStatement pst  = conn.prepareStatement(sql);
        pst.setLong(1,id);
        ResultSet rs = pst.executeQuery();
        List<User> userList = convert(rs);
        DbUtil.close(conn,pst,rs);
        return  userList;
    }
//
//    @Override
//    public List<User> selectByPage(int currentPage, int count) throws Exception {
//        Connection conn = DbUtil.getConnection();
//        String sql = "SELECT * FROM db_space.t_user LIMIT ?,?";
//        PreparedStatement pst = conn.prepareStatement(sql);
//        pst.setInt(1,(currentPage-1)*count);
//        pst.setInt(2,count);
//        ResultSet rs = pst.executeQuery();
//        List<User> userList = convert(rs);
//        DbUtil.close(conn,pst,rs);
//        return userList;
//    }

    @Override
    public List<User> selectByKeywords(String keywords) throws Exception {
        Connection conn = DbUtil.getConnection();
        String sql= "SELECT * FROM db_space.t_user WHERE nickname LIKE ?  OR introduction LIKE ? ";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,"%"+keywords+"%");
        pst.setString(2,"%"+keywords+"%");
        ResultSet rs = pst.executeQuery();
        List<User> userList =convert(rs);
        DbUtil.close(conn,pst,rs);
        return userList;
    }

    @Override
    public int update(User user) throws Exception {
        Connection conn = DbUtil.getConnection();
        String sql= "UPDATE db_space.t_user SET PASSWORD=?,nickname=?, avatar = ?, introduction = ? WHERE mobile = ? ";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,user.getPassword());
        pst.setString(2,user.getNickname());
        pst.setString(3,user.getAvatar());
        pst.setString(4,user.getIntroduction());
        pst.setString(5,user.getMobile());
        int n = pst.executeUpdate();
        DbUtil.close(conn,pst);
        return n;
    }

    @Override
    public boolean checkUser(User user) throws Exception {
        Connection con = DbUtil.getConnection();
        Boolean b = false;
        String sql = "SELECT mobile FROM db_space.t_user WHERE mobile = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,user.getMobile());
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                b = true;
            }
            rs.close();
            pst.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            con.close();
        }
        return b;
    }

    @Override
    public String checkId(User user) throws Exception {
        Connection con = DbUtil.getConnection();
        String id = null;
        String sql = "SELECT id FROM db_space.t_user where mobile=?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,user.getMobile());
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                id = rs.getString(1);
            }
            rs.close();
            pst.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }

    private List<User> convert(ResultSet rs)throws Exception{
        List<User> userList = new ArrayList<>();
        while (rs.next()){
            User user= new User();
            user.setId(rs.getLong("id"));
            user.setMobile(rs.getString("mobile"));
            user.setPassword(rs.getString("password"));
            user.setNickname(rs.getString("nickname"));
            user.setAvatar(rs.getString("avatar"));
            user.setGender(rs.getString("gender"));
//            user.setBirthday(rs.getDate("birthday").toLocalDate());
            user.setIntroduction(rs.getString("introduction"));
            user.setEmail(rs.getString("email"));
            user.setFans(rs.getInt("fans"));
            user.setArticles(rs.getInt("articles"));
//            user.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime());
            user.setStatus(rs.getShort("status"));
            user.setFlag(rs.getString("flag"));
            userList.add(user);
        }
        return userList;
    }
}
