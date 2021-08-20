package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.memberDTO;

@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick_name = request.getParameter("nick");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		int cash = Integer.parseInt(request.getParameter("cash"));
		String gender = request.getParameter("gender");

		String result = dao.join(id, pw, nick_name, age, address, cash, gender);
		
		PrintWriter writer = response.getWriter();
		writer.print(result);
		
		dao.finish();
	}

}
