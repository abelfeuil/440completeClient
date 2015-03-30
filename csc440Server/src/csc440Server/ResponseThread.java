package csc440Server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;


public class ResponseThread extends Thread
{
	ConnectedClient theClient;
	LinkedList<ConnectedClient> allTheClients;

	public ResponseThread(ConnectedClient theClient)
	{
		this.theClient = theClient;
		this.allTheClients = Driver.theClients;
	}
	
	public void run()
	{
		String theFileName = this.theClient.getMessage();
		String theSize = this.theClient.getMessage();
		int theSize = Integer.parseInt(this.theClient.getMessage());
		System.out.println("About to receive: " + theFileName + "(" + theSize + " bytes");
		File theNewFile = new File("./myfiles/" + theFileName);
		FileOutputStream fos;
		try
		{
			fos = new FileOutputStream(theNewFile);
			for(int i = 0; i < theSize; i++)
			{
				fos.write(this.theClient.readByte());
			}
			 fos.close();
		}
		catch(Exception e){}
	}
}