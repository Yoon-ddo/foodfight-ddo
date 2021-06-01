package UI;

public class BankSysUI extends BaseUI{
	
	public static boolean ckadmin;
	public static boolean ckuser;
	
	@Override
	public void execute() throws Exception {
		
		while(true) {
			try {
				//IBankSysUI ui = null;
				int type = menu();
				if(type == 1 || type == 2 || type == 0) {
					
					switch(type) {
					case 1: // 로그인
						LogInUI liui = new LogInUI();	
						liui.execute();
						ckadmin = liui.ckAdmin();
						ckuser = liui.ckUser();
								
						if(ckadmin == true) {
							AdminUI aui= new AdminUI();
							aui.execute();
						}else if(ckuser == true){
							UserUI uui = new UserUI();
							uui.execute();
						}
						
						break;
					case 2://회원가입
						SignInUI siui = new SignInUI();
						siui.execute();
						break;
					case 0://종료
						ExitUI exui = new ExitUI();
						exui.execute();
						break;
					}
				} else System.out.println("유효하지 않은 메뉴입니다.");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public int menu() {
		System.out.println("-------------------------------------------------------------------");
		System.out.println();
		System.out.println("\t\t하나원큐 통합계좌 관리 시스템에 오신 것을 환영합니다.");
		System.out.println();
		System.out.println("-------------------------------------------------------------------");
		System.out.println("\t     [1]. 로그인     [2]. 회원가입     [0]. 종료");
		System.out.println("-------------------------------------------------------------------");
		int type = scanInt("원하는 메뉴를 선택하세요. : ");
		return type;
		
	}
	

}//c
