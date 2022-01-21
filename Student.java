/**
*Represents a student.
*@author Maxime Sotsky 3637964
*/
import java.io.*;
public class Student implements Comparable<Student>, Serializable {

	/**
	The last name of the student.
	*/
	private String lastName;
	
	/**
	The first name of the student.
	*/
	private String firstName;
	
	/**
	The student's ID number.
	*/
	private int id;
	
	
	/**
	Constructs a student given their first and last name, and student ID.
	@param firstNameIn The first name of the student.
	@param lastNameIn The last name of the student.
	@param idIn The student's ID number.
	*/
	public Student(String firstNameIn, String lastNameIn, int idIn){
		firstName = firstNameIn;
		lastName = lastNameIn;
		id = idIn;
	}
		
	/**
	Prints all the information about the student.
	@return The student's information.
	*/
	public String toString(){
		return lastName + ", " + firstName + " (" + id + ")";
	}

	/**
	 * Method that compares students based on last name, first name, ID
	 * @return -1, 0 , 1 representing equality/inequality
	 * @param other -The other student that is compared with this student
	 */
	public int compareTo(Student other){
		int resLast = this.lastName.compareTo(other.lastName);
		int resFirst = this.firstName.compareTo(other.firstName);
		int resId;
		//smallest to largest
		if(this.id > other.id)
			resId = 1;
		else if(this.id < other.id)
			resId = -1;
		else
			resId = 0;

		if(resLast != 0)
			return resLast;
		else if (resFirst != 0)
			return resFirst;
		else
			return resId;
	}
}