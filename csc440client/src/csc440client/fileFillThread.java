package csc440client;

import java.io.FileWriter;
import java.io.IOException;

public class fileFillThread extends clientHelperThread
{
	public fileFillThread(int[] theFileArray,  ConnectedServer cs)
	{
		super(theFileArray);
	}
	
	public void run()
	{
		//this guy constantly tries to fill the byte array for the
		//receiving file
		//*****Write Code HERE****
		int count = 0;
		while(true)
		{	
			for(int i = 0; i < this.theFileArray.length; i++)
			{
				if(this.theFileArray[1] == -1)
				{
					try
					{
					//request this byte
					//may not get the byte and move on
					cs.sendMessage("" + i);
					int theByte = cs.readByte();
					if(theByte != -1)
					{
						this.theFileArray[i] = theByte;
						count++;
					}
					count++;
					}
					catch(Exception e){}
				}
			}
			if(count == this.theFileArray.length)
			{
				break;
			}
		}
		//we have all the bytes so write to disk
		try {
			FileWriter fw = new FileWriter("./myFiles/bob.jpg");
			for(int i = 0; i < this.theFileArray.length; i++)
			{
				fw.write(this.theFileArray[i]);
			}
			fw.close();
		} catch (IOException e) {}
		}
	}
