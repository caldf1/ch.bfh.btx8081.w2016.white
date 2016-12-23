package ch.bfh.btx8053.w2016.white.HVmanager.view;

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

	private HorizontalLayout horizontal;
	private Button addNewBtn;
	private Button homeBtn;
	private Grid grid;

	/**
	 * 
	 */
	@Override
	public void enter(ViewChangeEvent event) {

	}

	/**
	 * 
	 * @param myui
	 */
	public ClientDirectory(MyUI myui) {

		this.horizontal = new HorizontalLayout();

		this.addNewBtn = new Button(FontAwesome.USER_PLUS);
		this.homeBtn = new Button(FontAwesome.HOME);

		addNewBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.ADDINGNEWCLIENT);
		});

		homeBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.HOMESCREEN);
		});

		horizontal.setSpacing(true);
		horizontal.addComponents(addNewBtn, homeBtn);

		// CREATE A GRID
		this.grid = new Grid();
		grid.setSizeFull();

		grid.addColumn("Name", String.class);
		grid.addColumn("Vorname", String.class);
		grid.addColumn("Geburtsdatum", String.class);
		grid.addColumn("Wohnort", String.class);

		ClientOverview beat = new ClientOverview("Beat", "Müller", "10.08.1998", "Bern");
		ClientOverview hans = new ClientOverview("Hans", "Muster", "10.08.1967", "Interlaken");
		ClientOverview flora = new ClientOverview("Flora", "Zürcher", "10.08.1980", "Zug");
		ClientOverview max = new ClientOverview("Max", "Berner", "10.08.1990", "Basle");
		ClientOverview paula = new ClientOverview("Paula", "Knall", "10.08.1950", "Brünig");
		ClientOverview franz = new ClientOverview("Franz", "Hauster", "10.08.1978", "Basle");
		ClientOverview melina = new ClientOverview("Melina", "Berger", "10.08.1989", "Zürich");
		ClientOverview sabina = new ClientOverview("Sabina", "Muster", "10.08.1970", "Genf");

		grid.addRow(beat.getDataList());
		grid.addRow(hans.getDataList());
		grid.addRow(flora.getDataList());
		grid.addRow(max.getDataList());
		grid.addRow(paula.getDataList());
		grid.addRow(franz.getDataList());
		grid.addRow(melina.getDataList());
		grid.addRow(sabina.getDataList());

		grid.addItemClickListener(new ItemClickListener() {

			/**
			 * 
			 */
			@Override
			public void itemClick(ItemClickEvent event) {
				if (event.isDoubleClick()) {
					// grid.getSelectedRow(); nach PK fragen und referenzieren
					// mit DB
					myui.getNavigator().navigateTo(myui.PATIENTOVERVIEW);
				}
			}
		});

		this.addComponents(horizontal, grid);
		this.setMargin(true);
		this.setSpacing(true);

	}

}