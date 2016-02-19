package com.tdt.aws.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import com.tdt.aws.dao.UserDao;
import com.tdt.aws.model.User;
import com.tdt.aws.utils.MailUtils;
@WebServlet("/reset")
public class ResetPwdServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("forgot_pwd.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		UserDao dao = new UserDao();
		if (StringUtils.isNotEmpty(email)) {
			
			User user = dao.getByEmail(email);
			if (user != null) {
				
				resp.setContentType("text/plain");
				resp.setStatus(200);
				String newPwd = RandomStringUtils.randomAlphabetic(7);
				try {
					MailUtils.sendSimpleEmail("Reset password", "Hi, This is your new password: " + newPwd, "noreply@example.com", email);
				} catch (Exception e) {
					resp.getWriter().write("Cannot send email");
					e.printStackTrace();
				}
				
				try {
					dao.resetPwd(user, newPwd);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				resp.getWriter().write("Password resetted, please check your email");
			}
		}
	}
}
