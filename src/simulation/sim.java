package simulation;

import java.util.ArrayList;
import java.util.Collections;

public abstract class sim {

	public String filename;
	public int current_window;
	
	public sim(String filename, int current_window) {
		this.filename = filename;
		this.current_window = current_window;
	}
	
	public ArrayList<Double> diceRoll(int length)
	{
		/*ArrayList<Double> list = new ArrayList<>(length-1);
		for(int i=0;i<length-1;i++)
		{
			list.set(i, Math.random());
		}
		
		ArrayList<Double> sortedRand = list.stream().sorted().collect(Collectors.toCollection(ArrayList<Double>::new));
		sortedRand.add(1.0);
		sortedRand.add(0, 0.0);
		ArrayList<Double> summing2one = new ArrayList<Double>(sortedRand.size()-1);
		for(int i=0;i<summing2one.size();i++)
		{
			summing2one.set(i,sortedRand.get(i+1)-sortedRand.get(i));
		}
		return summing2one;*/
		
		ArrayList<Double> rand = new ArrayList<Double>(length);
		for(int i=0;i<length;i++)
		{
			rand.set(i, Math.random());
		}
		return rand;
		
	}
	
	public int simulate(int no_devices)
	{
		int latency=0;
		while(no_devices>0)
		{
			int cWin = getWindow();
			ArrayList<Integer> pkinwin = new ArrayList<Integer>(Collections.nCopies(cWin, 0));
			ArrayList<Double> diceRoll4devices = diceRoll(no_devices);
			int i=0;
			while(i<no_devices)
			{
				int winslot = (int)(diceRoll4devices.get(i)*cWin);
				pkinwin.set(winslot, pkinwin.get(winslot)+1);
				i++;
			}
			
			i = 0;
			while(i<no_devices)
			{
				if(pkinwin.get(i)==1)
					no_devices-=1;
				i++;
			}
			if(no_devices==0)
			{
				i=0;
				int toadd = 0;
				while(i<cWin)
				{
					if(pkinwin.get(i)==1)
						toadd=i;
					i++;
				}
				latency += toadd;
			}else
			{
				latency += cWin;
			}
		}
		
		return latency;
	}
	
	public abstract int getWindow();
}
