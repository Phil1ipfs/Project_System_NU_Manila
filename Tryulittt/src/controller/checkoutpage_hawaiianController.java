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

public class checkoutpage_hawaiianController implements Initializable{

    @FXML
    private ImageView Cbg13, Cbg14, Cpimg7;

    @FXML
    private Label Cpname7, Cpprice7, Cslices7, Cins7; 

    @FXML
    private Text Cdes7;

    @FXML
    private ChoiceBox <String> Ccbox7;
    private String [] slices12 = {"6 Slices", "8 Slices", "12 Slices", "Custom"};
    @FXML
    private TextArea Ctxtbox7;

    @FXML
    private Button Ccheckoutbtn7;

    @FXML
    private AnchorPane Ap9;

    @FXML
    private Pane Cp7;

    FXMLLoader loader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Cpname7.setText("Classic Hawaiian Pizza Americana");
        Cpprice7.setText("₱557");
        Image hawainnimage = new Image("images/IMG7.png");
        Cpimg7.setImage(hawainnimage);

        Ccbox7.getItems().addAll(slices12);
        Ccbox7.setOnAction(arg0 -> getSlices2(arg0));
  
    }
    public void getSlices2(ActionEvent event){
        String myslices12 = Ccbox7.getValue();
        ReceiptController.PizzSlice12 = myslices12;    
    }
    public void HawaiannChekout(ActionEvent event){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap9);
    // ReceiptController.margaritaLabel = Cpname2.getText();
        boolean Ccheckoutbtn7 = true;
        ReceiptController.HAWAINIMAGE = Cpimg7.getImage();
        ReceiptController.hawainprice =Cpprice7.getText();
        ReceiptController.hawainname = Cpname7.getText();
        ReceiptController.mytextarea12 = Ctxtbox7.getText();
        // System.out.println(ReceiptController.MargaritaLabel);
        if (Ccheckoutbtn7) {
            
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
