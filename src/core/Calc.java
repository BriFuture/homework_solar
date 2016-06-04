package core;

public class Calc {
	
	/**
	 * ��������֮��ľ���
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return ����֮��ľ���
	 */
	public static double distance(double x1, double y1, double x2, double y2) {
		double x = Math.abs(x1 - x2);
		double y = Math.abs(y1 - y2);
		double dis = Math.sqrt(x * x + y * y);
		return dis;
	}
	
	/**
	 * ������������
	 * @param M1 ���� 1 ������
	 * @param M2 ���� 2 ������
	 * @param r ��������֮��ľ���
	 * @return ��������
	 */
	public static double getGravity(double M1, double M2, double r) {
		double FG = Const.G * M1 * M2 / (r *r);
		return FG;
	}
	
	/**
	 * ����������ĳ���������ϵķ���
	 * @param M1  ���� 1 ������
	 * @param M2  ���� 2 ������
	 * @param r  ����
	 * @param x  ��������һ�����ǣ������ϴ���Ǹ�����λ����Ϊԭ�㣬����һ��������ĳ��������� ����
	 * @return
	 */
	public static double getGravityInX(double M1, double M2, double r, double x) {
		double FG = getGravity(M1, M2, r);
		double FGx = -(FG * x /r);
		return FGx;
	}
	
	/**
	 * ����ʸ����С
	 * @param vx  x ����
	 * @param vy  y ����
	 * @return    �ϳɵ�ʸ����С
	 */
	public static double getVec(double vx, double vy) {
		double v = Math.sqrt(vx * vx + vy * vy);
		return v;
	}
	
}
