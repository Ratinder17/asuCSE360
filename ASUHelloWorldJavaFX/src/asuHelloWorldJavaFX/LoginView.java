package asuHelloWorldJavaFX;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LoginView  {
    private PatientView patientView;
    private ArrayList<Integer> patientCTScanDone = TechnicianView.getArrayList();
	private ArrayList<Patient> patientList = ReceptionistView.getArrayList();
    Patient patientFound = null;
    

    public LoginView() {
        // Initialize the patient view
        patientView = new PatientView();
    }

    public void display(Stage primaryStage) {
    	
        primaryStage.setTitle("Login");
        

        VBox root = new VBox(10);
        root.setPrefWidth(800);
        root.setPrefHeight(600);
        root.setStyle("-fx-padding: 24px");

        Label titleLabel = new Label("Patient Login");
        Label idLabel = new Label("Patient ID:");
        TextField idField = new TextField();
        Button loginButton = new Button("Login");
        
        Button back = new Button("Back");

        loginButton.setOnAction(event -> {
            String enteredID = idField.getText();
            if (isValidID(enteredID)) {
                
                int id = Integer.parseInt(enteredID);

                for (Patient patient : patientList) {
                    if (patient.getID() == id) {
                        patientFound = patient;
                        break; 
                    }
                }

                if (patientFound != null) {
                    patientView.display(primaryStage, patientFound);
                } else {
                    System.out.println("CT Scan Report not Available. Please try again.");
                }
            } else {
                System.out.println("Error: Patient information not found.");
            }
        });
        
        back.setOnAction(event -> ASUHelloWorldJavaFX.showInitialView());

        root.getChildren().addAll(titleLabel, idLabel, idField, loginButton, back);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean isValidID(String patientID) {
        patientID = patientID.trim();

        int id = Integer.parseInt(patientID);
        
        return patientCTScanDone.contains(id);
    }

}
