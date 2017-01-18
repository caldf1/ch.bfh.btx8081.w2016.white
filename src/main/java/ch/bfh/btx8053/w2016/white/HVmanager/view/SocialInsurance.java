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
 * @author degeg1
 * @version 0.1
 */
public class SocialInsurance extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5423979575568631390L;
	private Grid grid;
	private HorizontalLayout buttons;
	private Button rtnBtn;
	private Button addBtn;
	private Button cancelBtn;
	private Button editBtn;
	
	
	@Override
	public void enter(ViewChangeEvent event) {

	}

	/**
	 * 
	 * @param tabNetwork
	 */
	public SocialInsurance(TabNetwork tabNetwork) {

		this.grid = new Grid();
		grid.setSizeFull();
		
		grid.addColumn("Kontaktperson");
		grid.addColumn("Telefonnummer");
		
		grid.addRow("Max Muster", "031 300 50 60");
		
		this.buttons = new HorizontalLayout();
		
		this.rtnBtn = new Button(FontAwesome.ARROW_LEFT);
		this.addBtn = new Button(FontAwesome.PLUS);
		this.cancelBtn = new Button(FontAwesome.MINUS);
		this.editBtn = new Button(FontAwesome.EDIT);
		
		rtnBtn.addClickListener(e -> {
			tabNetwork.displayNetworkScreen();
		});
		
		buttons.addComponents(rtnBtn, addBtn, cancelBtn, editBtn);
		buttons.setSpacing(true);
		
		this.addComponents(grid, buttons);
		this.setSpacing(true);
		
		
	}
}
