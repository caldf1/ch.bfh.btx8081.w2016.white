package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
//import SingleClientTabViews.TabNetwork;

/**
 * 
 * @author degeg1
 * @version 0.1
 */
public class Relatives extends VerticalLayout implements View {

	private Grid grid;
	private Button rtnBtn;
	
	/**
	 * 
	 */
	@Override
	public void enter(ViewChangeEvent event) {

	}

	/**
	 * 
	 * @param tabNetwork
	 */
	public Relatives(TabNetwork tabNetwork) {

		this.grid = new Grid();

		grid.addColumn("Kontaktperson");
		grid.addColumn("Status");
		grid.addColumn("Telefonnummer"); 

		grid.addRow("Max Muster", "Bruder", "031 300 50 60");

		this.rtnBtn = new Button(FontAwesome.ARROW_LEFT);

		rtnBtn.addClickListener(e -> {
			tabNetwork.displayStartScreen();
		});

		this.addComponents(grid, rtnBtn);
		this.setSpacing(true); 

	}
}