/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import javafx.scene.control.Alert;

/**
 *
 * @author Itach
 */
public class CustomAlertMsg {

    static Alert alert;

    static void getEmptyError(String FieldName) {
        alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning !");
        if (FieldName.equals("alot")) {
            alert.setHeaderText("Please Check your inputs");
            alert.setContentText(
                    " 1. Name should contains letters ONLY  "
                    + "\n 2. Address is required"
                    + "\n 3. Salary's max is 4 digits "
                    + "\n 4. E-Mail should be in formal"
                    + "\n 5. Password Can be anything");

        } else {
            alert.setHeaderText("Problem in " + FieldName);
            alert.setContentText("Please fill " + FieldName + " Field");
        }
        alert.showAndWait();
    }

    static void getIDError(String cell) {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error !");
        alert.setHeaderText("ID Error");
        alert.setContentText("Bad " + cell + " ID, please enter a valid id");
        alert.showAndWait();
    }

    static boolean checkEmail(String email) {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error !");
        alert.setHeaderText("E-Mail Error");
        alert.setContentText("Bad E-Mail, please write a vaild E-Mail");

        if (!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            alert.showAndWait();
            return true;
        }
        return false;
    }

    static boolean checkPass(String Pass) {
        alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning !");
        alert.setHeaderText("Password Error");
        alert.setContentText("Password should be 6 or more characters");

        if (Pass.isEmpty()) {
            getEmptyError("Password");
            return true;
        } else if (Pass.length() < 6) {
            alert.showAndWait();
            return true;
        } else if (Pass.contains(" ")) {
            alert.setContentText("Password can't contain spaces");
            alert.showAndWait();
            return true;
        }
        return false;
    }

    static boolean checkSalary(String Salary) {
        alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning !");
        alert.setHeaderText("Salary Error");
        alert.setContentText("Salary consists of at most 4 digits and only integers");

        if (Salary.isEmpty()) {
            getEmptyError("Salary");
            return true;
        } else if (Salary.length() > 4 || !Salary.matches("[0-9]+")) {
            alert.showAndWait();
            return true;
        }
        return false;
    }

    private static void getNameError() {
        alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning !");
        alert.setHeaderText("Name Error");
        alert.setContentText("Bad name, name cannot contain numbers or symbols");
        alert.showAndWait();
    }

    static boolean checkAddress(String address) {
        if (address.isEmpty()) {
            CustomAlertMsg.getEmptyError("Address");
            return true;
        }
        return false;
    }

    static boolean checkNameError(String name) {
        if (name.isEmpty()) {
            CustomAlertMsg.getEmptyError("Name");
            return true;
        } else if (!name.matches("^[ A-z -]+$")) {
            CustomAlertMsg.getNameError();
            return true;
        } else {
            return false;
        }
    }

    static void getEmailError() {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error !");
        alert.setHeaderText("E-Mail Format error");
        alert.setContentText("Please check your e-mail address");
        alert.showAndWait();
    }

    static void getAddressError() {
        alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning !");
        alert.setHeaderText("Address");
        alert.setContentText("Please check your address");
        alert.showAndWait();
    }

    static void getLoginError() {
        alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning !");
        alert.setHeaderText("Wrong credentials");
        alert.setContentText("Please check username and password");

        alert.showAndWait();
    }

    static void getDateError(String value) {
        alert = new Alert(Alert.AlertType.ERROR);
        if (value.equals("before")) {
            alert.setTitle("Error !");
            alert.setHeaderText("Wrong Expire Date");
            alert.setContentText("Expire Date Cannot be before current date");
            alert.showAndWait();
        } else if (value.equals("after")) {
            alert.setTitle("Error !");
            alert.setHeaderText("Account expired");
            alert.setContentText("Please renew this member subscribtion");
            alert.showAndWait();
        } else {
            alert.setTitle("Error !");
            alert.setHeaderText("Wrong Date format");
            alert.setContentText("Please type a vaild date");
            alert.showAndWait();
        }
    }

    static void getDoesNotExist(String x) {
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(x + " Does not exist");
        alert.setHeaderText(x + " Does not exist");
        alert.setContentText("This " + x + " does not exist in our records,"
                + "\nplease check the entered id");
        alert.showAndWait();
    }

}
