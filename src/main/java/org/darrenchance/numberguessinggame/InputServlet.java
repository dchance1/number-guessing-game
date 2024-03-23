package org.darrenchance.numberguessinggame;

import java.io.*;
import java.util.Date;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "inputServlet", value = "/input-servlet")
public class InputServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "something went wrong";

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Random randomInt = new Random();
        int randomNum = randomInt.nextInt(5 - 1 + 1) + 1;
        int numberInput = Integer.parseInt(request.getParameter("param1"));

        if (numberInput == randomNum) {
            message = "You guessed CORRECT ["+ numberInput+"] " + "the correct number was ["+ randomNum+"]" ;
        }else {
            message = "You guessed WRONG ["+ numberInput+"] " + "the correct number was ["+ randomNum+"]";
        }
        PrintWriter writer = response.getWriter();
        writer.print(message);
        System.out.println("Servlet is working" + new Date());
    }

    public void destroy() {
    }
}