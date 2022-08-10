package ex03_has_a;import ex01_is_a.Person;

public class SoldierMain {

	public static void main(String[] args) {
		
		
		Gun gun = new Gun();
		gun.setModel("K2");
		gun.setBullet(9);
		
		Soldier soldier=new Soldier();
		soldier.setGun(gun);
		
		// soldier가 총을 쏜다
		//soldier.getGun().shoot();
		soldier.shoot();
		
		// soldier가 장전한다
		//soldier.getGun().reload(1);
		soldier.reload(1);
		
		
		// soldier가 가지고 있는 gun의 model/bullet
		System.out.println(soldier.getGun().getModel());
		System.out.println(soldier.getGun().getBullet());

	}

}
