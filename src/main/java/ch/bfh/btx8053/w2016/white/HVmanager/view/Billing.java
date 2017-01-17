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
 * This class is for visualize purpose only that the customer sees how the
 * complete software might look like. It shows a menu, where bills are created.
 * 
 * @author degeg1
 * @version 0.1
 */
public class Billing extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8616736102514411219L;
	private Grid billing;
	private Button homeBtn;
	private HorizontalLayout horizontal;

	///////// VIEW SIZE /////////
	final static String WIDTH = "280";
	final static String HEIGHT = "570";
	////////////////////////////////////

	@Override
	public void enter(ViewChangeEvent event) {

	}

	/**
	 * This constructor shows one image "Site under construction" that the view
	 * has some content.
	 * 
	 * @param myui
	 */
	@SuppressWarnings("static-access")
	public Billing(MyUI myui) {

		///// Billing Overview /////
		this.billing = new Grid("Rechungs�bersicht:");
		billing.setWidth(WIDTH);
		billing.setHeight(HEIGHT);

		billing.addColumn("Rechungsdatum");
		billing.addColumn("Rg. ID");
		billing.addColumn("cID");
		billing.addColumn("Pfleger ID");
		billing.addColumn("Beschreibung");
		billing.addRow("15.01.2017", "63489", "1079", "99087", "Erste Fallabrechung");
		billing.addRow("12.12.2016", "49937", "1080", "57890", "Monatliche Gespr�che");
		//////////////////////////////////////////////////////

		///// Home Button /////
		this.horizontal = new HorizontalLayout();
		this.homeBtn = new Button(FontAwesome.HOME);

		homeBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.setNavigaterString(NavigateType.HOMESCREEN));
		});

		horizontal.addComponent(homeBtn);
		//////////////////////////////////////////////////////

		///// Root /////
		this.addComponents(billing, horizontal);
		this.setMargin(true);
		this.setSpacing(true);

	}

}
