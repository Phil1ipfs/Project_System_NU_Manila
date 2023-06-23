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

public class checkoutpage_margheritaController implements Initializable{

    @FXML
    private ImageView Cbg3, Cbg4, Cpimg2;

    @FXML
    private Label Cpname2, Cpprice2, Cslices2, Cins2; 

    @FXML
    private Text Cdes2;

    @FXML
    private ChoiceBox <String> Ccbox2;
    private String [] slices2 = {"6 Slices", "8 Slices", "12 Slices", "Custom"};
    @FXML
    private TextArea Ctxtbox2;

    @FXML
    private Button Ccheckoutbtn2;

    @FXML
    private AnchorPane Ap4;

    @FXML
    private Pane Cp2;

    FXMLLoader loader;

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Classic Margherita Pizza Americana
        Cpprice2.setText("\u20B1552");
        Cpname2.setText("Classic Margherita Pizza Americana");
        Image Imagemargharita = new Image("images/IMG2.png");
        Cpimg2.setImage(Imagemargharita);

        Ccbox2.getItems().addAll(slices2);
        Ccbox2.setOnAction(arg0 -> getSlices2(arg0));

    }
    public void getSlices2(ActionEvent event){
        String myslices2 = Ccbox2.getValue();
        ReceiptController.PizzSlice2 = myslices2;    
    }
    public void Magarita(ActionEvent event){
    FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), Ap4);
    // ReceiptController.margaritaLabel = Cpname2.getText();
        boolean Ccheckoutbtn2 = true;
        ReceiptController.MARGHARITAIMAGE = Cpimg2.getImage();
        ReceiptController.margaritaprice = Cpprice2.getText();
        ReceiptController.MargaritaLabel = Cpname2.getText();
        ReceiptController.mytextarea2 = Ctxtbox2.getText();
        // System.out.println(ReceiptController.MargaritaLabel);
        if (Ccheckoutbtn2) {
            
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
