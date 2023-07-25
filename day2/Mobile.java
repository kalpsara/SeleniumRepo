package week1.day2;

public class Mobile {

	private long phoneNumber;

	public void sendSms() {
		System.out.println("calling from RealMe");
	}

	public long makeCall(long phoneNumber) {
		return phoneNumber;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Mobile mob = new Mobile();
		mob.sendSms();
		mob.makeCall(9500012120l);

	}

}
