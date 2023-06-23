package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    @FXML
    private  TextField usernameField, mobileNumberField;
    @FXML
    Label termsLabel, mobileNumberWarning;
    @FXML
    private PasswordField passwordField;
    @FXML
    AnchorPane anchorpane5;
    @FXML
    private TextField emailField;
    @FXML
    private TextField confirmPasswordField;
    @FXML
    private CheckBox termsCheckBox;
    @FXML
    Button createAccountButton, loginButton,doorButton;

    private boolean agreedToTerms = false;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), termsLabel);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setCycleCount(1);

        termsCheckBox.setOnAction(event -> {
            if (termsCheckBox.isSelected()) {
                showTermsAndConditionsDialog();
                fadeTransition.play();
            } else {
                agreedToTerms = false;
                fadeTransition.stop();
                termsLabel.setOpacity(1);
            }
        });
        mobileNumberField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                // Non-integer value entered, show warning message
                mobileNumberWarning.setText("Mobile number should only contain digits");
                mobileNumberWarning.setVisible(true);
            } else {
                // Integer value entered, hide warning message
                mobileNumberWarning.setVisible(false);
            }
        });
    }
    

    private void showTermsAndConditionsDialog() {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Terms and Conditions");

        String message = "By creating a user account, you agree to the following terms and conditions:\n\n"
                + "1. You must provide accurate and complete information during the registration process,\nincluding your full name, username, and any other information that may be required.\n\n"
                + "2. You must choose a strong and secure password and keep it confidential. You are\nsolely responsible for maintaining the confidentiality of your password and\naccount information.\n\n"
                + "3. You are solely responsible for all activities that occur under your account.\nYou agree to notify us immediately of any unauthorized use of your account\nor any other breach of security.\n\n"
                + "4. You may not use the user account to engage in any illegal or unauthorized activity,\nincluding but not limited to violating any applicable laws or regulations, infringing\non any intellectual property rights, or accessing any restricted areas\nor confidential information.\n\n"
                + "5. You may not share your user account or password with anyone else,\nor allow anyone else to access your account.\n\n"
                + "Do you agree to these terms and conditions?";

        ButtonType agreeButton = new ButtonType("Agree");
        ButtonType cancelButton = new ButtonType("Cancel");

        alert.getButtonTypes().setAll(agreeButton, cancelButton);
        alert.setContentText(message);

        alert.setOnHidden(dialogEvent -> {
            if (alert.getResult() == agreeButton) {
                agreedToTerms = true;
            } else {
                termsCheckBox.setSelected(false);
            }
        });

        alert.showAndWait();
    }

    public void signup(ActionEvent event) {
    String username = usernameField.getText();
    String email = emailField.getText();
    String password = passwordField.getText();
    String confirmPassword = confirmPasswordField.getText();
    String mobile = mobileNumberField.getText();

    SettingsController.usernameInfo = username;
    SettingsController.passwordInfo = password;
    SettingsController.emailInfo = email;
    SettingsController.mobileInfo = mobile;

     if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || mobile.isEmpty() || !agreedToTerms) {
        showAlert("Error", "Please fill in all fields.");
    } else if (!isValidEmail(email)) {
        showAlert("Error", "Please enter a valid email address.");
    } else if (!isValidPassword(password)) {
        showAlert("Error", "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, and one digit.");
    } else if (!password.equals(confirmPassword)) {
        showAlert("Error", "Passwords do not match.");
    } else {
        showAlert("Success", "Password is strong and passwords match.");
        // Hide the message label if the checkbox is checked
        termsCheckBox.setVisible(false);
        // Signup successful, proceed with registration logic

        try {
            // Load the Login.fxml file
            FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
            Parent loginRoot = loginLoader.load();
            LoginController loginController = loginLoader.getController();

            // Pass the username and password values to the login controller
            loginController.setCredentials(email, password);

            // Create a new stage and set the LoginScene as its scene
            Stage loginStage = new Stage();
            Image icon = new Image("images/pizzaLogo-removebg-preview.png");
            loginStage.getIcons().add(icon);
            loginStage.setTitle("PIZZERIA - Login");
            loginStage.setScene(new Scene(loginRoot));

            // Show the LoginScene
            loginStage.show();

            // Hide the current scene (assuming the button is in the current scene)
            Node source = (Node) event.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            currentStage.hide();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

   private void showAlert(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION); // Use INFORMATION type for success messages
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
    }

    private boolean isValidEmail(String email) {
        // Implement your email validation logic here
        // This is just a basic example
        return email.matches("[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}");
    }

    private boolean isValidPassword(String password) {
        // Implement your password validation logic here
        // This is just a basic example
        return password.length() >= 8 && password.matches(".*[a-z].*") && password.matches(".*[A-Z].*") && password.matches(".*\\d.*");
    }

public void HomePage(ActionEvent event)throws IOException{
         FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), anchorpane5);

            boolean LogoButton = true;
            if (LogoButton) {
            try {
                // Load the LoginScene.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Home.fxml"));
                Parent root = loader.load();

                // Create a new stage and set the LoginScene as its scene
                Stage HomeStage = new Stage();
                Image icon = new Image("images/pizzaLogo-removebg-preview.png");
                HomeStage.getIcons().add(icon);
                HomeStage.setTitle("PIZZERIA - Home");  
                HomeStage.setScene(new Scene(root));

                // Show the LoginScene
                HomeStage.show();

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