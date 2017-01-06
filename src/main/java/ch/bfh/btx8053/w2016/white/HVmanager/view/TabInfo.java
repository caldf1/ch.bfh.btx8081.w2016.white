package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;




/**
 * 
 * @author degeg1
 * @version 0.1
 */
public class TabInfo extends VerticalLayout implements View {

	private VerticalLayout cID;
	private VerticalLayout cName;
	private VerticalLayout cFirstName;
	private HorizontalLayout clientDetails;
	private Label clientId;
	private Label clientLastname;
	private Label clientFirstname;
	private Grid grid;
	private Button editBtn;

	@Override
	public void enter(ViewChangeEvent event) {

	}

	/**
	 * 
	 * @param patientOverview
	 */
	public TabInfo(SingleClientOverview patientOverview) {

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

		// Create client grid
		this.grid = new Grid("Kontaktdaten:");
		grid.setSizeFull();

		grid.addColumn("Client ID", String.class);
		grid.addColumn("Name", String.class);
		grid.addColumn("Vorname", String.class);
		grid.addColumn("Geburtsdatum", String.class);
		grid.addColumn("Strasse/Nr", String.class);
		grid.addColumn("PLZ", String.class);
		grid.addColumn("Wohnort", String.class);
		grid.addColumn("Telefonnummer p", String.class);
		grid.addColumn("Mobile", String.class);
		
		Client hans = new Client("10079", "Hans", "Muster", "10.08.1967", "Bahnhofstrasse 100", 3800, "Interlaken", "031 300 22 31", "079 450 45 80");
		
		this.editBtn = new Button(FontAwesome.EDIT);

		grid.addRow(hans.getDataList());
		//////////////////////////////////////////////////////
		
		
		// add components in root //
		this.addComponents(clientDetails, grid, editBtn);
		this.setSpacing(true);

	}
}
