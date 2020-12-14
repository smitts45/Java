package Con1;

public class Adi1 {
	
	int a;
	int b;
	int s1;
	int sub1;
	int mul;
	
	Adi1()
	{
	
	}
	
 public  void sum()
 {
	
	 s1= a+b;
	 System.out.println("Sum of a & b= "+ s1);
 }
 
 public void sub()
 {
	 sub1= a-b;
	 System.out.println("Sub of a & b= "+ sub1);
 }
 public void mul1()
 {
	 mul= a*b;
	 System.out.println("multiplication of a & b="+ mul);
 }
	public static void main(String[] args) 
	{
		Adi1 s= new Adi1();
		s.sum();
		s.sub();
		s.mul1();
		
		
	}

}
