package ex03_number;

public class Ex03 {

	public static void main(String[] args) {
		
		//대입 연산
		int score =100; //등호(=)가 대입 연산자이다.같다 라는 뜻X
		System.out.println(score);
		
		//연습
		// x에 10이 있고 y에 20이 있다.
		// x와 y의 저장된 값을 서로 교환하시오
		
		int x = 10;
		int y = 20;
		int temp = x;
		
		x=y;
		y=temp;
		
		System.out.println(x);
		System.out.println(y);
	
		

	}

}
