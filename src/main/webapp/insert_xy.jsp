<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <script
   src="https://cdnjs.cloudflare.com/ajax/libs/proj4js/2.7.2/proj4.js"></script> -->

<script src="./js/proj4js-combined.js"></script>




<script>
   function goPopup() {
      
      // 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrCoordUrl.do)를 호출하게 됩니다.
      var pop = window.open("insert_xy_popup.jsp", "pop",
            "width=570,height=420, scrollbars=yes, resizable=yes");
   }
   
   function jusoCallBack(roadFullAddr, roadAddrPart1, addrDetail,
                  roadAddrPart2, engAddr, jibunAddr, zipNo, admCd,
                  rnMgtSn, bdMgtSn, detBdNmList, bdNm, bdKdcd, siNm,
                  sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno,
                  mtYn, lnbrMnnm, lnbrSlno, emdNo, entX, entY) {
      
               // 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
               document.form.roadAddrPart1.value = roadAddrPart1;
               document.form.roadAddrPart2.value = roadAddrPart2;
               document.form.addrDetail.value = addrDetail;
               document.form.zipNo.value = zipNo;
               document.form.entX.value = entX;
               document.form.entY.value = entY;
               
         /*       
               proj4.defs["EPSG:5179"] 〓 "+proj〓tmerc +lat_0〓38 +lon_0〓127.5 +k〓0.9996 +x_0〓1000000 +y_0〓2000000 +ellps〓GRS80 +units〓m +no_defs";//제공되는 좌표 
               Proj4js.defs["EPSG:4326"] = "+proj=longlat +ellps=WGS84 +datum=WGS84 +no_defs";//WGS84
               var grs80 〓 proj4.Proj(proj4.defs["EPSG:5179"]) 
               var wgs84 〓 proj4.Proj(proj4.defs["EPSG:4326"]); //경위도 

               var p 〓 proj4.Point( entX , entY );//한국지역정보개발원 좌표 
               p 〓 proj4.transform( grs80, wgs84, p); 
               console.log(p); */

               
   }




   
   
/*---------------------------------------------------------------------------------------*/

</script>


<script type='text/javascript'>
function go_change(){
   
   Proj4js.defs['GRS80'] = '+proj=tmerc +lat_0=38 +lon_0=127.5 +k=0.9996 +x_0=1000000 +y_0=2000000 +ellps=GRS80 +units=m +no_defs';
   Proj4js.defs['WGS84'] ='+proj=longlat +ellps=WGS84 +datum=WGS84 +no_defs';

   var GRS80 = new Proj4js.Proj('GRS80');
   var WGS84 = new Proj4js.Proj('WGS84');

   var pre_x=document.getElementById("entX").value;
   var pre_y=document.getElementById("entY").value;


   var p = new Proj4js.Point(pre_x,pre_y);
   Proj4js.transform(GRS80, WGS84, p);

   document.getElementById("lon").value=p.x;
   document.getElementById("lat").value=p.y;
   
   /* setTimeout(() => window.close(), 1000); */
   
   sleep(1000);
   
   window.close();
   
   }

</script>



<title>주소 입력 샘플</title>
</head>
<body>
	   <form name="form" action="InsertAddressServlet" id="form" method="post" style="margin-left:20px">
      <table>
         <colgroup>
            <col style="width: 20%">
            <col>
            <div style="margin:100px 50px 0px 0px;"></div>
            
         </colgroup>
         <tbody>
				<div>
					<tr>
						<th  width=80px;>우편<br>번호</th>
						<td><input type="hidden" id="confmKey" name="confmKey" value="">
							<input type="text" id="zipNo" name="zipNo" readonly style="width: 100px"> 
							<!-- <button onclick="goPopup();">주소검색</button></td> -->
							<input type="button" value="주소검색" onclick="goPopup();"></td>
					</tr>


					<tr>
						<th><label>도로명<br>주소</label></th>
						<td><input type="text" name="roadAddrPart1"
							id="roadAddrPart1" style="width: 85%"></td>
					</tr>

					<tr>
						<th>상세<br>주소</th>
						<td><input type="text" name="addrDetail" id="addrDetail"
							style="width: 40%" value=""> <input type="text"
							id="roadAddrPart2" style="width: 40%" value=""></td>
					</tr>

					<tr>
						<th>
							<!-- 좌표정보(X,Y좌표) -->
						</th>
						<td><input type="hidden" name="entX" id="entX"
							style="width: 40%"> <input type="hidden" name="entY"
							id="entY" style="width: 40%"></td>
					</tr>
					<tr>
						<th>
							<!-- 좌표정보<br>(위경도) -->
						</th>
						<td><input type="hidden" name="lat" id="lat"
							style="width: 40%"> <input type="hidden" name="lon"
							id="lon" style="width: 40%"> <!-- <input type="button" value="좌표변환" onclick="go_change();"> -->
						</td>
					</tr>
					<tr>
						<td colspan='2', align="center"><input type="submit" value="전송완료" onclick="go_change();">
						</td>

					</tr>
				</div>
			</tbody>
         
         
      </table>
   </form>

	<!-- <form name="form" action="InsertAddressServlet" id="form" method="post">
		<table>
			<colgroup>
				<col style="width: 20%">
				<col>
			</colgroup>
			<tbody>
				<tr>
					<th>우편번호</th>
					<td><input type="hidden" id="confmKey" name="confmKey"
						value=""> <input type="text" id="zipNo" name="zipNo"
						readonly style="width: 100px"> <button onclick="goPopup();">주소검색</button></td>
						<input type="button" value="주소검색" onclick="goPopup();"></td>
				</tr>

				<tr>
					<th><label>도로명주소</label></th>
					<td><input type="text" name="roadAddrPart1" id="roadAddrPart1"
						style="width: 85%"></td>
				</tr>

				<tr>
					<th>상세주소</th>
					<td><input type="text" name="addrDetail" id="addrDetail"
						style="width: 40%" value=""> <input type="text"
						id="roadAddrPart2" style="width: 40%" value=""></td>
				</tr>

				<tr>
					<th>좌표정보(X,Y좌표)</th>
					<td><input type="text" name="entX" id="entX"
						style="width: 40%"> <input type="text" name="entY"
						id="entY" style="width: 40%"></td>
				</tr>
				<tr>
					<th>좌표정보(위경도)</th>
					<td><input type="text" name="lat" id="lat" style="width: 40%">
						<input type="text" name="lon" id="lon" style="width: 40%">
						<input type="button" value="좌표변환" onclick="go_change();">
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="전송완료" onclick="go_change();">
					</td>
				</tr>
			</tbody>
		</table>
	</form> -->
</body>
</html>
