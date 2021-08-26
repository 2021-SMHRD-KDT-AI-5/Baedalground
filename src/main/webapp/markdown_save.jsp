<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>���� �����ϱ�</title>
</head>
<body>
	<!-- ������ ǥ���� div �Դϴ� -->
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
				dataType : "json", //�������� ���� ������ ������ �����Ѵ�.
				url : "Markdown_info_Servlet", //��û���� ���� url �̸�
				success : function(check) {
					alert("����"); //��ſ� �����ߴ��� Ȯ���ϱ����� �˸�â
					/* console.log(check); */
					var mapContainer = document.getElementById('map'), // ������ ǥ���� div 
					mapOption = {
						center : new kakao.maps.LatLng(
								35.11066820739486, 126.87733276913963), // ������ �߽���ǥ
						level : 2
					// ������ Ȯ�� ����
					};
	
					// ������ ǥ���� div��  ���� �ɼ�����  ������ �����մϴ�
					var map = new kakao.maps.Map(mapContainer,
							mapOption);
	
					//��Ŀ �̹����� �̹��� �ּ��Դϴ�
					var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
	
					/*------------------------------------------------------------------------------------------------------------------------------------ */
					// ������ ��Ŀ�� ���������츦 ǥ���ϴ� �Լ��Դϴ�
					function displayMarker(locPosition, message) {
	
						// ��Ŀ�� �����մϴ�
						var marker = new kakao.maps.Marker({
							map : map,
							position : locPosition
						});
	
						var iwContent = message, // ���������쿡 ǥ���� ����
						iwRemoveable = true;
	
						// ���������츦 �����մϴ�
						var infowindow = new kakao.maps.InfoWindow({
							content : iwContent,
							removable : iwRemoveable
						});
	
						// ���������츦 ��Ŀ���� ǥ���մϴ� 
						infowindow.open(map, marker);
	
						// ���� �߽���ǥ�� ������ġ�� �����մϴ�
						map.setCenter(locPosition);
					}
					/*------------------------------------------------------------------------------------------------------------------------------------ */
					// ���� Ȯ�� ��Ҹ� ������ �� �ִ�  �� ��Ʈ���� �����մϴ�
					var zoomControl = new kakao.maps.ZoomControl();
					map.addControl(zoomControl,
							kakao.maps.ControlPosition.RIGHT);
	
					// ������ Ȯ�� �Ǵ� ��ҵǸ� ������ �Ķ���ͷ� �Ѿ�� �Լ��� ȣ���ϵ��� �̺�Ʈ�� ����մϴ�
					kakao.maps.event.addListener(map, 'zoom_changed',
							function() {
	
								// ������ ���� ������ ���ɴϴ�
								var level = map.getLevel();
							});
					/*------------------------------------------------------------------------------------------------------------------------------------ */
				}
			});
			//ajax ������ �κ�
		});
	</script>
	
</body>
</html>