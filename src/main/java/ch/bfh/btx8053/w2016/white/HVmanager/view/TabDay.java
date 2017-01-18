package ch.bfh.btx8053.w2016.white.HVmanager.view;

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
 * @version 0.1
 */
public class TabDay extends VerticalLayout implements View {

	
/*==============================================
 *    Attributes
 *==============================================
 */ 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2228937876524596805L;

	
	/*=========== Layouts ===========*/
	private VerticalLayout vertical1 = new VerticalLayout();
	private VerticalLayout vertical2 = new VerticalLayout();
	private VerticalLayout vertical3 = new VerticalLayout();
	
	private HorizontalLayout horizontal2 = new HorizontalLayout();
	private HorizontalLayout horizontal4 = new HorizontalLayout();
	//private HorizontalLayout horizontal5 = new HorizontalLayout();

	private Grid gridAgreement  = new Grid("Vereinbarungen: ");
	private Grid gridDailiyActivity = new Grid("Tagesablauf: ");;
	

	/*=========== Images ===========*/
	
	
	/*=========== View-Size ===========*/	
	final static String WIDTH= "280";
	final static String HEIGHT= "400";
	
	final static String BUTTONWIDTH = "50";
	final static String BUTTONHEIGHT = "50";
	
	
	/*=========== Buttons ===========*/	
	private Button addAgrmtBtn = new Button(FontAwesome.PLUS);
	private Button removeAgrmtBtn = new Button(FontAwesome.MINUS);
	private Button editAgrmtBtn = new Button(FontAwesome.EDIT);
	
	private Button addDailyBtn = new Button(FontAwesome.PLUS);;
	private Button removeDailyBtn = new Button(FontAwesome.MINUS);
	private Button editDailyBtn = new Button(FontAwesome.EDIT);


	
/*==============================================
 *    Constructor
 *==============================================
 */

	/**
	 * 
	 * @param singleClientOverview
	 */
	public TabDay(SingleClientOverview singleClientOverview) {

	
		
		/*=========== set Layout / addComponents ===========*/
		
		gridAgreement.setWidth(WIDTH);
		//gridAgreement.setHeight(HEIGHT);
		//gridAgreement.setSizeFull();
		
		gridDailiyActivity.setWidth(WIDTH);
		//gridDailiyActivity.setHeight(HEIGHT);
		//gridDailiyActivity.setSizeFull();
		
		addFirstRow();
		addToGrid();
	
		horizontal2.addComponents(addAgrmtBtn, editAgrmtBtn, removeAgrmtBtn);
		horizontal2.setSpacing(true);
		
		horizontal4.addComponents(addDailyBtn, editDailyBtn, removeDailyBtn);
		horizontal4.setSpacing(true);
		
		vertical1.addComponents(gridAgreement, horizontal2);
		vertical1.setSpacing(true);
		
		vertical2.addComponents(gridDailiyActivity, horizontal4);
		vertical2.setSpacing(true);
		
		//horizontal5.addComponents(vertical1, vertical2);
		//horizontal5.setSpacing(true);
		
		vertical3.addComponents(vertical1, vertical2);
		vertical3.setSpacing(true);
	
		
		/*=========== Root set Layout ===========*/
		this.addComponents(vertical3);
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
		
	gridAgreement.addColumn("Zeit", String.class);
	gridAgreement.addColumn("Aktivität", String.class);
	
	gridDailiyActivity.addColumn("Zeit", String.class);
	gridDailiyActivity.addColumn("Aktivität", String.class);
		
	}
	
	
	/*
	 * 
	 */
	private void addToGrid() {
		gridAgreement.addRow("11:00 Uhr", "Laufen gehen");
		gridAgreement.addRow("13:00 Uhr", "Medikamente einnehmen");
		gridAgreement.addRow("15:00 Uhr", "Bericht schreiben");
		

		gridDailiyActivity.addRow("08:00 Uhr", "Aufstehen");
		gridDailiyActivity.addRow("08:30 Uhr", "Morgenessen");
		gridDailiyActivity.addRow("11:00 Uhr", "Neue Ziele definieren");
		gridDailiyActivity.addRow("13:00 Uhr", "Mittagessen einnehmen");
		gridDailiyActivity.addRow("14:00 Uhr", "Freunde treffen");
		gridDailiyActivity.addRow("15:00 Uhr", "Mittagessen einnehmen");
		gridDailiyActivity.addRow("16:00 Uhr", "Einkaufen gehen");
		gridDailiyActivity.addRow("17:00 Uhr", "Laufen gehen");
		gridDailiyActivity.addRow("18:00 Uhr", "Fragebogen ausfüllen");
		
	}
	
	
}
