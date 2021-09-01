package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import model.DAO;

@WebServlet("/testServlet")
public class testServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("test");
		
		response.setContentType("application/json; charset=utf-8");
		
		DAO dao = new DAO();
		dao.conn();
//		
//		String cate = request.getParameter("category");
//		
//		JSONObject res_DTO = dao.category(cate);
		
		String inputYn = request.getParameter("inputYn"); 
		String roadFullAddr = request.getParameter("roadFullAddr"); 
		String roadAddrPart1 = request.getParameter("roadAddrPart1"); 
		String roadAddrPart2 = request.getParameter("roadAddrPart2"); 
		String engAddr = request.getParameter("engAddr"); 
		String jibunAddr = request.getParameter("jibunAddr"); 
		String zipNo = request.getParameter("zipNo"); 
		String addrDetail = request.getParameter("addrDetail"); 
		String admCd    = request.getParameter("admCd");
		String rnMgtSn = request.getParameter("rnMgtSn");
		String bdMgtSn  = request.getParameter("bdMgtSn");
		String detBdNmList  = request.getParameter("detBdNmList");	
//		/** 2017년 2월 추가제공 **/
		String bdNm  = request.getParameter("bdNm");
		String bdKdcd  = request.getParameter("bdKdcd");
		String siNm  = request.getParameter("siNm");
		String sggNm  = request.getParameter("sggNm");
		String emdNm  = request.getParameter("emdNm");
		String liNm  = request.getParameter("liNm");
		String rn  = request.getParameter("rn");
		String udrtYn  = request.getParameter("udrtYn");
		String buldMnnm  = request.getParameter("buldMnnm");
		String buldSlno  = request.getParameter("buldSlno");
		String mtYn  = request.getParameter("mtYn");
		String lnbrMnnm  = request.getParameter("lnbrMnnm");
		String lnbrSlno  = request.getParameter("lnbrSlno");
//		/** 2017년 3월 추가제공 **/
		String emdNo  = request.getParameter("emdNo");
		
		JSONArray object = new JSONArray();
		
		object.add(roadFullAddr);
		object.add(roadAddrPart1);
		object.add(addrDetail);
		object.add(roadAddrPart2);
		object.add(jibunAddr);
		object.add(zipNo);
		object.add(detBdNmList);
		object.add(bdNm);
		object.add(siNm);
		object.add(sggNm);
		object.add(emdNm);
		
		System.out.println(object.toString());
		
		PrintWriter writer = response.getWriter();
		writer.print("1");
		
		
	}

}
