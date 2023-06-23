package controller;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.pizzaHome;


import java.io.IOException;


import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private Label HomeLabel, MenuLabel, OrderLabel, LoginLabel, AmericanaLabel, SpecialLabel, PizzaLabel;

    @FXML
    private AnchorPane AnchorPaneImage;

    @FXML
    private ImageView image1, image2, image3;

    @FXML
    private Button loginButton,AboutButton,MenuButton,OrderButton, ProfileButton, Image2Button,image1Button;
    @FXML
    Text description;

    private static pizzaHome pizza1 = new pizzaHome();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Home Initialization
        HomeLabel.setText("ABOUT");

        MenuLabel.setText("MENU");

        OrderLabel.setText("ORDER");

        LoginLabel.setText("LOGIN");

        SpecialLabel.setText("SPECIAL");

        PizzaLabel.setText("PIZZA");

        AmericanaLabel.setText("AMERICANA");

        // Background and Two Product Image

        pizza1.setProductImage("images/Rectangle 9.png");
        Image Pizza2 = new Image(pizza1.getProductImage());
        image2.setImage(Pizza2);

        pizza1.setProductImage("images/Rectangle 11.png");
        Image Pizza3 = new Image(pizza1.getProductImage());
        image3.setImage(Pizza3);
    } 
    public void ABOUT(ActionEvent e){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), AnchorPaneImage);
        boolean AboutButton = true;
     if (AboutButton) {
            try {
                // Load the About.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/About.fxml"));
                Parent root = loader.load();

                // Create a new stage and set the AboutScene as its scene
                Image icons = new Image("images/pizzaLogo-removebg-preview.png");
                Stage aboutStage = new Stage();
                aboutStage.getIcons().add(icons);
                aboutStage.setTitle("PIZZERIA - About");                
                aboutStage.setScene(new Scene(root));

                // Show the AboutScene
                aboutStage.show();

                // Hide the current scene (assuming the button is in the current scene)
                Node source = (Node) e.getSource();
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

    public void LoginPage(ActionEvent e) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), AnchorPaneImage);

        // For example, let's assume the login is valid if a certain condition is true
        boolean isValidLogin = true; // Replace with your actual validation logic
        if (isValidLogin) {
            try {
                // Load the LoginScene.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
                Parent root = loader.load();

                // Create a new stage and set the LoginScene as its scene
                Image icons = new Image("images/pizzaLogo-removebg-preview.png");
                Stage loginStage = new Stage();
                loginStage.getIcons().add(icons);
                loginStage.setTitle("PIZZERIA - Login");
                loginStage.setScene(new Scene(root));
                
                // Show the LoginScene
                loginStage.show();
                

                // Hide the current scene (assuming the button is in the current scene)
                Node source = (Node) e.getSource();
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
    public void MenuButtonGoingToLogin(ActionEvent event){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), AnchorPaneImage);

        // For example, let's assume the login is valid if a certain condition is true
        boolean MenuButton = true; // Replace with your actual validation logic
        if (MenuButton) {
            try {
                // Load the LoginScene.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
                Parent root = loader.load();

                // Create a new stage and set the LoginScene as its scene
                Image icons = new Image("images/pizzaLogo-removebg-preview.png");
                Stage loginStage = new Stage();
                loginStage.getIcons().add(icons);
                loginStage.setTitle("PIZZERIA - Login");
                loginStage.setScene(new Scene(root));
                
                // Show the LoginScene
                loginStage.show();
                

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
    public void OrderButtonGoingToLogin(ActionEvent event){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), AnchorPaneImage);

        // For example, let's assume the login is valid if a certain condition is true
        boolean OrderButton = true; // Replace with your actual validation logic
        if (OrderButton) {
            try {
                // Load the LoginScene.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
                Parent root = loader.load();

                // Create a new stage and set the LoginScene as its scene
                Image icons = new Image("images/pizzaLogo-removebg-preview.png");
                Stage loginStage = new Stage();
                loginStage.getIcons().add(icons);
                loginStage.setTitle("PIZZERIA - Login");
                loginStage.setScene(new Scene(root));
                
                // Show the LoginScene
                loginStage.show();
                

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
    public void profileButton(ActionEvent event) {
    //profileButton
    FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), AnchorPaneImage);
    boolean profileButton = true;
    if (profileButton) {
        try {
            // Load the Settings.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
            Parent root = loader.load();

            // Create a new stage and set the Settings as its scene
            Stage aboutStage = new Stage();
            Image icon = new Image("images/pizzaLogo-removebg-preview.png");
            aboutStage.getIcons().add(icon);
            aboutStage.setTitle("PIZZERIA - Login");
            aboutStage.setScene(new Scene(root));

            // Show the Settings
            aboutStage.show();

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
    public void goingtologin(ActionEvent event){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), AnchorPaneImage);
        boolean image1Button = true;
        if (image1Button) {
        try {
            // Load the Settings.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
            Parent root = loader.load();

            // Create a new stage and set the Settings as its scene
            Stage aboutStage = new Stage();
            Image icon = new Image("images/pizzaLogo-removebg-preview.png");
            aboutStage.getIcons().add(icon);
            aboutStage.setTitle("PIZZERIA - Login");
            aboutStage.setScene(new Scene(root));

            // Show the Settings
            aboutStage.show();

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
    public void goingToLoginImage2 (ActionEvent event){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), AnchorPaneImage);
        boolean Image2Button = true;
        if (Image2Button) {
        try {
            // Load the Settings.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
            Parent root = loader.load();

            // Create a new stage and set the Settings as its scene
            Stage aboutStage = new Stage();
            Image icon = new Image("images/pizzaLogo-removebg-preview.png");
            aboutStage.getIcons().add(icon);
            aboutStage.setTitle("PIZZERIA - Login");
            aboutStage.setScene(new Scene(root));

            // Show the Settings
            aboutStage.show();

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
