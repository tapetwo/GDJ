package ex01_field;

public class UserMain {

	public static void main(String[] args) {
		
		// 클래스(데이터타입)		: User
		// 객체(변수개념,인스턴스)	: user
		// int a = 10; //변수
		// String s = "hi"; //객체:객체는 개체가 가지고 있는 기능을 끄집어 낼 수 있다 //
		
		
		// 객체 선언( 모든 객체는 null값을 가질 수 있다)
		// User user = null;
		
		//객체 생성
		// user = new User();
		
		// 객체 선언과 생성을 한 번에
		User user = new User();
		
		// 모든 User 객체는 필드값을 가지고 있다.
		// 마침표(.)를 이용해서 필드값을 호출한다.
		
		System.out.println(user.id);
		System.out.println(user.password);
		System.out.println(user.email);
		System.out.println(user.point);
		System.out.println(user.isVip);
		
		
		
		System.out.println();
		
		
		//필드값 변경
		user.id="admin";
		user.password="123456";
		user.email="admin@web.com";
		user.point=1000;
		user.isVip=(user.point>=10000);
		System.out.println(user.id);
		System.out.println(user.password);
		System.out.println(user.email);
		System.out.println(user.point);
		System.out.println(user.isVip);
		
		
		
		
		
	}

}
