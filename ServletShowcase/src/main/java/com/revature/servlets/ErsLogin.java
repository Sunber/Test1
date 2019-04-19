package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import dao.EmployeeDAO;

/**
 * Servlet implementation class ErsLogin
 */
public class ErsLogin extends HttpServlet {
	
	private static final Logger log = Logger.getLogger(ErsLogin.class);

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErsLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		String username = request.getParameter("username");
		String password = request.getParameter("password1");
		
		if(!username.equals("") && !password.equals(""))
		{
			
			if(EmployeeDAO.validate(username, password)){
				HttpSession session = request.getSession();
				session.setAttribute("userId", username);
				session.setAttribute("userType", "employee");
				response.sendRedirect("Users/ErsBasicUser.html");
				
			}
			
			else
				response.sendRedirect("./index.html");
				
			//response.setContentType("text/plain");
			//PrintWriter writing = response.getWriter();
			//Call the PrintWriter's write method
			//writing.write("The user name that you entered is: " + username + " and the password is " + password);
		}
		else {
			
			response.sendRedirect("./index.html");
		}
		
		log.info("The context param is: " + request.getServletContext().getInitParameter("someName"));
	}

}
