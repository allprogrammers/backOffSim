package simulation;

public class Logarithmic extends sim{

	public Logarithmic(String filename, int current_window) {
		super(filename, current_window);
		// TODO Auto-generated constructor stub
	}

	public int getWindow()
	{
		int tmp = current_window;
		current_window = (int)(1+1/(Math.log(current_window)/Math.log(2)))*2;
		return tmp;
	}
}
