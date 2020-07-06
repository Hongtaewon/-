package Ch2_Variable;

public class VariablePrintEx {

	public static void main(String[] args)
	{
		int x = 19;
		char a = 'a';
		//System.out.println("%d",x); // <-error : println은 변수값을 다르게 표현할 수 없다.
		System.out.printf("%d%n",(int)a); // Java에선 char는 반드시 캐스팅이 필요하다.
		int oct = 010;
		int hex = 0x10;
		int bin = 0b10;
		int finger = 10;
		// 8,16,2진수 표현법
		System.out.printf("outNum = %o, %d%n", oct,oct);
		System.out.printf("hexNum = %h, %d%n", hex,hex);
		System.out.printf("binNum = %s, %d%n", Integer.toBinaryString(bin),bin); // binary는 표현하는 방법이 없기 때문에 정수를 2진수로 변환해주는 메소드를 사용해야 한다.
		System.out.printf("finger = [%5d], [%-5d], [%05d]%n",finger,finger,finger);
		
		/*
		 * float S(1) + E(8) + M(23) : 부호 + 지수 + 가수
		 * double S(1) + E(11) + M(52) : 부호 + 지수 + 가수
		 * +-M x 2^E
		 * 부호 : 0 or 1
		 * 지수 : -2^(E-1)+1 ~ 2^(E-1) : 바이어스 표현법으로 사용된다. -127(00000000) ~ 128(11111111)
		 * 바이어스 표현법 = 2의 보수법 + 바이어스 상수
		 * ex) 127을 바이어스 표현법으로 나타낸다.
		 * 127을 2의 보수법으로 0111 1111
		 * 바이어스 상수 : 2^(n-1)-1 n: 비트부 자리수(여기서는 8bit)
		 * 0111 1111 + 0111 1111 = 1111 1110
		 * 가수 : 구하려는 숫자를 부동소수점으로 나타낸다. 19.25 -> 10011.01 -> 1.001101 x 2^4 -> 100110100000....
		 * float은 10진수로 7자리, double은 10진수로 15자리의 정밀도로 저장 가능
		*/
		float f1 = .10f;
		float f2 = 1e1f;
		float f3 = 3.14e3f;
		double d = 1.23456789;
		// float형 변수를 선언할 때, 반드시 f를 붙여야 한다. 소수부를 쓰고 f를 붙이지 않는다면 double형으로 간주하여 float보다 큰 저장공간이 필요하기 때문에 컴파일 에러가 발생한다.
		System.out.println("------------------------");
		System.out.printf("f1 = %f, %e, %g%n",f1,f1,f1);
		System.out.printf("f2 = %f, %e, %g%n",f2,f2,f2);
		System.out.printf("f3 = %f, %e, %g%n",f3,f3,f3);
		// %f 실수형 깂 츨력에 주로 사용, %e 지수형태로 출력, %g 값을 간략하게 출력
		System.out.printf("d = %f%n",d);
		System.out.printf("d = %14.10f%n",d); // 14자리 중 10자리는 소수점 밑을 사용하겠다.
	}
}
