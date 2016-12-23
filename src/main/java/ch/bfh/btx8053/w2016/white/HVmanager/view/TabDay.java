package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
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
public class TabDay extends VerticalLayout implements View {

	private VerticalLayout cID;
	private VerticalLayout cName;
	private VerticalLayout cFirstName;
	private HorizontalLayout clientDetails;
	private Label clientId;
	private Label clientLastname;
	private Label clientFirstname;
	private Grid agreement;
	private Grid dailiyActivity;
	
	
	@Override
	public void enter(ViewChangeEvent event) {

	}

	/**
	 * 
	 * @param patientOverview
	 */
	public TabDay(SingleClientOverview patientOverview) {

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
		
		Button addBtn = new Button();
		
		//////////////////////////////////////////////////////

		///// Agreement grid /////
		this.agreement = new Grid("Vereibarungen: ");

		agreement.addColumn("Zeit", String.class);
		agreement.addColumn("Aktivität", String.class);
		agreement.addRow("11:00 Uhr", "Laufen gehen");
		agreement.addRow("13:00 Uhr", "Medikamente einnehmen");
		agreement.addRow("15:00 Uhr", "Bericht schreiben");

		agreement.setSizeFull();
		////////////////////////////////////////////////////////

		///// Daily activity grid /////
		this.dailiyActivity = new Grid("Tagesablauf: ");

		dailiyActivity.addColumn("Zeit", String.class);
		dailiyActivity.addColumn("Aktivität", String.class);

		dailiyActivity.addRow("08:00 Uhr", "Aufstehen");
		dailiyActivity.addRow("08:30 Uhr", "Morgenessen");
		dailiyActivity.addRow("11:00 Uhr", "Neue Ziele definieren");
		dailiyActivity.addRow("13:00 Uhr", "Mittagessen einnehmen");
		dailiyActivity.addRow("14:00 Uhr", "Freunde treffen");
		dailiyActivity.addRow("15:00 Uhr", "Mittagessen einnehmen");
		dailiyActivity.addRow("16:00 Uhr", "Einkaufen gehen");
		dailiyActivity.addRow("17:00 Uhr", "Laufen gehen");
		dailiyActivity.addRow("18:00 Uhr", "Fragebogen ausfüllen");

		dailiyActivity.setSizeFull();
		////////////////////////////////////////////////////////

		///// Root /////
		this.addComponents(clientDetails, agreement, dailiyActivity);
		this.setSpacing(true);

	}

}
