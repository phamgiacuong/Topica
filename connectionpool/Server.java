package com.topica.cuongpg.connectionpool;

public class Server {
	static ConnectionPool connectionPool = new ConnectionPool();
	static final int CONNECTION_NUMBER = 6;
	public static void main(String[] args) {
		for(int i =0;i<CONNECTION_NUMBER;i++) {
			Thread thread = new Thread() {
				public void run() {
					try {
						connectionPool.getConnectionFromPool();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			thread.start();
		}
		
		
	}
}
