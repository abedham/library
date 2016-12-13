/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author AbdelRahman
 */
public class SignIn extends VBox {

    private final int minWidth = 200;
    private final int minWidthLabels = 115;
    private final int spacing = 15;
    private final int padding = 10;

    private Button btnLogin;

    private Label lbUserId;
    private Label lbPassword;

    private TextField tfUserId;
    private PasswordField pfPassword;

    public SignIn() {
        initSignInView();
    }

    private void initSignInView() {
        setLbUserId(new Label("User Name"));
        getLbUserId().setMinWidth(minWidthLabels);

        setTfUserId(new TextField());
        getTfUserId().setMinWidth(minWidth);
        getTfUserId().setMaxWidth(minWidth);
        getTfUserId().setPromptText("User Name");

        HBox hboxUserName = new HBox(10, lbUserId, tfUserId);
        setLbPassword(new Label("Password"));
        getLbPassword().setMinWidth(minWidthLabels);

        setPfPassword(new PasswordField());
        getPfPassword().setMinWidth(minWidth);
        getPfPassword().setMaxWidth(minWidth);
        getPfPassword().setPromptText("Password");

        HBox hboxPassword = new HBox(10, lbPassword, pfPassword);
        setBtnLogin(new Button("Login"));

        hboxPassword.setAlignment(Pos.CENTER);
        hboxUserName.setAlignment(Pos.CENTER);

        setSpacing(spacing);
        getChildren().addAll(hboxUserName, hboxPassword, getBtnLogin());
        setAlignment(Pos.CENTER);
        setPadding(new Insets(padding));
    }

    /**
     * @return the btnLogin
     */
    public Button getBtnLogin() {
        return btnLogin;
    }

    /**
     * @param btnLogin the btnLogin to set
     */
    public void setBtnLogin(Button btnLogin) {
        this.btnLogin = btnLogin;
    }

    /**
     * @return the tfUserId
     */
    public TextField getTfUserId() {
        return tfUserId;
    }

    /**
     * @param tfUserId the tfUserId to set
     */
    public void setTfUserId(TextField tfUserId) {
        this.tfUserId = tfUserId;
    }

    /**
     * @return the pfPassword
     */
    public TextField getPfPassword() {
        return pfPassword;
    }

    /**
     * @param pfPassword the pfPassword to set
     */
    public void setPfPassword(PasswordField pfPassword) {
        this.pfPassword = pfPassword;
    }

    /**
     * @return the User Name
     */
    public int getUserId() {
        return Integer.parseInt(getTfUserId().getText());
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return getPfPassword().getText();
    }

    public Label getLbUserId() {
        return lbUserId;
    }

    public void setLbUserId(Label lbUserId) {
        this.lbUserId = lbUserId;
    }

    public Label getLbPassword() {
        return lbPassword;
    }

    public void setLbPassword(Label lbPassword) {
        this.lbPassword = lbPassword;
    }

}
