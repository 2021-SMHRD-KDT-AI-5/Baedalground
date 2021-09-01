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
import model.reviewDTO;

@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      System.out.println("리뷰 글목록 요청...");
      
      DAO dao = new DAO();

      String resName = request.getParameter("resName");
      ArrayList<reviewDTO> result = dao.reviewlist(resName); 
      System.out.println(result);

      Gson gson = new Gson();

      response.setContentType("application/json; charset=utf-8");
      String jsonArr = gson.toJson(result);
      
      System.out.println(jsonArr);
      
      PrintWriter writer = response.getWriter();
      writer.print(jsonArr);
   }

}