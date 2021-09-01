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

@WebServlet("/ToptenServlet")
public class ToptenServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json; charset=utf-8");
		
		DAO dao = new DAO();
		
		String age = request.getParameter("age").substring(0,2);
		String gender = "";
		if(request.getParameter("gender").equals("여자")){
			gender = "F";
		}else if(request.getParameter("gender").equals("남자")) {
			gender = "M";
		}else {
			gender = "('F', 'M')";
		}
		String myaddr = request.getParameter("myaddr");
		
//		System.out.println(age + ", " + gender + ", " + myaddr);
		
		ArrayList<Integer> top_seq_DTO = dao.topResult_seq(age, gender, myaddr);
		
//		System.out.println(top_seq_DTO);
		
		JSONObject obj = dao.menuseqtos(top_seq_DTO);
		
		PrintWriter writer = response.getWriter();
		writer.print(obj);
		
		System.out.println(obj.toString());
		
		dao.finish();
		
	}

}
