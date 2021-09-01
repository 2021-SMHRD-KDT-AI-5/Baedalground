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

@WebServlet("/writereviewServlet")
public class writereviewServlet extends HttpServlet {
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      DAO dao = new DAO();
      
      String tasteReview = request.getParameter("tasteReview");
      String amountReview = request.getParameter("amountReview");
      String deliReview = request.getParameter("deliReview");
      String memberId = request.getParameter("memberId");
      String reviewContents = request.getParameter("reviewContents");
      
      float tasteReview1 = Float.valueOf(tasteReview);
      float amountReview1 = Float.valueOf(amountReview);
      float deliReview1 = Float.valueOf(deliReview);
      
      String result = dao.reviewup(memberId, reviewContents, tasteReview1, amountReview1, deliReview1);
      		
      PrintWriter writer = response.getWriter();
      writer.print(result);
      
      
   }

}