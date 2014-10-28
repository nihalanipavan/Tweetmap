package com.cloud.project.tweetmap.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cloud.project.tweetmap.model.user.UserModel;

/**
 * Servlet implementation class UserLogin
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName;
		String password;
		boolean loginResult;
		userName = request.getParameter("username");
		password = request.getParameter("password");
		
		if((userName == "" || userName == null) || (password == "" || password == null))
		{
			System.out.println("null inputs");
		}
		
		UserModel objModel = new UserModel();
		loginResult = objModel.checkLogin(userName, password);
		
		if(loginResult)
		{
			request.getRequestDispatcher("userHome.jsp").forward(request, response);
		}
	}

}
