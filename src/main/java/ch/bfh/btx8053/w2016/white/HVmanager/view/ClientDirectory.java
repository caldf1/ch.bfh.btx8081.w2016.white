package ch.bfh.btx8053.w2016.white.HVmanager.view;

import ch.bfh.btx8053.w2016.white.HVmanager.model.Client;
import ch.bfh.btx8053.w2016.white.HVmanager.util.NavigateType;

import com.vaadin.annotations.Theme;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;


/**
 * 
 * @author degeg1, caldf1
 * @version 1.0
 */
@Theme("mytheme")
public class ClientDirectory extends VerticalLayout implements View {

	
/*==============================================
 *    Attributes
 *==============================================
 */ 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2022394876643555544L;
	
	/*=========== Layouts ===========*/
	private VerticalLayout vertical1 = new VerticalLayout();
	private HorizontalLayout horizontal1 = new HorizontalLayout();
	private HorizontalLayout horizontal2 = new HorizontalLayout();
	private Grid grid1 = new Grid("Meine Klienten:"); 

	/*=========== Images ===========*/
	
	
	/*=========== View-Size ===========*/	
	final static String WIDTH= "280";
	final static String HEIGHT= "400";
	
	final static String BUTTONWIDTH = "50";
	final static String BUTTONHEIGHT = "50";
	
	
	/*=========== Buttons ===========*/	
	private Button addNewBtn = new Button(FontAwesome.USER_PLUS);
	private Button homeBtn = new Button(FontAwesome.HOME);


	
/*==============================================
 *    Constructor
 *==============================================
 */
	
	/**
	 * 
	 * @param myui
	 */
	//@SuppressWarnings("static-access")
	public ClientDirectory(MyUI myui) {

		
		/*=========== set Layout / addComponents ===========*/
		
		grid1.setWidth(WIDTH);
		//grid1.setHeight(HEIGHT);
	
		addFirstRow(); // add Column
		fillList(); // fill grid1 with testclients
		
	
		horizontal1.setSpacing(true);
		horizontal1.addComponents(homeBtn, addNewBtn);
		vertical1.addComponents(horizontal1, horizontal2, grid1);
		
		/*=========== Root set Layout ===========*/
		this.addComponents(vertical1);
		//this.addComponents(horizontal1, grid1);
		this.setMargin(true);
		this.setSpacing(true);
		
		
		/*=========== addClickListener ===========*/

		addNewBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.setNavigaterString(NavigateType.ADDING_NEW_CLIENT));
		});

		homeBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.setNavigaterString(NavigateType.HOMESCREEN));
		});

		
		grid1.addItemClickListener(new ItemClickListener() {

			/**
			 * 
			 */
			private static final long serialVersionUID = -133370549833349229L;

			
			@Override
			public void itemClick(ItemClickEvent event) {
				if (event.isDoubleClick()) {
					// grid.getSelectedRow(); nach PK fragen und referenzieren
					// mit DB
					myui.getNavigator().navigateTo(myui.setNavigaterString(NavigateType.SINGLE_CLIENT_OVERVIEW));
				}
			}
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
	
	private void addFirstRow(){
		
		grid1.addColumn("Client ID", String.class);
		grid1.addColumn("Name\nVorname", String.class);
//		grid1.addColumn("Vorname", String.class);
		grid1.addColumn("Geburtsdatum", String.class);
		grid1.addColumn("Wohnort", String.class);
		
	}
	
	
	/**
	 * 
	 * @param client
	 */
	private void addToGrid(Client client) {
		grid1.addRow(client.getPersonId() + "", client.getLastname() + " " + client.getFirstname(), client.getBirthdate(),
				client.getPrivateAddress().getCity());
	}
	
	
	/**
	 * 
	 */
	private void fillList(){
				
		Client client10 = new Client("Berger", "Melina", 'w', "10.08.1989");
		client10.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");
		addToGrid(client10);
		
		Client client1 = new Client("Christen", "Veronika", 'w', "23.05.1993");
		client1.setPrivateAddress("Haldenstrasse 10", "4800", "Zofingen");
		addToGrid(client1); 

		Client client11 = new Client("Gross", "Sabina", 'w', "10.08.1970");
		client11.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");
		addToGrid(client11);
		
		Client client2 = new Client("Hofmann", "Peter", 'm', "05.06.1956");
		client2.setPrivateAddress("Haldenstrasse 10", "3000", "Bern");
		addToGrid(client2);
		
		Client client3 = new Client("Hofstetter", "Jolanda", 'w', "09.11.1978");
		client3.setPrivateAddress("Haldenstrasse 10", "4800", "Zug");
		addToGrid(client3);
		
		Client client4 = new Client("Müller", "Beat", 'm', "10.08.1998");
		client4.setPrivateAddress("Haldenstrasse 10", "6000", "Luzern");
		addToGrid(client4);
		
		Client client5 = new Client("Muster", "Hans", 'm', "10.08.1967");
		client5.setPrivateAddress("Haldenstrasse 10", "4000", "Basel");
		addToGrid(client5);
				
		Client client7 = new Client("Suter", "Max", 'm', "10.08.1990");
		client7.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");
		addToGrid(client7);
		
		Client client8 = new Client("Utiger", "Paula", 'f', "10.08.1950");
		client8.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");
		addToGrid(client8);
	
		Client client6 = new Client("Zürcher", "Flora", 'f', "10.08.1980");
		client6.setPrivateAddress("Haldenstrasse 10", "5000", "Aarau");
		addToGrid(client6);


		
/*		=========== copy to add new TestClient ===========
		Client client = new Client();
		client.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");
		addClientToGrid(client);
*/	
		
	}
	

}