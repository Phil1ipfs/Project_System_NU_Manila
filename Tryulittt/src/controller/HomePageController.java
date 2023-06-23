package controller;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.animation.FadeTransition;
import javafx.util.Duration;
import model.VegetarianPizza;

public class HomePageController implements Initializable {
    @FXML 
    AnchorPane AnchorPane3,anchorpane6;
    @FXML
    ImageView vegetarian , newyorkpizzpic;
    @FXML
    Label HomeLabel2, MenuLabel2, peperoniLabel,pizzaLabel;
    @FXML
    Button AboutButton,profileButton, LogoutDoorButton, vegepizz;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // -------------- LABEL -------------------
        HomeLabel2.setText("ABOUT");
        MenuLabel2.setText("MENU");

        peperoniLabel.setText("PEPERONI");
        pizzaLabel.setText("PIZZA");
        // ---------------- PIZZA IMAGE -----------------------

    }
    public void ABOUTSCENE(ActionEvent event){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), AnchorPane3);
        boolean AboutButton = true;
     if (AboutButton) {
            try {
                // Load the LoginScene.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/About.fxml"));
                Parent root = loader.load();

                // Create a new stage and set the AboutScene as its scene
                Stage AboutStage = new Stage();
                Image icon = new Image("images/pizzaLogo-removebg-preview.png");
                AboutStage.getIcons().add(icon);
                AboutStage.setTitle("PIZZERIA - About");  
                AboutStage.setScene(new Scene(root));

                // Show the AboutScene
                AboutStage.show();

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
 public void ProfileButton(ActionEvent event) {
    //profileButton
    FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), anchorpane6);
        boolean profileButton = true;
     if (profileButton) {
            try {
                // Load the Settings.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Settings.fxml"));
                Parent root = loader.load();

                // Create a new stage and set the Settings as its scene
                Stage Settingtage = new Stage();
                Image icon = new Image("images/pizzaLogo-removebg-preview.png");
                Settingtage.getIcons().add(icon);
                Settingtage.setTitle("PIZZERIA - Settings");  
                Settingtage.setScene(new Scene(root));

                // Show the Settings
                Settingtage.show();

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
    public void LOGOUTDOORS(ActionEvent event){
        
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), anchorpane6);

            boolean LogoutDoorButton= true;
            if (LogoutDoorButton) {
                showAlert("Logout", "Are you sure you want to logout?");
            try {
                // Load the LoginScene.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Home.fxml"));
                Parent root = loader.load();

                // Create a new stage and set the LoginScene as its scene
                Stage LogoutDoorsStage = new Stage();
                Image icon = new Image("images/pizzaLogo-removebg-preview.png");
                LogoutDoorsStage.getIcons().add(icon);
                LogoutDoorsStage.setTitle("PIZZERIA - Home");  
                LogoutDoorsStage.setScene(new Scene(root));

                // Show the LoginScene
                LogoutDoorsStage.show();

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
    private void showAlert(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION); // Use INFORMATION type for success messages
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
    }
    public void MenuPageOne(ActionEvent event){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), anchorpane6);

            boolean MenuButton= true;
            if (MenuButton) {
            try {
                // Load the LoginScene.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/menu_pageone.fxml"));
                Parent root = loader.load();

                // Create a new stage and set the LoginScene as its scene
                Stage MenupageoneStage = new Stage();
                Image icon = new Image("images/pizzaLogo-removebg-preview.png");
                MenupageoneStage.getIcons().add(icon);
                MenupageoneStage.setTitle("PIZZERIA - Menu");  
                MenupageoneStage.setScene(new Scene(root));

                // Show the LoginScene
                MenupageoneStage.show();

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
    //vegepizz
    public void crustycrub(ActionEvent event){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), anchorpane6);

            boolean vegepizz= true;
            if (vegepizz) {
            try {
                // Load the LoginScene.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/menu_pageone.fxml"));
                Parent root = loader.load();

                // Create a new stage and set the LoginScene as its scene
                Stage MenupageoneStage = new Stage();
                Image icon = new Image("images/pizzaLogo-removebg-preview.png");
                MenupageoneStage.getIcons().add(icon);
                MenupageoneStage.setTitle("PIZZERIA - Menu");  
                MenupageoneStage.setScene(new Scene(root));

                // Show the LoginScene
                MenupageoneStage.show();

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