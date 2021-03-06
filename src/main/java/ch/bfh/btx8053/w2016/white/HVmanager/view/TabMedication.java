package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;



/**
 * This class gives the user detail information about the clients medication. 
 * 
 * @author degeg1, caldf1
 * @version 1.0
 */
public class TabMedication extends VerticalLayout implements View {

/*==============================================
 *    Attributes
 *==============================================
 */ 
	
	private static final long serialVersionUID = 6231141921679303856L;

	
	/*=========== Layouts ===========*/
	private VerticalLayout vertical1 = new VerticalLayout();
	private HorizontalLayout horizontal1 = new HorizontalLayout();

	private Grid grid1 = new Grid("Medikation: ");;

	
	/*=========== Images ===========*/
	
	
	/*=========== View-Size ===========*/	
	final static String WIDTH= "280";
	final static String HEIGHT= "400";
	
	final static String BUTTONWIDTH = "50";
	final static String BUTTONHEIGHT = "50";
	
	
	/*=========== Buttons ===========*/	
	private Button addMedicationBtn = new Button(FontAwesome.PLUS);
	private Button removeMedicationBtn = new Button(FontAwesome.MINUS);
	private Button editMedicationBtn = new Button(FontAwesome.EDIT);



	
/*==============================================
 *    Constructor
 *==============================================
 */

	/**
	 * All components are added in this constructor.
	 * 
	 * @param singleClientOverview
	 */
	public TabMedication(SingleClientOverview singleClientOverview) {

		
		/*=========== set Layout / addComponents ===========*/
		
		grid1.setWidth(WIDTH);

		
		addFirstRow();
		addToGrid();
		
		horizontal1.addComponents(addMedicationBtn, editMedicationBtn, removeMedicationBtn);
		horizontal1.setSpacing(true);
			
		vertical1.addComponents( horizontal1, grid1);
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
	 * generate columns for grid
	 */
	private void addFirstRow(){
		
		grid1.addColumn("Zeit", String.class);
		grid1.addColumn("Medikament", String.class);
		grid1.addColumn("Dosierung", String.class);		
	}
	
	/*
	 * fill rows for demo
	 */
	private void addToGrid() {
		
		grid1.addRow("08:00 Uhr", "Ibuprofen", "50mg");
		grid1.addRow("13:00 Uhr", "Alcacent", "20mg");
		grid1.addRow("18:00 Uhr", "Ibuprofen", "50mg");
	}

}
