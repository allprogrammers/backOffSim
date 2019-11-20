/*
 * Muhammad Hamza Ali
 * ma1973
 * Programming Assignment 3 Logarithmic.java
 * 
 */

//class extending abstract sim class to implement getWindow method for Logarithmic Back-off
public class Logarithmic extends sim{

	public Logarithmic(int current_window) {
		super(current_window);
		// TODO Auto-generated constructor stub
	}

	public int getWindow()
	{
		int tmp = current_window;
		current_window = (int)((1+1/(Math.log10(current_window)/Math.log10(2)))*current_window);
		return tmp;
	}
}
