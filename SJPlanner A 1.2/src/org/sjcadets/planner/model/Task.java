package org.sjcadets.planner.model;
import java.time.LocalDate;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * A Java bean representing all the information associated with a <code>Task</code>.
 * Users can add, edit and remove tasks. Tasks along with Events are displayed
 * in the many calendar formats (Day, Week, Month).
 * <p>
 * Needs to be a Java bean (SimpleStringProperty, etc) because within
 * JavaFX in order to change and update data (for ObservableLists, etc)
 * data needs to be stored in properties.
 */
public class Task {
	//constructors
	
	//complete constructor
	public Task(String className, String assignment, String description, LocalDate dueDate) {
		this.className = new SimpleStringProperty(className);
		this.assignment = new SimpleStringProperty(assignment);
		this.description = new SimpleStringProperty(description);
		
		this.dueDate = new SimpleObjectProperty<LocalDate>(dueDate);
	}
	
	/**
	 * Sets a model data into the task, sets the 
	 * due date to be tomorrow.
	 */
	public Task() {
		this("", "", "", LocalDate.now().plusDays(1));
		
		setClassName("English");
		setAssignment("Read");
		setDescription("1984");
		
		//setDueDate(LocalDate.now());
	}
	//Instance variables
	
	private final SimpleStringProperty className;
	private final SimpleStringProperty assignment;
	private final SimpleStringProperty description;
		
	private final ObjectProperty<LocalDate> dueDate;
	
	//Constant fields
	//private static final String[] ATTRIBUTE_NAMES = {"className", "assignment", "description", "dueDate"};
	
	
//	@Override
//	public String toString() {
//		String all = "Class: " + this.getClassName() + 
//				" Assignment: " + this.getAssignment() + 
//				" Description: " + this.getDescription() + 
//				" Due Date: " + this.getDueDate();
//		return all;
//	}
	
//	//XML methods
//	public void generateXML(File xml) throws FileNotFoundException, XMLStreamException {
//		
//		//XML writing setup
//		XMLOutputFactory outFactory = XMLOutputFactory.newFactory();
//		FileOutputStream outStream = new FileOutputStream(xml);
//		XMLStreamWriter writer = outFactory.createXMLStreamWriter(outStream);
//			
//				//writing
//				
//				/*Example of the insertion:
//				 * <task>
//				 * 		<className>English</className>
//				 * 		<assignment>Read Lord of the Flies</assignment>
//				 * 		<description>pg 20-55</description>
//				 * </task>
//				 */
//		
//		writer.writeStartDocument();
//		writer.writeStartElement("tasks");
//		
//		writer.writeStartElement("task");
//		
//		writer.writeStartElement("date");
//		
//		writer.writeStartElement("dueDate");
//		writer.writeCharacters(getDueDate());
//		writer.writeEndElement();
//				
//		writer.writeStartElement("className");
//		writer.writeCharacters(getClassName());
//		writer.writeEndElement();
//				
//		writer.writeStartElement("assignment");
//		writer.writeCharacters(getAssignment());
//		writer.writeEndElement();
//				
//		writer.writeStartElement("description");
//		writer.writeCharacters(getDescription());
//		
//		writer.writeEndElement();
//
//		writer.writeEndDocument();
//		
//		writer.close();
//	}
//	/**Parses an XML document to check if the task is within the file.
//	 * 
//	 * @param xml
//	 * @return true if the course is within the specified xml file.
//	 * @throws FileNotFoundException
//	 * @throws XMLStreamException
//	 */
//	//public boolean isInXML(File xml) throws FileNotFoundException, XMLStreamException {
//	//	return XMLManager.isInXML(xml, "task", ATTRIBUTE_NAMES, getClassName(), getAssignment(), getDescription(), getDueDate());
//	//}
//
////	//XML method
////	public static Task getFromXML(File xml) throws FileNotFoundException, XMLStreamException {
////		TaskBook tb = TaskBook.getFromXML(xml);
////		if(tb.size() == 1) {
////			Task t = new Task(tb.get(0));
////			return t;
////		} else throw new IllegalArgumentException("XML file contains more than one task");
////	}
//	
//	//Getters and setters
	
	public final SimpleStringProperty classNameProperty() {
		return this.className;
	}
	public final java.lang.String getClassName() {
		return this.classNameProperty().get();
	}
	public final void setClassName(final java.lang.String className) {
		this.classNameProperty().set(className);
	}
	public final SimpleStringProperty assignmentProperty() {
		return this.assignment;
	}
	public final java.lang.String getAssignment() {
		return this.assignmentProperty().get();
	}
	public final void setAssignment(final java.lang.String assignment) {
		this.assignmentProperty().set(assignment);
	}
	public final SimpleStringProperty descriptionProperty() {
		return this.description;
	}
	public final java.lang.String getDescription() {
		return this.descriptionProperty().get();
	}
	public final void setDescription(final java.lang.String description) {
		this.descriptionProperty().set(description);
	}
	public final ObjectProperty<LocalDate> dueDateProperty() {
		return this.dueDate;
	}
	public final java.time.LocalDate getDueDate() {
		return this.dueDateProperty().get();
	}
	public final void setDueDate(final java.time.LocalDate dueDate) {
		this.dueDateProperty().set(dueDate);
	}
}
