package main;


import java.awt.Graphics;

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
	 * ����
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
			//�����ʼʱ�������� x ���������ϣ������� AU Ϊ��λ
			earth.setPosX(1);
			earth.setPosY(0);
			//��ʼ�ٶ�Ϊ (0, 2 * PI)
			earth.setSpeedX(0);
			earth.setSpeedY(2 * Math.PI);
			
			double r;
			double x;
			double y;
			double vx;
			double vy;
			double dt = 0.001;
			
			for(int i = 0; i < 100001; i++) {
				//�������
				r = Calc.distance(sun.getPosX(), sun.getPosY(), earth.getPosX(), earth.getPosY());
				//���
				System.out.println("====== �� " + i + " �� ======");
				System.out.printf("λ�ã�   x: %.4f  ======= y: %.4f" , earth.getPosX(), earth.getPosY());
				System.out.println();
				System.out.printf("�ٶȣ�   x: %.4f  ======= y: %.4f" , earth.getSpeedX(), earth.getSpeedY());
				System.out.println();
				System.out.printf("���룺   r: %.6f", r);
				System.out.println();
				System.out.println();
				//��ͼ
				mp.setPos(earth.getPosX() * SIZE, earth.getPosY() * SIZE);
				mp.repaint();;
				//�ٶȱ仯
				vx = getViNext(earth.getSpeedX(), earth.getPosX(), r, dt);
				earth.setSpeedX(vx);
				vy = getViNext(earth.getSpeedY(), earth.getPosY(), r, dt);
				earth.setSpeedY(vy);
				//λ�ñ仯
				x = getNextPos(earth.getPosX(), earth.getSpeedX(), dt);
				earth.setPosX(x);
				y = getNextPos(earth.getPosY(), earth.getSpeedY(), dt);
				earth.setPosY(y);		
			}

		}
		
	}
	
	/**
	 * 
	 * @param vi �� i �ε��ٶȷ���
	 * @param pi �� i ���������
	 * @param ri �� i �ξ���
	 * @param dt ʱ����
	 * @return   �� i+1 �ε��ٶȷ���
	 */
	public double getViNext(double vi, double pi, double ri, double dt) {
		double vin = vi - 4 * Math.PI * Math.PI* pi * dt / Math.pow(ri, 3);
		return vin;
	}
	
	/**
	 * 
	 * @param pi  �� i ��������� 
	 * @param vin �� i+1 �ε��ٶȷ���
	 * @param dt  ʱ����
	 * @return    �� i+1 �ε��������
	 */
	public double getNextPos(double pi, double vin, double dt) {
		double pni = pi + vin * dt;
		return pni;
	}
}
