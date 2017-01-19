package ch.bfh.btx8053.w2016.white.HVmanager.view;


import java.util.ArrayList;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8053.w2016.white.HVmanager.model.Bill;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Case;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Client;
import ch.bfh.btx8053.w2016.white.HVmanager.util.NavigateType;

/**
 * This class is for visualize purpose only that the customer sees how the
 * complete software might look like. It gives an overview of all the bills, which were issued.
 * It can by sorted by date, invoice number, total amount for each bill, client and has for each bill
 * a short description.
 * 
 * @author degeg1
 * @version 1.0
 */
public class Billing extends VerticalLayout implements View {

/*==============================================
 *    Attributes
 *==============================================
 */ 
	
	
	private static final long serialVersionUID = 8616736102514411219L;

	
	/*=========== Layouts ===========*/
	private VerticalLayout vertical1 = new VerticalLayout();
	private HorizontalLayout horizontal1 = new HorizontalLayout();
	private HorizontalLayout horizontal2 = new HorizontalLayout();
	private Grid grid1 = new Grid("Rechnungsübersicht");

	/*=========== Images ===========*/
	
	
	/*=========== View-Size ===========*/	
	final static String WIDTH= "280";
	final static String HEIGHT= "400";
	
	final static String BUTTONWIDTH = "50";
	final static String BUTTONHEIGHT = "50";
	
	/*=========== Buttons ===========*/	
	private Button homeBtn = new Button(FontAwesome.HOME);

	
	
	
/*==============================================
 *    Constructor
 *==============================================
 */
	
	/**
	 * This constructor has several components and a click listener that directs the user to
	 * homescreen.
	 * 
	 * @param myui
	 */
	public Billing(MyUI myui) {


		/*=========== set Layout / addComponents ===========*/
		
		grid1.setWidth(WIDTH);
		//grid1.setHeight(HEIGHT);

		addFirstRow();
		fillList();
		
		horizontal1.addComponents(homeBtn);
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
		
		
		private void addFirstRow(){

			grid1.addColumn("Datum");
			grid1.addColumn("RgNr");
			grid1.addColumn("Rechnungstotal");
			grid1.addColumn("Client");			
			grid1.addColumn("Beschreibung");			
		}
		
		

		private void addToGrid(Client client, String date, String billnb, String value, String description) {
			
			grid1.addRow(date, billnb, value, client.getLastname() + " " + client.getFirstname(), description);	
		
		}
		
		
		private void addToGrid(Client client) {

			ArrayList<Case> cases = client.getCases();
	
			for (int i = 0; i < cases.size(); i++){
				String[] toList = new String[5];
				toList[3] = client.getLastname() + " " + client.getFirstname();
				
				Case aCase = cases.get(i);
				ArrayList<Bill> bills = aCase.getBills();
				
					for (int j = 0; j < cases.size(); j++){
						Bill aBill = bills.get(j);
						toList[0] = aBill.getBillDate();
						toList[1] = aBill.getBillID() + "";
						toList[2] = "CHF " + aBill.getBillTotalValue();
						toList[4] = aBill.getDescription();								
					}
		
				grid1.addRow(toList[0], toList[1], toList[2], toList[3], toList[4]);			
			}
		}	
		
		
		
		private void fillList(){
			
			
			Client client10 = new Client("Berger", "Melina", 'w', "10.08.1989");
			client10.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");
			client10.addCaseToList(new Case());
			ArrayList<Case> cases = client10.getCases();
			cases.get(0).addBillToList(new Bill("05.01.2017", cases.get(0).getCaseID(), cases.get(0).getCargiverID(), "Monatliche Gespräche"));
			addToGrid(client10);  
			
/*
			Client client9 = new Client("Brönnimann", "Elisabeth", 'w', "03.05.1937");
			client9.setPrivateAddress("Kreuzweg 10", "2502", "Biel/Bienne");
			addToGrid(client9, "10.01.2017", "87379", "CHF 88.50", "Gespräche");
*/
			Client client1 = new Client("Christen", "Veronika", 'w', "23.05.1993");
			client1.setPrivateAddress("Haldenstrasse 10", "4800", "Zofingen");
			addToGrid(client1, "05.01.2017", "93484", "CHF 88.50", "Erstgespräch");
			
			Client client11 = new Client("Gross", "Sabina", 'w', "10.08.1970");
			client11.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");
			addToGrid(client11, "05.01.2017", "12454", "CHF 88.50", "Begleitung");
			
			Client client2 = new Client("Hofmann", "Peter", 'm', "05.06.1956");
			client2.setPrivateAddress("Haldenstrasse 10", "3000", "Bern");
			addToGrid(client2, "06.01.2017", "43511", "CHF 88.50", "Wöchentliche Gespräche");
			
			Client client3 = new Client("Hofstetter", "Jolanda", 'w', "09.11.1978");
			client3.setPrivateAddress("Haldenstrasse 10", "4800", "Zug");
			addToGrid(client3, "06.01.2017", "75768", "CHF 88.50", "Gespräche");
			
			Client client4 = new Client("Müller", "Beat", 'm', "10.08.1998");
			client4.setPrivateAddress("Haldenstrasse 10", "6000", "Luzern");
			addToGrid(client4, "06.01.2017", "23412", "CHF 88.50", "Gespräche");
			
			Client client5 = new Client("Muster", "Hans", 'm', "10.08.1967");
			client5.setPrivateAddress("Haldenstrasse 10", "4000", "Basel");
			addToGrid(client5, "09.01.2017", "98483", "CHF 88.50", "Gespräche");
			
			Client client7 = new Client("Suter", "Max", 'm', "10.08.1990");
			client7.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");
			addToGrid(client7, "09.01.2017", "10934", "CHF 88.50", "Gespräche");
			
			Client client8 = new Client("Utiger", "Paula", 'f', "10.08.1950");
			client8.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");
			addToGrid(client8, "09.01.2017", "65643", "CHF 88.50", "Gespräche");
			
			Client client6 = new Client("Zürcher", "Flora", 'f', "10.08.1980");
			client6.setPrivateAddress("Haldenstrasse 10", "5000", "Aarau");
			addToGrid(client6, "10.01.2017", "93890", "CHF 88.50", "Begleitung");

			
	/*		=========== copy to add new TestClient ===========
			Client client = new Client();
			client.setPrivateAddress("Haldenstrasse 10", "2502", "Biel/Bienne");
			addClientToGrid(client, "09.01.2017", "08:00");
	*/	
			
		}

}
