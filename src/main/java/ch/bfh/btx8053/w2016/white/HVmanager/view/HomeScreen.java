package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author degeg1
 * @version 0.1
 */
public class HomeScreen extends VerticalLayout implements View {

	private HorizontalLayout logo;
	private ThemeResource resource;
	private Image image;
	private GridLayout gridLayout;
	private Button clientBtn;
	private Button helpBtn;
	private Button statsBtn;
	private Button facturingBtn;
	
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
	public HomeScreen(MyUI myui) {

		this.logo = new HorizontalLayout();

		/// Loading HV Manager Logo ///
		this.resource = new ThemeResource("HVmangerLogo.png");
		this.image = new Image("", resource);

		logo.addComponent(image);
		logo.setComponentAlignment(image, ALIGNMENT_DEFAULT);

		/// Creating Home Screen Grid Layout ///
		this.gridLayout = new GridLayout(2, 3);
		gridLayout.setSizeFull();
		gridLayout.setSpacing(true);

		// Creating menu buttons
		this.clientBtn = new Button("Klientensuche");
		clientBtn.setSizeFull();
		this.helpBtn = new Button("Hilfe");
		helpBtn.setSizeFull();
		this.statsBtn = new Button("Statistik");
		statsBtn.setSizeFull();
		this.facturingBtn = new Button("Abrechnung");
		facturingBtn.setSizeFull();

		gridLayout.addComponents(clientBtn, facturingBtn, statsBtn, helpBtn);

		clientBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.PATIENTDIRECTORY);
		});

		helpBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.HELP);
		});

		statsBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.STATS);
		});

		facturingBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.FACTURING);
		});

		// Adding components to root
		this.addComponents(logo, gridLayout);
		this.setSizeFull();
		this.setMargin(true);
		this.setSpacing(true);
	}
}