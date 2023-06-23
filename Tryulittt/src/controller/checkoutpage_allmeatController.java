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

public class checkoutpage_allmeatController implements Initializable{

    @FXML
    private ImageView Cbg19, Cbg20, Cpimg10;

    @FXML
    private Label Cpname10, Cpprice10, Cslices10, Cins10; 

    @FXML
    private Text Cdes10;

    @FXML
    private ChoiceBox <String> Ccbox10;
    private String [] slices10 = {"6 Slices", "8 Slices", "12 Slices", "Custom"};
    @FXML
    private TextArea Ctxtbox10;

    @FXML
    private Button Ccheckoutbtn10;

    @FXML
    private AnchorPane Ap12;

    @FXML
    private Pane Cp10;

    FXMLLoader loader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Cpprice10.setText("\u20B1560");
        Cpname10.setText("Classic All-Meat Pizza Americana");
        Image imageallmeat = new Image ("images/IMG10.png");
        Cpimg10.setImage(imageallmeat);
        Ccbox10.getItems().addAll(slices10);
        Ccbox10.setOnAction(arg0 -> getSlices2(arg0));
  
    }
    public void getSlices2(ActionEvent event){
        String myslices10 = Ccbox10.getValue();
        ReceiptController.PizzSlice10 = myslices10;
    }
    public void AllmeatCheckout(ActionEvent event){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap12);
    // ReceiptController.margaritaLabel = Cpname2.getText();
        boolean Ccheckoutbtn10 = true;
        ReceiptController.IMAGEALLMEAT = Cpimg10.getImage();
        ReceiptController.allmeatprice =Cpprice10.getText();
        ReceiptController.allmeatname = Cpname10.getText();
        ReceiptController.mytextarea10 = Ctxtbox10.getText();
        if (Ccheckoutbtn10) {
            
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
