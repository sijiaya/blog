package com.soft1841.web.blog.controller;

import com.soft1841.web.blog.dao.Impl.NoteDaoImpl;
import com.soft1841.web.blog.entity.Note;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NoteServlet",urlPatterns = {"/NoteServlet"})
public class NoteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String flag = request.getParameter("flag");
        if (flag.equals(("delNote"))) {
            String s_noteId = (String) request.getParameter("note_id");
            int note_id = Integer.parseInt(s_noteId);
            NoteDaoImpl noteDAO = new NoteDaoImpl();
            try {
                if (noteDAO.delete(note_id)==1) {
                        request.getRequestDispatcher("success.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("err.jsp").forward(request, response);
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (flag.equals("insert")) {
            String note_id = request.getParameter("Un");
            String title = request.getParameter("Ut");
            String author = request.getParameter("Ua");
            String content = request.getParameter("Uc");
            Note note = new Note();
            note.setNoteId(Integer.parseInt(note_id));
            note.setTitle(title);
            note.setAuthor(author);
            note.setContent(content);
            NoteDaoImpl noteDAO = new NoteDaoImpl();
            int n = 0;
            try {
                n = noteDAO.insert(note);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (n == 0) {
                request.getRequestDispatcher("note-suc.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("note-err.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
