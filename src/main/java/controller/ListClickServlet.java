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
import model.communityDTO;

import com.google.gson.Gson;

@WebServlet("/ListClickServlet")
public class ListClickServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("커뮤니티 글목록 요청...");
		
		DAO dao = new DAO();

		String nick = request.getParameter("host_nick");
		String list_title = request.getParameter("title");
		System.out.println(nick);
		System.out.println(list_title);
		ArrayList<communityDTO> result = dao.listclick(nick, list_title); 

		Gson gson = new Gson();

		response.setContentType("application/json; charset=utf-8");
		String jsonArr = gson.toJson(result);
		

		
		PrintWriter writer = response.getWriter();
		writer.print(jsonArr);
	}

}
