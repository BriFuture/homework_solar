package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Example extends JFrame{
	public Example() {
		this.setSize(800, 600);// 设置窗体的大小
		this.setLocation(300, 50);// 设置窗体的位置
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
