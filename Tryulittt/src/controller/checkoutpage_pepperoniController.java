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

public class checkoutpage_pepperoniController implements Initializable{

    @FXML
    private ImageView Cbg7, Cbg8, Cpimg4;

    @FXML
    private Label Cpname4, Cpprice4, Cslices4, Cins4; 

    @FXML
    private Text Cdes4;

    @FXML
    private ChoiceBox <String> Ccbox4;
    private String [] slices13 = {"6 Slices", "8 Slices", "12 Slices", "Custom"};
    @FXML
    private TextArea Ctxtbox4;

    @FXML
    private Button Ccheckoutbtn4;
    
    @FXML
    private AnchorPane Ap6;

    @FXML
    private Pane Cp1;

    FXMLLoader loader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Cpname4.setText("Classic Pepperoni Pizza Americana");
        Cpprice4.setText("\u20B1554");
        Ccbox4.getItems().addAll(slices13);
        Ccbox4.setOnAction(arg0 -> getSlices2(arg0));
        Image PEPERONI = new Image("images/IMG4.png");
        Cpimg4.setImage(PEPERONI);
  
    }
    public void getSlices2(ActionEvent event){
        String myslices2 = Ccbox4.getValue();
        ReceiptController.PizzSlice13 = myslices2;    
    }
    public void pepperinoCheckout(ActionEvent event){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap6);
    // ReceiptController.margaritaLabel = Cpname2.getText();
        boolean Ccheckoutbtn4 = true;
        ReceiptController.Imagepeperoni = Cpimg4.getImage();
        ReceiptController.pepperoniprice = Cpprice4.getText();
        ReceiptController.pepperoniLabel = Cpname4.getText();
        ReceiptController.mytextarea13 = Ctxtbox4.getText();
        // System.out.println(ReceiptController.MargaritaLabel);
        if (Ccheckoutbtn4) {
            
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
