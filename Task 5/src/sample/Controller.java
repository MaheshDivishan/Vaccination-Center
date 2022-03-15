package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    public Button btn;

    @FXML
    public TextField fname;

    @FXML
    public TextField lname;

    @FXML
    public TextField age;

    @FXML
    public RadioButton astra;

    @FXML
    public RadioButton sino;

    @FXML
    public RadioButton fizer;

    @FXML
    public Label firstname;

    @FXML
    public Label agen;

    @FXML
    public Label vaccine;

    @FXML
    public Button button;

    @FXML
    public Label invoice;

    @FXML
    public CheckBox booth1;

    @FXML
    public CheckBox booth2;

    @FXML
    public CheckBox booth3;

    @FXML
    public CheckBox booth4;

    @FXML
    public CheckBox booth5;

    @FXML
    public CheckBox booth6;

    @FXML
    public Label number;


    public void add() {

        invoice.setText("---------------------------------Receipt--------------------------------------");
        firstname.setText("Name : " +  fname.getText()+" "+ lname.getText());
        agen.setText("Age : " +  age.getText());





    }
    public void astra(){
        vaccine.setText("Vaccine Type : " +  astra.getText());

    }
    public void sino(){
        vaccine.setText("Vaccine Type : " +  sino.getText());

    }
    public void fizer(){
        vaccine.setText("Vaccine Type : " +  fizer.getText());

    }
    public void booth1(){
        number.setText("Booth Number : " +  booth1.getText());

    }
    public void booth2(){
        number.setText("Booth Number : " +  booth2.getText());

    }
    public void booth3(){
        number.setText("Booth Number : " +  booth3.getText());

    }
    public void booth4(){
        number.setText("Booth Number : " +  booth4.getText());

    }
    public void booth5(){
        number.setText("Booth Number : " +  booth5.getText());

    }
    public void booth6(){
        number.setText("Booth Number : " +  booth6.getText());

    }









}
