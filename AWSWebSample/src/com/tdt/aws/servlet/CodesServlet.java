package com.tdt.aws.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.tdt.aws.dao.CodeDAO;
import com.tdt.aws.model.Code;
import com.tdt.aws.service.DynamodbService;

@WebServlet("/codes")
public class CodesServlet extends HttpServlet {
	
	private DynamodbService dynamodbService = new DynamodbService();
	public final static String CHARSET = "UTF-8";

	public final static String JSON_CONTENT_TYPE = "application/json; charset=" + CHARSET;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		
		// send content type
		resp.setContentType(JSON_CONTENT_TYPE);
		
		PrintWriter out = resp.getWriter();
		
		CodeDAO dao = new CodeDAO();
		String category = req.getParameter("category");
		List<Code> codeList = new ArrayList<Code>();
		
		JSONObject codesJSON = new JSONObject();
		JSONObject codeJSON =  new JSONObject();
	    
		if(category.isEmpty()) {
			// first get all codes from table
			codeList = dao.getAll();
		} else {
			codeList = dao.getByCategory(category);
		}
		
		String prevCodeCat = codeList.get(0).getCategory();
		String currCodeCat = codeList.get(0).getCategory();
		
		for (Code c: codeList) {
			currCodeCat = c.getCategory();
			if (!currCodeCat.equals(prevCodeCat)){
				codeJSON.put(c.getValue(), c.getDescription());
			} else {
				codesJSON.put(currCodeCat, codeJSON );
				codeJSON =  new JSONObject();
			}
			prevCodeCat = currCodeCat;
	
		}
		
		resp.setStatus(HttpServletResponse.SC_OK);
		out.write(codesJSON.toString());
		
	}

}
