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
public class TabSpecial extends VerticalLayout implements View {

	/**
	 * 
	 */
	private VerticalLayout cID;
	private VerticalLayout cName;
	private VerticalLayout cFirstName;
	private HorizontalLayout clientDetails;
	private HorizontalLayout fearFieldBtns;
	private HorizontalLayout aggressFieldBtns;
	private HorizontalLayout dangerFieldBtns;
	private Button addBtn1;
	private Button cancelBtn1;
	private Button editBtn1;
	private Button addBtn2;
	private Button cancelBtn2;
	private Button editBtn2;
	private Button addBtn3;
	private Button cancelBtn3;
	private Button editBtn3;
	private Grid fear;
	private Grid aggress;
	private Grid danger;
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

		///// Fear Grid /////
		this.fear = new Grid("Ängste:");
		fear.setSizeFull();
		fear.addColumn("Definition");
		fear.addRow("Platzangst");
		fear.addRow("Höhenangst");

		this.fearFieldBtns = new HorizontalLayout();
		fearFieldBtns.setSpacing(true);

		this.addBtn1 = new Button(FontAwesome.PLUS);
		this.cancelBtn1 = new Button(FontAwesome.MINUS);
		this.editBtn1 = new Button(FontAwesome.EDIT);

		fearFieldBtns.addComponents(addBtn1, cancelBtn1, editBtn1);
		fearFieldBtns.setSpacing(true);
		//////////////////////////////////////////////////////

		///// Aggression Grid /////
		this.aggress = new Grid("Aggression:");
		aggress.setSizeFull();
		aggress.addColumn("Definition");
		aggress.addRow("Kann bei persönlichen Themen sehr gereizt reagieren.");

		this.aggressFieldBtns = new HorizontalLayout();
		aggressFieldBtns.setSpacing(true);

		this.addBtn2 = new Button(FontAwesome.PLUS);
		this.cancelBtn2 = new Button(FontAwesome.MINUS);
		this.editBtn2 = new Button(FontAwesome.EDIT);

		aggressFieldBtns.addComponents(addBtn2, cancelBtn2, editBtn2);
		//////////////////////////////////////////////////////

		///// Danger Grid /////
		this.danger = new Grid("Selbst-/Fremdgefahr:");
		danger.setSizeFull();
		danger.addColumn("Definition");
		danger.addRow("Bei zu nahe Treten Vorsicht geboten");

		this.dangerFieldBtns = new HorizontalLayout();
		dangerFieldBtns.setSpacing(true);

		this.addBtn3 = new Button(FontAwesome.PLUS);
		this.cancelBtn3 = new Button(FontAwesome.MINUS);
		this.editBtn3 = new Button(FontAwesome.EDIT);

		dangerFieldBtns.addComponents(addBtn3, cancelBtn3, editBtn3);
		//////////////////////////////////////////////////////

		///// Root /////
		this.addComponents(clientDetails, fear, fearFieldBtns, aggress, aggressFieldBtns, danger, dangerFieldBtns);
		this.setSpacing(true);

	}

}
