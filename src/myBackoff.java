import java.io.FileWriter;
import java.io.IOException;

public class myBackoff {

	private static final String linFile = "linearLatency.txt";
	private static StringBuilder linContent = new StringBuilder("");
	
	private static final String binFile = "binaryLatency.txt";
	private static StringBuilder binContent = new StringBuilder("");
	
	private static final String logFile = "logLatency.txt";
	private static StringBuilder logContent = new StringBuilder("");
	
	private static final int increment = 100;
	private static final int max = 6000;
	private static final int trials = 10;
	
	private static final int linW = 2;
	private static final int binW = 2;
	private static final int logW = 2;
	
	private static int N = 100;
	
	public static void writeFile(String filename, String filecontent) throws IOException
	{
		FileWriter fw = new FileWriter(filename,false);//can also buffer the output to the writing buffer so that all of the file is not held in the memory
		fw.write(filecontent);
		fw.close();
	}
	
	public static void main(String[] args) throws IOException
	{	
		
		for(int i=N;i<=max;i+=increment)//remove increment to be max
		{
			
			int avgLinLat = 0;
			int avgBinLat = 0;
			int avgLogLat = 0;
			for(int j=0;j<trials;j++)//change 1 to be trials
			{
				Linear Linsim = new Linear(linW);
				Binary Binsim = new Binary(binW);
				Logarithmic Logsim = new Logarithmic(logW);
				avgLinLat += Linsim.simulate(i);
				avgBinLat += Binsim.simulate(i);
				avgLogLat += Logsim.simulate(i);
				
				System.out.println("One trial done");
			}
			
			avgLinLat /= trials;
			linContent.append(avgLinLat+"\n");
			
			avgBinLat /= trials;
			binContent.append(avgBinLat+"\n");
			
			avgLogLat /= trials;
			logContent.append(avgLogLat+"\n");
			System.out.println(" "+i+" devices now out of " + max);
			
		}
		
		writeFile(linFile,linContent.toString());
		writeFile(binFile,binContent.toString());
		writeFile(logFile,logContent.toString());
		
	}

}
