package ATM;

import java.lang.invoke.StringConcatFactory;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

public class UserManager {
	private static ArrayList<User> list = new ArrayList<User>();

<<<<<<< HEAD
	public int getSize() {// 사이즈를 받아 반환

		return this.list.size();

	}
	
	
	
	// create


	public boolean addUser(User user) {// 유저를 받아 리스트에 추가

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
=======
	// 유저에 관한 CRUD를 여 안에
	// 만들기
	public int getSize() {// 인덱스를 받아 반환


		return this.list.size();

	} void addUser(User user) {// 유저를 받아 리스트에 추가
		this.list.add(user);

>>>>>>> af76340467a83b7b201f19d0976578229ced924e
	}

	public User getUser(int index) {// 인덱스를 받아 반환

<<<<<<< HEAD

		User user = this.list.get(index);

		User tmp = new User(
				user.getName(), 
				user.getId(), 
				user.getPassword(), 
				user.getAccountList());
=======
		User user = this.list.get(index);

		User tmp = user;
>>>>>>> af76340467a83b7b201f19d0976578229ced924e

		return tmp;

	}

	public User getUserById(String id) {// 아이디를 받아 계정 반환)
<<<<<<< HEAD
		User user = null;
		int idx = indexOfById(id);
		if (idx != -1) {
			user = getUser(idx);
		}

		return user;
=======

		int idx = -1;
		for (int i = 0; i < list.size(); i++) {
			User tmp = getUser(i);
			if (id.equals(tmp.getId())) {
				idx = i;
			}
		}

		return getUser(idx);

>>>>>>> af76340467a83b7b201f19d0976578229ced924e
	}

//업데이트
	public void setUser(int index, User user) {
		this.list.set(index, user);

	}

<<<<<<< HEAD
	
	
	
	
	//delete
	public boolean delUser(User user) {
		// 변수 user의 아이디를 인자로 삼아 해당 아이디와 동일한 index 검색
		int index = indexOfById(user.getId());
		// 인덱스를 기반으로 가변수 생성
		User tmp = getUser(index);
		// 이미 동일 id를 통해 검색했으므로 이름과 비밀번호가 같은지 검사
		if (tmp.getName().equals(user.getName())) {
			if (tmp.getPassword().equals(user.getPassword())) {
				this.list.remove(index);
				return true;
			}

		}
		return false;
=======
	public void delUser(int index) {

		this.list.remove(index);

>>>>>>> af76340467a83b7b201f19d0976578229ced924e
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
		//유저와 
		int userIdx =indexOfById(loginUser.getId());
		this.list.get(userIdx).deleteAccount(index);
		
	}
	
}
