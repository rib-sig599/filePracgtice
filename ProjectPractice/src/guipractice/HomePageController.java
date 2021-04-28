/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipractice;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author andre
 */
public class HomePageController implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    
    FileChooser fileChooser = new FileChooser();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fileChooser.setInitialDirectory(new File
        ("C:\\Users\\andre\\Documents\\GitHub\\Stevens-n-Riberio-Final-Project-CIS-2151\\savedGames"));
    }    

    @FXML
    private void newGameButton(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("GuiFXML.fxml"));
        anchorPane.getChildren().setAll(pane);
    }

    @FXML
    private void loadGameButton(ActionEvent event) {
        Window stageWindow = anchorPane.getScene().getWindow();
        fileChooser.setTitle("Load Games");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(".java", "*.java"));
        fileChooser.showOpenDialog(stageWindow);
        fileChooser.getInitialDirectory().getParentFile();
    }

    
}
