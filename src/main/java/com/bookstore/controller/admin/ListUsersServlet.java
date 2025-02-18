package com.bookstore.controller.admin;

import com.bookstore.entity.User;
import com.bookstore.service.UserServices;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListUsersServlet", value = "/admin/list_users")
public class ListUsersServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserServices userService = new UserServices();
        List<User> listUsers=  userService.listUser();

        request.setAttribute("listUsers", listUsers);

        String listPage = "user_list.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);

        requestDispatcher.forward(request,response);
    }


}