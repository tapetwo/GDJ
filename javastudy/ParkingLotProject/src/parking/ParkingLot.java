package parking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ParkingLot {
	
	private Scanner sc;
	private Car[] cars;
	String name;
	private int idx;
	
	public ParkingLot(String name) {
		this.name=name;
		sc=new Scanner(System.in);
		cars=new Car[10];
	}
	
	public void addCar() throws RuntimeException {
		if(idx==cars.length) {
			System.out.println("더 이상 차량 등록이 불가능합니다.");
			throw new RuntimeException("Full");
		}
		System.out.println("현재 등록된 차량"+idx+"대");
		System.out.println("차량 번호 >>>");
		String carNo=sc.next();
		System.out.println("모델 >>>");
		String model=sc.next();
		Car car=new Car(carNo, model);
		cars[idx++]=car;
		
	}
	
	public void deleteCar()throws RuntimeException {
		if(idx==0) {
			System.out.println("등록된 차량이 없습니다.");
			throw new RuntimeException("EMPTY");
		}
		
		System.out.println("제거할 차량 번호 >>> ");
		String carNo=sc.next();
		for(int i=0;i<idx;i++) {
			if(cars[i].getCarNo().equals(carNo)) {
				System.arraycopy(cars, i+1, cars, i, idx-i-1);
				cars[--idx]=null;
				System.out.println("차량번호  " +carNo+"  차량이 삭제되었습니다.");
				return;
			}
		}	
		System.out.println("대상 차량이 존재하지 않습니다.");
	}
	
	public void printAllCar() throws RuntimeException {
		if(idx==0) {
			System.out.println("등록된 차량이 없습니다.");
			throw new RuntimeException("EMPTY");
		}
		System.out.println(name+" 차량목록");
		for(int i=0; i<idx; i++) {
			System.out.println(cars[i]);
		}
	}
	
	public void manage() {
		
		while(true) {
		try{	
			System.out.println("1.추가 2.삭제 3.전체 0.종료 >>>");
			int choice=sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:addCar(); break;
			case 2:deleteCar(); break;
			case 3:printAllCar(); break;
			case 0:System.out.println("주차 프로그램 종료");
					return;
			default:System.out.println("존재하지 않는 메뉴입니다.");
			}
	}catch(InputMismatchException e) {
		sc.next();
		System.out.println("처리 명령은 정수 1~4,0 입니다.");
	}catch(RuntimeException e) {
		System.out.println(e.getMessage());
	}
	}
	}
}	
	
