package ATM;

import java.util.Random;
import java.util.Scanner;

public class Bank {

	private Scanner in;

	private String name;
	private UserManager um = new UserManager();
	private AccountManager am = new AccountManager();
	private int log;

	public Bank(String name) {
		this.name = name;
	}

	private String inputToString(String ment) {
		in = new Scanner(System.in);
		System.out.print(ment + ":");
		String input = in.next();
		return input;
	}

	private int inputToInt(String ment) {
		Scanner in = new Scanner(System.in);
		System.out.print(ment + ": ");
		int input = -1;

		if (in.hasNextInt()) {
			input = in.nextInt();
		} else {
			System.out.println("숫자만을 입력해주세요.");
		}

		return input;
	}

	private void print() {

		for (int i = 0; i < um.getSize(); i++) {
			System.out.println(um.getUser(i));
		}
		if (log != -1) {
			System.out.println(um.getUser(log).getName() + "님 로그인");
		}
	}

//	==============기본셋팅======================
	void inIt() {
		this.log = -1;
	}

//	==============회원가입======================
	private void signUp() {

		String name = inputToString("이름");
		String id = inputToString("id");
		String password = inputToString("password");

		User newUser = new User(name, id, password);

		if (um.addUser(newUser)) {

			System.out.println(id + "생성 완료");

		} else {
			System.out.println("이미 존재하는 계정입니다");

		}

	}

//==============회원탈퇴======================
	void leave() {
		System.out.println("회원 탈퇴");
		String delName = inputToString("이름");
		String delId = inputToString("id");
		String delPassword = inputToString("password");

		User delUser = new User(delName, delId, delPassword);

		if (um.delUser(delUser)) {

			System.out.println(delId + "삭제 완료");
			if (delId.equals(um.getUser(log).getName())) {
				log = -1;
			}
		} else {

			System.out.printf("아이디/비밀번호 오류.");

		}

	}

//==============로그인======================
	private void login() {
		if(log==-1) {
			System.out.println("로그인");
			String id = inputToString("id");
			String password = inputToString("password");

			User loginUser = new User(null, id, password);

			int idx = checkIdPwToLogin(loginUser);

			if (idx != -1) {
				this.log = idx;
			} else {
				System.out.println("미존재 계정");
			}
			
		}else {
		System.out.println("로그인 중에는 이용 불가");
		}
	
	}

	private int checkIdPwToLogin(User user) {

		int chk = -1;
		;
		for (int i = 0; i < um.getSize(); i++) {
			if (user.getId().equals(um.getUser(i).getId()) && user.getPassword().equals(um.getUser(i).getPassword())) {
				chk = i;
			}
		}

		return chk;
	}

	// ==============개설======================
	private void openingAccount() {

		if (this.log != -1) {

			// 현재 로그인중인 아이디 인계
			User loginUser = um.getUser(log);
			// 현 계정의 계좌 숫자 확인
			int size = loginUser.getAccountCount();
			if (size < 3) {
				// 무작위 6자리 숫자 생성
				int accountNum = makeAccountCode();
				// 현 계정 정보와 계좌번호를 통해 새 계정 생성
				Account newAccount = am.createAccount(loginUser, accountNum);
				// am에는 이미 저장되었으니 현 계정에 접근용 주소 연결

				// 로그인 계정을 찾아서 신규 계좌 삽입(후 계좌 개수 증가)
				// 이름 변경
				um.addAccountToUser(loginUser, newAccount);

				System.out.println("계좌 " + newAccount.getAccountNum() + "생성완료");

			} else {
				System.out.println("더이상 생성 불가");
			}

		}else {
			System.out.println("로그인 중에만 이용 가능");
		}

	}

	private int makeAccountCode() {
		Random ran = new Random();

		int num = -1;
		while (true) {

			boolean check = true;

			num = ran.nextInt(899999) + 100000;

			for (int i = 0; i < am.getSize(); i++) {
				if (num == am.getAccount(i).getAccountNum()) {
					check = false;
				}
			}
			if (check) {
				break;
			}
		}
		return num;
	}

	// ==============계좌 삭제======================
	private void closingAccount() {

		if (this.log != -1) {

			User loginUser = um.getUser(log);
			if (loginUser.getAccountCount() != 0) {
				um.getUser(log).printAccList();
				System.out.println();
				loginUser.printAccList();

				int idx = inputToInt("삭제할 계정의 번호(취소:0)") - 1;
				if (idx >= 0 && idx < loginUser.getAccountCount()) {
				if(	am.findDeleteAccount(loginUser, idx)) {
					um.deleteAccountFromUser(loginUser, idx);
					
				}else {
					System.out.println("삭제 실패");
					
				}

					
					
					
					
					
					
				} else if (idx == -1) {
					System.out.println("삭제를 취소합니다");
				} else {
					System.out.println("번호를 다시 입력하십시오");
				}

			}else {
				System.out.println("계좌가 없습니다.");
			}

		} else {
			System.out.println("사용 불가능 메뉴");
		}

	}

	// ==============계좌 삭제======================

	public void run() {
		inIt();
		while (true) {
			if(isLoggedIn()) {
				printMainMenu();
			}
			else {
				printSubMain();
			}
			System.out.println(this.name);
			print();
			
			
			System.out.print("1. 회원가입 2.회원탈퇴 3.계좌신청\n4.계좌탈퇴 5.로그인 6.로그아웃\n0.종료\n");
			int sel = inputToInt("입력");
			if (sel == 1) {
				signUp();
			} else if (sel == 2) {
				leave();
			} else if (sel == 3) {
				openingAccount();
			} else if (sel == 4) {
				closingAccount();
			} else if (sel == 5) {
				login();
			} else if (sel == 6) {
				this.log = -1;
			} else if (sel == 0) {
			}

		}

	}

	// 뱅킹 관련 메소드
}
//
//private boolean duppleCheckUser(User user) {
//
//	boolean chk = true;
//	for (int i = 0; i < um.getSize(); i++) {
//		if (user.getId().equals(um.getUser(i).getId()) && user.getName().equals(um.getUser(i).getName())) {
//			chk = false;
//		}
//	}
//
//	return chk;
//}

//public int leaveCheckUser(User delUser) {
//	int index = -1;
//	for (int i = 0; i < um.getSize(); i++) {
//		if (delUser.equals(um.getUser(i))) {
//			index = i;
//		}
//	}
//
//	return index;
//}
