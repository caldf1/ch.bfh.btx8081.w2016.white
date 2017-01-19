package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8053.w2016.white.HVmanager.util.NavigateType;

/**
 * This class gives the user a brief overview, who they can call in case of any question regarding this
 * software.
 * 
 * @author degeg1
 * @version 1.0
 */
public class Help extends VerticalLayout implements View {

	
/*==============================================
 *    Attributes
 *==============================================
 */

	/*
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = 5007572246035078221L;

	
	/* =========== Layouts =========== */
	private VerticalLayout vertical1 = new VerticalLayout();
	private HorizontalLayout horizontal1 = new HorizontalLayout();
	private HorizontalLayout horizontal2 = new HorizontalLayout();
	private Grid grid1 = new Grid();


	/* =========== Images =========== */

	/* =========== View-Size =========== */
	final static String WIDTH = "280";
	final static String HEIGHT = "400";

	final static String BUTTONWIDTH = "50";
	final static String BUTTONHEIGHT = "50";

	/* =========== Buttons =========== */
	private Button homeBtn = new Button(FontAwesome.HOME);

	
/*==============================================
 *    Constructor
 *==============================================
 */

	/**
	 * This constructor adds all components and contains a click listener, which redirects the
	 * user to the home screen.
	 * 
	 * @param myui
	 */
	// @SuppressWarnings("static-access")
	public Help(MyUI myui) {

		/* =========== set Layout / addComponents =========== */
		
		grid1.setWidth(WIDTH);
		addFirstRow();
		fillList();

		horizontal1.addComponents(homeBtn);
		horizontal1.setSpacing(true);

		vertical1.addComponents(horizontal1, horizontal2, grid1);

		/* =========== Root set Layout =========== */
		this.addComponents(vertical1);
		this.setMargin(true);
		this.setSpacing(true);

		/* =========== addClickListener =========== */

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
	 * generate columns for grid 
	 */
	private void addFirstRow(){

		grid1.addColumn("Wir danken Ihnen für Ihr Vertrauen");			
	}
	
	
	/*
	 * fill row for demo
	 */
	private void addToGrid(String text) {
		
		grid1.addRow(text);

	}
	
	/*
	 * fill grid for demo
	 */
	private void fillList(){
		
		String[] text = {"", "Support", "", 
				"Bei Fragen beraten wir Sie gerne!", "Telefon: +41 500 40 60", 
				"Mail: support@hvmanager.ch", "", "Ihre Lizenznummer: HV50012"				
		};
	
		for (String str : text){
			addToGrid(str);
		}	  
	}

}
