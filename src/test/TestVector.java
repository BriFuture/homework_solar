package test;

import core.MyVector;
import core.Point;

public class TestVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyVector mv1 = new MyVector();
		mv1.setDirect(new Point(1, 0));
		mv1.setLength(10);
		MyVector mv2 = new MyVector();
		mv2.setDirect(new Point(-0.5, 0));
		mv2.setLength(10);
		int i = 0;
		while(i < 6) {
			mv1.add(mv2);
			System.out.println("length: "+mv1.getLength() + " === X: " + mv1.getDirect().getX() + " === Y: " + mv1.getDirect().getY());
			i++;
		}
	}

}
