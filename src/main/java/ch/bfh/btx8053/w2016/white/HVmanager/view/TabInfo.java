package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
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

	/**
	 * 
	 */
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

		grid.addColumn("Name", String.class);
		grid.addColumn("Vorname", String.class);
		grid.addColumn("Geburtsdatum", String.class);
		grid.addColumn("AHV-Nr.", String.class);
		grid.addColumn("Strasse/Nr", String.class);
		grid.addColumn("PLZ", String.class);
		grid.addColumn("Wohnort", String.class);
		grid.addColumn("Telefonnummer zu Hause", String.class);
		grid.addColumn("Telefonnummer Mobile", String.class);

		Client beat = new Client("Hans", "Muster", "10.08.1990", "756-5442-12-14-56,", "Bahnhofstrasse 100", 3000,
				"Bern", "031 300 22 31", "079 450 45 80");

		grid.addRow(beat.getDataList());

		// add components in root
		this.addComponents(clientDetails, grid);
		this.setSpacing(true);

	}
}
