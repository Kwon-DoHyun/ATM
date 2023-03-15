package ATM;

import java.lang.invoke.StringConcatFactory;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

public class UserManager {
	private static ArrayList<User> list = new ArrayList<User>();

	public int getSize() {// ����� �޾� ��ȯ

		return this.list.size();

	}
	
	
	
	// create


	public boolean addUser(User user) {// ������ �޾� ����Ʈ�� �߰�

		User newUser = getUserById(user.getId());

		if (newUser == null) {
			this.list.add(user);
			return true;
		}

		return false;

	}

	
	
	public void	addAccountToUser(User loginUser, Account newAccount) {
		
		int idx =indexOfById(loginUser.getId());
		
		this.list.get(idx).createAccount(newAccount);	

	}


	
	//read
	private int indexOfById(String id) {

		int index = -1;
		for (User user : list) {
			if (user.getId().equals(id)) {
				index = list.indexOf(user);
			}
		}
		return index;
	}

	public User getUser(int index) {// �ε����� �޾� ��ȯ


		User user = this.list.get(index);

		User tmp = new User(
				user.getName(), 
				user.getId(), 
				user.getPassword(), 
				user.getAccountList());

		return tmp;

	}

	public User getUserById(String id) {// ���̵� �޾� ���� ��ȯ)
		User user = null;
		int idx = indexOfById(id);
		if (idx != -1) {
			user = getUser(idx);
		}

		return user;
	}

//������Ʈ
	public void setUser(int index, User user) {
		this.list.set(index, user);

	}

	
	
	
	
	//delete
	public boolean delUser(User user) {
		// ���� user�� ���̵� ���ڷ� ��� �ش� ���̵�� ������ index �˻�
		int index = indexOfById(user.getId());
		// �ε����� ������� ������ ����
		User tmp = getUser(index);
		// �̹� ���� id�� ���� �˻������Ƿ� �̸��� ��й�ȣ�� ������ �˻�
		if (tmp.getName().equals(user.getName())) {
			if (tmp.getPassword().equals(user.getPassword())) {
				this.list.remove(index);
				return true;
			}

		}
		return false;
	}

	public void delUserById(String id) {
		int idx = -1;
		for (int i = 0; i < list.size(); i++) {
			User tmp = getUser(i);
			if (id.equals(tmp.getId())) {
				idx = i;
			}
		}
		this.list.remove(idx);

	}

	//
	
	public void deleteAccountFromUser(User loginUser, int index) {
		//������ 
		int userIdx =indexOfById(loginUser.getId());
		this.list.get(userIdx).deleteAccount(index);
		
	}
	
}
