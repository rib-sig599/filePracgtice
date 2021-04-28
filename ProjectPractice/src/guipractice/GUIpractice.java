/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipractice;

import com.sun.tools.javac.Main;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author andre
 */
public class GUIpractice extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // right click Libraries in the project, add the JavaFX16 library        
        // right click project, go to Run, add this to VM Options
        // make sure the project JDK platfor and JFX versions match - 16 for both
        // --add-modules javafx.controls,javafx.fxml
        // in the Libraries, Run tab, add JavaFX16 to the Module Path
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // change the name of your fxml file to match
        Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Blackjack");
        stage.setScene(scene);
        

        stage.show();
    }

}
