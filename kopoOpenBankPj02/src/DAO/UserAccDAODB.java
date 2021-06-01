package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Util.ConnectionFactory;
import VO.UserVO;

public class UserAccDAODB {
	
	/**
	 * 전체 계좌정보 출력
	 * @return
	 * @throws Exception
	 */
	public List<UserVO> showAllAcc(String res) throws Exception{
		List<UserVO> uvo = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append("select name, phone, bank_code, account, accpwd, accalias, enroll_dt, balance, res_code ");
			sql.append("from accountdb ");
			sql.append("where res_code = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, res);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String bank_code = rs.getString("bank_code");
				String account = rs.getString("account");
				String accpwd = rs.getString("accpwd");
				String accalias = rs.getString("accalias");
				String enroll_dt = rs.getString("enroll_dt");
				int balance = rs.getInt("balance");
				String res_code = rs.getString("res_code");
				
				UserVO inputvo = new UserVO(name, phone, bank_code, account, accpwd, accalias, enroll_dt, balance, res_code);
				uvo.add(inputvo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uvo;
	}

}
