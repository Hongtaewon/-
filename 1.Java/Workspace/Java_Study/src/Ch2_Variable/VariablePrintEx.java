package Ch2_Variable;

public class VariablePrintEx {

	public static void main(String[] args)
	{
		int x = 19;
		char a = 'a';
		//System.out.println("%d",x); // <-error : println�� �������� �ٸ��� ǥ���� �� ����.
		System.out.printf("%d%n",(int)a); // Java���� char�� �ݵ�� ĳ������ �ʿ��ϴ�.
		int oct = 010;
		int hex = 0x10;
		int bin = 0b10;
		int finger = 10;
		// 8,16,2���� ǥ����
		System.out.printf("outNum = %o, %d%n", oct,oct);
		System.out.printf("hexNum = %h, %d%n", hex,hex);
		System.out.printf("binNum = %s, %d%n", Integer.toBinaryString(bin),bin); // binary�� ǥ���ϴ� ����� ���� ������ ������ 2������ ��ȯ���ִ� �޼ҵ带 ����ؾ� �Ѵ�.
		System.out.printf("finger = [%5d], [%-5d], [%05d]%n",finger,finger,finger);
		
		/*
		 * float S(1) + E(8) + M(23) : ��ȣ + ���� + ����
		 * double S(1) + E(11) + M(52) : ��ȣ + ���� + ����
		 * +-M x 2^E
		 * ��ȣ : 0 or 1
		 * ���� : -2^(E-1)+1 ~ 2^(E-1) : ���̾ ǥ�������� ���ȴ�. -127(00000000) ~ 128(11111111)
		 * ���̾ ǥ���� = 2�� ������ + ���̾ ���
		 * ex) 127�� ���̾ ǥ�������� ��Ÿ����.
		 * 127�� 2�� ���������� 0111 1111
		 * ���̾ ��� : 2^(n-1)-1 n: ��Ʈ�� �ڸ���(���⼭�� 8bit)
		 * 0111 1111 + 0111 1111 = 1111 1110
		 * ���� : ���Ϸ��� ���ڸ� �ε��Ҽ������� ��Ÿ����. 19.25 -> 10011.01 -> 1.001101 x 2^4 -> 100110100000....
		 * float�� 10������ 7�ڸ�, double�� 10������ 15�ڸ��� ���е��� ���� ����
		*/
		float f1 = .10f;
		float f2 = 1e1f;
		float f3 = 3.14e3f;
		double d = 1.23456789;
		// float�� ������ ������ ��, �ݵ�� f�� �ٿ��� �Ѵ�. �Ҽ��θ� ���� f�� ������ �ʴ´ٸ� double������ �����Ͽ� float���� ū ��������� �ʿ��ϱ� ������ ������ ������ �߻��Ѵ�.
		System.out.println("------------------------");
		System.out.printf("f1 = %f, %e, %g%n",f1,f1,f1);
		System.out.printf("f2 = %f, %e, %g%n",f2,f2,f2);
		System.out.printf("f3 = %f, %e, %g%n",f3,f3,f3);
		// %f �Ǽ��� �� ���¿� �ַ� ���, %e �������·� ���, %g ���� �����ϰ� ���
		System.out.printf("d = %f%n",d);
		System.out.printf("d = %14.10f%n",d); // 14�ڸ� �� 10�ڸ��� �Ҽ��� ���� ����ϰڴ�.
	}
}
