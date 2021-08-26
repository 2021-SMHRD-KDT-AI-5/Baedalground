   $(function(){
      $.ajax({
         type : "post",
         dataType : "json", //서버에서 받을 데이터 형식을 지적한다.
         url : "markdown_info", //요청받을 서블릿 url 이름
         success : function(check){
               alert("성공"); //통신에 성공했는지 확인하기위한 알림창
               console.log(check);
               var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
                   mapOption = {
                       center: new kakao.maps.LatLng(35.11066820739486, 126.87733276913963), // 지도의 중심좌표
                       level: 2 // 지도의 확대 레벨
                   };  
               
               
               // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
               var map = new kakao.maps.Map(mapContainer, mapOption); 
                // 지도에 표시할 원을 생성합니다
                 /*   var circle = new kakao.maps.Circle({
                       center : new kakao.maps.LatLng(35.11066820739486, 126.87733276913963),  // 원의 중심좌표 입니다 
                       radius: 70, // 미터 단위의 원의 반지름입니다 
                       strokeWeight: 5, // 선의 두께입니다 
                       strokeColor: '#BA2B2B', // 선의 색깔입니다
                       strokeOpacity: 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
                       strokeStyle: 'dashed', // 선의 스타일 입니다
                       fillColor: '#000000', // 채우기 색깔입니다
                       fillOpacity: 0.2  // 채우기 불투명도 입니다   
                   }); 
                   // 지도에 원을 표시합니다
                   circle.setMap(map); */ 
               //주소-좌표 변환 객체를 생성합니다
               /*var geocoder = new kakao.maps.services.Geocoder(); 
               
               function info(result, status,latitude,longitude){//좌표 검색과, 해당 좌표에 대한 데이터를 출력하기 위한 클로저 함수
                  return function(result, status) {
                  
                      // 정상적으로 검색이 완료됐으면 
                       if (status === kakao.maps.services.Status.OK) {
                  
                          var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
                  
                          // 결과값으로 받은 위치를 마커로 표시합니다
                          var marker = new kakao.maps.Marker({
                              map: map,
                              position: coords
                          });
                  
                          // 인포윈도우로 장소에 대한 설명을 표시합니다
                          var infowindow = new kakao.maps.InfoWindow({
                              content: '위치명1 :<div style="width:150px;text-align:left;padding:0px 0;">'+title+'</div><br>'+
                              '위치명2 :<div style="width:150px;text-align:left;padding:0px 0;">'+title+'</div>'
                          });
                          
                          
                          // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
                          // 이벤트 리스너로는 클로저를 만들어 등록합니다 
                          // ★★★★★for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
                          kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
                          kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
                          
                              
                          // 마커에 클릭이벤트를 등록합니다
                          kakao.maps.event.addListener(marker, 'click', function() {
                             //클릭한 해당 마크의 name 과 tell 을 쿼리스트링으로 get 방식으로 넘겨줌 
                             location.href = "ex01info.jsp?title=" +title+"&&latitude="+latitude+"&&longitude="+longitude;
                          });
               
                      } 
                      
                  }
               }
               for (var i = 0; i < check.length; i ++) {
                  // 주소로 좌표를 검색하여 map 에 마크로 나타낸다
                  geocoder.addressSearch(check[i].address, info(null,null,check[i].name,check[i].tell));         
               }
               // 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
               function makeOverListener(map, marker, infowindow) {
                   return function() {
                       infowindow.open(map, marker);
                   };
               }
               // 인포윈도우를 닫는 클로저를 만드는 함수입니다 
               function makeOutListener(infowindow) {
                   return function() {
                       infowindow.close();
                   };
               }*/
               
               
               //마커들의 위도,경도
               /* var positions = [
               {
                   title: 'CGI 센터', 
                   latlng: new kakao.maps.LatLng(35.11051666538836, 126.87766717605018)
               },
               {
                   title: '1', 
                   latlng: new kakao.maps.LatLng(35.1104544722799, 126.87839463019746)
               },
               {
                   title: '2', 
                   latlng: new kakao.maps.LatLng(35.11349508634095,126.87539937935898)
               },
               {
                   title: '3',
                   latlng: new kakao.maps.LatLng(35.10762039978934, 126.8776007083012)
               },
               {
                   title: '4', 
                   latlng: new kakao.maps.LatLng(35.12255721442306, 126.86753233502012)
               },
               ]; */
               
               //마커 이미지의 이미지 주소입니다
               var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
               
               for (var i = 0; i < check.length; i ++) {
                   
                   // 마커 이미지의 이미지 크기 입니다
                   var imageSize = new kakao.maps.Size(24, 35); 
                   
                   // 마커 이미지를 생성합니다    
                   var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
                   
                   // 마커를 생성합니다
                   var marker = new kakao.maps.Marker({
                       map: map, // 마커를 표시할 지도
                       position: new kakao.maps.LatLng(check[i].latitude, check[i].longitude), // 마커를 표시할 위치
                       title : check[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                       image : markerImage // 마커 이미지 
                   }); 
               } 
               
               /* // HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
               if (navigator.geolocation) {
                   
                   // GeoLocation을 이용해서 접속 위치를 얻어옵니다
                   navigator.geolocation.getCurrentPosition(function(position) {
                       
                       var lat = position.coords.latitude, // 위도
                           lon = position.coords.longitude; // 경도
                       
                       var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
                           message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다
                       
                       // 마커와 인포윈도우를 표시합니다
                       displayMarker(locPosition, message);
                       var circle = new kakao.maps.Circle({
                          center : new kakao.maps.LatLng(lat,lon),  // 원의 중심좌표 입니다 
                          radius: 70, // 미터 단위의 원의 반지름입니다 
                          strokeWeight: 5, // 선의 두께입니다 
                          strokeColor: '#BA2B2B', // 선의 색깔입니다
                          strokeOpacity: 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
                          strokeStyle: 'dashed', // 선의 스타일 입니다
                          fillColor: '#000000', // 채우기 색깔입니다
                          fillOpacity: 0.2  // 채우기 불투명도 입니다   
                      }); 
                      // 지도에 원을 표시합니다
                      circle.setMap(map);
                      
                      //위경도 DB저장
                      $.ajax({
                         url:'insert_mark',
                         data:'lat='+lat+'&lon='+lon,
                         success:function(){
                            alert('저장완료');
                         }
                      });
                           
                     });
                   
               } else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
                   
                   var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),    
                       message = 'geolocation을 사용할수 없어요..'
                       
                   displayMarker(locPosition, message);
               } */
      /*----------------------------------------------------------------------------------------------------------------------  */

               // 지도에 마커와 인포윈도우를 표시하는 함수입니다
               function displayMarker(locPosition, message) {

                   // 마커를 생성합니다
                   var marker = new kakao.maps.Marker({  
                       map: map, 
                       position: locPosition
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
               map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

               // 지도가 확대 또는 축소되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
               kakao.maps.event.addListener(map, 'zoom_changed', function() {        
                   
                   // 지도의 현재 레벨을 얻어옵니다
                   var level = map.getLevel();   
                   });
      /*------------------------------------------------------------------------------------------------------------------------------------ */
                 
                  
         
            
      /*------------------------------------------------------------------------------------------------------------------------------------ */
       
       
       //ajax 끝나는 부분
         }
      });
   });