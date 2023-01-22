package kirgaard.addressparser.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import kirgaard.addressparser.Model.Address;
import kirgaard.addressparser.Model.Exceptions.NoMatchFoundException;
import kirgaard.addressparser.Model.Parser;

public class MainController {
    @FXML private Label roadName;
    @FXML private Label roadNumber;
    @FXML private Label postalCode;
    @FXML private Label cityName;
    @FXML private TextField inputField;

    private Parser parser;

    @FXML
    public void initialize(){
        System.out.println("Main scene is initialized");
        parser = new Parser();
    }

    @FXML
    public void onAddressUpdated(){
        Address address;
        try {
            address = parser.Parse(inputField.getText());
        } catch (NoMatchFoundException e) {
            return;
        }

        if (address == null){
            return;
        }

        roadName.setText(address.getRoadName());
        roadNumber.setText(address.getRoadNumber());
        postalCode.setText(address.getPostalNumber());
        cityName.setText(address.getCityName());
    }

}
