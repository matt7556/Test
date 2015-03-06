package org.sjcadets.planner.view.dialogs;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.controlsfx.dialog.Dialogs;
import org.sjcadets.planner.model.Task;

public class EditTaskDialogController {
	@FXML
	TextField assignmentField;
	@FXML
	TextField courseField;
	@FXML
	TextField descriptionField;
	@FXML
	DatePicker dueDatePicker;
	
	private Stage dialogStage;
	private Task t;
	private boolean saveClicked = false;
	
	public void setDialogStage(Stage dialogeStage) {
		this.dialogStage = dialogeStage;
	}
	
	public boolean isSaveClicked() {
		return saveClicked;
	}
	
	public  void setTask(Task t) {
		this.t = t;
		if(t != null) {
			assignmentField.setText(t.getAssignment());
			courseField.setText(t.getClassName());
			descriptionField.setText(t.getDescription());
			dueDatePicker.setValue(t.getDueDate());
		} else {
			//sets default value to tomorrow (most tasks will be due tomorrow)
			dueDatePicker.setValue(LocalDate.now().plusDays(1));
		}
	}
	
	public Task getTask() {
		return t;
	}
	
	/**
	 * Tests if the fields are valid in order to save.
	 * @return true if fields contain values.
	 */
	private boolean validFields() {
		if(assignmentField.getText() == null || assignmentField.getText().equals("")) {
			return false;
		}
		if(courseField.getText() == null || courseField.getText().equals("")) {
			return false;
		}
		if(descriptionField.getText() == null || descriptionField.getText().equals("")) {
			return false;
		}
		if(dueDatePicker.getValue() == null) {
			return false;
		}
		return true;
	}
	
	//Event handle methods
	
	@FXML
	public boolean onSave() {
		Task tempTask = new Task();
		if(validFields()) {
			tempTask.setAssignment(assignmentField.getText());
			tempTask.setClassName(courseField.getText());
			tempTask.setDescription(descriptionField.getText());
			tempTask.setDueDate(dueDatePicker.getValue());
		} else {
			Dialogs.create()
			.title("Fields")
			.masthead("Incorrect Fields")
			.message("Please input a value for each field.")
			.showWarning();
			return false;
		}
		t = tempTask;
		saveClicked = true;
		dialogStage.close();
		return saveClicked;
	}
	
	@FXML
	public void onCancel() {
		dialogStage.close();
	}
	
}
