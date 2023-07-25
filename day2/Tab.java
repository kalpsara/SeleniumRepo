package week1.day2;

public class Tab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mobile m1 = new Mobile();
		m1.sendSms();
		long mobMumber = m1.makeCall(9500121193l);

		System.out.println(mobMumber);
	}

}
