/*
 * Copyright 2016 SWM Services GmbH
 */

package de.swm.ela.presentation.radiobuttongroup;

import de.swm.ela.presentation.checkboxgroup.CheckboxGroupController;
import de.swm.ela.presentation.checkboxgroup.CheckboxGroupController.SelectArt;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;



/**
 * @author xie.fei
 * @since 1.0
 */
@Component
public class ButtonGroupController implements Initializable {

	@FXML
	private RadioButton group1, group2, group3, group4, group5;

	@FXML
	ToggleGroup toggleGroup;

	@FXML
	StackPane buttonGroup;

	@Autowired
	CheckboxGroupController checkboxGroupController;



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		toggleGroup.selectedToggleProperty().addListener((observable, oldToggle, newToogle) -> {
			if (toggleGroup.getSelectedToggle() != null) {

				RadioButton selected = (RadioButton) toggleGroup.getSelectedToggle();
				checkboxGroupController.select(SelectArt.valueOf(selected.getText().toUpperCase()));
			}
		});
	}
}
