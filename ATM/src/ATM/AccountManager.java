package ATM;

import java.util.ArrayList;

public class AccountManager {

	private static ArrayList<Account> list = new ArrayList<Account>();

	public int getSize() {// �ε����� �޾� ��ȯ

		return this.list.size();

	}

	// Create
	public void createAccount(Account account) {
		this.list.add(account);
	}

	public Account createAccount(User user, int accountNum) {

		String id = user.getId();

		Account newAccount = new Account(id, accountNum, 0);
		this.list.add(newAccount);

		return newAccount;
	}

	// read
	public Account getAccount(int index) {
		Account account = list.get(index);

		String id = account.getId();

		int accountNum = account.getAccountNum();

		int cash = account.getCash();

		Account tmp = new Account(id, accountNum, cash);
		return tmp;
	}

	// update
	public void setAccount(int index, Account account) {
		list.set(index, account);
	}
	// delete

	public boolean delAccount(int index) {

		boolean chk = false;

		if (index != -1) {
			this.list.remove(index);

			chk = true;
			System.out.println("���� �Ϸ�");

			for (int i = 0; i < this.list.size(); i++) {
				System.out.println(list.get(i));
			}
		}

		return chk;

	}

	public boolean findDeleteAccount(User loginUser, int idx) {

		boolean delete = false;
		// ���� ��ȣ
		// �Է°�: ����/idx
		// ������ �ϴ� �޼ҵ�: (���� ���� ã��)
		// idx�� ���� ���¹�ȣ ã��
		int num = loginUser.getAccsAccount(idx).getAccountNum();
		// ���¹�ȣ�� ���� �ε��� ã��
		int index = indexByAccountnum(num);
		//
		// �ش� �ε��� ����
		loginUser.deleteAccount(idx);
		if (delAccount(index)) {
			delete = true;
		}

		return delete;
	}

	public int indexByAccountnum(int accountnum) {

		int index = -1;

		for (int i = 0; i < this.list.size(); i++) {
			if (accountnum == this.list.get(i).getAccountNum()) {
				index = i;
			}

		}
		return index;
	}

}
