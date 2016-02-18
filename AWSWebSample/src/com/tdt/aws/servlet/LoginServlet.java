package com.tdt.aws.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.tdt.aws.service.DynamodbService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private DynamodbService dynamodbService = new DynamodbService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		req.getRequestDispatcher("login.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		try {
			if (dynamodbService.checkLogin(email, password)) {
				resp.getWriter().write(new JSONObject().put("message", "login success").toString());
			} else{
				resp.getWriter().write(new JSONObject().put("message", "login failed").toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.getWriter().write(new JSONObject().put("message", "login failed").toString());
		}
	}
}
