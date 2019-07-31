package controller;

import domain.User;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Dell on 2/1/2017.
 */
@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");

        if (page.equalsIgnoreCase("login")) {
            String name = request.getParameter("username");
            String password = request.getParameter("password");
            User user = new UserService().getUser(name, password);
            if (user != null) {
                RequestDispatcher rd = request.getRequestDispatcher("user/home.jsp");
                rd.forward(request,response);
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request,response);
            }

        }
        if (page.equalsIgnoreCase("logout")) {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }
        if (page.equalsIgnoreCase("list")) {

            List<User> userList = new UserService().getUserList();
            request.setAttribute("userList",userList);
            RequestDispatcher rd = request.getRequestDispatcher("user/list.jsp");
            rd.forward(request,response);
        }
        if (page.equalsIgnoreCase("userform")) {
            RequestDispatcher rd = request.getRequestDispatcher("user/userForm.jsp");
            rd.forward(request,response);
        }
        if (page.equalsIgnoreCase("adduser")) {
            User user = new User();
            user.setName(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setRole(request.getParameter("role"));

            new UserService().add(user);
            List<User> userList = new UserService().getUserList();
            request.setAttribute("userList",userList);
            RequestDispatcher rd = request.getRequestDispatcher("user/list.jsp");
            rd.forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);


    }
}
