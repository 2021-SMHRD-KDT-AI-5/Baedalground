package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	int cnt;
	
	public void conn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "cgi_7_1";
			String pw = "smhrd1";
			
			conn = DriverManager.getConnection(url, user, pw);
			
			if(conn != null) {
				System.out.println("conn()//DB연결성공");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void finish() {
		try {
			if(rs != null) {
				rs.close();
			}if(psmt != null) {
				psmt.close();
			}if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String login(String id, String pw) {
		
		String result = null;
		
		conn();
		
		String sql = "select * from members where member_id = ? AND member_pw = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String user = rs.getString(1);
				String nick_name = rs.getString(3);
				String address = rs.getString(5);
				
				result =  "1," + user + ", " + nick_name + "," + address;
				System.out.println("로그인 성공");
			}else {
				result =  "0";
				System.out.println("로그인 실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			finish();
		}
		return result;
		
	}

	public String join(String id, String pw, String nick_name, int age, String address, int cash, String gender) {
		
		String result = null;
		conn();
		
		String sql = "insert into members values (?, ?, ?, ?, ?, ?, ?, null, null)";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, nick_name);
			psmt.setInt(4, age);
			psmt.setString(5, address);
			psmt.setInt(6, cash);
			psmt.setString(7, gender);
			
			int count = psmt.executeUpdate();
			System.out.println("sql 성공!");
			
			if(count!=0) {
				result = "1";
				System.out.println("조인 성공");
			}else {
				result = "0";
				System.out.println("조인 실패");
			}
			
		} catch (SQLException e) {
			System.out.println("Join error");
			e.printStackTrace();
		}
		
		finally {
			finish();
		}
		
		return  result;
	}

	public JSONObject search(String res_name) {
		
		JSONObject res_DTO = new JSONObject();
		int sr = 0;
		
		conn();
		
		String sql = "select * from restaurants where res_name like ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, "%" + res_name + "%");
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				String getRes_cate = rs.getString(2);
				String getRes_name = rs.getString(3);
				String getCall_num = rs.getString(4);
				String getRes_address= rs.getString(5);
				
				JSONArray dto = new JSONArray();
				
				dto.add(getRes_name);
				dto.add(getRes_address);
				dto.add(getCall_num);
				
				res_DTO.put(sr, dto);
				sr++;
				
				System.out.println(sr + "출력");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			finish();
		}
		return res_DTO;
		
	}

	public String setup(String title, String restaurant, String time, int min, String location, String nick, String content) {
	      String result = null;
	      conn();
	      
	      String sql = "insert into communities values (COMMUNITIES_SEQ.NEXTVAL, ?, (select res_seq from restaurants where res_name = ?), sysdate(datetime, ?, 'hh:mi'), ?, (select member_id from members where member_addr = ?), ?, sysdate)";
	      
	      try {
	         psmt = conn.prepareStatement(sql);
	         
	         psmt.setString(1, title);
	         psmt.setString(2, restaurant);
	         psmt.setString(3, time);
	         psmt.setInt(4, min);
	         psmt.setString(5, location);
	         psmt.setString(6, content);
	         
	         int count = psmt.executeUpdate();
	         
	         System.out.println("sql 성공!");
	         
	         if(count!=0) {
	            result = "1";
	            System.out.println("커뮤 성공");
	         }else {
	            result = "0";
	            System.out.println("커뮤 실패");
	         }
	         
	      } catch (SQLException e) {
	         System.out.println("setup error");
	         e.printStackTrace();
	      }
	      
	      finally {
				finish();
	      }
	      
	      return  result;

	}

	public JSONObject menu(String res_name) {
		
		JSONObject menu_DTO = new JSONObject();
		int mr = 0;
		
		conn();
		
//		String sql = "select * from menus where res_name = ?";
		String sql = "select * from menus where res_seq = (select res_seq from restaurants where res_name = ? )";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, res_name);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String getRes_name = res_name;
				String getMenu_img = rs.getString(3);
				String getMenu_name = rs.getString(4);
				int getMenu_price = rs.getInt(5);
				
				JSONArray dto = new JSONArray();
				
				dto.add(getRes_name);
				dto.add(getMenu_img);
				dto.add(getMenu_name);
				dto.add(getMenu_price);
				
				menu_DTO.put(mr, dto);
				mr++;
				
				System.out.println(mr + "출력");
				System.out.println(menu_DTO.toString());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			finish();
		}
		
		return menu_DTO;
	}

	public JSONObject menuinfo(String res_name) {
		
		JSONObject menu_info_DTO = new JSONObject();
		int mir = 0;
		
		conn();
		
		String sql = "select * from restaurants where res_name = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, res_name);
			
			rs = psmt.executeQuery();
			
			System.out.println("가게정보");
			
			while(rs.next()) {
				String getRes_name = rs.getString(3);
				String getRes_addr = rs.getString(5);
				String getRes_tel = rs.getString(4);
				
				JSONArray dto = new JSONArray();
				
				dto.add(getRes_name);
				dto.add(getRes_addr);
				dto.add(getRes_tel);
				
				menu_info_DTO.put(mir, dto);
				mir++;
				
				System.out.println(mir + "출력");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			finish();
		}
		
		return menu_info_DTO;
	}

	public JSONObject category(String cate) {
		
		JSONObject res_DTO = new JSONObject();
		int csr = 0;
		
		conn();
		
		String sql = "select * from restaurants where res_category = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, cate);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String getRes_id = rs.getString(2);
				String getRes_pw = rs.getString(3);
				String getRes_cate = rs.getString(4);
				String getRes_name = rs.getString(5);
				String getRes_address= rs.getString(6);
				String getCall_num = rs.getString(7);
				
				JSONArray dto = new JSONArray();
				
				dto.add(getRes_id);
				dto.add(getRes_pw);
				dto.add(getRes_name);
				dto.add(getRes_address);
				dto.add(getCall_num);
				dto.add(getRes_cate);
				
				res_DTO.put(csr, dto);
				csr++;
				
				System.out.println(csr + "출력");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			finish();
		}
		
		return res_DTO;
		
	}

	public String update(String temp_pw, String up_pw, String temp_nick, String temp_address, String id) {
		
		String result = null;
        conn();
        
        String sql = "update members set member_pw = ?, nickname = ?, member_addr = ? where member_id = ? and member_pw = ?";
        
        try {
           psmt = conn.prepareStatement(sql);
           
           psmt.setString(1,up_pw);
           psmt.setString(2,temp_nick);
           psmt.setString(3,temp_address);
           psmt.setString(4,id);
           psmt.setString(5,temp_pw);
          
           
           int count = psmt.executeUpdate();
           System.out.println("sql 성공!");
           
           if(count!=0) {
              result = "1";
              System.out.println("업데이트 성공");
           }else {
              result = "0";
              System.out.println("업데이트 실패");
           }
           
        } catch (SQLException e) {
           System.out.println("Update error");
           e.printStackTrace();
        }
        
        finally {
			finish();
		}
        
        return  result;

	}

	public JSONObject listup(String my_loca) {
		
		JSONObject commulist_DTO = new JSONObject();
		int no_listup = 0;
		
		conn();
		
		String sql = "select * from communities";
//		 where location=?
		
		try {
			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, my_loca);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String title = rs.getString(2);
				int restaurant = rs.getInt(3);
				String time = rs.getString(4);
		        int min = rs.getInt(5);
		        String host_id = rs.getString(6);
		        String content = rs.getString(7);
		        
		        JSONArray dto = new JSONArray();
		        
		        dto.add(title);
		        dto.add(resitos(restaurant).get(0));
		        dto.add(time);
		        dto.add(min);
		        dto.add(host_id);
		        dto.add(content);
		        
		        commulist_DTO.put(no_listup, dto);
		        no_listup++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			finish();
		}
		
		return commulist_DTO;
	}
		
	public ArrayList<String> resitos(int res_seq) {
		
		ArrayList<String> result = new ArrayList<>();
		
		conn();
		
		String sql = "select res_name, res_addr from restaurants where res_seq = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, res_seq);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result.add(rs.getString(1));
				result.add(rs.getString(2));
				
			}
		} catch (SQLException e) {
			System.out.println("rest seq to String error");
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public ArrayList<communityDTO> myPost(String nick) {
		
		 ArrayList<communityDTO> list = new ArrayList<communityDTO>();
		 communityDTO commulist = null;

	      try {
	         conn();
	         // 쿼리 실행
	         String sql = "select * from community where host_id=?";

	         psmt = conn.prepareStatement(sql);
	         psmt.setString(1, nick);
	         
	         rs = psmt.executeQuery();
	         
	         while (rs.next()) {
	            // 컬럼인덱스는 1부터 시작
	        	String title = rs.getString(2);
	            int restaurant = rs.getInt(3);
	            String time = rs.getString(4);
	            int min = rs.getInt(5);
	            String host_id = rs.getString(6);
	            String content = rs.getString(7);

	            commulist = new communityDTO(0, title, restaurant, time, min, host_id, content, null);
	            list.add(commulist);
	         }
	      } catch (SQLException e) {
	         System.out.println("sql문 오류다!!");

	         e.printStackTrace();
	      } finally {
	         finish();
	      }
	      return list;
	   }
	
	public JSONObject listclick(String list_id, String list_title) {
			
		JSONObject clicklist_DTO = new JSONObject();
		
		int no_listup = 0;
		
		conn();
		
		try {
		
			String sql = "select * from communities where member_id = ? and title = ?";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, list_id);
			psmt.setString(2, list_title);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				
				String title = rs.getString(2);
				int restaurant = rs.getInt(3);
				String time = rs.getString(4);
		        int min = rs.getInt(5);
		        String host_id = rs.getString(6);
		        String content = rs.getString(7);
		        String input_time = rs.getString(8);
		        
		        JSONArray dto = new JSONArray();
		        
		        dto.add(title);
		        dto.add(resitos(restaurant).get(0));
		        dto.add(time);
		        dto.add(min);
		        dto.add(host_id);
		        dto.add(content);
		        dto.add(input_time);
		        
		        clicklist_DTO.put(no_listup, dto);
		        no_listup++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			finish();
		}
		
	return clicklist_DTO;
	
   }
	
	public ArrayList<joinlistDTO> Joinlist(String nick) {
		
		 ArrayList<joinlistDTO> list = new ArrayList<joinlistDTO>();
		 joinlistDTO commulist = null;

	      try {
	         conn();
	         // 쿼리 실행
	         String sql = "select * from communityjoins where (select nickname from members where member_id = ?)";

	         psmt = conn.prepareStatement(sql);
	         psmt.setString(1,nick);
	       
	         
	         rs = psmt.executeQuery();
	         
	         while (rs.next()) {
	            // 컬럼인덱스는 1부터 시작
	        	String title = rs.getString(2);
	            int communitySeq = rs.getInt(3);
	            String content = rs.getString(4);
	            int menuSeq = rs.getInt(5);
	            int menuCnt = rs.getInt(6);
	            String host_id = rs.getString(7);

	            commulist = new joinlistDTO(0, title, communitySeq, content, menuSeq, menuCnt, host_id);
	            list.add(commulist);
	         }
	      } catch (SQLException e) {
	         System.out.println("sql문 오류다!!");

	         e.printStackTrace();
	      } finally {
	         finish();
	      }
	      return list;
	   }

	
	public String deleteJoin(String title) {
		
		String result = null;
		conn();
		
		String sql = "delete from community where title=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			int count = psmt.executeUpdate();
			System.out.println("sql 성공!");
			
			if(count!=0) {
				result = "1";
				System.out.println("커뮤 성공");
			}else {
				result = "0";
				System.out.println("커뮤 실패");
			}
			
		} catch (SQLException e) {
			System.out.println("deleteJoin error");
			e.printStackTrace();
		}
		
		return  result;
	}

	public String getinsert_address(String id, String address, double latitude, double longitude){
		insert_markDTO insert_dto= null;
		ArrayList<insert_markDTO>insert_address=new ArrayList<insert_markDTO>();
		String result = "";
		conn();
		
		try {
			String sql = "update members set member_addr = ?, latitude = ?, longitude = ? WHERE member_id = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,address);// address
			psmt.setDouble(2,latitude);// latitude
			psmt.setDouble(3,longitude);// longitude
			psmt.setString(4,id);// id
			
			cnt = psmt.executeUpdate();
			if(cnt!=0) {
				result = "1";
			}else {
				result = "0";
			}
			
		} catch (Exception e) {
			System.out.println("sql문 오류");
		} finally {
			finish();
		}
		return result;
	}
	
