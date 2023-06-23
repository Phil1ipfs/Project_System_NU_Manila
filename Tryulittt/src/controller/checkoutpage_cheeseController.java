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

public class checkoutpage_cheeseController implements Initializable{

    @FXML
    private ImageView Cbg5, Cbg6, Cpimg3;

    @FXML
    private Label Cpname3, Cpprice3, Cslices3, Cins3; 

    @FXML
    private Text Cdes3;

    @FXML
    private ChoiceBox <String> Ccbox3;
    private String [] slices3 = {"6 Slices", "8 Slices", "12 Slices", "Custom"};
    @FXML
    private TextArea Ctxtbox3;

    @FXML
    private Button Ccheckoutbtn3;

    @FXML
    private AnchorPane Ap5;

    @FXML
    private Pane Cp3;

    FXMLLoader loader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Cpprice3.setText("\u20B1553");
        Cpname3.setText("Classic Cheese Pizza Americana");
        Image imagecheese = new Image("images/IMG3.png");
        Cpimg3.setImage(imagecheese);
        Ccbox3.getItems().addAll(slices3);
        Ccbox3.setOnAction(arg0 -> getSlices2(arg0));
  
    }
    public void getSlices2(ActionEvent event){
        String myslices3 = Ccbox3.getValue();
        ReceiptController.PizzSlice3 = myslices3;
    }
    public void Anothercheese(ActionEvent event){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap5);
    // ReceiptController.margaritaLabel = Cpname2.getText();
        boolean Ccheckoutbtn3 = true;
        ReceiptController.CHEESEIMAGE = Cpimg3.getImage();
        ReceiptController.cheeseprice =Cpprice3.getText();
        ReceiptController.CheeseLabel = Cpname3.getText();
        ReceiptController.mytextarea3 = Ctxtbox3.getText();
        // System.out.println(ReceiptController.MargaritaLabel);
        if (Ccheckoutbtn3) {
            
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
