package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.animation.FadeTransition;
import javafx.util.Duration;

public class SettingsController implements Initializable{
    @FXML
    AnchorPane Anchorpane3,anchorpane6;
    @FXML
    Text profileNameText,profileEmailText, profilePasswordText,profileMobileNo;
    @FXML
    Button LogoHomepage;

    static String emailInfo;
    static String usernameInfo;
    static String passwordInfo;
    static String mobileInfo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        profileNameText.setText(usernameInfo);
        profileEmailText.setText(emailInfo);
        profilePasswordText.setText(passwordInfo);
        profileMobileNo.setText(mobileInfo);
    }
    public void BackToHomePage(ActionEvent event){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), anchorpane6);
        boolean LogoHomepage = true;
        if (LogoHomepage) {
            
            try {
                // Load the Settings.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HomePage.fxml"));
                Parent root = loader.load();

                // Create a new stage and set the Settings as its scene
                Stage HomePageStage = new Stage();
                Image icon = new Image("images/pizzaLogo-removebg-preview.png");
                HomePageStage.getIcons().add(icon);
                HomePageStage.setTitle("PIZZERIA - Home Page");  
                HomePageStage.setScene(new Scene(root));

                // Show the Settings
                HomePageStage.show();

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
        public void LOGOUTDOOR(ActionEvent event){
        
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), anchorpane6);

            boolean doorButton= true;
            if (doorButton) {
                showAlert("Logout", "Are you sure you want to logout?");
            try {
                // Load the LoginScene.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Home.fxml"));
                Parent root = loader.load();

                // Create a new stage and set the LoginScene as its scene
                Stage LogoutDoorStage = new Stage();
                Image icon = new Image("images/pizzaLogo-removebg-preview.png");
                LogoutDoorStage.getIcons().add(icon);
                LogoutDoorStage.setTitle("PIZZERIA - Home");  
                LogoutDoorStage.setScene(new Scene(root));

                // Show the LoginScene
                LogoutDoorStage.show();

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
}
