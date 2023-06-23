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

public class checkoutpage_pestoController implements Initializable{

    @FXML
    private ImageView Cbg17, Cbg18, Cpimg9;

    @FXML
    private Label Cpname9, Cpprice9, Cslices9, Cins9; 

    @FXML
    private Text Cdes9;

    @FXML
    private ChoiceBox <String> Ccbox9;
    private String [] slices14 = {"6 Slices", "8 Slices", "12 Slices", "Custom"};
    @FXML
    private TextArea Ctxtbox9;

    @FXML
    private Button Ccheckoutbtn9;

    @FXML
    private AnchorPane Ap11;

    @FXML
    private Pane Cp9;

    FXMLLoader loader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Cpname9.setText("Classic Pesto Pizza Americana");
        Cpprice9.setText("\u20B1559");
        Ccbox9.getItems().addAll(slices14);
        Ccbox9.setOnAction(arg0 -> getSlices2(arg0));
        Image imagepesto = new Image("images/IMG9.png");
        Cpimg9.setImage(imagepesto);
  
    }
    public void getSlices2(ActionEvent event){
        String myslices16 = Ccbox9.getValue();
        ReceiptController.PizzSlice116 = myslices16; 
    }
    public void pestoCheckout(ActionEvent event){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Cp9);
        // ReceiptController.priceLabel1 = Cpname1.getText();
        boolean Ccheckoutbtn9 = true;
        ReceiptController.PestoImage = Cpimg9.getImage();
        ReceiptController.pestoprice = Cpprice9.getText();
        ReceiptController.pestoLabel1 = Cpname9.getText();
        ReceiptController.mytextarea16 = Ctxtbox9.getText();
        if (Ccheckoutbtn9) {
            
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
