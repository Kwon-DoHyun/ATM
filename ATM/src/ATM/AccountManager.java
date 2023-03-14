package ATM;

import java.util.ArrayList;

public class AccountManager {

	private static ArrayList<Account> list = new ArrayList<Account>();

	
	
	//Create
	public void createAccount(Account account) {
		this.list.add(account);
	}
	//read
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
	//delete
	public void delAccount(int index) {
		list.remove(index);
	}

}
