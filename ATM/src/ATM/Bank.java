package ATM;

import java.util.Scanner;

public class Bank {

	private Scanner in;

	private String name;
	private UserManager um = new UserManager();
	private AccountManager am = new AccountManager();

	public	Bank(String name) {
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

	private	void print() {

		for (int i = 0; i < um.getSize(); i++) {
			System.out.println(um.getUser(i));
		}

	}

//	==============회원가입======================
private	void signUp() {

		String name = inputToString("이름");
		String id = inputToString("id");
		String password = inputToString("password");

		User newUser = new User(name, id, password);

		if (duppleCheckUser(newUser)) {

			um.addUser(newUser);
		} else {
			System.out.println("이미 존재하는 계정입니다");

		}

	}

private	boolean duppleCheckUser(User user) {

		boolean chk = true;
		for (int i = 0; i < um.getSize(); i++) {
			if (user.getId().equals(um.getUser(i).getId()) && user.getName().equals(um.getUser(i).getName())) {
				chk = false;
			}
		}

		return chk;
	}

//==============회원탈퇴======================
	void leave() {
		System.out.println("회원 탈퇴");
		String delName = inputToString("이름");
		String delId = inputToString("id");
		String delPassword = inputToString("password");

		User delUser = new User(delName, delId, delPassword);
		int idx = leaveCheckUser(delUser);
		if (idx!=-1) {

			um.delUser(idx);
		} else {
			System.out.println("존재하지 않는 계정입니다");

		}

	}
public	int  leaveCheckUser(User delUser) {
	int index = -1;
	for (int i = 0; i < um.getSize(); i++) {
		if (delUser.equals(um.getUser(i)) ) {
			index = i;
		}
	}
	

return index;
	}

	
//==============로그인======================
private void login() {
	
	System.out.println("회원가입");
	String id = inputToString("id");
	String password = inputToString("password");
}





	public void run() {

		while (true) {

			System.out.println(this.name);
			print();
			System.out.print("1. 회원가입\n2.회원탈퇴\n3.계좌신청\n4.계좌탈퇴\n5.로그인\n6.로그아웃\n0.종료\n");
			int sel = inputToInt("입력");
			if (sel == 1) {
				signUp();
			} else if (sel == 2) {
			} else if (sel == 3) {
			} else if (sel == 4) {
			} else if (sel == 5) {
			} else if (sel == 6) {
			} else if (sel == 0) {
			}

		}

	}

	// 뱅킹 관련 메소드
}
