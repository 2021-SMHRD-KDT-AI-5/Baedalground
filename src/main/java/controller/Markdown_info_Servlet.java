package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import model.DAO;
import model.markdownDTO;

@WebServlet("/Markdown_info_Servlet")
public class Markdown_info_Servlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JsonArray jarray = new JsonArray(); //json
		JsonObject json = new JsonObject(); // json
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		DAO dao = new DAO();
		ArrayList<markdownDTO> markdown_info = new ArrayList<markdownDTO>();
		markdown_info = dao.getmarkdown_info();
		
		String id = null;
		String title = null;
		double latitude =  0.0f;
		double longitude = 0.0f;
		
		for(int i=0; i<markdown_info.size();i++) {
			
			id = markdown_info.get(i).getId();
			title = markdown_info.get(i).getTitle();
			latitude = markdown_info.get(i).getLatitude();
			longitude = markdown_info.get(i).getLongitude();
			
			json.addProperty("id", id);
			json.addProperty("title", title);
			json.addProperty("latitude",latitude);
			json.addProperty("longitude",longitude);
			
			jarray.add(json);
			
			json = new JsonObject();
		}
		
			out.print(jarray);
	}

}
