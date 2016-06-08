package core;

public class MyVector {
	private double length;
	private Point direct;
	
	/**
	 * 向量相加
	 * @param mv
	 */
	public void add(MyVector mv) {
		double l1 = Calc.getVec(direct.getX(), direct.getY());
		double xl;
		double yl;
		
		if(l1 != 0) {
			xl = length * direct.getX() / l1;
			yl = length * direct.getY() / l1;
		} else {
			xl = 0;
			yl = 0;
		}
//		System.out.println("xl: "+xl);
//		System.out.println("yl: "+yl);
//		System.out.println();
		double l2 = Calc.getVec(mv.direct.getX(), mv.direct.getY());
		double xl2;
		double yl2;
		if(l2 != 0) {
			xl2 = mv.length * mv.direct.getX() / l2;
			yl2 = mv.length * mv.direct.getY() / l2;
		} else {
			xl2 = 0;
			yl2 = 0;
		}
//		System.out.println("xl2: "+xl2);
//		System.out.println("yl2: "+yl2);
//		System.out.println();
		xl += xl2;
		yl += yl2;
		double dx = direct.getX() + mv.direct.getX();
		double dy = direct.getY() + mv.direct.getY();
		
		direct.setX(dx);
		direct.setY(dy);
		length = Calc.getVec(xl, yl);
	}
	
	/**
	 * 与数字相乘
	 * @param mul
	 */
	public MyVector multi(double mul) {
		double l = length * mul;
		MyVector mv = new MyVector();
		mv.setDirect(direct);
		mv.setLength(l);
		return mv;
	}
	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		this.length = length;
	}
	/**
	 * @return the direct
	 */
	public Point getDirect() {
		return direct;
	}
	/**
	 * @param direct the direct to set
	 */
	public void setDirect(Point direct) {
		this.direct = direct;
	}
	
}
