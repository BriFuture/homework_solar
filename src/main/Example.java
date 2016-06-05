package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Example extends JFrame{
	public Example() {
		this.setSize(800, 600);// 设置窗体的大小
		this.setLocation(300, 50);// 设置窗体的初始位置
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
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
			//横纵轴
			g.drawLine(-240, 240, 240, 240);
			g.drawLine(-240, -240, -240, 240);
			
		}
	}
	

}
