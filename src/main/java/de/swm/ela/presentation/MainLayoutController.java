package de.swm.ela.presentation;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import de.swm.ela.presentation.checkboxgroup.CheckboxGroupView;
import de.swm.ela.presentation.radiobuttongroup.ButtonGroupView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



/**
 * test.
 */
@Component
public class MainLayoutController implements Initializable {

	@FXML
	VBox centerPane;

	@Autowired
	ButtonGroupView buttonGroupView;


	@Autowired
	CheckboxGroupView checkboxGroupView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		centerPane.getChildren().add(buttonGroupView.getView());
		centerPane.getChildren().add(checkboxGroupView.getView());
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
