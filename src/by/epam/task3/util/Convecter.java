
package by.epam.task3.util;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.epam.task3.entity.Student;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static by.epam.task3.main.Main.*;

public class Convecter {
	
	public static void objectToXml(Student student) {
		try (FileWriter writer = new FileWriter(new File(FILE_PATH + student.getFileName() + ".xml"))) {
			String content = "<" + student.getFileName() + ">\n<student firstName=\""
					+ student.getFirstName() + "\" secondName=\"" + student.getSecondName() + "\" patronymic=\""
					+ student.getPatronymic() + "\" averageMark=\"" + student.getCourse() + "\" access=\""
					+ student.getAccess() + "\" />\n" + "</" + student.getFileName() + ">";

			writer.write(content);
			writer.flush();
		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
	}

	// example file name file.xml
	public static Student xmlToObject(String xmlFileName) {

		Student student = null;

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			DocumentBuilder builder;
			builder = factory.newDocumentBuilder();

			Document document;
			document = builder.parse(new File(FILE_PATH + xmlFileName + ".xml"));

			NodeList studentElements = document.getDocumentElement().getElementsByTagName("student");

			for (int i = 0; i < studentElements.getLength(); i++) {
				Node studentNode = studentElements.item(i);

				NamedNodeMap attributes = studentNode.getAttributes();

				student = new Student();
				student.setFileName(document.getDocumentElement().getNodeName());
				student.setFirstName(attributes.getNamedItem("firstName").getNodeValue());
				student.setSecondName(attributes.getNamedItem("secondName").getNodeValue());
				student.setPatronymic(attributes.getNamedItem("patronymic").getNodeValue());
				student.setcourse(Integer.parseInt(attributes.getNamedItem("course").getNodeValue()));
				student.setAccess(Integer.parseInt(attributes.getNamedItem("access").getNodeValue()));
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		return student;
	}
}
