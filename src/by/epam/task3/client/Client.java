package by.epam.task3.client;

import static by.epam.task3.main.Main.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import by.epam.task3.entity.Student;
import by.epam.task3.util.Reader;
import by.epam.task3.util.Writer;

import static by.epam.task3.main.Main.*;

public class Client implements Runnable{

	private Scanner scanner = new Scanner(System.in);

	private Socket socket;
	private ObjectOutputStream writer;
	private ObjectInputStream reader;

	private int access;
	private Thread thread;

	public Client(int access) {				
		this.access = access;
		try {
			socket = new Socket(SERVER_IP, APP_PORT);
			System.out.println("Client start!");

			writer = new ObjectOutputStream(socket.getOutputStream());
			reader = new ObjectInputStream(socket.getInputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		thread = new Thread(this);
		thread.start();
	}

	public int getAccess() {
		return access;
	}

	@Override
	public void run() {
		while (!socket.isClosed()) {
			try {
				System.out.println("Maker a choose:" + "\n1.get student file by name."
						+ "\n2.change student file by name." + "\n3.add student file.\n4.Exit.");

				String choose = scanner.nextLine(); 
				switch (choose) {
				case "1": {
					Writer.writeObject(writer, "get");

					System.out.println("Input file name:");
					String fileName = scanner.nextLine();
					
					Writer.writeObject(writer, fileName);
					
					// get answer if file i found
					String answer = (String) Reader.readObject(reader);

					if (answer.equals("yes")) {

						Student student = (Student) Reader.readObject(reader);
						if (student.getAccess() > access) {
							System.out.println("Access denied.");
						} else {
							System.out.println("File is:" + student);
						}

					} else if (answer.equals("no")) {
						System.out.println("File is'nt found.");
					}

					break;
				}

				case "2": {
					Writer.writeObject(writer, "change");

					System.out.println("Input file name:");
					String fileName = scanner.nextLine();

					Writer.writeObject(writer, fileName);

					// get answer if file i found
					String isFoundAnswer = (String) Reader.readObject(reader);

					if (isFoundAnswer.equals("yes")) {

						Student student = (Student) Reader.readObject(reader);
						if (student.getAccess() > access) {
							System.out.println("Access denied.");
							Writer.writeObject(writer, "noaccess");
						} else {
							Writer.writeObject(writer, "access");
							System.out.println("Input new first name:");
							student.setFirstName(scanner.nextLine());

							System.out.println("Input new second name:");
							student.setSecondName(scanner.nextLine());

							System.out.println("Input new patronymic:");
							student.setPatronymic(scanner.nextLine());

							System.out.println("Input new course:");
							student.setcourse(Integer.parseInt(scanner.nextLine()));

							Writer.writeObject(writer, student);
						}

					} else if (isFoundAnswer.equals("no")) {
						System.out.println("File is'nt found.");
					}

					break;
				}

				case "3": {
					Writer.writeObject(writer, "create");

					Student student = new Student();

					System.out.println("Input first name:");
					student.setFirstName(scanner.nextLine());

					System.out.println("Input second name:");
					student.setSecondName(scanner.nextLine());

					System.out.println("Input patronymic:");
					student.setPatronymic(scanner.nextLine());

					System.out.println("Input course:");
					student.setcourse(Integer.parseInt(scanner.nextLine()));

					System.out.println("Input file name:");
					student.setFileName(scanner.nextLine());

					student.setAccess(access);

					Writer.writeObject(writer, student);
					break;
				}
				case "4": {
					Writer.writeObject(writer, "exit");

					writer.close();
					reader.close();
					socket.close();
					System.out.println("Client was closed.");
					break;
				}

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}
}
