package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
//import SingleClient.SingleClientOverview;

/**
 * 
 * @author degeg1
 * @version 0.1
 */
public class TabSpecial extends VerticalLayout implements View {

	private VerticalLayout cID;
	private VerticalLayout cName;
	private VerticalLayout cFirstName;
	private HorizontalLayout clientDetails;
	private Label clientId;
	private Label clientLastname;
	private Label clientFirstname;
	private ThemeResource resource;
	private Image image;
	
	/**
	 * 
	 */
	@Override
	public void enter(ViewChangeEvent event) {

	}

	/**
	 * 
	 */
	public TabSpecial(SingleClientOverview patientOverview) {

		///// Client details /////
		this.clientDetails = new HorizontalLayout();
		clientDetails.setSpacing(true);

		this.cID = new VerticalLayout();
		this.cName = new VerticalLayout();
		this.cFirstName = new VerticalLayout();

		this.clientId = new Label("cID: 10079");
		this.clientLastname = new Label("Muster");
		this.clientFirstname = new Label("Hans");

		cID.addComponent(clientId);
		cName.addComponent(clientLastname);
		cFirstName.addComponent(clientFirstname);

		clientDetails.addComponents(cID, cName, cFirstName);
		//////////////////////////////////////////////////////

		// Image
		this.resource = new ThemeResource("site-under-construction.jpeg");
		this.image = new Image("", resource);

		this.addComponents(clientDetails, image);
	}

}
