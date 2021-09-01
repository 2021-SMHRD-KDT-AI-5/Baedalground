package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;

@WebServlet("/InsertAddressServlet")
public class InsertAddressServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		DAO dao = new DAO();
		
		String id = "test";
		String address = request.getParameter("roadAddrPart1")+" "+request.getParameter("addrDetail");
		double latitude = Double.parseDouble(request.getParameter("lat"));
		double longitude = Double.parseDouble(request.getParameter("lon"));
		
		System.out.println(id + ", " + address + ", " + latitude + ", " + longitude);
		
		String insert_address = dao.getinsert_address(id,address,latitude,longitude);
		
		System.out.println(insert_address);
		
		PrintWriter out = response.getWriter();
//		out.print(insert_address);
//		String str = "<script language='javascript'>";
//		str += "self.close();";
//		str += "</script>";
		out.print("수정 완료");
		
		
	}

}
