<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>지도 생성하기</title>
</head>
<body>
	<!-- 지도를 표시할 div 입니다 -->
	<!-- <div class="map_wrap">  -->
    	<div id="map" style="width:400px;height:400px;"></div>
	<!-- </div> -->
	<!--  -------------------------------------------------------------------------------------------------------------------------------------------------------->

	<script src="./js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2214e25ae5fc7d10f74fded049eed004&libraries=services,clusterer,drawing"></script>
	<script src="./js/markdown_save.js"></script>
	 
	<script>
	  
		$(function() {
			$.ajax({
				type : "post",
				dataType : "json", //서버에서 받을 데이터 형식을 지적한다.
				url : "Markdown_info_Servlet", //요청받을 서블릿 url 이름
				success : function(check) {
					alert("성공"); //통신에 성공했는지 확인하기위한 알림창
					/* console.log(check); */
					var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
					mapOption = {
						center : new kakao.maps.LatLng(
								35.11066820739486, 126.87733276913963), // 지도의 중심좌표
						level : 2
					// 지도의 확대 레벨
					};
	
					// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
					var map = new kakao.maps.Map(mapContainer,
							mapOption);
	
					//마커 이미지의 이미지 주소입니다
					var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
	
					/*------------------------------------------------------------------------------------------------------------------------------------ */
					// 지도에 마커와 인포윈도우를 표시하는 함수입니다
					function displayMarker(locPosition, message) {
	
						// 마커를 생성합니다
						var marker = new kakao.maps.Marker({
							map : map,
							position : locPosition
						});
	
						var iwContent = message, // 인포윈도우에 표시할 내용
						iwRemoveable = true;
	
						// 인포윈도우를 생성합니다
						var infowindow = new kakao.maps.InfoWindow({
							content : iwContent,
							removable : iwRemoveable
						});
	
						// 인포윈도우를 마커위에 표시합니다 
						infowindow.open(map, marker);
	
						// 지도 중심좌표를 접속위치로 변경합니다
						map.setCenter(locPosition);
					}
					/*------------------------------------------------------------------------------------------------------------------------------------ */
					// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
					var zoomControl = new kakao.maps.ZoomControl();
					map.addControl(zoomControl,
							kakao.maps.ControlPosition.RIGHT);
	
					// 지도가 확대 또는 축소되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
					kakao.maps.event.addListener(map, 'zoom_changed',
							function() {
	
								// 지도의 현재 레벨을 얻어옵니다
								var level = map.getLevel();
							});
					/*------------------------------------------------------------------------------------------------------------------------------------ */
				}
			});
			//ajax 끝나는 부분
		});
	</script>
	
</body>
</html>