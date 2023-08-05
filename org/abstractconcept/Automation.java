package org.abstractconcept;

public class Automation extends MultipleLangauge implements Language {

	@Override
	public void Java() {
		System.out.println("Java method Implemented in Automation class");

	}

	@Override
	public void ruby() {
		// TODO Auto-generated method stub
		
		System.out.println("Ruby method Implemented in Automation class");

	}

	public static void main(String[] args) {
	
		
		Automation a=new Automation();
		a.Java();
		a.ruby();
		a.python();

	}

}
