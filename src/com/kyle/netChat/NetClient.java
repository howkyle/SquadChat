package com.kyle.netChat;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import javax.swing.JTextArea;

public class NetClient {

	private Socket clientSocket;
	private PrintWriter out;
	private  BufferedReader in;
	private String fromServer;
	private String fromUser;
	private String host = "127.0.0.1";
    private int port = 4444;
    private String uName;
	
    
    public NetClient(String uName){
    	
    	try{
    		
        	this.uName = uName;
	    	clientSocket = new Socket(host, port);
		    out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out.println(uName);
			
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    }
    
    public void sendMessage(String message){
    	if (message != null){
    		out.println("Kyle:" +message);
    	}
    }
    
    public String receiveMessage() {
		
		try {
			while((fromServer = in.readLine())!=null){
				return fromServer;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "lol this didnt work";
 	
    }
    
    
    	
    
}
