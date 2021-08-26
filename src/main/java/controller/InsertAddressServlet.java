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
		PrintWriter out = response.getWriter(); //�븘�썐 媛앹껜!! �궡蹂대궪 媛앹껜瑜� 諛쏆븘�삤湲� �쟾�뿉!! �씤肄붾뵫�쓣 �빐以섏빞 �궡蹂대궪 媛앹껜�뿉 �쟻�슜�씠 �릺�꽌 �씤肄붾뵫�씠 �븞源⑥쭊�떎!!!!!
		
		DAO dao = new DAO(); //DB�� �뿰寃고빐�꽌 DB �뿉�엳�뒗 媛믪쓣 insert�빐以� DAO媛앹껜 �깮�꽦
		
		String id = "test10";
		String address = request.getParameter("roadAddrPart1")+" "+request.getParameter("addrDetail");
//		String latitude = request.getParameter("entX");
//		String longitude = request.getParameter("entY");
		double latitude = Double.parseDouble(request.getParameter("entX"));
		double longitude = Double.parseDouble(request.getParameter("entY"));
		
		// set �빐�꽌 DB�뿉 �꽔�뼱以섏빞 �븿
		String insert_address = dao.getinsert_address(id,address,latitude,longitude);
		
		System.out.println(insert_address);
	}

}
