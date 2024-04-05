package com.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.site.dao.UserDao;
import com.site.dao.UserDaoImp;


@WebServlet("/logInServlet")
public class logInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userDao=new UserDaoImp();
    public logInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(userDao.isValidUser(username,password)) {
			HttpSession session=request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("welcome.jsp");
		}
		else {
			response.sendRedirect("login.jsp?error=1");
			System.out.println("Error");
		}
	}

}
