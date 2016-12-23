package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;



/**
 * 
 * @author degeg1
 * @version 0.1
 */
public class ClientNetwork extends VerticalLayout implements View {

	@Override
	public void enter(ViewChangeEvent event) {

	}

	public ClientNetwork(MyUI myui) {

		AbsoluteLayout absolute = new AbsoluteLayout();
		absolute.setWidth("581px"); // 300px
		absolute.setHeight("560px"); // 520px

		// Buttons
		Button ahvBtn = new Button("AHV");
		Button doctorBtn = new Button("Hausarzt");
		Button healthInsBtn = new Button("Krankenkasse");
		Button relativesBtn = new Button("Angehörige");

		// Images
		ThemeResource resource = new ThemeResource("Netzwerk.png");
		Image image = new Image("", resource);

		absolute.addComponent(ahvBtn, "left: 260px; top: 440px; z-index: 2");
		absolute.addComponent(doctorBtn, "left: 60px; top: 260px; z-index: 2");
		absolute.addComponent(healthInsBtn, "left: 220px; top: 90px; z-index: 2");
		absolute.addComponent(relativesBtn, "right: 60px; top: 260px; z-index: 2");
		absolute.addComponent(image, "z-index: 1");

		this.addComponents(absolute);

	}
}