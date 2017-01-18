package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8053.w2016.white.HVmanager.model.Client;


/**
 * 
 * @author degeg1, caldf1
 * @version 0.1
 */
public class TabInfo extends VerticalLayout implements View {

	
/*==============================================
 *    Attributes
 *==============================================
 */ 
	
	/**
	 * 
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
	 * 
	 * @param singleClientOverview
	 */
	public TabInfo(SingleClientOverview singleClientOverview) {


		
		/*=========== set Layout / addComponents ===========*/
		
		grid1.setWidth(WIDTH);
		//grid1.setHeight(HEIGHT);
		//grid1.setSizeFull();
		
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
	 * 
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
	 * 
	 * @param client
	 */
	private void addToGrid(Client client) {
		grid1.addRow(client.getPersonId() + "", client.getLastname(), client.getFirstname(), client.getBirthdate(),
				client.getPrivateAddress().getStreet(), client.getPrivateAddress().getZip(),
				client.getPrivateAddress().getCity(), client.getPrivateAddress().getPhonenumber(),
				client.getPrivateAddress().getMobilenumber());
	}

	/**
	 * 
	 */
	private void fillList(){
				

		Client client12 = new Client("Brönnimann", "Elisabeth", 'w', "03.05.1937");
		client12.setPrivateAddress("Kreuzweg 11", "2502", "Biel/Bienne");
		client12.getPrivateAddress().setPhonenumber("062 620 36 63");
		client12.getPrivateAddress().setMobilenumber(" ");
		addToGrid(client12);
		
//		Client client10 = new Client("Berger", "Melina", 'w', "10.08.1989");
//		client10.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");
//		client10.getPrivateAddress().setPhonenumber("056 376 88 65");
//		client10.getPrivateAddress().setMobilenumber("077 967 05 65");
//		addToGrid(client10);
//		
//		Client client1 = new Client("Christen", "Veronika", 'w', "23.05.1993");
//		client1.setPrivateAddress("Haldenstrasse 10", "4800", "Zofingen");
//		client1.getPrivateAddress().setPhonenumber("056 376 88 65");
//		client1.getPrivateAddress().setMobilenumber("077 967 05 65");
//		addToGrid(client1); 
//
//		Client client11 = new Client("Gross", "Sabina", 'w', "10.08.1970");
//		client11.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");
//		client11.getPrivateAddress().setPhonenumber("056 376 88 65");
//		client11.getPrivateAddress().setMobilenumber("077 967 05 65");
//		addToGrid(client11);
//		
//		Client client2 = new Client("Hofmann", "Peter", 'm', "05.06.1956");
//		client2.setPrivateAddress("Haldenstrasse 10", "3000", "Bern");
//		client2.getPrivateAddress().setPhonenumber("056 376 88 65");
//		client2.getPrivateAddress().setMobilenumber("077 967 05 65");
//		addToGrid(client2);
//		
//		Client client3 = new Client("Hofstetter", "Jolanda", 'w', "09.11.1978");
//		client3.setPrivateAddress("Haldenstrasse 10", "4800", "Zug");
//		client3.getPrivateAddress().setPhonenumber("056 376 88 65");
//		client3.getPrivateAddress().setMobilenumber("077 967 05 65");
//		addToGrid(client3);
//		
//		Client client4 = new Client("Müller", "Beat", 'm', "10.08.1998");
//		client4.setPrivateAddress("Haldenstrasse 10", "6000", "Luzern");
//		client4.getPrivateAddress().setPhonenumber("056 376 88 65");
//		client4.getPrivateAddress().setMobilenumber("077 967 05 65");
//		addToGrid(client4);
//		
//		Client client5 = new Client("Muster", "Hans", 'm', "10.08.1967");
//		client5.setPrivateAddress("Haldenstrasse 10", "4000", "Basel");
//		client5.getPrivateAddress().setPhonenumber("056 376 88 65");
//		client5.getPrivateAddress().setMobilenumber("077 967 05 65");
//		addToGrid(client5);
//				
//		Client client7 = new Client("Suter", "Max", 'm', "10.08.1990");
//		client7.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");
//		client7.getPrivateAddress().setPhonenumber("056 376 88 65");
//		client7.getPrivateAddress().setMobilenumber("077 967 05 65");
//		addToGrid(client7);
//		
//		Client client8 = new Client("Utiger", "Paula", 'f', "10.08.1950");
//		client8.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");
//		client8.getPrivateAddress().setPhonenumber("056 376 88 65");
//		client8.getPrivateAddress().setMobilenumber("077 967 05 65");
//		addToGrid(client8);
//	
//		Client client6 = new Client("Zürcher", "Flora", 'f', "10.08.1980");
//		client6.setPrivateAddress("Haldenstrasse 10", "5000", "Aarau");
//		client6.getPrivateAddress().setPhonenumber("056 376 88 65");
//		client6.getPrivateAddress().setMobilenumber("077 967 05 65");
//		addToGrid(client6);


		
/*		=========== copy to add new TestClient ===========
		Client client = new Client();
		client.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");
		addClientToGrid(client);
*/	
		
	}
	
}
