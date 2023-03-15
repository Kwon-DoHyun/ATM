package ATM;

import java.util.ArrayList;

public class User {

	String name;
	String id;
	String password;

<<<<<<< HEAD
=======
	int accountCount;
>>>>>>> af76340467a83b7b201f19d0976578229ced924e
	ArrayList<Account> accsAccounts;

	User(String name, String id, String password) {
		this.name = name;
		this.id = id;
		this.password = password;

	}

<<<<<<< HEAD
	User(String name, String id, String password, ArrayList<Account> accsAccounts) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.accsAccounts =accsAccounts;

	}

	public String getName() {//이름 반환
		return name;
	}

	public String getId() {//id 반환
		return id;
	}

	public String getPassword() {//패스워드 반환
		return password;
	}


	public Account getAccsAccount(int index) {//계좌 삭제용
		return accsAccounts.get(index);
		
	}
	public int getAccountCount() {//현 유저의 계좌 개수 반환
		return this.accsAccounts.size();
	}



	public void createAccount(Account account) {//계좌 추가
		
		this.accsAccounts.add(account);

	}
	public void deleteAccount(int index) {
		accsAccounts.remove(index);
		
	}
	public ArrayList<Account>getAccountList(){//리스트를 복제해서 반환	
		if( (ArrayList<Account>)this.accsAccounts==null) {
			this.accsAccounts = new ArrayList<Account>();
			
		}
		return (ArrayList<Account>)this.accsAccounts.clone();
	}

	public String toString() {//상태 출력
		return String.format("%s [id:%s pw:%s] /(%d)", this.name, this.id, this.password, this.accsAccounts.size());

	}
	public void printAccList() {//상태 출력
		for (int i = 0; i < this.accsAccounts.size(); i++) {
			Account a = this.getAccsAccount(i);

			System.out.printf("%d acc:%d cash:%d \n", i + 1, a.getAccountNum(), a.getCash());

		}
		

		
		
	}
	
	
	
=======
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
>>>>>>> af76340467a83b7b201f19d0976578229ced924e

}
