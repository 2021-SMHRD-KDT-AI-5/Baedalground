package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		DAO dao = new DAO();

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		String result = dao.login(id, pw);
		
		PrintWriter writer = response.getWriter();
		writer.print(result);
		
		dao.finish();
	}

}
