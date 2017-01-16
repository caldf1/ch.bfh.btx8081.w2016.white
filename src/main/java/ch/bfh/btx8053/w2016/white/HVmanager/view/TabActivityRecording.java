package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;



/**
 * 
 * @author degeg1, nallm1
 * @version 0.1
 */
@SuppressWarnings("serial")
public class TabActivityRecording extends VerticalLayout implements View {

	private VerticalLayout cID;
	private VerticalLayout cName;
	private VerticalLayout cFirstName;
	private HorizontalLayout clientDetails;
	private HorizontalLayout activityRecFieldBtns; 
	private Grid activityRec;
	private Grid descrActivityRec;
	private Button addBtn1;
	private Button cancelBtn1;
	private Button editBtn1; 
	private Label clientId;
	private Label clientLastname;
	private Label clientFirstname;

	
	@Override
	public void enter(ViewChangeEvent event) {

	}

	/**
	 * 
	 * @param patientOverview
	 */
	public TabActivityRecording(SingleClientOverview patientOverview) {

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

	///// Activity Recording Grid /////
			this.activityRec = new Grid("Leistungsverrechnung:");
			activityRec.setSizeFull();
			activityRec.addColumn("Datum");
			activityRec.addColumn("Zeit");
			activityRec.addColumn("Leistung");
			activityRec.addRow("15.01.2017", "10:55", "Therapiegespräch");
			activityRec.addRow("10.01.2017", "13:00", "Medikamentenabgabe");

			this.activityRecFieldBtns = new HorizontalLayout();
			activityRecFieldBtns.setSpacing(true);

			this.addBtn1 = new Button(FontAwesome.PLUS);
			this.cancelBtn1 = new Button(FontAwesome.MINUS);
			this.editBtn1 = new Button(FontAwesome.EDIT);
			
			activityRecFieldBtns.addComponents(addBtn1, cancelBtn1, editBtn1);
			
			///// Description for Activity Recording /////
			this.descrActivityRec = new Grid("Leistungsverrechnungskategorien:");
			descrActivityRec.setSizeFull();
			descrActivityRec.addColumn("Kategorie");
			descrActivityRec.addColumn("Beschreibung");
			descrActivityRec.addRow("A", "Abgabe von Medikamenten");
			descrActivityRec.addRow("A", "Kontrolle von Tagesplan");
			descrActivityRec.addRow("A", "Zuschlag Medikation");
			descrActivityRec.addRow("B", "Gespräch");
			descrActivityRec.addRow("B", "Übrige Therapie");

			///// Root /////
			this.addComponents(clientDetails, activityRec, activityRecFieldBtns, descrActivityRec);
			this.setSpacing(true);
	}

}
