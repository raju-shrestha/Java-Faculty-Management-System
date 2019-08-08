package controller;

import javax.servlet.RequestDispatcher;
import java.io.IOException;

/**
 * Created on 1/26/2017.
 */
public class TestServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("---------Iam in dopost method---");

        RequestDispatcher rd = request.getRequestDispatcher("user/home.jsp");
        rd.forward(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
