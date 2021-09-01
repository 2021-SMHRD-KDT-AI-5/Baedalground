package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import model.DAO;
import model.communityDTO;

@WebServlet("/CommunityListServlet")
public class CommunityListServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		System.out.println("커뮤니티 글목록 요청...");
		
		DAO dao = new DAO();

		String my_loca = request.getParameter("location");
		
		System.out.println(my_loca);

		JSONObject result = dao.listup(my_loca);
		
		Gson gson = new Gson();
		
		response.setContentType("application/json; charset=utf-8");
		
		String jsonArr = gson.toJson(result);
		
		System.out.println(jsonArr);
		
		PrintWriter writer = response.getWriter();
		writer.print(jsonArr);
	}

}
