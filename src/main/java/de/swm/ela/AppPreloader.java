package de.swm.ela;

import javafx.application.Preloader;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.concurrent.TimeUnit;



/**
 * Created by xie on 2016/6/11.
 */
public class AppPreloader extends Preloader {

	private Stage stage;



	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		ProgressIndicator indicator = new ProgressIndicator(-1.0);

		Scene scene = new Scene(indicator, 100, 100);

		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setScene(scene);
        stage.show();
	}



	@Override
	public void handleApplicationNotification(PreloaderNotification info) {
		super.handleApplicationNotification(info);
		System.out.println(info);
		if (info instanceof StateChangeNotification) {
			stage.hide();
		}
	}
}
