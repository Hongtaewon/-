package Ch2_Variable;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("두 자리 정수를 하나 입력해주세요.>");
		String input = scanner.nextLine();
		int num = Integer.parseInt(input); //숫자를 입력하지 않으면 문자열 ->숫자로 변환하는 과정에서 Integer.parseInt()에서 에러가 발생한다. 
		
		System.out.println("입력내용 :"+input);
		System.out.printf("num = %d%n",num);
	}

}
