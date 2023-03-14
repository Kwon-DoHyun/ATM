package ATM;

import java.util.ArrayList;

public class UserManager {
	private static ArrayList<User> list = new ArrayList<User>();

	// 유저에 관한 CRUD를 여 안에
	// 만들기
	public int getSize() {// 인덱스를 받아 반환

		return this.list.size();

	}

	void addUser(User user) {// 유저를 받아 리스트에 추가
		this.list.add(user);

	}

	public User getUser(int index) {// 인덱스를 받아 반환

		User user = this.list.get(index);

		User tmp = user;

		return tmp;

	}

	public User getUserById(String id) {// 아이디를 받아 계정 반환)

		int idx = -1;
		for (int i = 0; i < list.size(); i++) {
			User tmp = getUser(i);
			if (id.equals(tmp.getId())) {
				idx = i;
			}
		}

		return getUser(idx);

	}

//업데이트
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
