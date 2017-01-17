package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8053.w2016.white.HVmanager.model.Client;
import ch.bfh.btx8053.w2016.white.HVmanager.util.NavigateType;

/**
 * 
 * @author degeg1, caldf1
 *
 */
public class MyAppointments extends VerticalLayout implements View {
	
	
/*==============================================
 *    Attributes
 *==============================================
 */ 

	/**
	 * 
	 */
	private static final long serialVersionUID = 5197415327720701886L;
	

	/*=========== Layouts ===========*/
	private VerticalLayout vertical1 = new VerticalLayout();
	private HorizontalLayout horizontal1 = new HorizontalLayout();
	private HorizontalLayout horizontal2 = new HorizontalLayout();
	private Grid grid1 = new Grid("Meine Termine:");

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
	
	
	/*=========== Object ===========*/	
	//private Calendar calendar = new Calendar(new Caregiver("Wenger", "Hanspeter", GenderType.MALE, "password"));

	
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
	public MyAppointments(MyUI myui) {
	

		/*=========== set Layout / addComponents ===========*/
		
		grid1.setWidth(WIDTH);
		//grid1.setHeight(HEIGHT);

		addFirstRow();
		fillList();
		
		horizontal1.addComponents(homeBtn, addBtn, editBtn, removeBtn);
		horizontal1.setSpacing(true);
		vertical1.addComponents(horizontal1, horizontal2, grid1);
		
		
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

			grid1.addColumn("Datum");
			grid1.addColumn("Zeit");
			grid1.addColumn("Client ID");
			grid1.addColumn("Klient/Klientin");
			//grid1.addColumn("Klienten Nachname", String.class);			
		}
		
		
		/*
		 * 
		 * @param client
		 * @param date
		 * @param time
		 */
		private void addToGrid(Client client, String date, String time) {
			
			grid1.addRow(date, time, client.getPersonId() + "", client.getLastname() + " " + client.getFirstname());
	
		}
		
		
		/*
		 * 
		 */
		private void fillList(){
			
			
			Client client10 = new Client("Berger", "Melina", 'w', "10.08.1989");
			client10.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");		
			addToGrid(client10,"05.01.2017", "09:00");  
/*
			Client client9 = new Client("Brönnimann", "Elisabeth", 'w', "03.05.1937");
			client9.setPrivateAddress("Kreuzweg 10", "2502", "Biel/Bienne");
			addToGrid(client9, "10.01.2017", "16:30");
*/
			Client client1 = new Client("Christen", "Veronika", 'w', "23.05.1993");
			client1.setPrivateAddress("Haldenstrasse 10", "4800", "Zofingen");
			addToGrid(client1, "05.01.2017", "10:30");
			
			Client client11 = new Client("Gross", "Sabina", 'w', "10.08.1970");
			client11.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");
			addToGrid(client11, "05.01.2017", "14:00");
			
			Client client2 = new Client("Hofmann", "Peter", 'm', "05.06.1956");
			client2.setPrivateAddress("Haldenstrasse 10", "3000", "Bern");
			addToGrid(client2, "06.01.2017", "10:00");
			
			Client client3 = new Client("Hofstetter", "Jolanda", 'w', "09.11.1978");
			client3.setPrivateAddress("Haldenstrasse 10", "4800", "Zug");
			addToGrid(client3, "06.01.2017", "13:30");
			
			Client client4 = new Client("Müller", "Beat", 'm', "10.08.1998");
			client4.setPrivateAddress("Haldenstrasse 10", "6000", "Luzern");
			addToGrid(client4, "06.01.2017", "15:00");
			
			Client client5 = new Client("Muster", "Hans", 'm', "10.08.1967");
			client5.setPrivateAddress("Haldenstrasse 10", "4000", "Basel");
			addToGrid(client5, "09.01.2017", "08:00");
			
			Client client7 = new Client("Suter", "Max", 'm', "10.08.1990");
			client7.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");
			addToGrid(client7, "09.01.2017", "09:45");
			
			Client client8 = new Client("Utiger", "Paula", 'f', "10.08.1950");
			client8.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");
			addToGrid(client8, "09.01.2017", "11:00");
			
			Client client6 = new Client("Zürcher", "Flora", 'f', "10.08.1980");
			client6.setPrivateAddress("Haldenstrasse 10", "5000", "Aarau");
			addToGrid(client6, "10.01.2017", "13:00");

			
	/*		=========== copy to add new TestClient ===========
			Client client = new Client();
			client.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");
			addClientToGrid(client, "09.01.2017", "08:00");
	*/	
			
		}

}

