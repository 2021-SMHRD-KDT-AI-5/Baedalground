package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mappingServlet")
public class mappingServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String admCd = request.getParameter("admCd");
		String rnMgtSn = request.getParameter("rnMgtSn");
		String udrtYn = request.getParameter("udrtYn");
		String buldMnnm = request.getParameter("buldMnnm");
		String buldSlno = request.getParameter("buldSlno");
		String confmKey = request.getParameter("confmKey");
		String resultType = request.getParameter("resultType");
  	
		// OPEN API ...
		String apiUrl = "https://www.juso.go.kr/addrlink/addrCoordApi.do?admCd ="+admCd+"&rnMgtSn="+rnMgtSn+"&udrtYn="+udrtYn+"&buldMnnm="+buldMnnm+"&buldSlno="+buldSlno+"&confmKey="+confmKey+"&resultType="+resultType;
		URL url = new URL(apiUrl);
    	BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
    	StringBuffer sb = new StringBuffer();
    	String tempStr = null;

    	while(true){
    		tempStr = br.readLine();
    		if(tempStr == null) break;
    		sb.append(tempStr);
    	}
    	br.close();
    	response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		response.getWriter().write(sb.toString());
	}

}
