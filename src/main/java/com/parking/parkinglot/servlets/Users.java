package com.parking.parkinglot.servlets;

import com.parking.parkinglot.common.UserDto;
import com.parking.parkinglot.ejb.UsersBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Users", value = "/Users")
public class Users extends HttpServlet {
    @Inject
    UsersBean UsersBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        List<UserDto> Users=UsersBean.findAllUsers();
        request.setAttribute("Users",Users);
        request.setAttribute("activatePage", "Users");
        request.getRequestDispatcher("/WEB-INF/pages/Users.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
    }
}