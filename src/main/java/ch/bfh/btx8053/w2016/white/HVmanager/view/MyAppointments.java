package HomeScreen;

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
 *
 */
public class MyAppointments extends VerticalLayout implements View {

	private Grid myAppointments;
	private Button homeBtn;
	private Button addBtn;
	private Button cancelBtn;
	private Button editBtn;
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
	public MyAppointments(MyUI myui) {
	

		///// Billing Overview /////
		this.myAppointments = new Grid("Meine Termine:");
		myAppointments.setWidth(WIDTH);
		myAppointments.setHeight(HEIGHT);

		myAppointments.addColumn("Datum");
		myAppointments.addColumn("Zeit");
		myAppointments.addColumn("cID");
		myAppointments.addColumn("Klienten Vorname");
		myAppointments.addColumn("Klienten Nachname");
		myAppointments.addRow("15.01.2017", "15:00", "10079", "Hans", "Muster");
		myAppointments.addRow("17.01.2017", "09:00", "10080", "Beatrice", "Müller");
		//////////////////////////////////////////////////////

		///// Home Button /////
		this.horizontal = new HorizontalLayout();
		this.homeBtn = new Button(FontAwesome.HOME);
		this.addBtn = new Button(FontAwesome.PLUS);
		this.cancelBtn =new Button(FontAwesome.MINUS);
		this.editBtn = new Button(FontAwesome.EDIT);

		homeBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.HOMESCREEN);
		});

		horizontal.addComponents(homeBtn, addBtn, cancelBtn, editBtn);
		horizontal.setSpacing(true);
		//////////////////////////////////////////////////////

		///// Root /////
		this.addComponents(myAppointments, horizontal);
		this.setMargin(true);
		this.setSpacing(true);

	}

}

