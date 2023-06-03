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
public class GuitarsController implements Initializable {
    
    ArrayList<Flashcard> GuitarCards = new ArrayList<Flashcard>();
    
    public int cardNo = 0;

    @FXML private Label CardQ, CardA;
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
        CardQ.setText(GuitarCards.get(cardNo).getFront());
        CardA.setText("");
        if (cardNo == GuitarCards.size()-1){
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
            cardNo = GuitarCards.size()-1;
            setCard();
            CardImg.setImage(null);
        }

    }
    @FXML
    private void FlipCard() {
        CardQ.setText("");
        CardA.setText(GuitarCards.get(cardNo).getBack());

        Image img = new Image(getClass().getResource(GuitarCards.get(cardNo).getImg()).toExternalForm());
        CardImg.setImage(img);
    }

    
 
    
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Create a new Flashcard instance
        Flashcard guitar1 = new Flashcard("Who made the first electric guitar?", "While disputed, a scientist and an engineer came together and made the first electric guitar sometime in the early 1900s, Adolph Rickenbacker and George Beauchamp.", "FirstGuitar.png");
        Flashcard guitar2 = new Flashcard("How many frets are on a guitar neck?", "While arbitrary how many there are, guitars generally have either 21, 22, or 24, with 22 being the most common. However, some guitars have up to 30 frets.", "NoFrets.png");
        Flashcard guitar3= new Flashcard("Who is the greatest guitar player of all time?", "Since guitar is an art form, there is no objective answer to this - however, Jimi Hendrix is the most widely credited as being the greatest and most influential electric guitar player.", "Hendrix.png");
        Flashcard guitar4= new Flashcard(" Why are the guitar strings different thicknesses?", "As they represent different frequencies, the higher the note value is, the thinner the string will have to be, to be able to generate the increased frequency due to a tighter tuning tension.", "StringThickness.png");
        Flashcard guitar5= new Flashcard("What is the most expensive guitar ever sold?", "David Gilmour, guitarist of British alternative rock band Pink Floyd sold his signature Fender Stratocaster for almost 4 million dollars back in 2019.", "MostExpensive.png");
        
        
        // Add the Flashcard instance to the GuitarCards list
        GuitarCards.add(guitar1);
        GuitarCards.add(guitar2);
        GuitarCards.add(guitar3);
        GuitarCards.add(guitar4);
        GuitarCards.add(guitar5);

        setCard();
        

        
        
        
    }    
}
    
    
    
