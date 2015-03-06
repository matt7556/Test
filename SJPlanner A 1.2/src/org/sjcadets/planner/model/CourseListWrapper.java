package org.sjcadets.planner.model;

import java.util.List;

import javafx.collections.ObservableList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//used in saving the objects to XML

@XmlRootElement(name = "courses")
public class CourseListWrapper {
	
	private ObservableList<Course> courses;

	public ObservableList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ObservableList<Course> courses) {
		this.courses = courses;
	}
	
}
