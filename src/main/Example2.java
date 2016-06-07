package main;

import core.Calc;
import core.Const;
import objs.Earth;
import objs.Sun;

public class Example2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void calc() {
		new Thread(new PaintThread()).start();
	}
	
	private class PaintThread implements Runnable {

		@Override
		public void run() {
			
			
			for(int i = 0; i < 100001; i++) {

				
					
			}

		}
		
	}
	
	/**
	 * 计算半径，假定 theta0 = 0
	 * @param Ms
	 * @param Mp
	 * @param theta
	 * @param L
	 * @param e
	 * @return
	 */
	public double getRadius(double Ms, double Mp, double theta, double L, double e) {
		double u = Calc.calcReducedMass(Ms, Mp);
//		double L = u * r * r * theta;
		// 对应 4.10 公式
		double r = (L * L / (u * Const.G * Ms * Mp)) / (1 - e * Math.cos(theta));
		
		return r;
	}
	
	/**
	 * 得到行星在椭圆轨道上的最大速度
	 * @param Ms
	 * @param Mp
	 * @param a
	 * @param e
	 * @return
	 */
	public double getVmax(double Ms, double Mp, double a, double e) {
		//对应 4.11  公式
		double Vmax = Math.sqrt(Const.G * Ms * (1 + e) * (1 + Mp / Ms) / a / (1 - e));
		return Vmax;
	}
	
	/**
	 * 得到行星在椭圆轨道上的最小速度
	 * @param Ms
	 * @param Mp
	 * @param a
	 * @param e
	 * @return
	 */
	public double getVmin(double Ms, double Mp, double a, double e) {
		//对应 4.11  公式
		double Vmin = Math.sqrt(Const.G * Ms * (1 - e) * (1 + Mp / Ms) / a / (1 + e));
		return Vmin;
	}
}
