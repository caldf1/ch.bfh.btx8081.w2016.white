package ch.bfh.btx8053.w2016.white.HVmanager.view;


import com.vaadin.data.validator.NullValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8053.w2016.white.HVmanager.util.NavigateType;


/**
 * This class has a view that allows the user to add new clients.
 * 
 * @author degeg1, caldf1
 * @version 1.0
 */
public class AddingNewClient extends VerticalLayout implements View {

	
/*==============================================
 *    Attributes
 *==============================================
 */ 
	
	
	private static final long serialVersionUID = 4638599022543216779L;
	
	
	/*=========== Layouts ===========*/
	private VerticalLayout vertical1 = new VerticalLayout();
	private HorizontalLayout horizontal1 = new HorizontalLayout();
	private HorizontalLayout horizontal2 = new HorizontalLayout();
	
	private TextField tfName = new TextField("Name");
	private TextField tfFirstname = new TextField("Vorname");
	private PopupDateField popupDfBirthdate = new PopupDateField("Geburtstag (MM.TT.JJJJ)");
	private TextField tfStreet = new TextField("Strasse/Nr.");
	private TextField tfZip = new TextField("PLZ");	
	private TextField tfCity = new TextField("Wohnort");
	
	/*=========== Images ===========*/
	
	
	/*=========== View-Size ===========*/	
	final static String WIDTH= "280";
	final static String HEIGHT= "400";
	
	final static String BUTTONWIDTH = "50";
	final static String BUTTONHEIGHT = "50";

	
	/*=========== Buttons ===========*/	
	private Button addBtn = new Button(FontAwesome.CHECK); 
	private Button returnBtn = new Button(FontAwesome.CLOSE); // or ARROW_LEFT
	

	
/*==============================================
 *    Constructor
 *==============================================
 */
	
	/**
	 * This constructor is responsible for adding components and has two click listeners that
	 * direct the user to their desired view.
	 * 
	 * @param myui
	 */
	//@SuppressWarnings("static-access")
	public AddingNewClient(MyUI myui) {
		
		/*=========== set Layout / addComponents ===========*/

		setFields(); // Creating TextFields and one DateField for adding new Client
			
		horizontal1.addComponents(addBtn, returnBtn);
		horizontal1.setSpacing(true);

		vertical1.addComponents(tfName, tfFirstname, popupDfBirthdate, tfStreet, tfZip, tfCity, horizontal2, horizontal1);
		
		
		/*=========== Root set Layout ===========*/
		this.addComponents(vertical1);
		this.setMargin(true);
		this.setSpacing(true);


		/*=========== addClickListener ===========*/
		
		addBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.setNavigaterString(NavigateType.CLIENT_DIRECTORY2));
		});

		returnBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.setNavigaterString(NavigateType.CLIENT_DIRECTORY));
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
		 * fill grid rows for demo
		 */
		private void setFields(){
			
			tfName.setRequired(true);
			tfName.addValidator(new NullValidator("Muss vorhanden sein", false));

			
			tfFirstname.setRequired(true);
			tfFirstname.addValidator(new NullValidator("Muss vorhanden sein", false));

		
			popupDfBirthdate.setRequired(true);
			popupDfBirthdate.addValidator(new NullValidator("Muss vorhanden sein", false));

		
			tfStreet.setRequired(true);
			tfStreet.addValidator(new NullValidator("Muss vorhanden sein", false));

			
			tfZip.setRequired(true);
			//tfZip.addValidator(new IntegerRangeValidator("Beispiel: 3000", 1000, 9999));
			
		
			tfCity.setRequired(true);
			tfCity.addValidator(new NullValidator("Muss vorhanden sein", false));
			
		}
		

}
