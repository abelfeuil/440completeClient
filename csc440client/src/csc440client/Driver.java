package csc440client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Driver 
{
	public static void main(String[] args) throws Exception
	{
		//connect to the server
		Socket theServer = new Socket("localhost",1234);
		
		ClientCommunicationProtocol ccp = new ClientCommunicationProtocol;
}
