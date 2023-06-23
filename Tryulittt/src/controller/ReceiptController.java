package controller;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Optional;

public class ReceiptController implements Initializable{

    @FXML
    Label mobileNumberLabel, forallLabel;
    @FXML
    static AnchorPane RecieptPane, forallpane;
    @FXML
    ImageView forallimage;
    @FXML
    Text intructionLabel;

    @FXML
    private Label forSlicesLabel,orderNumberLabel, houseNumberLabel, streetLabel, zipCodeLabel, cityLabel, 
    cardNumberLabel, dateLabel, Totalforprice;

    @FXML
    Button  checkoutButton, HomeButtons;

    static String SpinachLabel1;
    static String MargaritaLabel;
    static String CheeseLabel;
    static String Supreme;
    static String tuffle;
    static String White;
    static String allmeatname;
    static String bbqname;
    static String hawainname;
    static String pepperoniLabel;
    static String shrimpLabel15;
    static String pestoLabel1;

    static String PizzSlice;
    static String PizzSlice2;
    static String PizzSlice3;
    static String PizzSlice4;
    static String PizzSlice5;
    static String PizzSlice6;
    static String PizzSlice10;
    static String PizzSlice11;
    static String PizzSlice12;
    static String PizzSlice13;
    static String PizzSlice15;
    static String PizzSlice116;

    static String Supremeprice;
    static String Tuffleprice;
    static String Whiteprice;
    static String cheeseprice;
    static String margaritaprice;
    static String allmeatprice;
    static String spinachprice;
    static String bbqprice;
    static String hawainprice;
    static String pepperoniprice;
    static String shrimpprice;
    static String pestoprice;

    static String mytextarea1;
    static String mytextarea2;
    static String mytextarea3;
    static String mytextarea4;
    static String mytextarea5;
    static String mytextarea6;
    static String mytextarea10;
    static String mytextarea11;
    static String mytextarea12;
    static String mytextarea13;
    static String mytextarea15;
    static String mytextarea16;

    static Image shrimppic;
    static Image Imagepeperoni;
    static Image imagewhite;
    static Image Imagetuffle;
    static Image imagesupreme;
    static Image SPINACHIMAGES;
    static Image PestoImage;
    static Image MARGHARITAIMAGE;
    static Image HAWAINIMAGE;
    static Image BBQIMAGE;
    static Image CHEESEIMAGE;
    static Image IMAGEALLMEAT;

    public void setShippingInfo(String houseNumber, String street, String zipCode, String city, String mobileNumber) {
        houseNumberLabel.setText(capitalizeFirstLetter(houseNumber));
        streetLabel.setText(capitalizeFirstLetter(street));
        zipCodeLabel.setText(capitalizeFirstLetter(zipCode));
        cityLabel.setText(capitalizeFirstLetter(city));
        mobileNumberLabel.setText(capitalizeFirstLetter(mobileNumber));

        // Generate a random order number
        int orderNumber = generateOrderNumber();
        orderNumberLabel.setText(String.valueOf(orderNumber));

        // Set the current date
        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        dateLabel.setText(formattedDate);
    }

    public void setPaymentInfo(String cardNumber) {
        cardNumberLabel.setText(cardNumber);
    }

