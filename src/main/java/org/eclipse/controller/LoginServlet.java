package org.eclipse.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import org.eclipse.beans.*;
import org.eclipse.DAO.LoginDao;
 
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
 
public LoginServlet()  {
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
}

 
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
    String login = request.getParameter("login");
    String passwd = request.getParameter("passwd");
 
    User user = new User();
 
    user.setLogin(login);
    user.setPasswd(passwd);
 
    LoginDao loginDao = new LoginDao();
 
    try
    {
        String userValidate = loginDao.authenticateUser(user);
 
        if(userValidate.equals("manager_Role"))
        {
            System.out.println("Manger's Home");
 
            HttpSession session = request.getSession(); //Creating a session
            session.setAttribute("manager", login); //setting session attribute
            request.setAttribute("login", login);
 
            request.getRequestDispatcher("/WEB-INF/manager.jsp").forward(request, response);
        }
        else if(userValidate.equals("receptionist_Role"))
        {
            System.out.println("Receptionist's Home");
 
            HttpSession session = request.getSession();
            session.setAttribute("receptionist", login);
            request.setAttribute("login", login);
 
            request.getRequestDispatcher("/WEB-INF/receptionist.jsp").forward(request, response);
        }
        else if(userValidate.equals("operation_Role"))
        {
            System.out.println("Maitre des operations Home");
 
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10*60);
            session.setAttribute("Moperation", login);
            request.setAttribute("login", login);
 
            request.getRequestDispatcher("/WEB-INF/operation.jsp").forward(request, response);
        }
        else
        {
            System.out.println("Error message = "+userValidate);
            request.setAttribute("errMessage", userValidate);
 
            request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
        }
    }
    catch (IOException e1)
    {
        e1.printStackTrace();
    }
    catch (Exception e2)
    {
        e2.printStackTrace();
    }
} //End of doPost()
}