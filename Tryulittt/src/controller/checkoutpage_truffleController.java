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

public class checkoutpage_truffleController implements Initializable{

    @FXML
    private ImageView Cbg9, Cbg10, Cpimg5;

    @FXML
    private Label Cpname5, Cpprice5, Cslices5, Cins5; 

    @FXML
    private Text Cdes5;

    @FXML
    private ChoiceBox < String > Ccbox5;
    private String [] slices5 = {"6 Slices", "8 Slices", "12 Slices", "Custom"};
    @FXML
    private TextArea ctxtbox5;

    @FXML
    private Button Ccheckoutbtn5;

    @FXML
    private AnchorPane Ap7;

    @FXML
    private Pane Cp5;

    FXMLLoader loader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Classic Truffle Four Cheese Pizza Americana
        Cpprice5.setText("\u20B1555");
        Cpname5.setText("Classic Truffle Four Cheese Pizza Americana");
        Ccbox5.getItems().addAll(slices5);
        Ccbox5.setOnAction(arg0 -> getSlices2(arg0));
        Image truflImage = new Image("images/IMG5.png");
        Cpimg5.setImage(truflImage);
  
    }
    public void getSlices2(ActionEvent event){
        String myslices5 = Ccbox5.getValue();
        ReceiptController.PizzSlice5 = myslices5;
    }
    public void truffleCheckout(ActionEvent event){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap7);
    // ReceiptController.margaritaLabel = Cpname2.getText();
        boolean Ccheckoutbtn5 = true;
        ReceiptController.Imagetuffle = Cpimg5.getImage();
        ReceiptController.tuffle = Cpname5.getText();
        ReceiptController.Tuffleprice = Cpprice5.getText();
        ReceiptController.mytextarea5 = ctxtbox5.getText();
        // System.out.println(ReceiptController.MargaritaLabel);
        if (Ccheckoutbtn5) {
            
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
