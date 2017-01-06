package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;

/**
 * This class is for visualize purpose only that the customer sees how the
 * complete software might look like. It shows a menu, where bills are created.
 * 
 * @author degeg1
 * @version 0.1
 */
public class Facturing extends VerticalLayout implements View {

	private ThemeResource resource;
	private Image image;

	@Override
	public void enter(ViewChangeEvent event) {

	}

	/**
	 * This constructor shows one image "Site under construction" that the view
	 * has some content.
	 * 
	 * @param myui
	 */
	public Facturing(MyUI myui) {

		// Loading image
		this.resource = new ThemeResource("SiteUnderConstruction.jpeg");
		this.image = new Image("", resource);

		// Adding component to root
		this.addComponent(image);
		this.setMargin(true);

	}

}
