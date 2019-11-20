package simulation;

public class Binary extends sim{

	public Binary(String filename, int current_window) {
		super(filename, current_window);
		// TODO Auto-generated constructor stub
	}

	public int getWindow()
	{
		int tmp = current_window;
		current_window *= 2;
		return tmp;
	}
}
