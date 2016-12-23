package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;


/**
 * 
 * @author degeg1
 * @version 0.1
 */
public class SingleClientOverview extends VerticalLayout implements View {

	private HorizontalLayout header;
	private HorizontalLayout home;
	private HorizontalLayout rtn;
	private Button homeBtn;
	private Button returnBtn;
	private TabSheet tabSheet;
	private VerticalLayout tablDay;
	private VerticalLayout tablInfo;
	private VerticalLayout tablMedi;
	private VerticalLayout tablSpecial;
	private VerticalLayout tablDocu;
	private VerticalLayout tablNetwork;
	
	/**
	 * 
	 */
	@Override
	public void enter(ViewChangeEvent event) {

	}
	
	/**
	 * 
	 * @param myUI
	 */
	public SingleClientOverview(MyUI myUI) {

		this.header = new HorizontalLayout();

		this.home = new HorizontalLayout();
		this.homeBtn = new Button(FontAwesome.HOME);
		home.addComponent(homeBtn);
		home.setSpacing(true);

		homeBtn.addClickListener(e -> {
			myUI.getNavigator().navigateTo(myUI.HOMESCREEN);
		});

		this.rtn = new HorizontalLayout();
		this.returnBtn = new Button(FontAwesome.ARROW_LEFT);
		rtn.addComponent(returnBtn);
		rtn.setSpacing(true);

		returnBtn.addClickListener(e -> {
			myUI.getNavigator().navigateTo(myUI.PATIENTDIRECTORY);
		});

		header.addComponents(rtn, home);
		header.setSpacing(true);

		this.tabSheet = new TabSheet();

		this.tablDay = new TabDay(this);
		this.tablInfo = new TabInfo(this);
		this.tablMedi = new TabMedication(this);
		this.tablSpecial = new TabSpecial(this);
		this.tablDocu = new TabDocuments(this);
		this.tablNetwork = new TabNetwork(this);

		tabSheet.addTab(tablDay, "", FontAwesome.SUN_O); // Alltag
		tabSheet.addTab(tablInfo, "", FontAwesome.INFO); // Info
		tabSheet.addTab(tablMedi, "", FontAwesome.MEDKIT); // Medikation
		tabSheet.addTab(tablSpecial, "", FontAwesome.EXCLAMATION); // Besonderes
		tabSheet.addTab(tablDocu, "", FontAwesome.FILE_TEXT_O); // Dokumente
		tabSheet.addTab(tablNetwork, "", FontAwesome.ARROWS); // Netzwerk

		this.addComponents(header, tabSheet);
		this.setMargin(true);
		this.setSpacing(true);

	}

}