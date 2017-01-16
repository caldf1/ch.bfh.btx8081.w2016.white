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
public class Help extends VerticalLayout implements View {

	private Label help;
	private Label helpContact;
	private Button homeBtn;
	private HorizontalLayout horizontal1;
	private HorizontalLayout horizontal2;

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
	public Help(MyUI myui) {

		///// Help Section /////
		this.horizontal1 = new HorizontalLayout();
		this.help = new Label("Vielen Dank dass Sie HV Manager benutzen, bei Fragen "
				+ "wenden Sie sich bitte an Ihre Vertriebsfirma mit Ihrer Lizensnummer: HV50012");
		this.helpContact = new Label("Telefon: +41 500 40 60");

		horizontal1.addComponents(help, helpContact);
		horizontal1.setSpacing(true);
		//////////////////////////////////////////////////////

		///// Home Button /////
		this.horizontal2 = new HorizontalLayout();
		this.homeBtn = new Button(FontAwesome.HOME);

		homeBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.HOMESCREEN);
		});

		horizontal2.addComponent(homeBtn);
		//////////////////////////////////////////////////////

		///// Root /////
		this.addComponents(help, horizontal1, horizontal2);
		this.setMargin(true);
		this.setSpacing(true);
		this.setWidth(WIDTH);
		this.setHeight(HEIGHT);

	}

}

