package UI;

public class UserUI extends LogInUI{

	@Override
	public void execute() throws Exception {
		
		String res = rescd;
		//System.out.println(res); // 주민번호가져오기
		userservice.showAllAccService(res);
		while(true) {
			try {
				int type = menu();
				switch(type) {
				case 1:
					System.out.println("계좌등록");
					break;
				case 2:
					System.out.println("계좌수정");
					break;
				case 3:
					System.out.println("계좌삭제");
					break;
				case 4:
					System.out.println("내역조회");
					break;
				case 0:
					System.out.println("로그아웃");
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 유저계정 메인메뉴
	 * @return
	 */
	public int menu() {
		System.out.println("-------------------------------------------------------------------");
		System.out.println("      [1]계좌등록  [2]계좌수정  [3]계좌삭제  [4]계좌선택  [0]. 로그아웃");
		System.out.println("-------------------------------------------------------------------");
		int type = scanInt("원하는 메뉴를 선택하세요. : ");
		return type;
		
	}

}//c
