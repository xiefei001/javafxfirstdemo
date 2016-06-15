package de.swm.ela;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import static java.util.ResourceBundle.getBundle;



/**
 * Created by xie on 2016/6/12.
 */
public abstract class AbstractFxmlView implements ApplicationContextAware {

	private final URL resource;
	private final ResourceBundle bundle;
	private ApplicationContext applicationContext;
	protected FXMLLoader fxmlLoader;

	private static final String STRIP_END = "View";
	protected ObjectProperty<Object> presenterProperty;



	public AbstractFxmlView() {
		this.presenterProperty = new SimpleObjectProperty<>();
		String fxml = getConventionalName(false, "fxml");
		this.resource = getClass().getResource(fxml);
		this.bundle = getResourceBundle();
	}



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
		if (this.fxmlLoader == null) {
			URL resource = getClass().getResource("Madfdf.fxml");
			FXMLLoader.load(resource);
			// this.fxmlLoader = FXMLLoader.load()
		}
	}



	protected String getConventionalName(boolean lowercase, String ending) {
		String clazz = getClass().getSimpleName();

		// Remove Ending if ends with STRIP_END.
		if (clazz.endsWith(STRIP_END)) {
			clazz = clazz.substring(0, clazz.lastIndexOf(STRIP_END));
		}

		if (lowercase) {
			clazz = clazz.toLowerCase();
		}

		if (ending != null) {
			clazz = clazz + "." + ending;
		}

		return clazz;
	}



	public Parent getView() {
		if (this.fxmlLoader == null) {
			this.fxmlLoader = loadSynchronously(this.resource, this.bundle);
			this.presenterProperty.set(this.fxmlLoader.getController());
		}

		return fxmlLoader.getRoot();
	}



	protected ResourceBundle getResourceBundle() {
		String bundleName = getClass().getPackage().getName() + "." + getConventionalName(false, null);
		try {
			return getBundle(bundleName);
		} catch (MissingResourceException e) {
			return null;
		}
	}



    public FXMLLoader getFxmlLoader() {
        return fxmlLoader;
    }
}
