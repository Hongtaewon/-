package Ch2_Variable;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("�� �ڸ� ������ �ϳ� �Է����ּ���.>");
		String input = scanner.nextLine();
		int num = Integer.parseInt(input); //���ڸ� �Է����� ������ ���ڿ� ->���ڷ� ��ȯ�ϴ� �������� Integer.parseInt()���� ������ �߻��Ѵ�. 
		
		System.out.println("�Է³��� :"+input);
		System.out.printf("num = %d%n",num);
	}

}
