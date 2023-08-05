package org.system;

//Single inheritance
public class Desktop extends Computer {

	Double size = 15.3;

	public Double desktopSize() {
		return size;
	}

	public static void main(String[] args) {

		Desktop d = new Desktop();
		

		System.out.println("Computer model is "+d.computerModel());
		System.out.println("Desktop size is "+d.desktopSize());

	}

}
