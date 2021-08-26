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
				String user = rs.getString(2);
				String nick_name = rs.getString(4);
				String address = rs.getString(6);
				
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
		
		String sql = "insert into members values (MEMBERS_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, null, null)";
		
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
		
		String sql = "select * from restaurant_info where res_name like ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, "%" + res_name + "%");
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String getRes_id = rs.getString(1);
				String getRes_pw = rs.getString(2);
				String getRes_cate = rs.getString(3);
				String getRes_name = rs.getString(4);
				String getRes_address= rs.getString(5);
				String getCall_num = rs.getString(6);
				
				JSONArray dto = new JSONArray();
				
				dto.add(getRes_id);
				dto.add(getRes_pw);
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

	public String setup(String title, int restaurant, String time, int min, String location, String nick, String content) {
	      
	      String result = null;
	      conn();
	      
	      String sql = "insert into communities values (COMMUNITIES_SEQ.NEXTVAL, ?, (select res_seq where res_name = ?), ?, ?, ?, ?, SYSDATE()";
	      
	      try {
	         psmt = conn.prepareStatement(sql);
	         
	         psmt.setString(1, title);
	         psmt.setInt(2, restaurant);
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
				String getRes_name = rs.getString(5);
				String getRes_addr = rs.getString(6);
				String getRes_tel = rs.getString(7);
				
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

	public ArrayList<communityDTO> listup(String my_loca) {
//		String my_loca
		 ArrayList<communityDTO> list = new ArrayList<communityDTO>();
		 communityDTO commulist = null;

	      try {
	         conn();
	         // 쿼리 실행
//	         String sql = "select * from community where location=?";
	         String sql = "select * from communities";

	         psmt = conn.prepareStatement(sql);
//	         psmt.setString(1, my_loca);

	         rs = psmt.executeQuery();
	         
	         while (rs.next()) {
	            // 컬럼인덱스는 1부터 시작
	        	String title = rs.getString(2);
	            int restaurant = rs.getInt(3);
	            String time = rs.getString(4);
	            int min = rs.getInt(5);
	            String location = rs.getString(6);
	            String host_nick = rs.getString(6);
	            
//	            System.out.println(title +", "+ restaurant +", "+ time +", "+ min +", "+ location +", "+ host_nick);

	            commulist = new communityDTO(0, title, restaurant, time, min, location, host_nick, null);
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
//	
//	public ArrayList<communityDTO> myPost(String nick) {
//		
//		 ArrayList<communityDTO> list = new ArrayList<communityDTO>();
//		 communityDTO commulist = null;
//
//	      try {
//	         conn();
//	         // 쿼리 실행
//	         String sql = "select * from community where host_nick=?";
//
//	         psmt = conn.prepareStatement(sql);
//	         psmt.setString(1, nick);
//	         
//	         rs = psmt.executeQuery();
//	         
//	         while (rs.next()) {
//	            // 컬럼인덱스는 1부터 시작
//	        	String title = rs.getString(1);
//	            String restaurant = rs.getString(2);
//	            String time = rs.getString(3);
//	            String min = rs.getString(4);
//	            String location = rs.getString(5);
//	            String host_nick = rs.getString(6);
//	            String content = rs.getString(7);
//
//	            commulist = new communityDTO(title, restaurant, time, min, location, host_nick, content);
//	            list.add(commulist);
//	         }
//	      } catch (SQLException e) {
//	         System.out.println("sql문 오류다!!");
//
//	         e.printStackTrace();
//	      } finally {
//	         finish();
//	      }
//	      return list;
//	   }
//	
//	public ArrayList<communityDTO> listclick(String nick, String list_title) {
//		
//		 ArrayList<communityDTO> list = new ArrayList<communityDTO>();
//		 communityDTO commulist = null;
//
//	      try {
//	         conn();
//	         // 쿼리 실행
//	         String sql = "select * from community where host_nick=? and title=?";
//
//	         psmt = conn.prepareStatement(sql);
//	         psmt.setString(1, nick);
//	         psmt.setString(2, list_title);
//	         
//	         rs = psmt.executeQuery();
//	         
//	         while (rs.next()) {
//	            // 컬럼인덱스는 1부터 시작
//	        	String title = rs.getString(1);
//	            String restaurant = rs.getString(2);
//	            String time = rs.getString(3);
//	            String min = rs.getString(4);
//	            String location = rs.getString(5);
//	            String host_nick = rs.getString(6);
//	            String content = rs.getString(7);
//
//	            commulist = new communityDTO(title, restaurant, time, min, location, host_nick, content);
//	            list.add(commulist);
//	         }
//	      } catch (SQLException e) {
//	         System.out.println("sql문 오류다!!");
//
//	         e.printStackTrace();
//	      } finally {
//	         finish();
//	      }
//	      return list;
//	   }
//	
//	public ArrayList<joinlistDTO> Joinlist(String nick) {
//		
//		 ArrayList<joinlistDTO> list = new ArrayList<joinlistDTO>();
//		 joinlistDTO commulist = null;
//
//	      try {
//	         conn();
//	         // 쿼리 실행
//	         String sql = "select * from join where my_nick=?";
//
//	         psmt = conn.prepareStatement(sql);
//	         psmt.setString(1,nick);
//	       
//	         
//	         rs = psmt.executeQuery();
//	         
//	         while (rs.next()) {
//	            // 컬럼인덱스는 1부터 시작
//	        	String title = rs.getString(1);
//	            String restaurant = rs.getString(2);
//	            String time = rs.getString(3);
//	            String min = rs.getString(4);
//	            String location = rs.getString(5);
//	            String host_nick = rs.getString(6);
//	            String content = rs.getString(7);
//	            String my_nick = rs.getString(8);
//
//	            commulist = new joinlistDTO(title, restaurant, time, min, location , host_nick, content, my_nick);
//	            list.add(commulist);
//	         }
//	      } catch (SQLException e) {
//	         System.out.println("sql문 오류다!!");
//
//	         e.printStackTrace();
//	      } finally {
//	         finish();
//	      }
//	      return list;
//	   }
//	
//	public ArrayList<reviewDTO> reviewlist() {
//		
//		 ArrayList<reviewDTO> list = new ArrayList<reviewDTO>();
//		 reviewDTO reviewlist = null;
//
//	      try {
//	         conn();
//	         // 쿼리 실행
//	         String sql = "select * from review";
//
//	         psmt = conn.prepareStatement(sql);
//	
//	         rs = psmt.executeQuery();
//	         
//	         while (rs.next()) {
//	            // 컬럼인덱스는 1부터 시작
//	        	int taste = rs.getInt(1);
//	        	int amount = rs.getInt(2);
//	        	int speed = rs.getInt(3);
//	            String review = rs.getString(4);
//	            String review_nick = rs.getString(5);
//	         
//
//	            reviewlist = new reviewDTO(taste, amount, speed, review , review_nick);
//	            list.add(reviewlist);
//	         }
//	      } catch (SQLException e) {
//	         System.out.println("sql문 오류다!!");
//
//	         e.printStackTrace();
//	      } finally {
//	         finish();
//	      }
//	      return list;
//	   }
//	
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
			String sql = "insert into MARKDOWN_INFO VALUES(?,?,?,?)";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,id);// id
			psmt.setString(2,address);// address
			psmt.setDouble(3,latitude);// latitude
			psmt.setDouble(4,longitude);// longitude
			
			
			
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
	
	public ArrayList<markdownDTO> getmarkdown_info() {
		markdownDTO m_dto = null;
		ArrayList<markdownDTO> mardown_info = new ArrayList<markdownDTO>();

		conn();

		try {
			String sql = "select * from MARKDOWN_INFO";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");

				String title = rs.getString("title");

				double latitude = rs.getDouble("latitude");

				double longitude = rs.getDouble("longitude");

				System.out.printf("id: %s latitude:%f longitude:%f title:%s\n", id, latitude, longitude, title);
				m_dto = new markdownDTO(id, title, latitude, longitude);
				mardown_info.add(m_dto);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			finish();
		}

		return mardown_info;
	}

}
