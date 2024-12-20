package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import controller.UserController;

public class Main extends Application{
	
	private UserController userController;

    @Override
    public void start(Stage primaryStage) {
        userController = new UserController();

       
        Button btnLogin = new Button("Login");
        btnLogin.setOnAction(event -> {
           
            String username = "user"; 
            String password = "password"; 

            if (userController.authenticateUser(username, password)) {
                System.out.println("Login successful!");

            } else {
                System.out.println("Login failed!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btnLogin);

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Quiz Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
	

}
