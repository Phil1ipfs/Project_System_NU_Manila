package controller;

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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class pageoneController implements Initializable{

    @FXML
    private ImageView bgimg1, bgimg2, Pimg1, Pimg2, Pimg3, Pimg4, Pimg5, Pimg6, crt1, crt2, crt3, crt4, crt5, crt6;

    @FXML
    private Label Pname1, Pprice1, Pname2, Pprice2, Pname3, Pprice3, Pname4, Pprice4, Pname5, Pprice5, Pname6, Pprice6;

    @FXML
    private Button LogoButton,Checkoutbtn1, Checkoutbtn2, Checkoutbtn3, Checkoutbtn4, Checkoutbtn5, Checkoutbtn6, Nextpgbtn1, Nextpgbtn2;

    @FXML
    private AnchorPane Ap1, Ap2,AnchorePane3;

    @FXML
    private Pane P1;

    FXMLLoader loader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    public void Spinach(ActionEvent event) throws IOException{
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap2);
        boolean Checkoutbtn1 = true;
     if (Checkoutbtn1) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/checkoutpage_spinach.fxml"));
                Parent root = loader.load();

                Image icons = new Image("images/Icon.png");
                Stage PagetwoStage= new Stage();
                PagetwoStage.getIcons().add(icons);
                PagetwoStage.setTitle("PIZZERIA - CHECKOUT");              
                PagetwoStage.setScene(new Scene(root));

                PagetwoStage.show();

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

    public void Margherita(ActionEvent event) throws IOException{
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap2);
        boolean Checkoutbtn2 = true;
     if (Checkoutbtn2) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/checkoutpage_margherita.fxml"));
                Parent root = loader.load();

                Image icons = new Image("images/Icon.png");
                Stage PagetwoStage= new Stage();
                PagetwoStage.getIcons().add(icons);
                PagetwoStage.setTitle("PIZZERIA - CHECKOUT");              
                PagetwoStage.setScene(new Scene(root));

                PagetwoStage.show();

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

    public void Cheese(ActionEvent event) throws IOException{
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap2);
        boolean Checkoutbtn3 = true;
     if (Checkoutbtn3) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/checkoutpage_cheese.fxml"));
                Parent root = loader.load();

                Image icons = new Image("images/Icon.png");
                Stage PagetwoStage= new Stage();
                PagetwoStage.getIcons().add(icons);
                PagetwoStage.setTitle("PIZZERIA - CHECKOUT");              
                PagetwoStage.setScene(new Scene(root));

                PagetwoStage.show();

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

    public void Pepperoni(ActionEvent event) throws IOException{
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap2);
        boolean Checkoutbtn4 = true;
     if (Checkoutbtn4) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/checkoutpage_pepperoni.fxml"));
                Parent root = loader.load();

                Image icons = new Image("images/Icon.png");
                Stage PagetwoStage= new Stage();
                PagetwoStage.getIcons().add(icons);
                PagetwoStage.setTitle("PIZZERIA - CHECKOUT");              
                PagetwoStage.setScene(new Scene(root));

                PagetwoStage.show();

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

    public void Truffle(ActionEvent event) throws IOException{
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap2);
        boolean Checkoutbtn5 = true;
     if (Checkoutbtn5) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/checkoutpage_truffle.fxml"));
                Parent root = loader.load();

                Image icons = new Image("images/Icon.png");
                Stage PagetwoStage= new Stage();
                PagetwoStage.getIcons().add(icons);
                PagetwoStage.setTitle("PIZZERIA - CHECKOUT");              
                PagetwoStage.setScene(new Scene(root));

                PagetwoStage.show();

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

    public void Sshrimp(ActionEvent event) throws IOException{
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap2);
        boolean Ccheckoutbtn6 = true;
     if (Ccheckoutbtn6) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/checkoutpage_sshrimp.fxml"));
                Parent root = loader.load();

                Image icons = new Image("images/Icon.png");
                Stage PagetwoStage= new Stage();
                PagetwoStage.getIcons().add(icons);
                PagetwoStage.setTitle("PIZZERIA - CHECKOUT");              
                PagetwoStage.setScene(new Scene(root));

                PagetwoStage.show();

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

    public void Pagetwo(ActionEvent event) throws IOException{
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap2);
        boolean Nextpgbtn2 = true;
     if (Nextpgbtn2) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/menu_pagetwo.fxml"));
                Parent root = loader.load();

                Image icons = new Image("images/Icon.png");
                Stage PagetwoStage= new Stage();
                PagetwoStage.getIcons().add(icons);
                PagetwoStage.setTitle("PIZZERIA - MENU");                
                PagetwoStage.setScene(new Scene(root));

                PagetwoStage.show();

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
    public void MenuGoingToHomepage(ActionEvent event){
         FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), AnchorePane3);

            boolean LogoButton = true;
            if (LogoButton) {
            try {
                // Load the LoginScene.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HomePage.fxml"));
                Parent root = loader.load();

                // Create a new stage and set the LoginScene as its scene
                Stage HomeStage = new Stage();
                Image icon = new Image("images/pizzaLogo-removebg-preview.png");
                HomeStage.getIcons().add(icon);
                HomeStage.setTitle("PIZZERIA - HomePage");  
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
    public void PagetwoLeft(ActionEvent event) throws IOException{
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap2);
        boolean Nextpgbtn1 = true;
     if (Nextpgbtn1) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/menu_pagetwo.fxml"));
                Parent root = loader.load();

                Image icons = new Image("images/Icon.png");
                Stage PagetwoStage= new Stage();
                PagetwoStage.getIcons().add(icons);
                PagetwoStage.setTitle("PIZZERIA - MENU");                
                PagetwoStage.setScene(new Scene(root));

                PagetwoStage.show();

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
