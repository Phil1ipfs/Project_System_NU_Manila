package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CheckOutController {

    private Stage primaryStage;
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    private String cardHolderName;

    @FXML
    private AnchorPane CheckOutPane;

    @FXML
    private TextField houseNumberField, streetField, zipCodeField, cityField, mobileNumberField;

    @FXML
    private Button checkoutButton;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void initialize(String cardNumber, String expiryDate, String cvv, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.cardHolderName = cardHolderName;
    }

    @FXML
    private void handleCheckoutButton(ActionEvent event) {
        String houseNumber = houseNumberField.getText();
        String street = streetField.getText();
        String zipCode = zipCodeField.getText();
        String city = cityField.getText();
        String mobileNumber = mobileNumberField.getText();

        // Validate mandatory fields
        if (houseNumber.isEmpty() || street.isEmpty() || zipCode.isEmpty() || city.isEmpty() || mobileNumber.isEmpty()) {
            showError("Missing Information", "Please fill in all the required fields.");
            return;
        }

        // Validate zip code and mobile number fields
        if (!zipCode.matches("\\d{5}")) {
            showError("Invalid Zip Code", "Zip code should contain exactly 5 digits.");
            return;
        }

        if (!mobileNumber.matches("\\d{11}")) {
            showError("Invalid Mobile Number", "Mobile number should contain exactly 11 digits.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Receipt.fxml"));
            Parent root = loader.load();

            ReceiptController receiptController = loader.getController();
            receiptController.setShippingInfo(houseNumber, street, zipCode, city, mobileNumber);
            receiptController.setPaymentInfo(cardNumber);

            Stage receiptStage = new Stage();
            Image icons = new Image("images/pizzaLogo-removebg-preview.png");
            receiptStage.getIcons().add(icons);
            receiptStage.setTitle("PIZZERIA - Checkout");
            receiptStage.setScene(new Scene(root));
            receiptStage.show();

            // Close the current stage (Check Out)
            Stage checkOutStage = (Stage) CheckOutPane.getScene().getWindow();
            checkOutStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
