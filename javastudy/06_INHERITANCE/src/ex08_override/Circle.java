package ex08_override;

import ex07_override.Espresso;

public class Circle extends Shape {

	private double radius;

	public Circle(String type, double radius) {
		super(type);
		this.radius = radius;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI * Math.pow(radius, 2);
	}
	
	 @Override
	public void info() {
		super.info();
		System.out.println("반지름:"+radius);
		System.out.println("넓이:"+getArea());
	}
	
}
