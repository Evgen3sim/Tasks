package by.epam.task3.server;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import by.epam.task3.entity.Student;
import by.epam.task3.util.Convecter;
import by.epam.task3.util.Reader;
import by.epam.task3.util.Writer;

import static by.epam.task3.main.Main.*;

public class Server implements Runnable{
	
	List<Student> student = new ArrayList<>();
	ServerSocket serverSocket;

	private Socket socket;
	private ObjectOutputStream writer;
	private ObjectInputStream reader;

	private Thread thread;

	public Server() {
		try {
			serverSocket = new ServerSocket(APP_PORT);
			initList();
			System.out.println("Server start working!");

			socket = serverSocket.accept();
			System.out.println("Server get connection!");
			writer = new ObjectOutputStream(socket.getOutputStream());
			reader = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		try {
			while (!socket.isClosed()) {
				String request = (String) Reader.readObject(reader);

//				System.out.println(request);
				switch (request) {
				case "get": {
					String fileName = (String) Reader.readObject(reader);
					int i = 0;
					for (; i < student.size(); i++) {
						if (student.get(i).getFileName().equals(fileName)) {
							Writer.writeObject(writer, "yes");
							Writer.writeObject(writer, student.get(i));
							break;
						}
					}

					if (i == student.size()) {
						Writer.writeObject(writer, "no");
					}

					break;
				}

				case "change": {
					String fileName = (String) Reader.readObject(reader);

					int i = 0;
					for (; i < student.size(); i++) {
						if (student.get(i).getFileName().equals(fileName)) {
							Writer.writeObject(writer, "yes");
							Writer.writeObject(writer, student.get(i));
							String answer = (String) Reader.readObject(reader);
							if (answer.equals("access")) {
								student.set(i, (Student) Reader.readObject(reader));
							} else if (answer.equals("noaccess")) {
								System.out.println("Not enough client accessibility.");
							}
							break;
						}
					}

					if (i == student.size()) {
						Writer.writeObject(writer, "no");
					}

					break;
				}

				case "create": {
					student.add((Student) Reader.readObject(reader));
					break;
				}

				case "exit": {
					for (int i = 0; i < student.size(); i++) {
						Convecter.objectToXml(student.get(i));
					}

					writer.close();
					reader.close();
					socket.close();
					serverSocket.close();
					System.out.println("Server was closed.");
					break;
				}

				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void initList() {
		File folder = new File(FOLDER_PATH);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				student.add(Convecter.xmlToObject(listOfFiles[i].getName().replaceAll(".xml", "")));
			}
		}
	}

}
