package interface_programs;

interface Sample
{
	void add();
	void subtract();
//	in interface no need to mention public and abstract explicitly
	
      int a=10;    
//       no need to mention final explicitly
}

//every interface has a child class
class Calculation implements Sample{

	public void add() {
		int a =50; int b=30;
		System.out.println(a+b);
		
	}
	
	public void subtract() {
		int a=60; int b=80;
		System.out.println(a-b);
		
	}
	
}
//main class

public class Calculator {

	public static void main(String[] args) {
//	since we cannot create object of interface we will create an object of child class
		Calculation c=new Calculation();
		c.add();
		c.subtract();
//		by using the ref var of child class we  will access the add method from sample interface 

//		but by using the reference variable of the interface we can point to the object of the class
		
		Sample s =new Calculation();
		s.add();
		s.subtract();
	}

}
