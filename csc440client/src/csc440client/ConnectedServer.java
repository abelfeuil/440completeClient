package csc440client;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ConnectedServer 
{
	private Socket theSocket;
	private PrintWriter output;
	private Scanner input;

	public ConnectedServer(Socket theSocket)
	{
		this.theSocket = theSocket;
		this.output = new PrintWriter(this.theSocket.getOutputStream(), true);
		this.input = new Scanner(this.theSocket.getInputStream());
	}
	
	public void sendMessage(String msg)
	{
		this.output.println(msg);
	}
	
	public String getMessage()
	{
		return this.input.nextLine();
	}
	
	public int readByte() throws Exception
	{
		return this.theSocket.getInputStream().read();
	}
