package by.epam.task3.main;

import java.util.Scanner;

import by.epam.task3.client.Client;
import by.epam.task3.server.Server;

public class Main {

        private static Scanner in;

    	public static final int APP_PORT = 8080;
    	public static final String SERVER_IP = "localhost";
    	public static final String FILE_PATH = "src/by/epam/tasks/task3/resources/";
    	public static final String FOLDER_PATH = "src/by/epam/tasks/task3/resources";
    	private static Scanner scanner = new Scanner(System.in);

    	public static void main(String[] args) {

    		System.out.println("Make a choose:\n1.Log in as client.\n2.Server up.");
    		String choose = scanner.nextLine();
    		switch (choose) {

    		case "1": {
    			System.out.println("Input client accessibility:");
    			Client client = new Client(scanner.nextInt());
    			break;
    		}

    		case "2": {
    			Server server = new Server();
    			break;
    		}

    		default: {
    			System.out.println("Wrong choosing.");
    		}

    		}
    	}
}
