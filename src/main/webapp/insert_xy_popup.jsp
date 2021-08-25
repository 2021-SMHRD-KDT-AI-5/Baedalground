<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소설정 팝업창</title>
<%
request.setCharacterEncoding("UTF-8"); //한글깨지면 주석제거
//request.setCharacterEncoding("EUC-KR");  //해당시스템의 인코딩타입이 EUC-KR일경우에
String inputYn = request.getParameter("inputYn");
String roadFullAddr = request.getParameter("roadFullAddr");
String roadAddrPart1 = request.getParameter("roadAddrPart1");
String roadAddrPart2 = request.getParameter("roadAddrPart2");
String engAddr = request.getParameter("engAddr");
String jibunAddr = request.getParameter("jibunAddr");
String zipNo = request.getParameter("zipNo");
String addrDetail = request.getParameter("addrDetail");
String admCd = request.getParameter("admCd");
String rnMgtSn = request.getParameter("rnMgtSn");
String bdMgtSn = request.getParameter("bdMgtSn");
String detBdNmList = request.getParameter("detBdNmList");
String bdNm = request.getParameter("bdNm");
String bdKdcd = request.getParameter("bdKdcd");
String siNm = request.getParameter("siNm");
String sggNm = request.getParameter("sggNm");
String emdNm = request.getParameter("emdNm");
String liNm = request.getParameter("liNm");
String rn = request.getParameter("rn");
String udrtYn = request.getParameter("udrtYn");
String buldMnnm = request.getParameter("buldMnnm");
String buldSlno = request.getParameter("buldSlno");
String mtYn = request.getParameter("mtYn");
String lnbrMnnm = request.getParameter("lnbrMnnm");
String lnbrSlno = request.getParameter("lnbrSlno");
String emdNo = request.getParameter("emdNo");
String entX = request.getParameter("entX");
String entY = request.getParameter("entY");
/* String entX = request.getParameter("entX");
String entY = request.getParameter("entY"); */
%>
</head>


	
<script language="javascript">
function init(){
	var url = location.href;
	var confmKey = "devU01TX0FVVEgyMDIxMDgyMzIzMDQ0NzExMTU2ODY=";//승인키
	var resultType = "4"; // 도로명주소 검색결과 화면 출력유형, 1 : 도로명, 2 : 도로명+지번+상세보기(관련지번, 관할주민센터), 3 : 도로명+상세보기(상세건물명), 4 : 도로명+지번+상세보기(관련지번, 관할주민센터, 상세건물명)
	var inputYn= "<%=inputYn%>";


	
	
	if(inputYn != "Y"){
		document.form.confmKey.value = confmKey;
		document.form.returnUrl.value = url;
		document.form.resultType.value = resultType;
		document.form.action="https://www.juso.go.kr/addrlink/addrCoordUrl.do"; // 인터넷망
		document.form.submit();
	}else{
		opener.jusoCallBack("<%=roadFullAddr%>","<%=roadAddrPart1%>","<%=addrDetail%>", "<%=roadAddrPart2%>","<%=engAddr%>"
			, "<%=jibunAddr%>","<%=zipNo%>", "<%=admCd%>", "<%=rnMgtSn%>", "<%=bdMgtSn%>", "<%=detBdNmList%>"
			, "<%=bdNm%>", "<%=bdKdcd%>", "<%=siNm%>", "<%=sggNm%>", "<%=emdNm%>", "<%=liNm%>", "<%=rn%>", "<%=udrtYn%>"
			, "<%=buldMnnm%>", "<%=buldSlno%>", "<%=mtYn%>", "<%=lnbrMnnm%>", "<%=lnbrSlno%>", "<%=emdNo%>", "<%=entX%>", "<%=entY%>");
		
		
		
		
		window.close();
	}
	
}
</script>
<%-- <script>
proj4.defs["EPSG:5179"] 〓 "+proj〓tmerc +lat_0〓38 +lon_0〓127.5 +k〓0.9996 +x_0〓1000000 +y_0〓2000000 +ellps〓GRS80 +units〓m +no_defs";//제공되는 좌표 
Proj4.defs["EPSG:4326"] = "+proj=longlat +ellps=WGS84 +datum=WGS84 +no_defs";//WGS84
var grs80 〓 proj4.Proj(proj4.defs["EPSG:5179"]) //좌표
var wgs84 〓 proj4.Proj(proj4.defs["EPSG:4326"]);  //위경도

var p 〓 proj4.Point( "<%=entX%>" , "<%=entY%>" );//한국지역정보개발원 좌표 
p 〓 proj4.transform( grs80, wgs84, p); 

document .write(p.x + " " + p.y);
</script>
 --%>

<body onload="init();">
	<form id="form" name="form" method="post">
		<input type="hidden" id="confmKey" name="confmKey" value="" /> <input
			type="hidden" id="returnUrl" name="returnUrl" value="" /> <input
			type="hidden" id="resultType" name="resultType" value="" />
		<!-- 해당시스템의 인코딩타입이 EUC-KR일경우에만 추가 START-->
		<!-- 
		<input type="hidden" id="encodingType" name="encodingType" value="EUC-KR"/>
		 -->
		<!-- 해당시스템의 인코딩타입이 EUC-KR일경우에만 추가 END-->
	</form>
</body>
</html>