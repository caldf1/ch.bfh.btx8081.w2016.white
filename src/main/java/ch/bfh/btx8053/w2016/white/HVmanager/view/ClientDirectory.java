package ch.bfh.btx8053.w2016.white.HVmanager.view;

import ch.bfh.btx8053.w2016.white.HVmanager.model.Client;

import com.vaadin.annotations.Theme;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
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
@Theme("mytheme")
public class ClientDirectory extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2022394876643555544L;
	private HorizontalLayout horizontal;
	private Button addNewBtn;
	private Button homeBtn;
	private Grid grid;

	///////// VIEW SIZE /////////
	final static String WIDTH = "280";
	final static String HEIGHT = "568";
	////////////////////////////////////

	@Override
	public void enter(ViewChangeEvent event) {

	}

	/**
	 * 
	 * @param myui
	 */
	@SuppressWarnings("static-access")
	public ClientDirectory(MyUI myui) {

		this.horizontal = new HorizontalLayout();

		this.addNewBtn = new Button(FontAwesome.USER_PLUS);
		this.homeBtn = new Button(FontAwesome.HOME);

		addNewBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.ADDING_NEW_CLIENT);
		});

		homeBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.HOMESCREEN);
		});

		horizontal.setSpacing(true);
		horizontal.addComponents(addNewBtn, homeBtn);

		// CREATE A GRID
		this.grid = new Grid();
		grid.setWidth(WIDTH);
		grid.setHeight(HEIGHT);

		grid.addColumn("Client ID", String.class);
		grid.addColumn("Name", String.class);
		grid.addColumn("Vorname", String.class);
		grid.addColumn("Geburtsdatum", String.class);
		grid.addColumn("Wohnort", String.class);

//		ClientOverview beat = new ClientOverview("10080","Beat", "Müller", "10.08.1998", "Bern");
//		ClientOverview hans = new ClientOverview("10079", "Hans", "Muster", "10.08.1967", "Interlaken");
//		ClientOverview flora = new ClientOverview("20075", "Flora", "Zürcher", "10.08.1980", "Zug");
//		ClientOverview max = new ClientOverview("30680","Max", "Berner", "10.08.1990", "Basle");
//		ClientOverview paula = new ClientOverview("59905","Paula", "Knall", "10.08.1950", "Brünig");
//		ClientOverview franz = new ClientOverview("55094", "Franz", "Hauster", "10.08.1978", "Basle");
//		ClientOverview melina = new ClientOverview("78000","Melina", "Berger", "10.08.1989", "Zürich");
//		ClientOverview sabina = new ClientOverview("67099","Sabina", "Muster", "10.08.1970", "Genf");

		Client client1 = new Client("Buchmann", "Veronika", 'w', "23.05.1993");
		client1.setPrivateAddress("Haldenstrasse 10", "4800", "Zofingen");
		Client client2 = new Client("Hofmann", "Peter", 'm', "05.06.1956");
		client2.setPrivateAddress("Haldenstrasse 10", "4800", "Zofingen");
		Client client3 = new Client("Hofstetter", "Jolanda", 'w', "09.11.1978");
		
		String[] clientData = new String[4];
		String[] clientData2 = {client2.getPersonId() + "", client2.getLastname(), client2.getFirstname(), client2.getBirthdate(), client2.getPrivateAddress().getCity() };
		grid.addRow(client1.getPersonId() + "", client1.getLastname(), client1.getFirstname(), client1.getBirthdate(), client1.getPrivateAddress().getCity());
		grid.addRow(clientData2[0],clientData2[1],clientData2[2],clientData2[3],clientData2[4] );
//		grid.addRow(beat.getDataList());
//		grid.addRow(hans.getDataList());
//		grid.addRow(flora.getDataList());
//		grid.addRow(max.getDataList());
//		grid.addRow(paula.getDataList());
//		grid.addRow(franz.getDataList());
//		grid.addRow(melina.getDataList());
//		grid.addRow(sabina.getDataList());

		grid.addItemClickListener(new ItemClickListener() {

			/**
			 * 
			 */
			private static final long serialVersionUID = -133370549833349229L;

			
			@Override
			public void itemClick(ItemClickEvent event) {
				if (event.isDoubleClick()) {
					// grid.getSelectedRow(); nach PK fragen und referenzieren
					// mit DB
					myui.getNavigator().navigateTo(myui.SINGLE_CLIENT_OVERVIEW);
				}
			}
		});

		this.addComponents(horizontal, grid);
		this.setMargin(true);
		this.setSpacing(true);

	}

}