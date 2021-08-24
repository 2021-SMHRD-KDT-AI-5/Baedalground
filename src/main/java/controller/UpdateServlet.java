package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
        
        DAO dao = new DAO();
        
        String id = request.getParameter("id");
        String temp_pw = request.getParameter("temp_pw");
        String up_pw = request.getParameter("up_pw");
        String temp_nick = request.getParameter("temp_nick");
        String temp_address = request.getParameter("temp_address");
        
        
        System.out.println(id +","+temp_pw);
        String update_DTO = dao.update(temp_pw, up_pw, temp_nick,  temp_address, id);
        PrintWriter writer = response.getWriter();
        writer.print(update_DTO);
        
        dao.finish();

	}

}
