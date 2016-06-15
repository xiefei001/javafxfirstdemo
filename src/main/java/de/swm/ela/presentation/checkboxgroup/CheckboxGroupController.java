/*
 * Copyright 2016 SWM Services GmbH
 */

package de.swm.ela.presentation.checkboxgroup;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;



/**
 * @author xie.fei
 * @since 1.0
 */
@Component
public class CheckboxGroupController implements Initializable {
	public enum SelectArt {
		ALL, FIRST(0), SECONDTHIRD(1, 2), FOURTH(3), NONE;

		private int[] indis;



		private SelectArt(int... indis) {
			this.indis = indis;
		}



		public int[] getIndis() {
			return this.indis;
		}
	}

	private List<CheckBox> checkboxList;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		checkboxList = Arrays.asList(first, second, third, fourth, fifth, sixth, seventh, eighth);

	}


	@FXML
	private CheckBox first, second, third, fourth, fifth, sixth, seventh, eighth;



	public void select(SelectArt art) {
		switch (art){
			case NONE:{
				setAllSelected(false);
				break;
			}
			case ALL: {
				setAllSelected(true);
				break;
			}
			case FIRST:
			case SECONDTHIRD:
			case FOURTH: {
				setAllSelected(false);
				int[] indis = art.getIndis();
				Arrays.stream(indis).forEach(i -> checkboxList.get(i).setSelected(true));
			}
		}
	}

	public void setAllSelected(boolean value){
		checkboxList.forEach(cb -> cb.setSelected(value));
	}





}
