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
 * @author degeg1, nallm1, caldf1
 * @version 1.0
 */
public class TabSpecial extends VerticalLayout implements View {

	
/*==============================================
 *    Attributes
 *==============================================
 */ 
	
	/**
	 *  generated
	 */
	private static final long serialVersionUID = 3363074770844470820L;


	/*=========== Layouts ===========*/
	private VerticalLayout vertical1 = new VerticalLayout();

	private HorizontalLayout HLfear = new HorizontalLayout();
	private HorizontalLayout HLaggress = new HorizontalLayout();
	private HorizontalLayout HLcave = new HorizontalLayout();
	
	private Grid gridFear = new Grid("Ängste:");
	private Grid gridAggress = new Grid("Aggression:");
	private Grid gridCave = new Grid("Selbst-/Fremdgefahr:");
	
	private Label label1 = new Label("=============================");
	private Label label2 = new Label("=============================");

	
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
	
	private Button addBtn2 = new Button(FontAwesome.PLUS);
	private Button removeBtn2 = new Button(FontAwesome.MINUS);
	private Button editBtn2 = new Button(FontAwesome.EDIT);
	
	private Button addBtn3 = new Button(FontAwesome.PLUS);
	private Button removeBtn3 = new Button(FontAwesome.MINUS);
	private Button editBtn3 = new Button(FontAwesome.EDIT);

	
/*==============================================
 *    Constructor
 *==============================================
 */	

	/**
	 * 
	 */
	public TabSpecial(SingleClientOverview patientOverview) {

	
		/*=========== set Layout / addComponents ===========*/
		gridFear.setSizeFull();
		HLfear.setSpacing(true);
	
		gridAggress.setSizeFull();
		HLaggress.setSpacing(true);
		
		gridCave.setSizeFull();
		HLcave.setSpacing(true);
		
		addFirstRow();
		addToGrid();
		
		HLfear.addComponents(addBtn1, editBtn1, removeBtn1);
		HLaggress.addComponents(addBtn2, editBtn2, removeBtn2);
		HLcave.addComponents(addBtn3, editBtn3, removeBtn3);
			
		vertical1.addComponents(HLfear, gridFear,label1, HLaggress, gridAggress,label2, HLcave, gridCave);
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
		gridFear.addColumn("Definition");
		
		gridAggress.addColumn("Definition");
		
		gridCave.addColumn("Definition");
		
	}
	
	
	
	/*
	 *  fill rows for demo
	 */
	private void addToGrid() {
		gridFear.addRow("Platzangst");
		gridFear.addRow("Höhenangst");
		
		gridAggress.addRow("Kann bei persönlichen Themen sehr gereizt reagieren.");
		
		gridCave.addRow("Bei zu nahe Treten Vorsicht geboten");
	}
	

}
