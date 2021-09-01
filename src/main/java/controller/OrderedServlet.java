package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;


@WebServlet("/OrderedServlet")
public class OrderedServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json; charset=utf-8");
		
		DAO dao = new DAO();
		dao.conn();
		
		String res_name = request.getParameter("res_name");
		String menu_name = request.getParameter("menu_name");
		String price = request.getParameter("price");
		String id = request.getParameter("id");
		
		String result = dao.ordered(res_name, menu_name, price, id);
		if(result.equals("1") ) {
			result = dao.orderedmenu(res_name, menu_name, price, id);
		}
		
		PrintWriter writer = response.getWriter();
		writer.print(result);
		
		dao.finish();
		
		
		
		
	}

}
