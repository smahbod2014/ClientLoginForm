package com.koda;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient {
	
	private static final String NEW_CONNECTION = "c/";
	private static final String LOG_IN = "l/";
	private static final String REGISTER = "r/";
	
	private String ip;
	private int port;
	private OutputStream os;
	
	public SimpleClient(String ip, int port) {
		this.ip = ip;
		this.port = port;
		start();
	}
	
	public void start() {
		try {
			Socket connection = new Socket(ip, port);
			os = connection.getOutputStream();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendLogin(String username, String password) {
		String message = LOG_IN + username + " " + password;
		try {
			os.write(message.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new SimpleClient("192.168.1.93", 8000).start();
	}
}
