package GUI;

import DBClasses.*;

import JavaClasses.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class LoginController {

    @FXML
    private TextField TextFieldAccountId;
    @FXML
    private PasswordField TextFieldPassword;
    @FXML
    private RadioButton RbManager,RbReceptionist,RbGuest,RbServer;
    @FXML
    private Label LbLogin;
    public void SwitchSceneToReceptionist(ActionEvent event) throws IOException{
        Parent receptionistSceneParent= FXMLLoader.load(getClass().getResource("ReceptionistScene.fxml"));
        Scene receptionistScene=new Scene(receptionistSceneParent);

        Stage secondaryStage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        secondaryStage.setScene(receptionistScene);
        secondaryStage.show();
    }
    public void SwitchSceneToGuest(ActionEvent event) throws IOException{
        Parent receptionistSceneParent= FXMLLoader.load(getClass().getResource("GuestScene.fxml"));
        Scene receptionistScene=new Scene(receptionistSceneParent);

        Stage secondaryStage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        secondaryStage.setScene(receptionistScene);
        secondaryStage.show();
    }
    public void SwitchSceneToServer(ActionEvent event) throws IOException{
        Parent receptionistSceneParent= FXMLLoader.load(getClass().getResource("ServerScene.fxml"));
        Scene receptionistScene=new Scene(receptionistSceneParent);

        Stage secondaryStage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        secondaryStage.setScene(receptionistScene);
        secondaryStage.show();
    }
    public void SwitchSceneToManager(ActionEvent event) throws IOException{
        Parent receptionistSceneParent= FXMLLoader.load(getClass().getResource("ManagerScene.fxml"));
        Scene receptionistScene=new Scene(receptionistSceneParent);

        Stage secondaryStage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        secondaryStage.setScene(receptionistScene);
        secondaryStage.show();
    }



    public void Login(ActionEvent event) throws IOException, InterruptedException {
        if (RbGuest.isSelected()){
            DBGuest guest=new DBGuest();
            ArrayList<GuestAccount> guestAccounts=guest.guestLogin(TextFieldAccountId.getText(),TextFieldPassword.getText());
            if (guestAccounts.isEmpty() || (TextFieldAccountId.getText().isEmpty() && TextFieldPassword.getText().isEmpty())){
                LbLogin.setStyle("-fx-text-inner-color: #c32b2b;");
                LbLogin.setText("Guest Login Failed");
                TextFieldAccountId.setStyle("-fx-control-inner-background: #c32b2b;");
                TextFieldPassword.setStyle("-fx-control-inner-background: #c32b2b;");
                TextFieldAccountId.clear();
                TextFieldPassword.clear();

            }
            else{
                LbLogin.setStyle("-fx-text-inner-color: #31a745;");
                LbLogin.setText("Guest Login Succeded");
                TextFieldAccountId.setStyle(" -fx-control-inner-background: #31a745;");
                TextFieldPassword.setStyle(" -fx-control-inner-background: #31a745;");
                SwitchSceneToGuest(event);
            }
        }
        if (RbManager.isSelected()){
            DBManager manager=new DBManager();
            if (TextFieldAccountId.getText().equals("SYSTEM")&&TextFieldPassword.getText().equals("SYSTEM")){
                LbLogin.setStyle("-fx-text-inner-color: #31a745;");
                LbLogin.setText("Manager Login Succeded");
                TextFieldAccountId.setStyle(" -fx-control-inner-background: #31a745;");
                TextFieldPassword.setStyle(" -fx-control-inner-background: #31a745;");
                SwitchSceneToManager(event);
            }

            else{
                LbLogin.setStyle("-fx-text-inner-color: #c32b2b;");
                LbLogin.setText("Manager Login Failed");
                TextFieldAccountId.setStyle("-fx-control-inner-background: #c32b2b;");
                TextFieldPassword.setStyle("-fx-control-inner-background: #c32b2b;");}
            }
        if (RbReceptionist.isSelected()){
            DBReceptionist receptionist=new DBReceptionist();
            ArrayList<ReceptionistAccount> receptionistAccounts=receptionist.receptionistLogin(TextFieldAccountId.getText(),TextFieldPassword.getText());
            if (receptionistAccounts.isEmpty() || (TextFieldAccountId.getText().isEmpty() || TextFieldPassword.getText().isEmpty())){
                LbLogin.setStyle("-fx-text-inner-color: #c32b2b;");
                LbLogin.setText("Receptionist Login Failed");
                TextFieldAccountId.setStyle("-fx-control-inner-background: #c32b2b;");
                TextFieldPassword.setStyle("-fx-control-inner-background: #c32b2b;");
            }
            else{
                LbLogin.setStyle("-fx-text-inner-color: #31a745;");
                LbLogin.setText("Receptionist Login Succeded");
                TextFieldAccountId.setStyle(" -fx-control-inner-background: #31a745;");
                TextFieldPassword.setStyle(" -fx-control-inner-background: #31a745;");
                SwitchSceneToReceptionist(event);
            }
            }
        if (RbServer.isSelected()){
            DBServer server=new DBServer();
            ArrayList<ServerAccount> serverAccounts=server.serverLogin(TextFieldAccountId.getText(),TextFieldPassword.getText());
            if (serverAccounts.isEmpty() || (TextFieldAccountId.getText().isEmpty() && TextFieldPassword.getText().isEmpty())){
                LbLogin.setStyle("-fx-text-inner-color: #c32b2b;");
                LbLogin.setText("Server Login Failed");
                TextFieldAccountId.setStyle("-fx-control-inner-background: #c32b2b;");
                TextFieldPassword.setStyle("-fx-control-inner-background: #c32b2b;");
            }
            else{
                LbLogin.setStyle("-fx-text-inner-color: #31a745;");
                LbLogin.setText("Server Login Succeded");
                TextFieldAccountId.setStyle(" -fx-control-inner-background: #31a745;");
                TextFieldPassword.setStyle(" -fx-control-inner-background: #31a745;");
                SwitchSceneToServer(event);
            }
            }
    }
}
