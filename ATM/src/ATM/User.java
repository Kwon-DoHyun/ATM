package ATM;

import java.util.ArrayList;

public class User {

	String name;
	String id;
	String password;

	int accountCount;
	ArrayList<Account> accsAccounts;

	User(String name, String id, String password) {
		this.name = name;
		this.id = id;
		this.password = password;

	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public int getAccountCount() {
		return accountCount;
	}

	public String toString() {
		return String.format("%s [id:%s pw:%s] /(%d)", this.name, this.id, this.password, this.accountCount);

	}

//	acc
	// 계좌를 여기에 넣나 안넣냐 정도

}
