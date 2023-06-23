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

public class checkoutpage_chickenbbqController implements Initializable{

    @FXML
    private ImageView Cbg21, Cbg22, Cpimg11;

    @FXML
    private Label Cpname11, Cpprice11, Cslices11, Cins11; 

    @FXML
    private Text Cdes11;

    @FXML
    private ChoiceBox <String> Ccbox11;
     private String [] slices11 = {"6 Slices", "8 Slices", "12 Slices", "Custom"};
    @FXML
    private TextArea Ctxtbox11;

    @FXML
    private Button Ccheckoutbtn11;

    @FXML
    private AnchorPane Ap13;

    @FXML
    private Pane Cp11;

    FXMLLoader loader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Cpname11.setText("Classic Chicken BBQ Pizza Americana");
        Cpprice11.setText("\u20B1561");
        Image bbqImage = new Image("images/IMG11.png");
        Cpimg11.setImage(bbqImage);
        Ccbox11.getItems().addAll(slices11);
        Ccbox11.setOnAction(arg0 -> getSlices2(arg0));
  
    }
    public void getSlices2(ActionEvent event){
        String myslices11 = Ccbox11.getValue();
        ReceiptController.PizzSlice11 = myslices11;
    }
    public void chikenbbqCheckout(ActionEvent event){
    FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap13);
    // ReceiptController.margaritaLabel = Cpname2.getText();
        boolean Ccheckoutbtn11 = true;
        ReceiptController.BBQIMAGE= Cpimg11.getImage();
        ReceiptController.bbqprice =Cpprice11.getText();
        ReceiptController.bbqname = Cpname11.getText();
        ReceiptController.mytextarea11 = Ctxtbox11.getText();
        // System.out.println(ReceiptController.MargaritaLabel);
        if (Ccheckoutbtn11) {
            
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
