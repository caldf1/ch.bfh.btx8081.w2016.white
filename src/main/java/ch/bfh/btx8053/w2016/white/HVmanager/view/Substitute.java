package ch.bfh.btx8053.w2016.white.HVmanager.view;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8053.w2016.white.HVmanager.model.Client;
import ch.bfh.btx8053.w2016.white.HVmanager.util.NavigateType;

/**
 * 
 * @author degeg1, caldf1
 * @version 1.0
 */
public class Substitute extends VerticalLayout implements View {

	
/*==============================================
 *    Attributes
 *==============================================
 */ 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -887463824415766814L;


	/*=========== Layouts ===========*/
	private VerticalLayout vertical1 = new VerticalLayout();
	private HorizontalLayout horizontal1 = new HorizontalLayout();
	private Grid grid1 = new Grid("Stellvertretung: "); 
	private Grid grid2 = new Grid("Freigegebene Klienten: "); 
	private CheckBox checkbox = new CheckBox("Stellvertretung aktivieren");

	/*=========== Images ===========*/
	
	
	/*=========== View-Size ===========*/	
	final static String WIDTH= "280";
	final static String HEIGHT= "400";
	
	final static String BUTTONWIDTH = "50";
	final static String BUTTONHEIGHT = "50";
	
	/*=========== Buttons ===========*/	
	private Button homeBtn = new Button(FontAwesome.HOME);
	private Button addBtn = new Button(FontAwesome.PLUS);
	private Button removeBtn = new Button(FontAwesome.MINUS);
	private Button editBtn = new Button(FontAwesome.EDIT);

	
/*==============================================
 *    Constructor
 *==============================================
 */
	
	/**
	 * This constructor shows one image "Site under construction" that the view
	 * has some content.
	 * 
	 * @param myui
	 */
	//@SuppressWarnings("static-access")
	public Substitute(MyUI myui) {
	
		/*=========== set Layout / addComponents ===========*/
		
		grid1.setWidth(WIDTH);
		grid1.setHeight("80");
		
		grid2.setWidth(WIDTH);
		//grid2.setHeight(HEIGHT);

		addFirstRow();
		grid1.addRow("16.01. - 23.01.2017","Dr. Alfons Nierenstein");
		fillList();
		
		horizontal1.addComponents(homeBtn, addBtn, editBtn, removeBtn);
		horizontal1.setSpacing(true);
		vertical1.addComponents(horizontal1, grid1, checkbox,grid2);
		vertical1.setSpacing(true);
		
		
		/*=========== Root set Layout ===========*/
		this.addComponents(vertical1);
		//this.addComponents(horizontal1, grid1);
		this.setMargin(true);
		this.setSpacing(true);
		


		/*=========== addClickListener ===========*/

		homeBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.setNavigaterString(NavigateType.HOMESCREEN));
		});

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
			
			grid1.addColumn("Von/Bis");
			grid1.addColumn("Stellvertretung");
			
			grid2.addColumn("Client ID");
			grid2.addColumn("Klient/Klientin");
			
		}
		
		
		/*
		 * 
		 * @param client
		 */
		private void addToGrid(Client client) { //, String dateStart, String dateEnd) {
			
			grid2.addRow(client.getPersonId() + "", client.getLastname() + " " + client.getFirstname());
		
		}
		
		
		/*
		 * 
		 */
		private void fillList(){
			
			
			Client client10 = new Client("Berger", "Melina", 'w', "10.08.1989");
			client10.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");		
			addToGrid(client10); //,"05.01.2017", "16.01.2017");  
/*
			Client client9 = new Client("Brönnimann", "Elisabeth", 'w', "03.05.1937");
			client9.setPrivateAddress("Kreuzweg 10", "2502", "Biel/Bienne");
			addToGrid(client9); //,"05.01.2017", "16.01.2017"); 
*/
			Client client1 = new Client("Christen", "Veronika", 'w', "23.05.1993");
			client1.setPrivateAddress("Haldenstrasse 10", "4800", "Zofingen");
			addToGrid(client1); //,"05.01.2017", "16.01.2017"); 
			
			Client client11 = new Client("Gross", "Sabina", 'w', "10.08.1970");
			client11.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");
			addToGrid(client11); //,"05.01.2017", "16.01.2017"); 
			
			Client client2 = new Client("Hofmann", "Peter", 'm', "05.06.1956");
			client2.setPrivateAddress("Haldenstrasse 10", "3000", "Bern");
			addToGrid(client2); //,"05.01.2017", "16.01.2017"); 
			
			Client client3 = new Client("Hofstetter", "Jolanda", 'w', "09.11.1978");
			client3.setPrivateAddress("Haldenstrasse 10", "4800", "Zug");
			addToGrid(client3); //,"05.01.2017", "16.01.2017"); 
			
			Client client4 = new Client("Müller", "Beat", 'm', "10.08.1998");
			client4.setPrivateAddress("Haldenstrasse 10", "6000", "Luzern");
			addToGrid(client4); //,"05.01.2017", "16.01.2017"); 
			
			Client client5 = new Client("Muster", "Hans", 'm', "10.08.1967");
			client5.setPrivateAddress("Haldenstrasse 10", "4000", "Basel");
			addToGrid(client5); //,"05.01.2017", "16.01.2017"); 
			
			Client client7 = new Client("Suter", "Max", 'm', "10.08.1990");
			client7.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");
			addToGrid(client7); //,"05.01.2017", "16.01.2017"); 
			
			Client client8 = new Client("Utiger", "Paula", 'f', "10.08.1950");
			client8.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");
			addToGrid(client8); //,"05.01.2017", "16.01.2017"); 
			
			Client client6 = new Client("Zürcher", "Flora", 'f', "10.08.1980");
			client6.setPrivateAddress("Haldenstrasse 10", "5000", "Aarau");
			addToGrid(client6); //,"05.01.2017", "16.01.2017"); 

			
	/*		=========== copy to add new TestClient ===========
			Client client = new Client();
			client.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");
			addClientToGrid(client, "09.01.2017", "08:00");
	*/	
			
		}
	
	
}
