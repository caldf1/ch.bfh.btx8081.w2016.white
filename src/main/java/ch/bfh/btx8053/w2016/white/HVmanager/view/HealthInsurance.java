package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;


/**
 * This class contains the clients contact information of their health insurance.
 * 
 * @author degeg1, caldf1
 * @version 1.0
 */
public class HealthInsurance extends VerticalLayout implements View {
	
	
/*==============================================
 *    Attributes
 *==============================================
 */ 

	private static final long serialVersionUID = -9066111296622909940L;
	

	/*=========== Layouts ===========*/
	private VerticalLayout vertical1 = new VerticalLayout();
	private HorizontalLayout horizontal1 = new HorizontalLayout();
	private Grid grid = new Grid();
	
	
	/*=========== Images ===========*/

	
	
	/*=========== View-Size ===========*/	
	final static String WIDTH= "280";
	final static String HEIGHT= "400";
	
	final static String BUTTONWIDTH = "50";
	final static String BUTTONHEIGHT = "50";
	
	
	/*=========== Buttons ===========*/	
	private Button returnBtn = new Button(FontAwesome.ARROW_LEFT);
	private Button addBtn = new Button(FontAwesome.PLUS);
	private Button removeBtn = new Button(FontAwesome.MINUS);
	private Button editBtn = new Button(FontAwesome.EDIT);


	
/*==============================================
 *    Constructor
 *==============================================
 */

	/**
	 * All components are added in this constructor and there is a click listener, which redirects the
	 * user to the network overview.
	 * 
	 * @param tabNetwork
	 */
	public HealthInsurance(TabNetwork tabNetwork) {


		/*=========== set Layout / addComponents ===========*/
		
		grid.setSizeFull();
		vertical1.setSizeFull();
		
		addFirstRow();
		addToGrid();
	
		horizontal1.addComponents(returnBtn, addBtn, editBtn, removeBtn);
		horizontal1.setSpacing(true);
		
		vertical1.addComponents(horizontal1, grid);
		vertical1.setSpacing(true);
		
	
		/*=========== Root set Layout ===========*/
		this.addComponents(vertical1);
		this.setSpacing(true);
		
		
		/*=========== addClickListener ===========*/
		
		returnBtn.addClickListener(e -> {
			tabNetwork.displayNetworkScreen();
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
	 * generate columns for grid
	 * 
	 */
	private void addFirstRow(){
		grid.addColumn("Institution");
		grid.addColumn("Sektion");
		grid.addColumn("Kontaktperson");			
	}
	
	/*
	 * fill row for demo
	 */
	private void addToGrid() {
		grid.addRow("SWICA Krankenkasse", "Bern", "Alain Feelgood");		
	}
	
}
