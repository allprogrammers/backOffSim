/*
 * Muhammad Hamza Ali
 * ma1973
 * Programming Assignment 3 myBackoff.java
 * 
 */

import java.io.FileWriter;
import java.io.IOException;

public class myBackoff {

	//file names and a buffer for their contents
	private static final String linFile = "linearLatency.txt";
	private static StringBuilder linContent = new StringBuilder("");
	
	private static final String binFile = "binaryLatency.txt";
	private static StringBuilder binContent = new StringBuilder("");
	
	private static final String logFile = "logLatency.txt";
	private static StringBuilder logContent = new StringBuilder("");
	
	//Constants for Nodes
	private static final int increment = 100;
	private static final int max = 6000;
	private static final int trials = 10;
	private static final int N = 100;
	
	//initial window sizes for each protocol
	private static final int linW = 2;
	private static final int binW = 2;
	private static final int logW = 2;
	
	
	//writes the content to file
	public static void writeFile(String filename, String filecontent) throws IOException
	{
		FileWriter fw = new FileWriter(filename,false);//can also buffer the output to the writing buffer so that all of the file is not held in the memory
		fw.write(filecontent);
		fw.close();
	}
	
	public static void main(String[] args) throws IOException
	{	
		
		for(int i=N;i<=max;i+=increment)//simulates 10 trials for i devices with each protocol where i = 100,200,...,6000
		{
			
			//initializes averages
			int avgLinLat = 0;
			int avgBinLat = 0;
			int avgLogLat = 0;
			for(int j=0;j<trials;j++)//simulates a trial for each protocol 10 times and updates the average
			{
				Linear Linsim = new Linear(linW);
				Binary Binsim = new Binary(binW);
				Logarithmic Logsim = new Logarithmic(logW);
				avgLinLat += Linsim.simulate(i);
				avgBinLat += Binsim.simulate(i);
				avgLogLat += Logsim.simulate(i);
			}
			
			//finalizes averages and updates the filecontent buffers
			
			avgLinLat /= trials;
			linContent.append(avgLinLat+"\n");
			
			avgBinLat /= trials;
			binContent.append(avgBinLat+"\n");
			
			avgLogLat /= trials;
			logContent.append(avgLogLat+"\n");
			
			//not necessary but left here to show progress
			System.out.println("Done for "+i+" devices out of " + max);
			
		}
		
		//writes the file buffers to the respective files and exits
		writeFile(linFile,linContent.toString());
		writeFile(binFile,binContent.toString());
		writeFile(logFile,logContent.toString());
		
	}

}
