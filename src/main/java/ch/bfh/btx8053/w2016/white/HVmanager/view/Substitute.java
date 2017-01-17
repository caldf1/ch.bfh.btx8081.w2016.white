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
 * 
 * @author degeg1
 *
 */
public class Substitute extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = -887463824415766814L;
	private Grid substitute;
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
	@SuppressWarnings("static-access")
	public Substitute(MyUI myui) {
	

		///// Billing Overview /////
		this.substitute = new Grid("Stellvertretungen:");
		substitute.setWidth(WIDTH);
		substitute.setHeight(HEIGHT);

		substitute.addColumn("Von:");
		substitute.addColumn("Bis:");
		substitute.addColumn("Pfleger ID");
		substitute.addColumn("Pfleger Vorname: ");
		substitute.addColumn("Pfleger Nachname:");
		substitute.addRow("15.01.2017", "20.01.2017", "2079", "Beat", "M�ller");
		substitute.addRow("22.01.2017", "25.01.2017", "2080", "Leony", "Kuster");
		//////////////////////////////////////////////////////

		///// Home Button /////
		this.horizontal = new HorizontalLayout();
		this.homeBtn = new Button(FontAwesome.HOME);
		this.addBtn = new Button(FontAwesome.PLUS);
		this.cancelBtn =new Button(FontAwesome.MINUS);
		this.editBtn = new Button(FontAwesome.EDIT);

		homeBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.setNavigaterString(NavigateType.HOMESCREEN));
		});

		horizontal.addComponents(homeBtn, addBtn, cancelBtn, editBtn);
		horizontal.setSpacing(true);
		//////////////////////////////////////////////////////

		///// Root /////
		this.addComponents(substitute, horizontal);
		this.setMargin(true);
		this.setSpacing(true);

	}

}
