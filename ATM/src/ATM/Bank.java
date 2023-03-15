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
			System.out.println("���ڸ��� �Է����ּ���.");
		}

		return input;
	}

	private void print() {

		for (int i = 0; i < um.getSize(); i++) {
			System.out.println(um.getUser(i));
		}
		if (log != -1) {
			System.out.println(um.getUser(log).getName() + "�� �α���");
		}
	}

//	==============�⺻����======================
	void inIt() {
		this.log = -1;
	}

//	==============ȸ������======================
	private void signUp() {

		String name = inputToString("�̸�");
		String id = inputToString("id");
		String password = inputToString("password");

		User newUser = new User(name, id, password);

		if (um.addUser(newUser)) {

			System.out.println(id + "���� �Ϸ�");

		} else {
			System.out.println("�̹� �����ϴ� �����Դϴ�");

		}

	}

//==============ȸ��Ż��======================
	void leave() {
		System.out.println("ȸ�� Ż��");
		String delName = inputToString("�̸�");
		String delId = inputToString("id");
		String delPassword = inputToString("password");

		User delUser = new User(delName, delId, delPassword);

		if (um.delUser(delUser)) {

			System.out.println(delId + "���� �Ϸ�");
			if (delId.equals(um.getUser(log).getName())) {
				log = -1;
			}
		} else {

			System.out.printf("���̵�/��й�ȣ ����.");

		}

	}

//==============�α���======================
	private void login() {
		if(log==-1) {
			System.out.println("�α���");
			String id = inputToString("id");
			String password = inputToString("password");

			User loginUser = new User(null, id, password);

			int idx = checkIdPwToLogin(loginUser);

			if (idx != -1) {
				this.log = idx;
			} else {
				System.out.println("������ ����");
			}
			
		}else {
		System.out.println("�α��� �߿��� �̿� �Ұ�");
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

	// ==============����======================
	private void openingAccount() {

		if (this.log != -1) {

			// ���� �α������� ���̵� �ΰ�
			User loginUser = um.getUser(log);
			// �� ������ ���� ���� Ȯ��
			int size = loginUser.getAccountCount();
			if (size < 3) {
				// ������ 6�ڸ� ���� ����
				int accountNum = makeAccountCode();
				// �� ���� ������ ���¹�ȣ�� ���� �� ���� ����
				Account newAccount = am.createAccount(loginUser, accountNum);
				// am���� �̹� ����Ǿ����� �� ������ ���ٿ� �ּ� ����

				// �α��� ������ ã�Ƽ� �ű� ���� ����(�� ���� ���� ����)
				// �̸� ����
				um.addAccountToUser(loginUser, newAccount);

				System.out.println("���� " + newAccount.getAccountNum() + "�����Ϸ�");

			} else {
				System.out.println("���̻� ���� �Ұ�");
			}

		}else {
			System.out.println("�α��� �߿��� �̿� ����");
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

	// ==============���� ����======================
	private void closingAccount() {

		if (this.log != -1) {

			User loginUser = um.getUser(log);
			if (loginUser.getAccountCount() != 0) {
				um.getUser(log).printAccList();
				System.out.println();
				loginUser.printAccList();

				int idx = inputToInt("������ ������ ��ȣ(���:0)") - 1;
				if (idx >= 0 && idx < loginUser.getAccountCount()) {
				if(	am.findDeleteAccount(loginUser, idx)) {
					um.deleteAccountFromUser(loginUser, idx);
					
				}else {
					System.out.println("���� ����");
					
				}

					
					
					
					
					
					
				} else if (idx == -1) {
					System.out.println("������ ����մϴ�");
				} else {
					System.out.println("��ȣ�� �ٽ� �Է��Ͻʽÿ�");
				}

			}else {
				System.out.println("���°� �����ϴ�.");
			}

		} else {
			System.out.println("��� �Ұ��� �޴�");
		}

	}

	// ==============���� ����======================

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
			
			
			System.out.print("1. ȸ������ 2.ȸ��Ż�� 3.���½�û\n4.����Ż�� 5.�α��� 6.�α׾ƿ�\n0.����\n");
			int sel = inputToInt("�Է�");
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

	// ��ŷ ���� �޼ҵ�
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
