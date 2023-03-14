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
			System.out.println("���ڸ��� �Է����ּ���.");
		}

		return input;
	}

	private	void print() {

		for (int i = 0; i < um.getSize(); i++) {
			System.out.println(um.getUser(i));
		}

	}

//	==============ȸ������======================
private	void signUp() {

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

private	boolean duppleCheckUser(User user) {

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
		if (idx!=-1) {

			um.delUser(idx);
		} else {
			System.out.println("�������� �ʴ� �����Դϴ�");

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

	
//==============�α���======================
private void login() {
	
	System.out.println("ȸ������");
	String id = inputToString("id");
	String password = inputToString("password");
}





	public void run() {

		while (true) {

			System.out.println(this.name);
			print();
			System.out.print("1. ȸ������\n2.ȸ��Ż��\n3.���½�û\n4.����Ż��\n5.�α���\n6.�α׾ƿ�\n0.����\n");
			int sel = inputToInt("�Է�");
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

	// ��ŷ ���� �޼ҵ�
}
