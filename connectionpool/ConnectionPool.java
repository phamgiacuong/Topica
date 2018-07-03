package com.topica.cuongpg.connectionpool;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

public class ConnectionPool {
	private final int MIN_POOL_SIZE = 3;
	private final int MAX_POOL_SIZE = 5;
	private final String DB_USER_NAME = "root";
	private final String DB_PASSWORD = "";
	private final String DB_URL = "jdbc:mysql://localhost:3306/student";
	private final String DB_DRIVER = "com.mysql.jdbc.Driver";

	List<Connection> availableConnections = new ArrayList<Connection>();
	List<Connection> usingConnections = new ArrayList<Connection>();

	public ConnectionPool() {
		initializeConnectionPool();
	}

	private void initializeConnectionPool() {
		while (availableConnections.size() < MIN_POOL_SIZE) {
			System.out.println("Created a new connection");
			availableConnections.add((Connection) createNewConnectionForPool());
		}
	}

	// Creating a connection
	private Connection createNewConnectionForPool() {

		try {
			Class.forName(DB_DRIVER);
			Connection connection = (Connection) DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
			availableConnections.add(connection);
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public synchronized Connection getConnectionFromPool() throws InterruptedException {
		Connection connection = null;
		if (availableConnections.size() > 0) {
			System.out.println("Connection found");
			connection = (Connection) availableConnections.get(0);
			availableConnections.remove(0);
			usingConnections.add(connection);
		} else {
			if (usingConnections.size() < MAX_POOL_SIZE) {
				// create new connection
				System.out.println("Creating new connection. Available connection:" + availableConnections.size()
						+ ".Using connections:" + usingConnections.size());
				createNewConnectionForPool();
			} else {
				System.out.println("Connection limited");
				wait();
				System.out.println("Connecting");
			}
		}
		return connection;
	}

	public synchronized void returnConnectionToPool(Connection connection) {
		availableConnections.add((Connection) connection);
		usingConnections.remove(usingConnections.indexOf(connection));
		notifyAll();
	}

}
