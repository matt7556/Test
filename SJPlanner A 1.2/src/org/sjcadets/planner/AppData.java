package org.sjcadets.planner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.sjcadets.planner.model.Course;
import org.sjcadets.planner.model.CourseListWrapper;
import org.sjcadets.planner.model.Event;
import org.sjcadets.planner.model.StudentInfo;
import org.sjcadets.planner.model.Task;

/**
 * Class to hold all the app's data, such as
 * the list of courses, tasks and events.
 * @author Tommy
 *
 */
public final class AppData {
	
	//Instance variables
	
	private static ObservableList<Task> masterTaskList = FXCollections.observableArrayList();
	
	private static ObservableList<Course> masterCourseList = FXCollections.observableArrayList();
	
	private static ObservableList<Event> masterEventList = FXCollections.observableArrayList();
	
	private static StudentInfo masterStudentInfo = new StudentInfo();
	
	//Not meant to be instantiated
	private AppData() {
		throw new AssertionError("Cannot instantiate");
	}
	
	//getters and setters
	public static ObservableList<Task> getMasterTaskList() {
		return masterTaskList;
	}

	public static StudentInfo getMasterStudentInfo() {
		return masterStudentInfo;
	}

	public static void setMasterStudentInfo(StudentInfo masterStudentInfo) {
		AppData.masterStudentInfo = masterStudentInfo;
	}

	public static void setMasterTaskList(ObservableList<Task> masterTaskList) {
		AppData.masterTaskList = masterTaskList;
	}

	public static ObservableList<Course> getMasterCourseList() {
		return masterCourseList;
	}

	public static void setMasterCourseList(ObservableList<Course> masterCourseList) {
		AppData.masterCourseList = masterCourseList;
	}

	public static ObservableList<Event> getMasterEventList() {
		return masterEventList;
	}

	public static void setMasterEventList(ObservableList<Event> masterEventList) {
		AppData.masterEventList = masterEventList;
	}
	
	/**
	 * Used for populating the the various lists with test data.
	 */
	public static void populateLists() {
		AppData.getMasterTaskList().add(new Task("Math", "Book", "problems", LocalDate.of(2015, 1, 17)));
		AppData.getMasterTaskList().add(new Task("Religion", "Textbook", "problems", LocalDate.of(2015, 1, 17)));
		AppData.getMasterTaskList().add(new Task());
		
		AppData.getMasterCourseList().add(new Course());
		AppData.getMasterCourseList().add(new Course("Math", "Mrs. Dennin", "107", "B", "notebook", "2"));
	}
	/**
	 * Save to XML using JAXB
	 * @throws JAXBException 
	 * @throws FileNotFoundException 
	 */
	public static void save() throws JAXBException, FileNotFoundException{
		CourseListWrapper cl = new CourseListWrapper();
		cl.setCourses(getMasterCourseList());
		JAXBContext context = JAXBContext.newInstance(cl.getClass());
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(cl, new FileOutputStream(new File(System.getProperty("user.dir") + "/resources/xml/courses.xml")));
		
	}
}
