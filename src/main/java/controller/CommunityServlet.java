package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;

@WebServlet("/CommunityServlet")
public class CommunityServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();

	      String title = request.getParameter("title");
	      String restaurant = request.getParameter("restaurant");
	      String time = request.getParameter("time");
	      String min = request.getParameter("min");
	      String location = request.getParameter("location");
	      String nick = request.getParameter("nick");
	      String content = request.getParameter("content");
	      
	      System.out.println(title);

	      String result = dao.setup(title, restaurant, time, min, location, nick, content);
	      
	      PrintWriter writer = response.getWriter();
	      writer.print(result);
	      
	      dao.finish();

	}

}
