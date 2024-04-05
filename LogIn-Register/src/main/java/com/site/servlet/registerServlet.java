package com.site.servlet;
import com.site.dao.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userDao=new UserDaoImp();
	
    
   
    public registerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		NewUser newUser=new NewUser();
		
		newUser.setPassword(password);
		newUser.setUsername(username);
		newUser.setEmail(email);
		
		if(userDao.addUser(newUser)) {
			
			response.sendRedirect("login.jsp?registration=success");
			
		}
		else {
			response.sendRedirect("register.jsp?error=1");
		}
		
	}

}
