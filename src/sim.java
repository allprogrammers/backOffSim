/*
 * Muhammad Hamza Ali
 * ma1973
 * Programming Assignment 3 sim.java
 * 
 */

import java.util.ArrayList;
import java.util.Collections;

//abstract class implementing common methods and attributes for all backoffs
public abstract class sim {
	public int current_window;
	
	public sim(int current_window) {
		this.current_window = current_window;
	}
	
	//gives a random number(0<=x<=1) ArrayList of length=length
	//think about this as a dice roll with for each of the device.
	public ArrayList<Double> diceRoll(int length)
	{
		
		ArrayList<Double> rand = new ArrayList<Double>();
		for(int i=0;i<length;i++)
		{
			rand.add(Math.random());
		}
		return rand;
		
	}
	
	//given a device number this method uses the class's abstract method to return the Latency 
	public int simulate(int no_devices)
	{
		int latency=0;
		
		//while there are still devices
		while(no_devices>0)
		{
			int cWin = getWindow();
			
			//keeps track of how many devices tried to send in ith slot
			ArrayList<Integer> slots = new ArrayList<Integer>(Collections.nCopies(cWin, 0));
			//random numbers for each device showing which slot
			ArrayList<Double> diceRoll4devices = diceRoll(no_devices);
			int sent = 0;
			int last = 0;
			for(int i=0;i<no_devices;i++)
			{
				int winslot = (int)(diceRoll4devices.get(i)*cWin);//the slot in which it should send 
				if(slots.get(winslot)==0)
				{
					sent +=1;
				}else if (slots.get(winslot)==1)
				{
					sent -=1;
				}
				slots.set(winslot, slots.get(winslot)+1);
				last = winslot>last?winslot:last;
			}
			
			no_devices -= sent;
			latency += last;
			
		}
		
		return latency;
	}
	
	//this will be implemented by the classes extending this class
	public abstract int getWindow();
}
