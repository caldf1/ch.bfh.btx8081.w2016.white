package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import SingleClient.SingleClientOverview;


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
	private Grid medication;
	private Label clientId;
	private Label clientLastname;
	private Label clientFirstname;
	private HorizontalLayout medicationButtons;
	private Button addMedicationBtn;
	private Button cancelMedicationBtn;
	private Button editMedicationBtn;

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

		///// Medication /////
		this.medication = new Grid("Medikation: ");

		medication.addColumn("Zeit", String.class);
		medication.addColumn("Name", String.class);
		medication.addColumn("Dosierung", String.class);
		medication.addRow("08:00 Uhr", "Ibuprofen", "50mg");
		medication.addRow("13:00 Uhr", "Alcacent", "20mg");
		medication.addRow("18:00 Uhr", "Ibuprofen", "50mg");

		this.medicationButtons = new HorizontalLayout();
		medicationButtons.setSpacing(true);
		
		this.addMedicationBtn = new Button(FontAwesome.PLUS);
		this.cancelMedicationBtn =new Button(FontAwesome.MINUS);
		this.editMedicationBtn = new Button(FontAwesome.EDIT);
		
		medicationButtons.addComponents(addMedicationBtn, cancelMedicationBtn, editMedicationBtn);

		medication.setSizeFull();

		this.addComponents(clientDetails, medication, medicationButtons);
		this.setSpacing(true);

	}

}
