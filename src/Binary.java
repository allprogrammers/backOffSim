public class Binary extends sim{

	public Binary(int current_window) {
		super(current_window);
		// TODO Auto-generated constructor stub
	}

	public int getWindow()
	{
		int tmp = current_window;
		current_window *= 2;
		return tmp;
	}
}
