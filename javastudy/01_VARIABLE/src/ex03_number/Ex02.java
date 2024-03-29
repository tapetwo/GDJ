package ex03_number;

public class Ex02 {

	public static void main(String[] args) {
	
		// 증감 연산
		// 1씩 증가하거나 감소하는 연산
		// 증가는 ++ , 감소는 --를 사용한다.
		
		//전위 연산(pre operator)
		// ++a
		// 변수 a의 값을 1 증가 시키고 사용한다.
		
		int a = 1;
		int b = ++a;
		System.out.println(a);
		System.out.println(b);
		
		
		//후위 연산(post operator)
		// a++
		// 변수 a의 값을 사용하고나서 1증가 시킨다.
		
		int x = 1;
		int y = x++;
		System.out.println(x);
		System.out.println(y);
		
		//연습
		int i = 1;
		int j = 1;
		int result = i++ + --j;
		System.out.println(i); // i값은 2
		System.out.println(j); // j값은 0
		System.out.println(result); // result값은 1
		
		// 복합 대입 연산자
		// +=, -= , *= , /= , %=
		
		int wallet = 0;
		wallet = wallet + 5000;
		wallet += 5000; // wallet = wallet + 5000;
		wallet -=3000; // wallet = wallet - 3000;
		System.out.println(wallet);
		
		// 연습
		// 통장 잔액(balance)에서 이자 5%를 받았음을 나타내자
		long balance = 10000;
		balance *= 1.05; //balance를 double로 promotion해서 처리한다.
		System.out.println(balance);
		
		// balance =balance * 1.05; 실패. balance * 1.05 결과는 double이기 때문에 long balance에 저장할 수 없다.
		balance =(long)(balance *1.05); //성공.balance * 1.05 결과를 long으로 casting해서 저장할 수 있다.
		
		
		//balance = balance + balance * 0.5; //실패. balance + balance *0.5 결과는 double이기 때문에 long balance에 저장할 수 없다.
		balance = balance + (long)(balance * 0.5 ); //성공. balance+ balance  *0.5 결과를 long으로 casting해서 저장할 수 있다.
		balance = (long)(balance +balance * 0.5);
		
		
		
		
	
		
		
		
		
	
		
		
		
		
	}

}
