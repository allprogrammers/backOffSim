/*
 * Muhammad Hamza Ali
 * ma1973
 * Programming Assignment 3 Binary.java
 * 
 */

//class extending abstract sim class to implement getWindow method for Binary Exponential Back-off
public class Binary extends sim{

	public Binary(int current_window) {
		super(current_window);
	}

	public int getWindow()
	{
		int tmp = current_window;
		current_window *= 2;
		return tmp;
	}
}
