package ex09_upcasting;

public class Main {

	public static void main(String[] args) {
		
	
		//UpCasting
		// 슈퍼클래스 객체 = new 서브 클래스();
		
		Person alba=new Alba();
		alba.eat();
		alba.study();
		alba.work();

		
		// new Student()와 new Alba()는 모두 Person 타입으로 처리할 수 있다
		

		// 한 교실에 Student 와 ALba가 섞여있다
		// 어떻게 처리 할 것인가?
		// Person 타입의 배열을 이용해서 모두 처리할 수 있다.
		
		Person[] people=new Person[10];
		
		people[0] = new Alba();
		people[1] = new Alba();
		people[2] = new Student();
		
		
		for(int i=0; i<people.length;i++) {
			if(people[i]!=null) {
			people[i].eat();
			people[i].study();
			people[i].work();
		}
				
	}
	
		for(Person person:people) {
			if(person !=null) {
				person.eat();
				person.study();
				person.work();
			}
		}
		
		
		
	}

}
