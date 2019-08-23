package by.epam.task3.entity;

import java.io.Serializable;

public class Student implements Serializable{

	private static final long serialVersionUID = -2262083418651563139L;
	
	private String fileName;
	private String firstName;
	private String secondName;
	private String patronymic;
	private int course;
	private int access;

	public Student() {
		this.fileName = "Unnamed";
		this.firstName = "Unnamed";
		this.secondName = "Unnamed";
		this.patronymic = "Unnamed";
		this.course = 1;
		this.access = 0;
	}

	public Student(String fileName, String firstName, String secondName, String patronymic, int course,
			int access) {
		super();
		this.fileName = fileName;
		this.firstName = firstName;
		this.secondName = secondName;
		this.patronymic = patronymic;
		this.course = course;
		this.access = access;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public int getCourse() {
		return course;
	}

	public void setcourse(int course) {
		this.course = course;
	}

	public int getAccess() {
		return access;
	}

	public void setAccess(int access) {
		this.access = access;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + access;
		result = prime * result + course;
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((patronymic == null) ? 0 : patronymic.hashCode());
		result = prime * result + ((secondName == null) ? 0 : secondName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (access != other.access)
			return false;
		if (course != other.course)
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (patronymic == null) {
			if (other.patronymic != null)
				return false;
		} else if (!patronymic.equals(other.patronymic))
			return false;
		if (secondName == null) {
			if (other.secondName != null)
				return false;
		} else if (!secondName.equals(other.secondName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StudentFile [fileName=" + fileName + ", firstName=" + firstName + ", secondName=" + secondName
				+ ", patronymic=" + patronymic + ", course=" + course + ", access=" + access + "]";
	}
}
