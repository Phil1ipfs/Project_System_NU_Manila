package controller;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class PaymentMethodController {

    private Stage primaryStage;

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField cardNumberField, cvvField, nameHolderField;

    @FXML
    private CheckBox saveCardDetailsCheckbox;

    @FXML
    private DatePicker expiryDatePicker;

    @FXML
    private Rectangle rect1;

    @FXML
    private Button addCardButton;

    @FXML
    private ImageView img6;

    @FXML
    private ImageView img7;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    public void addCard(ActionEvent event) {
        String cardNumber = cardNumberField.getText();
        String expiryDate = expiryDatePicker.getValue().toString();
        String cvv = cvvField.getText();
        String cardHolderName = nameHolderField.getText();
        boolean saveCardDetails = saveCardDetailsCheckbox.isSelected();

        img6.setImage(new Image("/Images/qr.png"));
        img7.setImage(new Image("/Images/qr.png")); 

        // Validate card number
        if (!isValidCardNumber(cardNumber)) {
            showAlert("Invalid Card Number", "Card number should have 16 digits.");
            return;
        }

        // Validate CVV
        if (!isValidCVV(cvv)) {
            showAlert("Invalid CVV", "CVV should have 3 digits.");
            return;
        }

        // Show alert if "Save Card Details" checkbox is selected
        if (saveCardDetails) {
            showSaveCardDetailsAlert(cardNumber, expiryDate, cvv, cardHolderName);
        }

        // Perform necessary actions with the card details (e.g., store in a database)

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CheckOut.fxml"));
            Parent root = loader.load();

            CheckOutController checkOutController = loader.getController();
            checkOutController.initialize(cardNumber, expiryDate, cvv, cardHolderName);

            Stage checkOutStage = new Stage();
            checkOutStage.setTitle("PIZZERIA - Payment");
            checkOutStage.getIcons().add(new Image("/images/pizzaLogo-removebg-preview 1.png")); // Set application icon
            checkOutStage.setScene(new Scene(root));
            checkOutStage.show();

            // Close the current stage (Payment Method)
            Stage paymentMethodStage = (Stage) pane.getScene().getWindow();
            paymentMethodStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isValidCardNumber(String cardNumber) {
        return cardNumber.matches("\\d{16}");
    }

    private boolean isValidCVV(String cvv) {
        return cvv.matches("\\d{3}");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showSaveCardDetailsAlert(String cardNumber, String expiryDate, String cvv, String cardHolderName) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Save Card Details");
        alert.setHeaderText("Card Details Saved");
        alert.setContentText("Card Number: " + cardNumber
                + "\nExpiry Date: " + expiryDate
                + "\nCVV: " + cvv
                + "\nCard Holder Name: " + cardHolderName);

        ButtonType doneButton = new ButtonType("Done");
        alert.getButtonTypes().setAll(doneButton);

        Stage alertStage = (Stage) alert.getDialogPane().getScene().getWindow();
        alertStage.getIcons().add(new Image("/images/pizzaLogo-removebg-preview 1.png")); // Set application icon

        alert.showAndWait().ifPresent(response -> {
            if (response == doneButton) {
                clearFields();
            }
        });
    }

    private void clearFields() {
        clearTextFields(cardNumberField, cvvField, nameHolderField);
        expiryDatePicker.getEditor().clear();
    }

    private void clearTextFields(TextInputControl... fields) {
        for (TextInputControl field : fields) {
            field.clear();
        }
    } 
    // addCardButton
    // public void GoingToCheckout (ActionEvent event){
    //     FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), pane);
    //     boolean addCardButton = true;
    //  if (addCardButton) {
    //         try {
    //             // Load the About.fxml file
    //             FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Receipt.fxml"));
    //             Parent root = loader.load();

    //             // Create a new stage and set the AboutScene as its scene
    //             Image icons = new Image("images/pizzaLogo-removebg-preview.png");
    //             Stage aboutStage = new Stage();
    //             aboutStage.getIcons().add(icons);
    //             aboutStage.setTitle("PIZZERIA - About");                
    //             aboutStage.setScene(new Scene(root));

    //             // Show the AboutScene
    //             aboutStage.show();

    //             // Hide the current scene (assuming the button is in the current scene)
    //             Node source = (Node) event.getSource();
    //             Stage currentStage = (Stage) source.getScene().getWindow();
    //             currentStage.hide();

    //             fadeTransition.setFromValue(0);
    //             fadeTransition.setToValue(1);
    //             fadeTransition.play();
    //         } catch (IOException ex) {
    //             ex.printStackTrace();
    //         }
    //     }
    // }
}
