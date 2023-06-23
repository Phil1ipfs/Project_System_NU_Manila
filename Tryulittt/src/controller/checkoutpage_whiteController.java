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

public class checkoutpage_whiteController implements Initializable{

    @FXML
    private ImageView Cbg15, Cbg16, Cpimg8;

    @FXML
    private Label Cpname8, Cpprice8, Cslices8, Cins8; 

    @FXML
    private Text Cdes8;

    @FXML
    private ChoiceBox <String> Ccbox8;
    private String [] slices6 = {"6 Slices", "8 Slices", "12 Slices", "Custom"};
    @FXML
    private TextArea Ctxtbox8;

    @FXML
    private Button WhiteCheckoutButton;

    @FXML
    private AnchorPane Ap10;

    @FXML
    private Pane Cp8;

    FXMLLoader loader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Cpname8.setText("Classic White Pizza Americana");
        Cpprice8.setText("\u20B1558");
        Ccbox8.getItems().addAll(slices6);
        Ccbox8.setOnAction(arg0 -> getSlices2(arg0));
        Image whiteImage = new Image("images/IMG8.png");
        Cpimg8.setImage(whiteImage);
    }
    public void getSlices2(ActionEvent event){
        String myslices6 = Ccbox8.getValue();
        ReceiptController.PizzSlice6 = myslices6;

    }
    public void whiteCheckout(ActionEvent event){
         FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap10);
    // ReceiptController.margaritaLabel = Cpname2.getText();
        boolean WhiteCheckoutButton = true;
        ReceiptController.imagewhite = Cpimg8.getImage();
        ReceiptController.White = Cpname8.getText();
        ReceiptController.Whiteprice = Cpprice8.getText();
        ReceiptController.mytextarea6 = Ctxtbox8.getText();
        // System.out.println(ReceiptController.MargaritaLabel);
        if (WhiteCheckoutButton) {
            
            try {
                // Load the About.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Payment.fxml"));
                Parent root = loader.load();

                // Create a new stage and set the AboutScene as its scene
                Image icons = new Image("images/pizzaLogo-removebg-preview.png");
                Stage CheckoutStage = new Stage();
                CheckoutStage.getIcons().add(icons);
                CheckoutStage.setTitle("PIZZERIA - Checkout");                
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
