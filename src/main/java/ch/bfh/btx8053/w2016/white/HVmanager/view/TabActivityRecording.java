package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;



/**
 * 
 * @author degeg1, nallm1
 * @version 1.0
 */
public class TabActivityRecording extends VerticalLayout implements View {

	
/*==============================================
 *    Attributes
 *==============================================
 */ 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8310842718300278249L;

	
	/*=========== Layouts ===========*/
	private VerticalLayout vertical1 = new VerticalLayout();
	
	private HorizontalLayout horizontal1 = new HorizontalLayout();;
	
	private Grid grid1ActivityRec = new Grid("Leistungsverrechnung:");
	private Grid grid2Description = new Grid("Leistungsverrechnungskategorien:");
	
	private Label label1 = new Label("=============================");
	
	/*=========== Images ===========*/
	
	
	/*=========== View-Size ===========*/	
	final static String WIDTH= "280";
	final static String HEIGHT= "400";
	
	final static String BUTTONWIDTH = "50";
	final static String BUTTONHEIGHT = "50";
	
	
	/*=========== Buttons ===========*/	
	private Button addBtn1 = new Button(FontAwesome.PLUS);
	private Button removeBtn1 = new Button(FontAwesome.MINUS);
	private Button editBtn1 = new Button(FontAwesome.EDIT);



	
/*==============================================
 *    Constructor
 *==============================================
 */

	/**
	 * 
	 * @param singleClientOverview
	 */
	public TabActivityRecording(SingleClientOverview singleClientOverview) {


		/*=========== set Layout / addComponents ===========*/
		
		grid1ActivityRec.setWidth(WIDTH);
		//grid1ActivityRec.setHeight(HEIGHT);
		//grid1ActivityRec.setSizeFull();
		
		grid2Description.setWidth(WIDTH);
		//grid2Description.setHeight(HEIGHT);
		//grid2Description.setSizeFull();
		
		addFirstRow();
		addToGrid();
			
		horizontal1.addComponents(addBtn1, editBtn1, removeBtn1);
		horizontal1.setSpacing(true);
		
		vertical1.addComponents(horizontal1, grid1ActivityRec, label1, grid2Description);
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
		
		grid1ActivityRec.addColumn("Datum");
		grid1ActivityRec.addColumn("Zeit");
		grid1ActivityRec.addColumn("Leistung");
		
		grid2Description.addColumn("Kategorie");
		grid2Description.addColumn("Beschreibung");
		
	}
	
	
	/*
	 * 
	 */
	private void addToGrid() {
		
		grid1ActivityRec.addRow("15.01.2017", "10:55", "Therapiegespräch");
		grid1ActivityRec.addRow("10.01.2017", "13:00", "Medikamentenabgabe");
			
		grid2Description.addRow("A", "Abgabe von Medikamenten");
		grid2Description.addRow("A", "Kontrolle von Tagesplan");
		grid2Description.addRow("A", "Zuschlag Medikation");
		grid2Description.addRow("B", "Gespräch");
		grid2Description.addRow("B", "Übrige Therapie");
		
	}

}
