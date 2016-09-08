package com.matc.controller;

import com.matc.entity.User;
import com.matc.persistence.UserData;
import org.apache.log4j.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
    )

public class SearchUser extends HttpServlet {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String useridString = req.getParameter("userid").replaceAll("[^\\d]", "");
        String ageString = req.getParameter("age").replaceAll("[^\\d]", "");
        int userid;
        int age;
        if (useridString.matches("\\d+"))
            userid = Integer.parseInt(useridString);
        else userid = 0;
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        if (ageString.matches("\\d+"))
            age = Integer.parseInt(ageString);
        else age = 0;
        logger.info("In the doGet()");
        logger.warn("In the doGet() - This is a warning");
        UserData userData = new UserData();
        req.setAttribute("users", userData.getSpecificUsers(userid, firstName, lastName, age));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}