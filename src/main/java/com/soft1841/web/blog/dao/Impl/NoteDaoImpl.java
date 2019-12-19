package com.soft1841.web.blog.dao.Impl;


import com.soft1841.web.blog.dao.NoteDao;
import com.soft1841.web.blog.entity.Note;
import com.soft1841.web.blog.util.DataBaseConnection;
import com.soft1841.web.blog.util.JDBCUtil;
import com.soft1841.web.blog.util.SplitPage;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NoteDaoImpl extends JDBCUtil implements NoteDao {
    @Override
    public int insert(Note note) throws Exception {
        //新增留言
        int n ;
        String sql = "INSERT INTO db_space.t_note(title,author,content) VALUES (?,?,?) ";
        PreparedStatement pstmt = null;
        DataBaseConnection dbc = null;
        dbc= new DataBaseConnection();
        pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setString(1,note.getTitle());
        pstmt.setString(2,note.getAuthor());
        pstmt.setString(3,note.getContent());
        n = pstmt.executeUpdate();
        return n;
    }

    @Override
    public int delete(int id) throws Exception {
        //根据Id删除留言
        String sql = "DELETE FROM db_space.t_note WHERE note_id=?";
        PreparedStatement pstmt = null;
        DataBaseConnection dbc = null;
        dbc = new DataBaseConnection();
        pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setInt(1,id);
        int n = pstmt.executeUpdate();
        pstmt.close();
        dbc.close();
        return n;


    }

    @Override
    public Note queryById(int id) throws Exception {
        //根据id查询留言
        String sql = "SELECT * FROM db_space.t_note WHERE note_id=?";
        PreparedStatement pstmt = null;
        DataBaseConnection dbc = null;
        dbc = new DataBaseConnection();
        pstmt = dbc.getConnection().prepareStatement(sql);
        Note note = new Note();
        pstmt.setInt(1,id);
        ResultSet rs = pstmt.executeQuery();
        try {
            if (rs.next()){
                note.setNoteId(rs.getInt("note_id"));
                note.setTitle(rs.getString("title"));
                note.setAuthor(rs.getString("author"));
                note.setContent(rs.getString("content"));
            }
            rs.close();
            pstmt.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.close();
        }

        return note;
    }


    @Override
    public List<Note> queryAll() throws Exception {
        //查询所有留言
        String sql = "SELECT * FROM db_space.t_note ";
        PreparedStatement pstmt = null;
        DataBaseConnection dbc = null;
        dbc = new DataBaseConnection();
        pstmt = dbc.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Note> noteList = new ArrayList<>();
        try {
            while (rs.next()) {
                Note note = new Note();
                note.setNoteId(rs.getInt("note_id"));
                note.setTitle(rs.getString("title"));
                note.setAuthor(rs.getString("author"));
                note.setContent(rs.getString("content"));
                noteList.add(note);
            }
            pstmt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            dbc.close();
        }
        return noteList;

    }

    @Override
    public List<Note> findAll(SplitPage sp) throws Exception {
        List<Note> list = new ArrayList<Note>();
        String sql ="select * from db_space.t_note limit " +sp.getPageRows()*(sp.getCurrentPage()-1)+","+sp.getPageRows();
        PreparedStatement pstmt = null;
        DataBaseConnection dbc = null;
        dbc = new DataBaseConnection();
        try{
            pstmt = dbc.getConnection().prepareStatement(sql);
            ResultSet rs  =pstmt.executeQuery();
            while (rs.next()){
                Note note = new Note();
                note.setNoteId(rs.getInt(1));
                note.setTitle(rs.getString(2));
                note.setAuthor(rs.getString(3));
                note.setContent(rs.getString(4));
                list.add(note);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            pstmt.close();
            dbc.close();
        }
        return list;
    }

    @Override
    public int getRows(HashMap tm) throws Exception {
        List<Note> list = null;
        if (tm.isEmpty()){
            list=queryAll();
        }else{
            list=queryByLike(tm);
        }
        int num = list.size();
        return num;
    }

    @Override
    public List<Note> queryByLike(HashMap<String ,String > cond) throws Exception {
        List<Note> list = new ArrayList();
        String str = null;
        if (cond.containsKey("title")) {
            str = "title LIKE "+" '%"+cond.get("title")+"%'";
        }
        if (cond.containsKey("author")) {
            str = "author LIKE "+" '%"+cond.get("author")+"%'";
        }
        if (cond.containsKey("content")) {
            str = "content LIKE"+" '%"+cond.get("content")+"%'";
        }
        String sql = "SELECT * FROM note WHERE " + str;
        DataBaseConnection dbc = null;
        dbc = new DataBaseConnection();
        try{
            ResultSet rs  =this.executeQueryRS(sql);
            while (rs.next()){
                Note note = new Note();
                note.setNoteId(rs.getInt(1));
                note.setTitle(rs.getString(2));
                note.setAuthor(rs.getString(3));
                note.setContent(rs.getString(4));
                list.add(note);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.close();
        }
        return list;
    }

    @Override
    public List<Note> queryByLike(HashMap cond, SplitPage sp) throws Exception {
        List<Note> list = new ArrayList();
        String str = null;
        if (cond.containsKey("title")) {
            str = "title LIKE "+" '%"+cond.get("title")+"%'";
        }
        if (cond.containsKey("author")) {
            str = "author LIKE "+" '%"+cond.get("author")+"%'";
        }
        if (cond.containsKey("content")) {
            str = "content LIKE"+" '%"+cond.get("content")+"%'";
        }
        String sql = "SELECT * FROM note WHERE " + str+" LIMIT "+sp.getPageRows()*(sp.getCurrentPage()-1)+","+sp.getPageRows();
        DataBaseConnection dbc = null;
        dbc = new DataBaseConnection();
        try{
            ResultSet rs  =this.executeQueryRS(sql);
            while (rs.next()){
                Note note = new Note();
                note.setNoteId(rs.getInt(1));
                note.setTitle(rs.getString(2));
                note.setAuthor(rs.getString(3));
                note.setContent(rs.getString(4));
                list.add(note);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbc.close();
        }
        return list;
    }
}
