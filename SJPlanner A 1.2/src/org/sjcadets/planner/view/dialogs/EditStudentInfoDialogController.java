package org.sjcadets.planner.view.dialogs;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import org.controlsfx.dialog.Dialogs;
import org.sjcadets.planner.AppData;
import org.sjcadets.planner.model.StudentInfo;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class EditStudentInfoDialogController {
	//TextFields
	
	@FXML private TextField firstNameField;
	@FXML private TextField lastNameField;
	@FXML private TextField counselorField;
	@FXML private TextField lockerNumberField;
	@FXML private TextField homeRoomField;
	@FXML private TextField lockerComboFirstField;
	@FXML private TextField lockerComboSecondField;
	@FXML private TextField lockerComboThirdField;
	
	private List<TextField> textFieldContainer;
	
	// Year Radio Buttons
	ToggleGroup studentYear = new ToggleGroup();
	@FXML private RadioButton freshman;
	@FXML private RadioButton sophomore;
	@FXML private RadioButton junior;
	@FXML private RadioButton senior;
	
	private static BiMap<StudentInfo.Grade, RadioButton> studentYearMap = HashBiMap.create(4);
	
	//Buttons
	@FXML private Button saveButton;
	@FXML private Button cancelButton;

	//Instance Variables
	private Stage dialogStage;
	private boolean saveClicked = false;
	
	
	public void setDialogStage(Stage dialogStage){
		this.dialogStage = dialogStage;
	}

	public boolean isSaveClicked(){
		return saveClicked;
	}
	@FXML
	public void initialize(){
		freshman.setToggleGroup(studentYear);
		sophomore.setToggleGroup(studentYear);
		junior.setToggleGroup(studentYear);
		senior.setToggleGroup(studentYear);
		
		studentYearMap.put(StudentInfo.Grade.FRESHMAN, freshman);
		studentYearMap.put(StudentInfo.Grade.SOPHOMORE, sophomore);
		studentYearMap.put(StudentInfo.Grade.JUNIOR, junior);
		studentYearMap.put(StudentInfo.Grade.SENIOR, senior);
		
		textFieldContainer = new ArrayList<TextField>(8);
		textFieldContainer.add(firstNameField);
		textFieldContainer.add(lastNameField);
		textFieldContainer.add(counselorField);
		textFieldContainer.add(lockerNumberField);
		textFieldContainer.add(homeRoomField);
		textFieldContainer.add(lockerComboFirstField);
		textFieldContainer.add(lockerComboSecondField);
		textFieldContainer.add(lockerComboThirdField);
	}
	private boolean validData() {
		for(TextField tf: textFieldContainer) {
			if(tf.getText() == null || tf.getText().equals("")) {
				return false;
			}
		}
		return true;
	}
	@FXML
	private boolean onSave() {

		if(validData()) {	
			/*si = new StudentInfo.Builder().name(firstNameField.getText(), lastNameField.getText())
					.counselor(counselorField.getText())
					.homeRoom(Integer.parseInt(homeRoomField.getText()))
					.lockerNumber(Integer.parseInt(lockerNumberField.getText()))
					.lockCombo(StudentInfo.Builder.createLockCombo(
							Integer.parseInt(lockerComboFirstField.getText()),
							Integer.parseInt(lockerComboSecondField.getText()),
							Integer.parseInt(lockerComboThirdField.getText())))
					.year(studentYearMap.inverse().get(studentYear.getSelectedToggle()))
					.build();*/
			
			//must change the data rather than create a new one in order
			//to keep observers on track
			
			AppData.getMasterStudentInfo().setFirstName(firstNameField.getText());
			AppData.getMasterStudentInfo().setLastName(lastNameField.getText());
			AppData.getMasterStudentInfo().setCounselor(counselorField.getText());
			AppData.getMasterStudentInfo().setHomeRoom(homeRoomField.getText());
			AppData.getMasterStudentInfo().setLockerNumber(lockerNumberField.getText());
			AppData.getMasterStudentInfo().setLockerFirst(lockerComboFirstField.getText());
				AppData.getMasterStudentInfo().setLockerSecond(lockerComboSecondField.getText());
				AppData.getMasterStudentInfo().setLockerThird(lockerComboThirdField.getText());
			AppData.getMasterStudentInfo().setYear(studentYearMap.inverse().get(studentYear.getSelectedToggle()));
		} else {
			Dialogs.create()
			.title("Fields")
			.masthead("Incorrect Fields")
			.message("Please input a value for each field.")
			.showWarning();
			return false;
		}
		saveClicked = true;
		dialogStage.close();
		return saveClicked;
	}
	@FXML
	private void onCancel() {
		dialogStage.close();
	}
}
