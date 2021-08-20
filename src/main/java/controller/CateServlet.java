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

@WebServlet("/CateServlet")
public class CateServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		
		DAO dao = new DAO();
		dao.conn();
		
		String cate = request.getParameter("category");
		
		JSONObject res_DTO = dao.category(cate);
		PrintWriter writer = response.getWriter();
		writer.print(res_DTO);
		
		dao.finish();
		
	}

}
