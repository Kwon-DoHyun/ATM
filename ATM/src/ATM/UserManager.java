package ATM;

import java.util.ArrayList;

public class UserManager {
	private static ArrayList<User> list = new ArrayList<User>();

	// ������ ���� CRUD�� �� �ȿ�
	// �����
	public int getSize() {// �ε����� �޾� ��ȯ

		return this.list.size();

	}

	void addUser(User user) {// ������ �޾� ����Ʈ�� �߰�
		this.list.add(user);

	}

	public User getUser(int index) {// �ε����� �޾� ��ȯ

		User user = this.list.get(index);

		User tmp = user;

		return tmp;

	}

	public User getUserById(String id) {// ���̵� �޾� ���� ��ȯ)

		int idx = -1;
		for (int i = 0; i < list.size(); i++) {
			User tmp = getUser(i);
			if (id.equals(tmp.getId())) {
				idx = i;
			}
		}

		return getUser(idx);

	}

//������Ʈ
	public void setUser(int index, User user) {
		this.list.set(index, user);

	}

	public void delUser(int index) {

		this.list.remove(index);

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
}
