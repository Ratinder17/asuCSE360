package asuHelloWorldJavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ASUHelloWorldJavaFX extends Application {
    private static Stage primaryStage;
    private static ReceptionistView receptionistView;
    private static TechnicianView technicianView;
    private static LoginView loginView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ASUHelloWorldJavaFX.primaryStage = primaryStage;
        ASUHelloWorldJavaFX.receptionistView = new ReceptionistView();
        ASUHelloWorldJavaFX.technicianView = new TechnicianView();
        ASUHelloWorldJavaFX.loginView = new LoginView();

        setupInitialView();

        primaryStage.setTitle("Heart Health Imaging System");
        primaryStage.show();
    }

    private static void setupInitialView() {
        BorderPane root = new BorderPane();

        Label welcomeLabel = new Label("              Welcome to the Heart Health Imaging and Recording System");
        welcomeLabel.setStyle("-fx-font-size: 24px;"); 

        Button receptionistButton = new Button("Patient Intake");
        receptionistButton.setOnAction(e -> showReceptionistView());
        receptionistButton.setStyle("-fx-background-color: #4473c5;");

        
        Button technicianButton = new Button("CT Scan Tech View");
        technicianButton.setOnAction(e -> showTechnicianView());
        technicianButton.setStyle("-fx-background-color: #4473c5;");


        Button patientButton = new Button("Patient View");
        patientButton.setOnAction(e -> showPatientView());
        patientButton.setStyle("-fx-background-color: #4473c5;");
        
        receptionistButton.setPrefSize(200, 50);
        technicianButton.setPrefSize(200, 50);
        patientButton.setPrefSize(200, 50);


        VBox buttonLayout = new VBox(20); 
        buttonLayout.getChildren().addAll(receptionistButton, technicianButton, patientButton);
        buttonLayout.setAlignment(Pos.CENTER);
        
        buttonLayout.setPadding(new Insets(20));
        
        root.setTop(welcomeLabel); 
        root.setCenter(buttonLayout); 

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
    }

    private static void showReceptionistView() {
        receptionistView.display(primaryStage);
    }

    private static void showTechnicianView() {
        technicianView.display(primaryStage);
    }

    private static void showPatientView() {
        loginView.display(primaryStage);
    }

    public static void showInitialView() {
        setupInitialView(); 
        primaryStage.show(); 
    }
}
