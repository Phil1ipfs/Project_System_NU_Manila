package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AboutController implements  Initializable{
@FXML 
Label DiscoverLabel, infoLabel;
@FXML 
Text AboutText;
@FXML
Button LogoButton,ArrowButton;
@FXML
AnchorPane AnchorPane4;
@FXML
AnchorPane AnchorPane3;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DiscoverLabel.setText("DISCOVER");
        AboutText.setText("Welcome to The Pizzeria, where passion meets perfection! We are a vibrant pizza store crafting delightful and tantalizing pizzas using the finest ingredients. From traditional classics to creative combinations, our menu offers something for every pizza lover. Dine in, takeaway, or have us deliver to your doorstep for an unforgettable pizza experience. Join us and savor the true essence of authentic Italian pizza.");
    }
    public void Logo(ActionEvent event){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), AnchorPane4);
        boolean LogoButton = true;
        if (LogoButton) {
            try {
                // Load the LoginScene.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Home.fxml"));
                Parent root = loader.load();

                // Create a new stage and set the LoginScene as its scene
                Stage HomeStage = new Stage();
                Image icon = new Image("images/pizzaLogo-removebg-preview.png");
                HomeStage.getIcons().add(icon);
                HomeStage.setTitle("PIZZERIA - Home");                                
                HomeStage.setScene(new Scene(root));

                // Show the HomeScene
                HomeStage.show();

                // Hide the current scene (assuming the button is in the current scene)
                Node source = (Node) event.getSource();
                Stage currentStage = (Stage) source.getScene().getWindow();
                currentStage.hide();

                fadeTransition.setFromValue(0);
                fadeTransition.setToValue(1);
                fadeTransition.play();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void ArrowButtonBackToHomePage(ActionEvent event){
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), AnchorPane3);

            boolean ArrowButton = true;
            if (ArrowButton) {
            try {
                // Load the LoginScene.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HomePage.fxml"));
                Parent root = loader.load();

                // Create a new stage and set the LoginScene as its scene
                Stage HomeStage = new Stage();
                Image icon = new Image("images/pizzaLogo-removebg-preview.png");
                HomeStage.getIcons().add(icon);
                HomeStage.setTitle("PIZZERIA - Home");  
                HomeStage.setScene(new Scene(root));

                // Show the LoginScene
                HomeStage.show();

                // Hide the current scene (assuming the button is in the current scene)
                Node source = (Node) event.getSource();
                Stage currentStage = (Stage) source.getScene().getWindow();
                currentStage.hide();

                fadeTransition.setFromValue(0);
                fadeTransition.setToValue(1);
                fadeTransition.play();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    
}
