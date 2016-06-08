package core;

/**
 * 用向量的方法改写 planet
 * @author future
 *
 */
public class VecPlanet extends Planet{
	
	protected MyVector v;
	protected MyVector pos;
	/**
	 * 计算下一个时刻的速度
	 * @param a  加速度
	 * @param dt  时间间隔
	 */
	public void nextV(MyVector a, double dt) {
		
		this.v.add(a.multi(dt));
	}
	
	/**
	 * 计算下一个时刻的位移
	 * @param dt
	 */
	public void nextPos(double dt) {
//		System.out.println("v1: "+v.getLength());
		this.pos.add(this.v.multi(dt));
	}
	
	/**
	 * @return the v
	 */
	public MyVector getV() {
		return v;
	}
	/**
	 * @param v the v to set
	 */
	public void setV(MyVector v) {
		this.v = v;
	}
	
	/**
	 * X 轴上的速度分量
	 */
	public double getVX() {
		return v.getDirect().getX() * v.getLength();
	}
	/**
	 * Y 轴上的分量
	 */
	public double getVY() {
		return v.getDirect().getY() * v.getLength();
	}


	/**
	 * @return the pos
	 */
	public MyVector getPos() {
		return pos;
	}


	/**
	 * @param pos the pos to set
	 */
	public void setPos(MyVector pos) {
		this.pos = pos;
	}
	
	/**
	 * X 轴上的坐标
	 */
	public double getVecPosX() {
		return pos.getDirect().getX() * pos.getLength();
	}
	/**
	 * Y 轴上的坐标
	 */
	public double getVecPosY() {
		return pos.getDirect().getY() * pos.getLength();
	}

}
