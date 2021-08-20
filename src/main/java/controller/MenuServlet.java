package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.DAO;

@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		
		DAO dao = new DAO();
		
		String search_menu = request.getParameter("search_menu");
		
		JSONObject menu_DTO = dao.menu(search_menu);
		JSONObject menu_info_DTO = dao.menuinfo(search_menu);
		
		JSONObject menu = new JSONObject();
		menu.put("menu_DTO", menu_DTO);
		menu.put("menu_info_DTO", menu_info_DTO);
			
		
		PrintWriter writer = response.getWriter();
		writer.print(menu);
		
		dao.finish();
	}

}
