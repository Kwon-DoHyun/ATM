package ATM;

public class Account {
<<<<<<< HEAD


	
	private	String id;
	private	int accountNum;
	private	int cash;

	
	
	
	public Account(String id, int accountNum, int cash){
		this.id = id;
		this.accountNum= accountNum;
		this.cash=cash;
		
	}
	
	
	
	public String getId() {
		return this.id;
	}

	public int getAccountNum() {
		return accountNum;
	}

	public int getCash() {
		return cash;
	}

	public String toString() {
		return String.format("%s [%d] cash: %d", this.id, this.accountNum, this.cash);

	}
=======
//¸®¹Ô 3
>>>>>>> af76340467a83b7b201f19d0976578229ced924e
}
