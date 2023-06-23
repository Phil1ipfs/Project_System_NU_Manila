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

public class pagetwoController implements Initializable{

    @FXML
    private ImageView bgimg3, bgimg4, Pimg7, Pimg8, Pimg9, Pimg10, Pimg11, Pimg12, crt7, crt8, crt9, crt10, crt11, crt12;

    @FXML
    private Label Pname7, Pprice7, Pname8, Pprice8, Pname9, Pprice9, Pname10, Pprice10, Pname11, Pprice11, Pname12, Pprice12;

    @FXML
    private Button Checkoutbtn7, Checkoutbtn8, Checkoutbtn9, Checkoutbtn10, Checkoutbtn11, Checkoutbtn12, Nextpgbtn3, Nextpgbtn4;

    @FXML
    private AnchorPane Ap2;

    @FXML
    private Pane P2;

    FXMLLoader loader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void Hawaiian(ActionEvent event) throws IOException{
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap2);
        boolean Checkoutbtn7 = true;
     if (Checkoutbtn7) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/checkoutpage_hawaiian.fxml"));
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

    public void White(ActionEvent event) throws IOException{
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap2);
        boolean Checkoutbtn8 = true;
     if (Checkoutbtn8) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/checkoutpage_white.fxml"));
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

    public void Pesto(ActionEvent event) throws IOException{
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap2);
        boolean Checkoutbtn9 = true;
     if (Checkoutbtn9) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/checkoutpage_pesto.fxml"));
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

    public void Allmeat(ActionEvent event) throws IOException{
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap2);
        boolean Checkoutbtn10 = true;
     if (Checkoutbtn10) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/checkoutpage_allmeat.fxml"));
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

    public void Chickenbbq(ActionEvent event) throws IOException{
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap2);
        boolean Checkoutbtn11 = true;
     if (Checkoutbtn11) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/checkoutpage_chickenbbq.fxml"));
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

     public void Supreme(ActionEvent event) throws IOException{
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap2);
        boolean Checkoutbtn12 = true;
     if (Checkoutbtn12) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/checkoutpage_Supreme.fxml"));
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

    public void Pageone(ActionEvent event) throws IOException{
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap2);
            boolean Nextpgbtn3 = true;
            if (Nextpgbtn3) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/menu_pageone.fxml"));
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
    public void GiongToPageOne(ActionEvent event){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap2);
        boolean Nextpgbtn4 = true;
        if (Nextpgbtn4) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/menu_pageone.fxml"));
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
