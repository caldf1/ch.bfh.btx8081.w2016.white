package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8053.w2016.white.HVmanager.model.Client;


/**
 * This class gives the user detail information about the clients contact information.
 * 
 * @author degeg1, caldf1
 * @version 1.0
 */
public class TabInfo extends VerticalLayout implements View {

	
/*==============================================
 *    Attributes
 *==============================================
 */ 
	
	
	private static final long serialVersionUID = 3918400076507359207L;
	

	/*=========== Layouts ===========*/
	private VerticalLayout vertical1 = new VerticalLayout();

	private Grid grid1 = new Grid("Kontaktdaten:");

	
	/*=========== Images ===========*/
	
	
	/*=========== View-Size ===========*/	
	final static String WIDTH= "280";
	final static String HEIGHT= "400";
	
	final static String BUTTONWIDTH = "50";
	final static String BUTTONHEIGHT = "50";
	
	
	/*=========== Buttons ===========*/	
	private Button editInfoBtn = new Button(FontAwesome.EDIT);



	
/*==============================================
 *    Constructor
 *==============================================
 */

	/**
	 * All components are added in this constructor.
	 * 
	 * @param singleClientOverview
	 */
	public TabInfo(SingleClientOverview singleClientOverview) {


		
		/*=========== set Layout / addComponents ===========*/
		
		grid1.setWidth(WIDTH);
		
		
		addFirstRow();
		fillList();
			
		vertical1.addComponents(editInfoBtn, grid1);
		vertical1.setSpacing(true);
		
		
		/*=========== Root set Layout ===========*/
		this.addComponents(vertical1);
		this.setMargin(true);
		this.setSpacing(true);
		
		
		/*=========== addClickListener ===========*/
		

	}


	
/*==============================================
 *    Setter
 *==============================================
 */

	@Override
	public void enter(ViewChangeEvent event) {

	}
	
	
/*==============================================
 *    Helper
 *==============================================
 */

	/*
	 *  generate columns for grid
	 */
	private void addFirstRow(){
		
		grid1.addColumn("Client ID", String.class);
		grid1.addColumn("Name", String.class);
		grid1.addColumn("Vorname", String.class);
		grid1.addColumn("Geburtsdatum", String.class);
		grid1.addColumn("Strasse/Nr", String.class);
		grid1.addColumn("PLZ", String.class);
		grid1.addColumn("Wohnort", String.class);
		grid1.addColumn("Telefonnummer p", String.class);
		grid1.addColumn("Mobile", String.class);
		
	}
	
	/*
	 * fill rows for demo
	 */
	private void addToGrid(Client client) {
		grid1.addRow(client.getPersonId() + "", client.getLastname(), client.getFirstname(), client.getBirthdate(),
				client.getPrivateAddress().getStreet(), client.getPrivateAddress().getZip(),
				client.getPrivateAddress().getCity(), client.getPrivateAddress().getPhonenumber(),
				client.getPrivateAddress().getMobilenumber());
	}

	/*
	 *  fill grid for demo
	 */
	private void fillList(){
				

		Client client12 = new Client("Brönnimann", "Elisabeth", 'w', "03.05.1937");
		client12.setPrivateAddress("Kreuzweg 11", "2502", "Biel/Bienne");
		client12.getPrivateAddress().setPhonenumber("062 620 36 63");
		client12.getPrivateAddress().setMobilenumber(" ");
		addToGrid(client12);

		
/*		=========== copy to add new TestClient ===========
		Client client = new Client();
		client.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");
		addClientToGrid(client);
*/	
		
	}
	
}
