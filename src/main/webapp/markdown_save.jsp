<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지도 생성하기</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<!-- 지도를 표시할 div 입니다 -->
	<div class="map_wrap">
	    <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
	</div>
	<!--  -------------------------------------------------------------------------------------------------------------------------------------------------------->

	<script src="./js/jquery-3.6.0.min.js"></script>

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2214e25ae5fc7d10f74fded049eed004"></script>
	<script src="./js/markdown_save.js"></script>
</body>
</html>