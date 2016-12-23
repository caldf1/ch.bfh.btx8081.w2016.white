package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
//import SingleClient.SingleClientOverview;

/**
 * 
 * @author degeg1
 * @version 0.1
 */
public class TabMedication extends VerticalLayout implements View {

	private VerticalLayout cID;
	private VerticalLayout cName;
	private VerticalLayout cFirstName;
	private HorizontalLayout clientDetails;
	private Label clientId;
	private Label clientLastname;
	private Label clientFirstname;

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
	public TabMedication(SingleClientOverview patientOverview) {

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

		///// Medikation /////
		Grid medication = new Grid("Medikation: ");

		medication.addColumn("Zeit", String.class);
		medication.addColumn("Name", String.class);
		medication.addColumn("Dosierung", String.class);
		medication.addRow("08:00 Uhr", "Ibuprofen", "50mg");
		medication.addRow("13:00 Uhr", "Alcacent", "20mg");
		medication.addRow("18:00 Uhr", "Ibuprofen", "50mg");

		medication.setSizeFull();

		this.addComponents(clientDetails, medication);
		this.setSpacing(true);

	}

}
