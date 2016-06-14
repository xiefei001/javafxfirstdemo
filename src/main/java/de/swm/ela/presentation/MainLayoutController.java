package de.swm.ela.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import org.springframework.stereotype.Component;

/**
 * Created by xie on 2016/6/11.
 */
@Component
public class MainLayoutController {

    @FXML
    Label helloWorldLabel;

    @FXML
    RadioButton group1, group2, group3, group4;

    @FXML
    ToggleGroup myGroup;

    void onChange(){
        //myGroup.selectedToggleProperty().addListener();
    }
}
