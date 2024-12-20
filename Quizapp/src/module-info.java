/**
 * 
 */
/**
 * 
 */
module Quizapp {
	requires javafx.controls;
    requires javafx.fxml;
    requires java.sql; // if using MySQL
    
    exports view;
    opens view to javafx.fxml;
}