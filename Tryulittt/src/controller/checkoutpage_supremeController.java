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

public class checkoutpage_supremeController implements Initializable{

    @FXML
    private ImageView Cbg23, Cbg24, Cpimg12;

    @FXML
    private Label Cpname12, Cpprice12, Cslices12, Cins12; 

    @FXML
    private Text Cdes12;

    @FXML
    private ChoiceBox <String> Ccbox12;
    private String [] slices4 = {"6 Slices", "8 Slices", "12 Slices", "Custom"};
    @FXML
    private TextArea Ctxtbox12;

    @FXML
    private Button Ccheckoutbtn12;

    @FXML
    private AnchorPane Ap14;

    @FXML
    private Pane Cp12;

    FXMLLoader loader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Cpprice12.setText("\u20B1562");
        Cpname12.setText("Classic Supreme Pizza Americana"); 
        Ccbox12.getItems().addAll(slices4);
        Ccbox12.setOnAction(arg0 -> getSlices2(arg0));
        Image imagesupreme = new Image("images/IMG12.png");
        Cpimg12.setImage(imagesupreme);
  
    }
    public void getSlices2(ActionEvent event){
        String myslices4 = Ccbox12.getValue();
        ReceiptController.PizzSlice4 = myslices4;
    }
    public void GoingToSupremeOrder(ActionEvent event){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap14);
    // ReceiptController.margaritaLabel = Cpname2.getText();
        boolean Ccheckoutbtn12 = true;
        ReceiptController.imagesupreme = Cpimg12.getImage();
        ReceiptController.Supreme = Cpname12.getText();
        ReceiptController.Supremeprice = Cpprice12.getText();
        ReceiptController.mytextarea4 = Ctxtbox12.getText();
        // System.out.println(ReceiptController.MargaritaLabel);
        if (Ccheckoutbtn12) {
            
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
