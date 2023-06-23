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

public class checkoutpage_spinachController implements Initializable{

    @FXML
    private ImageView Cbg1, Cbg2, Cpimg1;

    @FXML
    private Label Cpname1, Cpprice1, Cslices1, Cins1; 

    @FXML
    private Text Cdes1;

    @FXML
    private ChoiceBox <String> Ccbox1;
    private String [] slice ={"6 Slices", "8 Slices", "12 Slices", "Custom"};

    @FXML
    private TextArea Ctxtbox1;

    @FXML
    private Button Ccheckoutbtn1;

    @FXML
    private AnchorPane Ap3;

    @FXML
    private Pane Cp1;

    FXMLLoader loader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Cdes1.setText("Introducing the Classic Spinach Pizza Americana, a culinary masterpiece that combines timeless flavors with a modern twist. Savor the perfect harmony of zesty tomato sauce, melty mozzarella cheese, and generous portions of vibrant spinach, creating an irresistible symphony of taste that will transport your palate to pizza perfection.");
        Cpname1.setText("Classic Spinach Pizza Americana");
        Cpprice1.setText("\u20B1551");

        Image imagespinach = new Image("images/IMG1.png");
        Cpimg1.setImage(imagespinach);

        Ccbox1.getItems().addAll(slice);
        Ccbox1.setOnAction(arg0 -> getSlice(arg0));
  
    }
    public void getSlice(ActionEvent event){
        String myslice = Ccbox1.getValue();
        ReceiptController.PizzSlice = myslice;

    }
    public void CheckoutSpinach(ActionEvent event){
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap3);
        // ReceiptController.priceLabel1 = Cpname1.getText();
        boolean Ccheckoutbtn1 = true;
        ReceiptController.SPINACHIMAGES = Cpimg1.getImage();
        ReceiptController.spinachprice = Cpprice1.getText();
        ReceiptController.SpinachLabel1 = Cpname1.getText();
        ReceiptController.mytextarea1 = Ctxtbox1.getText();
        if (Ccheckoutbtn1) {
            
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
