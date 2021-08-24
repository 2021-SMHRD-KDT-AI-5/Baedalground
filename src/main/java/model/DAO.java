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
		
		String sql = "select * from member where id = ? AND pw = ?";
		
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
		return result;
		
	}

	public String join(String id, String pw, String nick_name, int age, String address, int cash, String gender) {
		
		String result = null;
		conn();
		
		String sql = "insert into member values (?, ?, ?, ?, ?, ?, ?)";
		
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
		return res_DTO;
		
	}

	public String setup(String title, String restaurant, String time, String min, String location, String nick, String content) {
	      
	      String result = null;
	      conn();
	      
	      String sql = "insert into community values (?, ?, ?, ?, ?, ?, ?)";
	      
	      try {
	         psmt = conn.prepareStatement(sql);
	         
	         psmt.setString(1, title);
	         psmt.setString(2, restaurant);
	         psmt.setString(3, time);
	         psmt.setString(4, min);
	         psmt.setString(5, location);
	         psmt.setString(6, nick);
	         psmt.setString(7, content);
	         
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
	      
	      return  result;

	}

	public JSONObject menu(String res_name) {
		
		JSONObject menu_DTO = new JSONObject();
		int mr = 0;
		
		conn();
		
		String sql = "select * from menu where res_name = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, res_name);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String getRes_name = rs.getString(1);
				String getMenu_name = rs.getString(2);
				String getMenu_img = rs.getString(3);
				int getMenu_price = rs.getInt(4);
				
				JSONArray dto = new JSONArray();
				
				dto.add(getRes_name);
				dto.add(getMenu_name);
				dto.add(getMenu_img);
				dto.add(getMenu_price);
				
				menu_DTO.put(mr, dto);
				mr++;
				
				System.out.println(mr + "출력");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return menu_DTO;
	}

	public JSONObject menuinfo(String res_name) {
		
		JSONObject menu_info_DTO = new JSONObject();
		int mir = 0;
		
		conn();
		
		String sql = "select * from restaurant_info where res_name = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, res_name);
			
			rs = psmt.executeQuery();
			
			System.out.println("가게정보");
			
			while(rs.next()) {
				String getRes_name = rs.getString(4);
				String getRes_addr = rs.getString(5);
				String getRes_tel = rs.getString(6);
				
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
		
		return menu_info_DTO;
	}

	public JSONObject category(String cate) {
		
		JSONObject res_DTO = new JSONObject();
		int csr = 0;
		
		conn();
		
		String sql = "select * from restaurant_info where res_cate = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, cate);
			
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
				dto.add(getRes_cate);
				
				res_DTO.put(csr, dto);
				csr++;
				
				System.out.println(csr + "출력");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res_DTO;
		
	}

	public String update(String temp_pw, String up_pw, String temp_nick, String temp_address, String id) {
		String result = null;
        conn();
        
        String sql = "update member set pw=?, nick_name=?, address=? where id=? and pw=?";
        
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
        
        return  result;

	}






}
