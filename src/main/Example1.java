package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import core.Calc;
import objs.Earth;
import objs.Sun;

public class Example1 extends Example{
	/**
	 * Graphics of panel
	 */
	private MyPanel mp;
	
	private static final int SIZE = 240;
	
	public static void main(String[] args) {
		Example1 e1 = new Example1();
		e1.calc();
		
	}
	
	public Example1() {
		super();
		this.mp = new MyPanel();
		this.getContentPane().add(this.mp);
		this.setTitle("Expamle 4-1");
	}
	/**
	 * 计算
	 */
	public void calc() {
		PaintThread pt = new PaintThread();
		new Thread(pt).start();
	}
	
	protected class PaintThread implements Runnable {

		@Override
		public void run() {
			Sun sun = new Sun();
			sun.setPosX(0);
			sun.setPosY(0);
//			sun.setMass(Const.SUN_MASS);
			
			Earth earth = new Earth();
			//假设初始时，地球在 x 轴正半轴上，距离以 AU 为单位
			earth.setPosX(1);
			earth.setPosY(0);
			//初始速度为 (0, 2 * PI)
			earth.setSpeedX(0);
			earth.setSpeedY(2 * Math.PI);
			
			double r;
			double x;
			double y;
			double vx;
			double vy;
			double dt = 0.001;
			
			for(int i = 0; i < 100001; i++) {
				//计算距离
				r = Calc.distance(sun.getPosX(), sun.getPosY(), earth.getPosX(), earth.getPosY());
				//输出
				System.out.println("====== 第 " + i + " 次 ======");
				System.out.printf("位置：   x: %.4f  ======= y: %.4f" , earth.getPosX(), earth.getPosY());
				System.out.println();
				System.out.printf("速度：   x: %.4f  ======= y: %.4f" , earth.getSpeedX(), earth.getSpeedY());
				System.out.println();
				System.out.printf("距离：   r: %.6f", r);
				System.out.println();
				System.out.println();
				//绘图
				mp.setPos(earth.getPosX() * SIZE, earth.getPosY() * SIZE);
				mp.repaint();
				
				//对应 example 4.1 上的伪算法
				//速度变化
				vx = getViNext(earth.getSpeedX(), earth.getPosX(), r, dt);
				earth.setSpeedX(vx);
				vy = getViNext(earth.getSpeedY(), earth.getPosY(), r, dt);
				earth.setSpeedY(vy);
				//位置变化
				x = getNextPos(earth.getPosX(), earth.getSpeedX(), dt);
				earth.setPosX(x);
				y = getNextPos(earth.getPosY(), earth.getSpeedY(), dt);
				earth.setPosY(y);		
			}

		}
		
	}
	
	protected class MyPanel extends JPanel{
		double x = 0;
		double y = 0;
		
		public void setPos(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public void paint(Graphics g) {
//			super.paint(g);
			g.translate(400, 280);
			g.setColor(Color.BLACK);
			g.fillOval((int) x, (int) y, 2, 2);
			// 画出坐标系
			g.drawLine(-240, 240, 240, 240);
			g.drawLine(-240, -240, -240, 240);
			
		}
	}
	
	/**
	 * 
	 * @param vi 第 i 次的速度分量
	 * @param pi 第 i 次坐标分量
	 * @param ri 第 i 次距离
	 * @param dt 时间间隔
	 * @return   第 i+1 次的速度分量
	 */
	public double getViNext(double vi, double pi, double ri, double dt) {
		double vin = vi - 4 * Math.PI * Math.PI* pi * dt / Math.pow(ri, 3);
		return vin;
	}
	
	/**
	 * 
	 * @param pi  第 i 次坐标分量 
	 * @param vin 第 i+1 次的速度分量
	 * @param dt  时间间隔
	 * @return    第 i+1 次的坐标分量
	 */
	public double getNextPos(double pi, double vin, double dt) {
		double pni = pi + vin * dt;
		return pni;
	}
}
