package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import core.Calc;
import objs.Earth;
import objs.Sun;
import utils.FileUtil;

public class Example1 extends Example{
	/**
	 * Graphics of panel
	 */
	private MyPanel mp;
	
	/**
	 * 时间间隔
	 */
	private double dt;
	private double velocity;
	private double minPoints = 100;
	
	private static final int SIZE = 240;
	
	public static void main(String[] args) {
		double timestep = 0.08;
		double velocity = 2 * Math.PI;
		
		Example1 e1 = new Example1(timestep, velocity);
		e1.setMinPoints(3000);
		e1.calc();
		
	}
	
	
	/**
	 * @return the minPoints
	 */
	public double getMinPoints() {
		return minPoints;
	}


	/**
	 * @param minPoints the minPoints to set
	 */
	public void setMinPoints(double minPoints) {
		this.minPoints = minPoints;
	}


	public Example1(double timestep, double velocity) {
		super();
		this.mp 	  = new MyPanel();
		this.dt 	  = timestep;
		this.velocity = velocity;
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
	
	private void calc1() {
		Sun sun = new Sun();
		sun.setPosX(0);
		sun.setPosY(0);
//		sun.setMass(Const.SUN_MASS);
		
		Earth earth = new Earth();
		//假设初始时，地球在 x 轴正半轴上，距离以 AU 为单位
		earth.setPosX(1);
		earth.setPosY(0);
		//初始速度
		earth.setSpeedX(0);
		earth.setSpeedY(velocity);
		
		double r;
		double x;
		double y;
		double vx;
		double vy;
		
		int i = 0;
		// 至少循环一圈
		while(i < 1 / dt || !(earth.getPosY() > 0 && earth.getPosX() > 0) || i < minPoints) {
			//计算距离
			r = Calc.distance(sun.getPosX(), sun.getPosY(), earth.getPosX(), earth.getPosY());
			//输出
//			System.out.println("====== 第 " + i + " 次 ======");
//			System.out.printf("位置：   x: %.4f  ======= y: %.4f" , earth.getPosX(), earth.getPosY());
//			System.out.println();
//			System.out.printf("速度：   x: %.4f  ======= y: %.4f" , earth.getSpeedX(), earth.getSpeedY());
//			System.out.println();
//			System.out.printf("距离：   r: %.6f", r);
//			System.out.println();
//			System.out.println();
			String toWrite = "";
			toWrite += "====== 第 " + i + " 次 ======\r\n";
			toWrite += String.format("位置：   x: %.4f  ======= y: %.4f\r\n", earth.getPosX(), earth.getPosY());
			toWrite += String.format("速度：   x: %.4f  ======= y: %.4f\r\n" , earth.getSpeedX(), earth.getSpeedY());
			toWrite += String.format("距离：   r: %.6f\r\n\r\n", r);
			FileUtil.writeToFile(toWrite, "实验数据2.txt", true);
			//绘图
			mp.setPos(earth.getPosX() * SIZE, earth.getPosY() * SIZE);
			mp.repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//对应 example 4.1 上的伪算法，4.7 的公式
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
			i++;
		}
		mp.repaint();
		System.out.println("done!");
	}
	private class PaintThread implements Runnable {

		@Override
		public void run() {
			calc1();
		}
		
	}
	
	private class MyPanel extends JPanel{
//		double x = 0;
//		double y = 0;
		private ArrayList<Double[]> array = new ArrayList<Double[]>(); 
		
		public void setPos(double x, double y) {
//			this.x = x;
//			this.y = y;
			Double[] d = {x, y};
			this.array.add(d);
		}
		
		public void paint(Graphics g) {
			super.paint(g);
			g.drawString("timestep = " + dt + "  yr", 15, 15);
			g.drawString("velocity    = " + velocity/ Math.PI + " π AU/yr", 15, 30);
			
			g.translate(600, 340);
			g.setColor(Color.BLACK);
			for(int i = 0; i < array.size(); i++)
			{
//				g.fillOval((int) x, (int) y, 3, 3);
				Double[] ad = array.get(i);
				g.fillOval(ad[0].intValue(), ad[1].intValue(), 3, 3);				
			}
			// 画出中心
			g.fillOval(0, 0, 15, 15);
			g.drawString("solar", 8, -8);
			// 画出坐标系
			g.drawLine(-SIZE, SIZE, SIZE + 50, SIZE); //x 轴
			g.drawLine(-SIZE, -SIZE -50, -SIZE, SIZE);  //y 轴
			g.drawString("x (AU)", 0, SIZE + 35);
			g.drawString("y (AU)", -SIZE -55, 0);
			// 画出坐标点
			g.drawString("0", 0, SIZE + 15);
			g.drawString("1", SIZE, SIZE + 15);
			g.drawString("-1", -SIZE, SIZE + 15);
			g.drawString("0", -SIZE -15, 0);
			g.drawString("-1", -SIZE -15, SIZE);
			g.drawString("1", -SIZE -15, -SIZE);
		}
	}
	
	/**
	 * 使用 Euler-Cromer 法则计算下一次的速度分量
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
	 * 使用 Euler-Cromer 法则计算下一次的位置
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
