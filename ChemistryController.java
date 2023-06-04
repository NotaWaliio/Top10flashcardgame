/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package djpsproj;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.smartcardio.Card;

/**
 * FXML Controller class
 *
 * @author Gus Guidotti
 */
public class ChemistryController implements Initializable {

    ArrayList<Flashcard> ChemistryCards = new ArrayList<Flashcard>();

    public int cardNo = 0;

    @FXML private Label CardQ, CardA, ForB;
    @FXML private ImageView CardImg;
    @FXML private Button FlipCard, PrevCard, NextCard, BackToCategories;

    @FXML
    private void BackToCategories(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Category.fxml"));
        Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        thisStage.hide();
        thisStage.setScene(scene);
        thisStage.show();
    }
    @FXML
    private void setCard(){

        CardQ.setText(ChemistryCards.get(cardNo).getFront());
        CardA.setText("");
        CardImg.setImage(null);
        ForB.setText("Question:");

        if (cardNo == ChemistryCards.size()-1){
            NextCard.setDisable(true);
        }
        else {
            NextCard.setDisable(false);
        }
        if (cardNo == 0){
            PrevCard.setDisable(true);
        }
        else {
            PrevCard.setDisable(false);
        }
    }

    @FXML
    private void PrevCard(){
        try {
            cardNo--;
            setCard();
            CardImg.setImage(null);
        } catch (Exception e) {
            cardNo = 0;
            setCard();
            CardImg.setImage(null);
        }
    }

    @FXML
    private void NextCard(){
        try {
            cardNo++;
            setCard();
            CardImg.setImage(null);
        } catch (Exception e) {
            cardNo = ChemistryCards.size()-1;
            setCard();
            CardImg.setImage(null);
        }

    }
    @FXML
    private void FlipCard() {

        if (CardA.getText().equals("")) {
            CardQ.setText("");
            CardA.setText(ChemistryCards.get(cardNo).getBack());

            Image img = new Image(getClass().getResource(ChemistryCards.get(cardNo).getImg()).toExternalForm());
            CardImg.setImage(img);

            ForB.setText("Answer:");
        }
        else {
            setCard();
        }
    }






    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ForB.setText("");
        // Create a new Flashcard instance
        Flashcard chemistry1 = new Flashcard("What elements react violently with water?", "Alkali metals are also known to react violently and explosively with water. This is because enough heat is given off during the exothermic reaction to ignite the Hydrogen Gas.", "Alkali.png");
        Flashcard chemistry2 = new Flashcard("How many protons and neutrons are in one gram of ordinary matter?","The Avogadro number is the approximate number of nucleons (protons and neutrons) in one gram of ordinary matter. The value of the Avogadro constant was chosen so that the mass of one mole of a chemical compound, expressed in grams, is approximately the number of nucleons in one constituent particle of the substance.","Avogadro.png");
        Flashcard chemistry3= new Flashcard("This type of Hydrocarbon contains carbon-carbon double bonds.","Alkenes are a class of organic compounds that contain carbon-carbon double bonds. They are unsaturated hydrocarbons, meaning they have fewer hydrogen atoms than the corresponding saturated hydrocarbons (alkanes) with the same number of carbon atoms.","Alkenes.png");
        Flashcard chemistry4= new Flashcard("Which two elements change from a solid to a liquid at room temperature?","When set in room temperature, mercury and bromine both exist in the liquid state.","HgBr.jpg");
        Flashcard chemistry5= new Flashcard("Who invented the Voltaic Cell?","The voltaic pile was invented by Alessandro Volta in the 1800s, the first electric battery. The invention is tied to Luigi Galvani's notorious experiments with frog legs.","VoltaicCell.png");


        // Add the Flashcard instance to the GuitarCards list
        ChemistryCards.add(chemistry1);
        ChemistryCards.add(chemistry2);
        ChemistryCards.add(chemistry3);
        ChemistryCards.add(chemistry4);
        ChemistryCards.add(chemistry5);

        setCard();





    }
}