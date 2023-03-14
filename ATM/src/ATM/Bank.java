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

		if (duppleCheckUser(newUser)) {

			um.addUser(newUser);
		} else {
			System.out.println("�̹� �����ϴ� �����Դϴ�");

		}

	}

	private boolean duppleCheckUser(User user) {

		boolean chk = true;
		for (int i = 0; i < um.getSize(); i++) {
			if (user.getId().equals(um.getUser(i).getId()) && user.getName().equals(um.getUser(i).getName())) {
				chk = false;
			}
		}

		return chk;
	}

//==============ȸ��Ż��======================
	void leave() {
		System.out.println("ȸ�� Ż��");
		String delName = inputToString("�̸�");
		String delId = inputToString("id");
		String delPassword = inputToString("password");

		User delUser = new User(delName, delId, delPassword);
		int idx = leaveCheckUser(delUser);
		if (idx != -1) {

			um.delUser(idx);
		} else {
			System.out.println("�������� �ʴ� �����Դϴ�");

		}

	}

	public int leaveCheckUser(User delUser) {
		int index = -1;
		for (int i = 0; i < um.getSize(); i++) {
			if (delUser.equals(um.getUser(i))) {
				index = i;
			}
		}

		return index;
	}

//==============�α���======================
	private void login() {

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
			User loginUser = um.getUser(log);
			if (loginUser.getAccountCount() < 3) {
				String id = loginUser.getId();
				int accountNum = makeAccountCode();

				Account newAccount = new Account(id, accountNum, 0);
				// ���� ����� ���� �� ����Ʈ�� ���ʿ� �ϳ���
				am.createAccount(newAccount);
				loginUser.createAccount(newAccount);
				loginUser.setAccountCount(loginUser.getAccountCount() + 1);
				System.out.println("�Ϸ�");

			} else {
				System.out.println("���̻� ���� �Ұ�");
			}

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

			for (int i = 0; i < loginUser.getAccountCount(); i++) {
				Account a = loginUser.getAccsAccounts().get(i);
				System.out.printf("%d acc:%d cash:%d \n", i + 1, a.getAccountNum(), a.getCash());

			}

			int idx = inputToInt("������ ������ ��ȣ") - 1;
			if (idx >= 0 && idx < loginUser.getAccountCount()) {
				
				int num = loginUser.getAccsAccounts().get(idx).getAccountNum();
				System.out.println("���¹�ȣ"+num+"�����Ϸ�");
				loginUser.getAccsAccounts().remove(idx);
				loginUser.setAccountCount(loginUser.getAccountCount() - 1);
				
			} else {
				System.out.println("��ȣ�� �ٽ� �Է��Ͻʽÿ�");
			}

		}

	}

	// ==============���� ����======================

	public void run() {
		inIt();
		while (true) {

			System.out.println(this.name);
			print();
			System.out.print("1. ȸ������\n2.ȸ��Ż��\n3.���½�û\n4.����Ż��\n5.�α���\n6.�α׾ƿ�\n0.����\n");
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
