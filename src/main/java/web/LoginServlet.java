package web;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;

import database.LoginDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import loginform.LoginBean;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private LoginDao loginDao;

public void init() throws ServletException {
	// TODO Auto-generated method stub
	  super.init();
	    loginDao = new LoginDao();
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 System.out.println("doPost method called");
	            String username = request.getParameter("username");
	            String password = request.getParameter("password");
	            LoginBean loginbean = new LoginBean();
	            loginbean.setUserName(username);
	            loginbean.setPassWord(password);
	            
	            try {
	            	 if(loginDao.validate(loginbean)) {
	            		 
	 	            	response.sendRedirect("loginsuccess.jsp");
	 	            }
	 	            else {
	 	            	 HttpSession session = request.getSession();
	 	            	 session.setAttribute("user", username);
	 	            	 response.sendRedirect("login.jsp");
	 	            }
				} catch (Exception e) {
					e.printStackTrace();
				}
	           
	            
	}

}
