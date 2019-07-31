package controller;

import domain.Teacher;

import services.TeacherService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by MY PC on 2/28/2017.
 */
public class TeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");

        /*if (page.equalsIgnoreCase("login")) {
            String name = request.getParameter("teachername");
            String password = request.getParameter("password");
            Teacher teacher = new TeacherService().getTeacher(name, password);
            if (teacher!= null) {
                RequestDispatcher rd = request.getRequestDispatcher("teacher/home.jsp");
                rd.forward(request,response);
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request,response);
            }

        }*/
       /* if (page.equalsIgnoreCase("logout")) {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }*/
        if (page.equalsIgnoreCase("list")) {

            List<Teacher> teacherList = new TeacherService().getTeacherList();
            request.setAttribute("teacherList",teacherList);
            RequestDispatcher rd = request.getRequestDispatcher("teacher/list.jsp");
            rd.forward(request,response);
        }

        if (page.equalsIgnoreCase("teacherForm")) {
            RequestDispatcher rd = request.getRequestDispatcher("teacher/teacherForm.jsp");
            rd.forward(request,response);
        }

        if (page.equalsIgnoreCase("addTeacher")) {
            Teacher teacher = new Teacher();
            teacher.setName(request.getParameter("teachername"));
            teacher.setSubject(request.getParameter("subject"));
            teacher.setQualification(request.getParameter("qualification"));
            try {
                new TeacherService().add(teacher);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            List<Teacher> teacherList = new TeacherService().getTeacherList();
            request.setAttribute("teacherList",teacherList);
            RequestDispatcher rd = request.getRequestDispatcher("teacher/list.jsp");
            rd.forward(request,response);
        }

        if (page.equalsIgnoreCase("delete")) {
            Teacher teacher = new Teacher();

            int id = Integer.parseInt(request.getParameter("id"));

            /*user.setId(Integer.parseInt(request.getParameter("id")));
            user.setName(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setRole(request.getParameter("role"));*/

            new TeacherService().delete(id);

            List<Teacher> TeacherList = new TeacherService().getTeacherList();
            request.setAttribute("teacherList",TeacherList);
            RequestDispatcher rd = request.getRequestDispatcher("teacher/list.jsp");
            rd.forward(request,response);
        }
        if (page.equalsIgnoreCase("edit")) {
            int id =Integer.parseInt(request.getParameter("id"));
            Teacher teacher = new TeacherService().getTeacher(id);

            request.setAttribute("teacher", teacher);
            RequestDispatcher rd = request.getRequestDispatcher("teacher/edit.jsp");
            rd.forward(request,response);
        }
        if (page.equalsIgnoreCase("updateTeacher")) {
            Teacher teacher = new Teacher();
            teacher.setName(request.getParameter("teacherName"));
            teacher.setSubject(request.getParameter("subject"));
            teacher.setQualification(request.getParameter("qualification"));
            teacher.setId(Integer.parseInt(request.getParameter("id")));

            try {
                new TeacherService().update(teacher);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            List<Teacher> teacherList = new TeacherService().getTeacherList();
            request.setAttribute("teacherList",teacherList);
            RequestDispatcher rd = request.getRequestDispatcher("teacher/list.jsp");
            rd.forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);


    }
}
