package asuHelloWorldJavaFX;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ReceptionistView {
	
	public static ArrayList<Integer> patientIds = new ArrayList<>();
	public static ArrayList<Patient> patientList = new ArrayList<>();
	 Patient a;
	
	 TextField nameTextField = new TextField();
	 TextField lastNameTextField = new TextField();
	 TextField addressTextField = new TextField();
     TextField phoneTextField = new TextField();
     TextField insuranceIdTextField = new TextField(); 


	 
	public static int patientID;
	
	public void display(Stage primaryStage) {
        Stage receptionistStage = new Stage();
        receptionistStage.setTitle("Patient Intake");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label intakeFormLabel = new Label("                                  Patient Intake Form");
        intakeFormLabel.setFont(Font.font("Arial", 20)); 
        GridPane.setColumnSpan(intakeFormLabel, 2); 
        GridPane.setRowIndex(intakeFormLabel, 0); 
        gridPane.getChildren().add(intakeFormLabel);

        Label nameLabel = new Label("Name:");
        nameLabel.setFont(Font.font("Arial", 20)); 
        nameTextField.setFont(Font.font("Arial", 20)); 

        Label lastNameLabel = new Label("Last Name:");
        lastNameLabel.setFont(Font.font("Arial", 20)); 
        lastNameTextField.setFont(Font.font("Arial", 20));

        Label addressLabel = new Label("Address:");
        addressLabel.setFont(Font.font("Arial", 20)); 
        addressTextField.setFont(Font.font("Arial", 20)); 
        
        Label phoneLabel = new Label("Phone Number:");
        phoneLabel.setFont(Font.font("Arial", 20)); 
        phoneTextField.setFont(Font.font("Arial", 20)); 

        Label insuranceIdLabel = new Label("Insurance ID:");
        insuranceIdLabel.setFont(Font.font("Arial", 20)); 
        insuranceIdTextField.setFont(Font.font("Arial", 20)); 

        Button saveButton = new Button("Save");
        saveButton.setStyle("-fx-background-color: #4473c5; -fx-min-width: 120px; -fx-min-height: 40px;");

        gridPane.add(nameLabel, 0, 1);
        gridPane.add(nameTextField, 1, 1);
        gridPane.add(lastNameLabel, 0, 2);
        gridPane.add(lastNameTextField, 1, 2);
        gridPane.add(addressLabel, 0, 3);
        gridPane.add(addressTextField, 1, 3);
        gridPane.add(phoneLabel, 0, 4);
        gridPane.add(phoneTextField, 1, 4);
        gridPane.add(insuranceIdLabel, 0, 5); // Added insurance ID label
        gridPane.add(insuranceIdTextField, 1, 5); // Added insurance ID text field
        gridPane.add(saveButton, 3, 15); // Adjusted button position
        saveButton.setOnAction(e -> savePatientInfo());


        Scene scene = new Scene(gridPane, 800, 600); // Increased height for the label and fields
        receptionistStage.setScene(scene);
        receptionistStage.show();
    }
    
	private void savePatientInfo() {
	    String firstName = nameTextField.getText().trim();
	    a = new Patient();
	     a.setpatientName(firstName);
	     
	    String lastName  = lastNameTextField.getText().trim();
        String address   = addressTextField.getText().trim();
        String phone     = phoneTextField.getText().trim();
        String insur     = insuranceIdTextField.getText().trim();
	    if (firstName.isEmpty() || lastName.isEmpty() || address.isEmpty() || phone.isEmpty() || insur.isEmpty()) {
	        System.out.println("Error: Please fill in all fields.");
	        return;
	    }

	    // Generate a random exam date within the next 30 days
	    LocalDate currentDate = LocalDate.now();
	    LocalDate randomExamDate = currentDate.plusDays((long) (Math.random() * 30));
	    String examDate = randomExamDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

	    try {
	        // Generate a unique 5-digit patient ID
	        Random random = new Random();
	         patientID = 10000 + random.nextInt(90000);
	         
	         patientIds.add(patientID);
	         
	         a = new Patient();
	         patientList.add(a);
		     a.setpatientName(firstName);
	         a.setID(patientID);
	         
	         

	        String fileName = patientID + "_PatientInfo.txt";
	        FileWriter fileWriter = new FileWriter(fileName);
	        fileWriter.write("Patient ID: " + patientID + "\n");
	        fileWriter.write("First Name: " + firstName + "\n");
	        fileWriter.write("Last Name: " + lastName + "\n");
	        fileWriter.write("Exam Date: " + examDate + "\n");
	        fileWriter.write("Address: " + address + "\n");
	        fileWriter.write("Phone Number: " + phone + "\n");
	        fileWriter.write("Insurance ID: " + insur + "\n");
	        
	        
	        fileWriter.close();

	        System.out.println("Success: Patient information saved successfully. Patient ID: " + patientID);
	    } catch (IOException e) {
	        System.out.println("Error: An error occurred while saving patient information.");
	    }
	}
	public static ArrayList<Patient> getArrayList() {
        return patientList;
    }
	public static ArrayList<Integer> getArrayListofIDS(){
		return patientIds;
	}
}
