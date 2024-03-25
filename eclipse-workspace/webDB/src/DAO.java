package blog.naver.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

	
	Connection conn ;
	PreparedStatement pstm;
	ResultSet rs;
	ArrayList<VO> list;
	
	//싱글톤 패턴 : 한번만들면 계속사용가능
	
	private static DAO dao = new DAO();
	public static DAO getInstance() {
		return dao;
	}
	
	//db 접속
	public Connection getConnection() {
		try {
			list = new ArrayList<VO>();
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "rain";
			String password = "1111";
			conn = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}
	
	//DB에 사용할 메소
	
	//insert 회원가입
	public int getInsert(VO vo) {
		int res = 0;
		try {
			conn = getConnection();
			String sql = "insert into blog values(?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, vo.getRank());
			pstm.setString(2, vo.getId());
			pstm.setString(3, vo.getPw());
			pstm.setString(4, vo.getName());
			res = pstm.executeUpdate();
		} catch (Exception e) {
		
		}finally {
			try {
				pstm.close();
				conn.close();
			} catch (Exception e2) {
			
			}
		}
		return res;
	}
	
	// 로그인
	
	public VO getLogin(VO vo) {
		VO pvo = null;
		try {
			conn = getConnection();
			String sql = "select * from blog where id=? and pw=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, vo.getId());
			pstm.setString(2, vo.getPw());
			rs = pstm.executeQuery();
			if(rs.next()) {
				pvo = new VO();
				pvo.setRank(rs.getString(1));
				pvo.setId(rs.getString(2));
				pvo.setPw(rs.getString(3));
				pvo.setName(rs.getString(4));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				rs.close();
				pstm.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return pvo;
	}
	
	// 리스트에 정보보이기
	public ArrayList<VO> getList(){
		try {
			conn = getConnection();
			String sql ="select * from blog order by rank";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				VO vo  = new VO();
				vo.setRank(rs.getString(1));
				vo.setId(rs.getString(2));
				vo.setPw(rs.getString(3));
				vo.setName(rs.getString(4));
				list.add(vo);
			}
			
		} catch (Exception e) {
		} finally {
			try {
				rs.close();
				pstm.close();
				conn.close();
			} catch (Exception e2) {
			}
		}
		return list;
	}
	// 내정보 수정
	public int getUpdate(VO vo) {
		int result = 0 ;
		try {
			conn = getConnection();
			String sql ="update blog set name=? where rank=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, vo.getName());
			pstm.setString(2, vo.getRank());
			result = pstm.executeUpdate();
		} catch (Exception e) {
		} finally {
			try {
				pstm.close();
				conn.close();
			} catch (Exception e2) {
			}
		}
		return result;
	}
	
	// 회원탈퇴
	public int getDelete(String rank) {
		int result = 0 ;
		try {
			conn = getConnection();
			String sql ="delete from blog where rank = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, rank);
			result = pstm.executeUpdate();
		}catch (Exception e) {
		}finally {
			try {
				pstm.close();
				conn.close();
			} catch (Exception e2) {
			}
		}
		return result;
	}
}
