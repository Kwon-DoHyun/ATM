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

	public String getName() {//�̸� ��ȯ
		return name;
	}

	public String getId() {//id ��ȯ
		return id;
	}

	public String getPassword() {//�н����� ��ȯ
		return password;
	}


	public Account getAccsAccount(int index) {//���� ������
		return accsAccounts.get(index);
		
	}
	public int getAccountCount() {//�� ������ ���� ���� ��ȯ
		return this.accsAccounts.size();
	}



	public void createAccount(Account account) {//���� �߰�
		
		this.accsAccounts.add(account);

	}
	public void deleteAccount(int index) {
		accsAccounts.remove(index);
		
	}
	public ArrayList<Account>getAccountList(){//����Ʈ�� �����ؼ� ��ȯ	
		if( (ArrayList<Account>)this.accsAccounts==null) {
			this.accsAccounts = new ArrayList<Account>();
			
		}
		return (ArrayList<Account>)this.accsAccounts.clone();
	}

	public String toString() {//���� ���
		return String.format("%s [id:%s pw:%s] /(%d)", this.name, this.id, this.password, this.accsAccounts.size());

	}
	public void printAccList() {//���� ���
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
	// ���¸� ���⿡ �ֳ� �ȳֳ� ����
>>>>>>> af76340467a83b7b201f19d0976578229ced924e

}
