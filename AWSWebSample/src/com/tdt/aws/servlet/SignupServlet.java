package com.tdt.aws.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.tdt.aws.model.User;
import com.tdt.aws.service.DynamodbService;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

	private DynamodbService dynamodbService = new DynamodbService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("signup.html").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String id = req.getParameter("id");
		String person_id = req.getParameter("person_id");
		
		
		User user = new User(id, email, password, person_id);

		JSONObject jsonObject = new JSONObject(user);
		try {
			User result = dynamodbService.save(jsonObject.toString());
			resp
			.getWriter()
			.write(new JSONObject()
				.put("message", "success, user is: " + new JSONObject(result))
				.toString());
		} catch (Exception e) {
			
			e.printStackTrace();
			resp.getWriter().write(new JSONObject().put("message", "error").toString());
		}
		
	}
}
