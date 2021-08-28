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

import model.DAO;
import model.communityDTO;

import com.google.gson.Gson;

@WebServlet("/ListClickServlet")
public class ListClickServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO dao = new DAO();

		String list_id = request.getParameter("id");
		String list_title = request.getParameter("title");
		
		System.out.println(list_id);
		System.out.println(list_title);
		
		JSONObject result = dao.listclick(list_id, list_title); 

		Gson gson = new Gson();

		response.setContentType("application/json; charset=utf-8");
		String jsonArr = gson.toJson(result);
		

		
		PrintWriter writer = response.getWriter();
		writer.print(jsonArr);
	}

}
