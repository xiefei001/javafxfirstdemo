package de.swm.ela;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by xie on 2016/6/12.
 */
public abstract class AbstractFxmlView implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    protected FXMLLoader fxmlLoader;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (this.applicationContext != null) {
            return;
        }
        this.applicationContext = applicationContext;
    }

    private Object createControllerForType(Class<?> type) {
        return this.applicationContext.getBean(type);
    }

    protected FXMLLoader loadSynchronously(URL resource, ResourceBundle bundle) {
        FXMLLoader loader = new FXMLLoader(resource, bundle);
        loader.setControllerFactory(this::createControllerForType);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loader;
    }

    protected void initializeFXMLLoader() throws IOException {
        if(this.fxmlLoader == null){
            URL resource = getClass().getResource("Madfdf.fxml");
            FXMLLoader.load(resource);
            //this.fxmlLoader = FXMLLoader.load()
        }
    }

    public Parent getView() {
        return null;
    }

    private ResourceBundle getResourceBundle(String name){
        return ResourceBundle.getBundle(name);
    }




}
