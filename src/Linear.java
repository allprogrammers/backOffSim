/*
 * Muhammad Hamza Ali
 * ma1973
 * Programming Assignment 3 Linear.java
 * 
 */

//class extending abstract sim class to implement getWindow method for Linear Back-off
public class Linear extends sim{

	public Linear(int current_window) {
		super(current_window);
		// TODO Auto-generated constructor stub
	}

	public int getWindow()
	{
		int tmp = current_window;
		current_window += 1;
		return tmp;
	}
}
