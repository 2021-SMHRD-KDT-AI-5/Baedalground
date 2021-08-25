package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.DAO;
import model.joinlistDTO;

@WebServlet("/JoinListServlet")
public class JoinListServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("커뮤니티 글목록 요청...");
		
		DAO dao = new DAO();

		String nick = request.getParameter("my_nick");
		System.out.println(nick);

		ArrayList<joinlistDTO> result = dao.Joinlist(nick); 

		Gson gson = new Gson();
		

		
		response.setContentType("application/json; charset=utf-8");
		String jsonArr = gson.toJson(result);
		
		System.out.println(jsonArr);
		
		PrintWriter writer = response.getWriter();
		writer.print(jsonArr);
	}

}
