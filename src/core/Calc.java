package core;

/**
 * 计算最常用的公式的结果
 * @author future
 *
 */
public class Calc {
	
	/**
	 * 计算两点之间的距离
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return 两点之间的距离
	 */
	public static double distance(double x1, double y1, double x2, double y2) {
		double x = Math.abs(x1 - x2);
		double y = Math.abs(y1 - y2);
		double dis = Math.sqrt(x * x + y * y);
		return dis;
	}
	
	/**
	 * 计算万有引力
	 * @param M1 行星 1 的质量
	 * @param M2 行星 2 的质量
	 * @param r 两个行星之间的距离
	 * @return 万有引力
	 */
	public static double getGravity(double M1, double M2, double r) {
		double FG = Const.G * M1 * M2 / (r *r);
		return FG;
	}
	
	/**
	 * 万有引力在某个坐标轴上的分量
	 * @param M1  行星 1 的质量
	 * @param M2  行星 2 的质量
	 * @param r  距离
	 * @param x  当将其中一个行星（质量较大的那个）的位置作为原点，另外一个行星在某个坐标轴的 坐标
	 * @return
	 */
	public static double getGravityInX(double M1, double M2, double r, double x) {
		double FG = getGravity(M1, M2, r);
		double FGx = -(FG * x /r);
		return FGx;
	}
	
	/**
	 * 计算矢量大小
	 * @param vx  x 分量
	 * @param vy  y 分量
	 * @return    合成的矢量大小
	 */
	public static double getVec(double vx, double vy) {
		double v = Math.sqrt(vx * vx + vy * vy);
		return v;
	}
	
	/**
	 * 计算开普勒第三定律， T<sup>2</sup>/a <sup>3</sup>
	 * @param  T  周期
	 * @param  a  半长轴
	 * @return
	 */
	public static double calcKepler3(double T, double a) {
		return T * T / Math.pow(a, 3);
	}
	
	/**
	 * 计算约化质量
	 * @param m1
	 * @param m2
	 * @return
	 */
	public static double calcReducedMass(double m1, double m2) {
		return m1 * m2 / ( m1 + m2 );
	}
	
}
