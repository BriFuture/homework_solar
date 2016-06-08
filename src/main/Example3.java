package main;

import core.Calc;
import core.Const;
import objs.Earth;
import objs.Sun;

public class Example3 {

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
	

}
