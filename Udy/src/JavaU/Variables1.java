package JavaU;

public class Variables1 {

	public static void main(String[] args)
	{
		int a=5;
		int b=10;
		int c=2*100;
		
		System.out.println("a="+a+ " b="+b+" C="+ c);
		System.out.println("Sum = "+(a+b+c));
		
		int mul= a*b*c;
		System.out.println("Multiplication= "+mul);
		int sub= mul-1000;
		System.out.println("subtracting 1000 from mul= "+sub);
		int min= Integer.MIN_VALUE;
		int max= Integer.MAX_VALUE;
		System.out.println(min+"  "+ max);
		System.out.println("overflow value"+ (max+1));// max becomes min value
		System.out.println("underflow value"+ (min-1));// min becomes max value
		

	}

}
