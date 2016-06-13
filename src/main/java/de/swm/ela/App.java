package de.swm.ela;

import de.swm.ela.presentation.MainLayoutView;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;

/**
 * Hello world!
 */
@Lazy
@SpringBootApplication
public class App extends Application {

    private static String[] args;
    private ConfigurableApplicationContext context;

    /**
     * Note that this is configured in application.properties
     */
    @Value("${app.ui.title:Example App}")//
    private String windowTitle;

    @Autowired
    private MainLayoutView mainLayoutView;


    @Override
    public void init() throws Exception {
        super.init();
        context = SpringApplication.run(App.class, args);
        context.getAutowireCapableBeanFactory().autowireBean(this);

    }

    @Override
    public void stop() throws Exception {
        super.stop();
        context.close();
    }

    public static void main(String[] args) {
        App.args = args;
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        notifyPreloader(new Preloader.StateChangeNotification(Preloader.StateChangeNotification.Type.BEFORE_START));
        stage.setTitle(windowTitle);
        Parent view = mainLayoutView.getView();
        stage.setScene(new Scene(view));
        stage.setResizable(true);
        stage.centerOnScreen();
        stage.show();
    }
}
