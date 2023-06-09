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
public class EnglishController implements Initializable {

    ArrayList<Flashcard> EnglishCards = new ArrayList<Flashcard>();

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
        CardQ.setText(EnglishCards.get(cardNo).getFront());
        CardA.setText("");
        CardImg.setImage(null);

        ForB.setText("Question:");
        if (cardNo == EnglishCards.size()-1){
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
            cardNo = EnglishCards.size()-1;
            setCard();
            CardImg.setImage(null);
        }

    }
    @FXML
    private void FlipCard() {

        if (CardA.getText().equals("")) {
            CardQ.setText("");
            CardA.setText(EnglishCards.get(cardNo).getBack());

            Image img = new Image(getClass().getResource(EnglishCards.get(cardNo).getImg()).toExternalForm());
            CardImg.setImage(img);

            ForB.setText("Answer:");
        }
        else {
            setCard();
        }
    }






    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Create a new Flashcard instance
        Flashcard english1 = new Flashcard("Who was the author of the short story \"Two Words?\"", "\"Two Words\" was written by south american writer Isabel Allende, published in 1989 under her collection, \"Cuentos de Eva Luna,\" or \"The Stories of Eva Luna.\"", "IsabelAllende.jpg");
        Flashcard english2 = new Flashcard("Who pioneered the literary style of magic realism?", "Gabriel Garcia Marquez was a Nobel prize-winning Columbian writer and was one of the first to utilize the style of magic realism. ", "Marquez.png");
        Flashcard english3= new Flashcard("Which of Gabriel Marquez's books are the most well-known?", "As a very accomplished writer, Gabriel Marquez has published a multitude of successful works, but of those, One Hundred Years of Solitude and Love in the Time of Cholera are his best-known novels.", "MarquezBooks.png");
        Flashcard english4= new Flashcard("What is Pablo Neruda most known for?", "Some of Pablo Neruda's most famous works are collections of poems about love expressed through metaphors and images of nature.", "PabloNeruda.jpg");
        Flashcard english5= new Flashcard("What themes does the novel \"Eva Luna\" by Isabel Allende follow?", "Isabel Allende explores the transformative power of words and stories in telling the story of the novel. Abuse of power and women's rights are also tackled in the book.", "EvaLuna.jpeg");


        // Add the Flashcard instance to the GuitarCards list
        EnglishCards.add(english1);
        EnglishCards.add(english2);
        EnglishCards.add(english3);
        EnglishCards.add(english4);
        EnglishCards.add(english5);

        setCard();





    }
}