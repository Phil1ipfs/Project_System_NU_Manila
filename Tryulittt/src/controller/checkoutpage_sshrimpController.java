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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class checkoutpage_sshrimpController implements Initializable{

    @FXML
    private ImageView Cbg11, Cbg12, Cpimg6;

    @FXML
    private Label Cpname6, Cpprice6, Cslices6, Cins6; 

    @FXML
    private Text Cdes6;

    @FXML
    private ChoiceBox <String> Ccbox6;
    private String [] slices15 = {"6 Slices", "8 Slices", "12 Slices", "Custom"};
    @FXML
    private TextArea Ctxtbox6;
    @FXML
    ImageView Imageshrimp;

    @FXML
    private Button Ccheckoutbtn6;

    @FXML
    private AnchorPane Ap8;

    @FXML
    private Pane Cp6;

    FXMLLoader loader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Cpname6.setText("Classic Spinach & Shrimp Pizza Americana");
        Cpprice6.setText("\u20B1556");
        Ccbox6.getItems().addAll(slices15);
        Ccbox6.setOnAction(arg0 -> getSlice(arg0));
        Image SHRIMP = new Image("images/IMG6.png");
        Imageshrimp.setImage(SHRIMP);
  
    }
    public void getSlice(ActionEvent event){
        String myslice = Ccbox6.getValue();
        ReceiptController.PizzSlice15 = myslice;
    }
    public void shrimpCheckout(ActionEvent event){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap8);
        // ReceiptController.priceLabel1 = Cpname1.getText();
        boolean Ccheckoutbtn6 = true;
        ReceiptController.shrimppic = Imageshrimp.getImage();
        ReceiptController.shrimpprice = Cpprice6.getText();
        ReceiptController.shrimpLabel15 = Cpname6.getText();
        ReceiptController.mytextarea15 = Ctxtbox6.getText();
        if (Ccheckoutbtn6) {
            
            try {
                // Load the About.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Payment.fxml"));
                Parent root = loader.load();

                // Create a new stage and set the AboutScene as its scene
                Image icons = new Image("images/pizzaLogo-removebg-preview.png");
                Stage CheckoutStage = new Stage();
                CheckoutStage.getIcons().add(icons);
                CheckoutStage.setTitle("PIZZERIA - About");                
                CheckoutStage.setScene(new Scene(root));

                // Show the AboutScene
                CheckoutStage.show();

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
