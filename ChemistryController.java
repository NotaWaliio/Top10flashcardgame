/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package djpsproj;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gus Guidotti
 */
public class ChemistryController implements Initializable {
    
    @FXML
    private void BackToCategory(ActionEvent event) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("Category.fxml"));
       Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
       Scene scene = new Scene(root);
       thisStage.hide();
       thisStage.setScene(scene);
       thisStage.show();
       
      
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
