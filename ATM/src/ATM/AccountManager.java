package ATM;

import java.util.ArrayList;

public class AccountManager {

	private static ArrayList<Account> list = new ArrayList<Account>();

	public int getSize() {// 인덱스를 받아 반환

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
			System.out.println("삭제 완료");

			for (int i = 0; i < this.list.size(); i++) {
				System.out.println(list.get(i));
			}
		}

		return chk;

	}

	public boolean findDeleteAccount(User loginUser, int idx) {

		boolean delete = false;
		// 계좌 번호
		// 입력값: 유저/idx
		// 만들어야 하는 메소드: (삭제 계좌 찾기)
		// idx를 통해 계좌번호 찾기
		int num = loginUser.getAccsAccount(idx).getAccountNum();
		// 계좌번호를 통해 인덱스 찾기
		int index = indexByAccountnum(num);
		//
		// 해당 인덱스 삭제
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
