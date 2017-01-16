package HomeScreen;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * This class is for visualize purpose only that the customer sees how the
 * complete software might look like. It shows a menu, where bills are created.
 * 
 * @author degeg1
 * @version 0.1
 */
public class Billing extends VerticalLayout implements View {

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
	public Billing(MyUI myui) {

		///// Billing Overview /////
		this.billing = new Grid("Rechungsübersicht:");
		billing.setWidth(WIDTH);
		billing.setHeight(HEIGHT);

		billing.addColumn("Rechungsdatum");
		billing.addColumn("Rg. ID");
		billing.addColumn("cID");
		billing.addColumn("Pfleger ID");
		billing.addColumn("Beschreibung");
		billing.addRow("15.01.2017", "63489", "1079", "99087", "Erste Fallabrechung");
		billing.addRow("12.12.2016", "49937", "1080", "57890", "Monatliche Gespräche");
		//////////////////////////////////////////////////////

		///// Home Button /////
		this.horizontal = new HorizontalLayout();
		this.homeBtn = new Button(FontAwesome.HOME);

		homeBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.HOMESCREEN);
		});

		horizontal.addComponent(homeBtn);
		//////////////////////////////////////////////////////

		///// Root /////
		this.addComponents(billing, horizontal);
		this.setMargin(true);
		this.setSpacing(true);

	}

}
