package ex13_abstract;


// 추상 메소드
// 1.본문이 없는 메소드를 의미
// 2.호출용으로 사용되는 메소드
// 3. 중괄호{} 자체를 없애고 세미코론(;)을 추가함
// 4.public abstract(추천) 또는 abstract public 으로 사용(



// 추상 클래스
// 1.추상 메소드가 1개이상 존재하는 클래스를 말한다
// 2.public abstract class
// 3.본문이없는 메소드를 포함하기 때문에 객체 생성이 불허된다
// 4.추상 클래스를 상속 받는 클래스는 "반드시" "모든"추상메소드를 오버라이드 해야한다


public abstract class  Shape {

	
	private String type;

	public Shape(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public abstract double getArea();  //shape을 상속받는 객체들이 호출할 때 사용하는 메소드
									  //사용되지는 않는다.->추상 메소드로 바꿔준다(본문이 없는 메소드)
	
}



