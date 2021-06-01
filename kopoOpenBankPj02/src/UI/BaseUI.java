package UI;

import java.util.Scanner;

import Service.LogService;
import Service.LogServiceFactory;
import Service.UserService;
import Service.UserServiceFactory;
import VO.UserVO;

public abstract class BaseUI implements IBankSysUI{
	
	private Scanner sc;
	protected LogService logservice;
	protected UserService userservice;
	public static UserVO uservo; // 로그인한사람의 주민번호 
	
	public BaseUI() {
		sc = new Scanner(System.in);
		logservice = LogServiceFactory.getInstance();
		userservice = UserServiceFactory.getInstance();
		uservo = new UserVO();
	}
	
	protected String scanStr(String msg) {
		System.out.print(msg);
		String str = sc.nextLine();
		return str;
	}
	
	protected int scanInt(String msg) {
		int num = Integer.parseInt(scanStr(msg));
		return num;
	}
	
	public static UserVO getUserVO() {
		return uservo;
	}

}
