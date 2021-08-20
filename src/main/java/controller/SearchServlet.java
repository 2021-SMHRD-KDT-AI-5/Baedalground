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
import model.restaurantDTO;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		DAO dao = new DAO();
		
		String search = request.getParameter("search");
		
		JSONObject res_DTO = dao.search(search);
		PrintWriter writer = response.getWriter();
		writer.print(res_DTO);
		
		dao.finish();
	}

}