    @FXML
    public void handleBackToHomePageButton(ActionEvent event) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), RecieptPane);

            boolean HomeButtons = true;
            if (HomeButtons) {
            try {
                // Load the SignUpScene.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HomePage.fxml"));
                Parent root = loader.load();

                // Create a new stage and set the SignUpScene as its scene
                Stage HomePageStage = new Stage();
                Image icons = new Image("images/pizzaLogo-removebg-preview.png");
                HomePageStage.getIcons().add(icons);
                HomePageStage.setTitle("PIZZERIA - SignUp");  
                HomePageStage.setScene(new Scene(root));

                // Show the SignUpScene
                HomePageStage.show();

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

    @FXML
    private void handleCheckoutButton(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("We've prepared your mouthwatering pizza. It's now headed straight to your doorstep!");

        // Additional message
        String additionalMessage = "Thank you for ordering from our pizza store! We're grateful for your choice to satisfy your pizza cravings with us. \n"
                + "Our dedicated team is hard at work to prepare your mouthwatering pizza just the way you like it.\n"
                + "We can't wait for you to indulge in a delicious slice of cheesy goodness.\n"
                + "Your satisfaction is our priority, and we're honored to serve you.";
        Label additionalLabel = new Label(additionalMessage);

        ButtonType okButton = new ButtonType("OK");
        alert.getButtonTypes().setAll(okButton);

        // Set the expandable content of the alert
        alert.getDialogPane().setExpandableContent(additionalLabel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == okButton) {
            // Perform any additional actions after the user clicks "OK"
            // For example, you can perform some operations or update the UI without closing the receipt stage
            // ...
        }
    }
    private int generateOrderNumber() {
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }

    private String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }  
    @Override
  public void initialize(URL location, ResourceBundle resources) {

    // Set the label value based on the selected pizza
    if (SpinachLabel1 != null && PizzSlice != null && mytextarea1 != null && spinachprice != null && SPINACHIMAGES != null) {
      
        forallLabel.setText(SpinachLabel1);
        forSlicesLabel.setText(PizzSlice);
        intructionLabel.setText(mytextarea1);
        Totalforprice.setText(spinachprice);
        forallimage.setImage(SPINACHIMAGES);
    } else if (MargaritaLabel != null && PizzSlice2 != null && mytextarea2 != null && margaritaprice != null && MARGHARITAIMAGE != null) {
        forallLabel.setText(MargaritaLabel);
        forSlicesLabel.setText(PizzSlice2);
        intructionLabel.setText(mytextarea2);
        Totalforprice.setText(margaritaprice);
        forallimage.setImage(MARGHARITAIMAGE);
    } else if (CheeseLabel != null && PizzSlice3 != null && mytextarea3 != null && cheeseprice != null && CHEESEIMAGE != null) {
        forallLabel.setText(CheeseLabel);
        forSlicesLabel.setText(PizzSlice3);
        intructionLabel.setText(mytextarea3);
        Totalforprice.setText(cheeseprice);
        forallimage.setImage(CHEESEIMAGE);
    } else if (Supreme != null && PizzSlice4 != null && mytextarea4 != null && Supremeprice != null & imagesupreme != null) {
        forallLabel.setText(Supreme);
        forSlicesLabel.setText(PizzSlice4);
        intructionLabel.setText(mytextarea4);
        Totalforprice.setText(Supremeprice);
        forallimage.setImage(imagesupreme);
    } else if (tuffle != null && PizzSlice5 != null && mytextarea5 != null && Tuffleprice != null && Imagetuffle != null) {
        forallLabel.setText(tuffle);
        forSlicesLabel.setText(PizzSlice5);
        intructionLabel.setText(mytextarea5);
        Totalforprice.setText(Tuffleprice);
        forallimage.setImage(Imagetuffle);
    } else if (White != null && PizzSlice6 != null && mytextarea6 != null && Whiteprice != null && imagewhite != null) {
        forallLabel.setText(White);
        forSlicesLabel.setText(PizzSlice6);
        intructionLabel.setText(mytextarea6);
        Totalforprice.setText(Whiteprice);
        forallimage.setImage(imagewhite);
    } else if(allmeatname != null && PizzSlice10 != null && mytextarea10 != null && allmeatprice != null && IMAGEALLMEAT != null) {
        forallLabel.setText(allmeatname);
        forSlicesLabel.setText(PizzSlice10);
        intructionLabel.setText(mytextarea10);
        Totalforprice.setText(allmeatprice);
        forallimage.setImage(IMAGEALLMEAT);
    }else if(bbqname != null && PizzSlice11 != null && mytextarea11 != null && bbqprice != null && BBQIMAGE != null) {
        forallLabel.setText(bbqname);
        forSlicesLabel.setText(PizzSlice11);
        intructionLabel.setText(mytextarea11);
        Totalforprice.setText(bbqprice);
        forallimage.setImage(BBQIMAGE);
    }else if(hawainname != null && PizzSlice12 != null && mytextarea12 != null && hawainprice != null && HAWAINIMAGE != null) {
        forallLabel.setText(hawainname);
        forSlicesLabel.setText(PizzSlice12);
        intructionLabel.setText(mytextarea12);
        Totalforprice.setText(hawainprice);
        forallimage.setImage(HAWAINIMAGE);
    }else if(pepperoniLabel != null && PizzSlice13 != null && mytextarea13 != null && pepperoniprice != null && Imagepeperoni != null) {
        forallLabel.setText(pepperoniLabel);
        forSlicesLabel.setText(PizzSlice13);
        intructionLabel.setText(mytextarea13);
        Totalforprice.setText(pepperoniprice);
        forallimage.setImage(Imagepeperoni);
    }else if(shrimpLabel15 != null && PizzSlice15 != null && mytextarea15 != null && shrimpprice != null && forallimage != null) {
        forallLabel.setText(shrimpLabel15);
        forSlicesLabel.setText(PizzSlice15);
        intructionLabel.setText(mytextarea15);
        Totalforprice.setText(shrimpprice);
        forallimage.setImage(shrimppic);
    }else if (pestoLabel1 != null && PizzSlice116 != null && mytextarea16 != null && pestoprice != null && forallimage != null && PestoImage != null) {
        forallLabel.setText(pestoLabel1);
        forSlicesLabel.setText(PizzSlice116);
        intructionLabel.setText(mytextarea16);
        Totalforprice.setText(pestoprice);
        forallimage.setImage(PestoImage);
    }
}

}