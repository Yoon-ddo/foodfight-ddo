package Service;

import java.util.List;

import DAO.UserAccDAODB;
import VO.UserVO;

public class UserService {
	
	private UserAccDAODB dao;
	
	public UserService() {
		dao = new UserAccDAODB();
	}
	
	/**
	 * 전체계좌 출력서비스
	 * @param res
	 * @throws Exception
	 */
	public void showAllAccService(String res) throws Exception{
		List<UserVO> lst = showAllAccList(res);
		if(lst.size()==0) {
			System.out.println("정보가 없습니다. 영업점에 문의하세요.");
		}else {
			//System.out.println(lst);
			for(UserVO u : lst) {
				System.out.println("-------------------------------------------------------------------");
				System.out.println("\t[은행명] "+BankName(u.getBank_code()));
				System.out.print("\t[계좌번호] "+u.getAccount());
				System.out.println("\t[별칭] "+u.getAccalias());
				System.out.println("\t[잔액] "+u.getBalance());
				System.out.println("-------------------------------------------------------------------");
			}
		}
		
	}
	
	/**
	 * 본인 계좌 전체리스트
	 * @param res
	 * @return
	 * @throws Exception
	 */
	public List<UserVO> showAllAccList(String res) throws Exception{
		List<UserVO> userlist = dao.showAllAcc(res);
		return userlist;
	}
	
	/**
	 * 은행코드->은행이름으로 변경
	 * @param bname
	 * @return
	 */
	public String BankName(String bname) {
		String bankname = bname;
		switch(bankname) {
		case "H":
			bankname = "하나은행";
			break;
		case "S":
			bankname = "신한은행";
			break;
		case "K":
			bankname = "국민은행";
			break;
		case "I":
			bankname = "기업은행";
			break;
		case "W":
			bankname = "우리은행";
			break;
		}
		
		return bankname;
	}
	
	public String AccPrint(String bname, String accnum) {
		String bankname = bname;
		String acc = "";
		switch(bankname) {
		case "H":
			for(int a = 0; a<accnum.length(); a++) {
				System.out.println();
			}
			break;
		case "S":
			bankname = "신한은행";
			break;
		case "K":
			bankname = "국민은행";
			break;
		case "I":
			bankname = "기업은행";
			break;
		case "W":
			bankname = "우리은행";
			break;
		}
		
		return bankname;
	}
	

}