//	public ArrayList<markdownDTO> getmarkdown_info(String id) {
//		markdownDTO m_dto = null;
//		ArrayList<markdownDTO> mardown_info = new ArrayList<markdownDTO>();
//
//		conn();
//
//		try {
//			String sql = "select member_id, latitude, longitude from members where member_id = ?";
//			psmt = conn.prepareStatement(sql);
//			
//			psmt.setString(1, id);
//			
//			rs = psmt.executeQuery();
//			
//
//			while (rs.next()) {
//				
////				String id = rs.getString("id");
//
////				String title = rs.getString("title");
//
//				double latitude = rs.getDouble("latitude");
//
//				double longitude = rs.getDouble("longitude");
//
//				System.out.printf("id: %s latitude:%f longitude:%f title:%s\n", id, latitude, longitude);
//				
//				m_dto = new markdownDTO(id, latitude, longitude);
//				
//				mardown_info.add(m_dto);
//
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		finally {
//			finish();
//		}
//
//		return mardown_info;
//	}

	public ArrayList<Integer> topResult_seq(String age, String gender, String myaddr) {
		ArrayList<Integer> topResult_seq = new ArrayList<Integer>();
		
		conn();
		
		try {
			
//			String sub1 = "select member_id from members where ? AND ? AND ?";
//			String sub2 = "select menu_seq from orders where member_id = sub1";
//			String sub3 = "select menu_name from menus where menu_seq =  sub2";
			
//			String sub1 = "select member_id from members where ? AND ? AND ?";
//			String sub2 = "select menu_seq from orders where member_id = sub1";
//			String sub3 = "select menu_name from menus where menu_seq in (select menu_seq from orders where member_id = (select member_id from members where ? AND ? AND ?))";
			
			String sql = "select menu_seq from (select count(menu_seq) as cnt, menu_seq from orders where member_id = (select member_id from members where member_age between ? and ? AND member_gender like ? AND member_addr like ?) group by menu_seq order by cnt desc)";

			
			psmt = conn.prepareStatement(sql);
			
			
			psmt.setInt(1, Integer.valueOf(age));
			psmt.setInt(2, Integer.valueOf(age)+10);
			
			psmt.setString(3, gender);
			psmt.setString(4, "%" + myaddr);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				int result_seq = (rs.getInt(1));
				
//				System.out.println(rs.getInt(1));
//				System.out.println(result_seq);
				
				topResult_seq.add(result_seq);
				
//				String title = rs.getString(2);
//				int restaurant = rs.getInt(3);
//				String time = rs.getString(4);
//		        int min = rs.getInt(5);
//		        String host_id = rs.getString(6);
//		        String content = rs.getString(7);
//		        String input_time = rs.getString(8);
//		        
//		        JSONArray dto = new JSONArray();
//		        
//		        dto.add(title);
//		        dto.add(resitos(restaurant));
//		        dto.add(time);
//		        dto.add(min);
//		        dto.add(host_id);
//		        dto.add(content);
//		        dto.add(input_time);
//		        
//		        topResult.put(no_top10, dto);
//		        no_top10++;
			}
			
			System.out.println(topResult_seq);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			finish();
		}
		
		return topResult_seq;
	}

	public JSONObject menuseqtos(ArrayList<Integer> menu_seq) {
		
		JSONObject obj = new JSONObject();
		
		conn();
		
		String sql = "select * from menus where menu_seq = ?";
		
		try {
			
//			System.out.println(menu_seq.get(0));
			
			for(int i=0; i<menu_seq.size(); i++) {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, menu_seq.get(i));
				
//				System.out.println(menu_seq.get(i));

				ResultSet rst = psmt.executeQuery();
				
				if(rst.next()) {
					
					JSONArray dto = new JSONArray();
					dto.add(i+1);
//					dto.add(rs.getInt(2));
					dto.add(resitos(rst.getInt(2)).get(0));
					dto.add(rst.getString(3));
					dto.add(rst.getString(4));
					dto.add(rst.getInt(5));
					dto.add(resitos(rst.getInt(2)).get(1));
					
//					dto.add(resitos(rs.getInt(2)).get(0));
					
					
//					System.out.println(rs.getString(4));
//					System.out.println(rs.getString(5));

//					System.out.println(resitos(res).get(0));
					obj.put(i, dto);
					
				}
				if(i == 10) {
					break;
				}
			}
		} catch (SQLException e) {
			System.out.println("menu seq to String error");
			e.printStackTrace();
		}
		
		return obj;
		
	}

	public JSONObject myordered(String id) {
		JSONObject myordered = new JSONObject();
		
		int no_ordered = 0;
		
		conn();
		
		String sql = "select order_day, menu_seq, final_sum from orders where member_id = ? order by order_day desc";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			
			ResultSet rsv = psmt.executeQuery();
			
			while(rsv.next()) {
				String ordereddate = rsv.getString(1);
				int orderedname = rsv.getInt(2);
				String orderedprice = rsv.getString(3);
				
				ArrayList<Integer> arr = new ArrayList<Integer>();
				arr.add(orderedname);
				
				JSONArray dto = new JSONArray();
				
				dto.add(ordereddate);
				dto.add(menuseqtos(arr).get(0));
				dto.add(orderedprice);
				
				myordered.put(no_ordered, dto);
				
				System.out.println(no_ordered + ", " + dto.toString());
				no_ordered++;
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			finish();
		}
		
		return myordered;
	}

	public String reviewup(String memberId, String reviewContents, float tasteReview1, float amountReview1, float deliReview1) {
		String result = null;
	    conn();
	      
	    String sql = "insert into reviews values (reviews_seq.nextval, ?, ?, sysdate, ?, ?, ?, (select order_seq from orders where member_id = ?) , null, null, null, null, null, select menu_seq from orderdetails where order_seq = (select order_seq from orders where member_id = ?))";
	      
	    try {
	        psmt = conn.prepareStatement(sql);
		         
		    psmt.setString(1, memberId);
		    psmt.setString(2, reviewContents);
		    psmt.setFloat(3, tasteReview1);
		    psmt.setFloat(4, amountReview1);
		    psmt.setFloat(5, deliReview1);
		    psmt.setString(6, memberId);
		    psmt.setString(7, memberId);
	
	        int count = psmt.executeUpdate();
	        System.out.println("sql 성공!");
	        
	        if(count!=0) {
	        	result = "1";
	            System.out.println("리뷰업 성공");
	        }else {
	            result = "0";
	            System.out.println("리뷰업 실패");
	        }
         
        } catch (SQLException e) {
         System.out.println("review up error");
         e.printStackTrace();
        }
	      
		return result;
	}

	public ArrayList<reviewDTO> reviewlist(String resName) {
	      
	       ArrayList<reviewDTO> list = new ArrayList<reviewDTO>();
	       reviewDTO reviewlist = null;

	         try {
	            conn();
	            // 쿼리 실행
	            String sql = "select * from reviews where res_seq = (select res_seq from restaurants where res_name = ? )";

	            psmt = conn.prepareStatement(sql);

	            psmt.setString(1, resName);
	            
	            rs = psmt.executeQuery();
	            
	            while (rs.next()) {
	               // 컬럼인덱스는 1부터 시작
	              String memberId = rs.getString(2);
	              String reviewContents = rs.getString(3);
	              String inputDate = rs.getString(4);
	              int tasteReview = rs.getInt(5);
	              int amountReview = rs.getInt(6);
	              int deliReview = rs.getInt(7);
	            
	               reviewlist = new reviewDTO(0, memberId, reviewContents, inputDate, tasteReview , amountReview, deliReview, 0);
	               
	               list.add(reviewlist);
	               
	            }
	         } catch (SQLException e) {
	            System.out.println("sql문 오류다!!");

	            e.printStackTrace();
	         } finally {
	            finish();
	         }
	         return list;
	         
	   }
	
	public String ordered(String res_name, String menu_name, String price, String id) {
			
			String result = null;
	        conn();
	        
	        String sql = "insert into orders values(orders_seq.nextval, null, null, ?, sysdate, null, null, ?)";
	        
	        try {
	           psmt = conn.prepareStatement(sql);
	           
	           psmt.setString(1, price);
	           psmt.setString(2, id);
	          
	           
	           int count = psmt.executeUpdate();
	           System.out.println("sql 성공!");
	           
	           if(count!=0) {
	              result = "1";
	           }else {
	              result = "0";
	           }
	           
	        } catch (SQLException e) {
	           e.printStackTrace();
	        }
	        
	        finally {
				finish();
			}
	        
	        return result;
	
		}
	
	
	public String orderedmenu(String res_name, String menu_name, String price, String id) {
		String[] arr = menu_name.split(",");
		String result = null;
        conn();
        
        String sql = "insert into orderdetails values(orderdetails_seq.nextval, select MAX(orders_seq) from orders where member_id = ? , select menu_seq from menus where menu_name = ? , 1)";
        
        try {
        	
        	
        	for(int i = 0; i<arr.length; i++) {
        		psmt = conn.prepareStatement(sql);
        		
        		psmt.setString(1, id);
        		psmt.setString(2, arr[i]);
        		
        		
        	}
          
           
           int count = psmt.executeUpdate();
           System.out.println("sql 성공!");
           
           if(count!=0) {
              result = "1";
           }else {
              result = "0";
           }
           
        } catch (SQLException e) {
           System.out.println("orderedmenu error");
           e.printStackTrace();
        }
        
        finally {
			finish();
		}
        
        return  result;

	}
	

}
