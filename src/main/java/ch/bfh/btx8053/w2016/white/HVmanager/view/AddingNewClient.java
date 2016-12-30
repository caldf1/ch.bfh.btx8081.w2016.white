package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.data.validator.IntegerRangeValidator;
import com.vaadin.data.validator.NullValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import HomeScreen.MyUI;

/**
 * This class has a view that allows the user to add new clients.
 * 
 * @author degeg1
 * @version 0.1
 */
public class AddingNewClient extends VerticalLayout implements View {

	private TextField tfName;
	private TextField tfFName;
	private PopupDateField popupDfBirthdate;
	private TextField tfStreet;
	private TextField tfZIP;
	private TextField tfPlaceOfLiving;
	private HorizontalLayout add;
	private Button addBtn;
	private Button returnBtn;

	@Override
	public void enter(ViewChangeEvent event) {

	}

	/**
	 * In this constructor are following TextFields, Buttons and PopupDateField
	 * defined:
	 * 
	 * TextFields: tfName, tfFName, , tfStreet, tfZIP, tfPlaceOfLiving, tfPlace
	 * Buttons: addBtn, returnBtn, homeBtn PopupDateField: popupDfBirthdate
	 * 
	 * Each TextField must be filled out.
	 * 
	 * @param myui
	 */
	public AddingNewClient(MyUI myui) {

		/// Creating TextFields and one DateField for adding new Client
		this.tfName = new TextField("Name");
		tfName.setRequired(true);
		tfName.addValidator(new NullValidator("Muss vorhanden sein", false));

		this.tfFName = new TextField("Vorname");
		tfFName.setRequired(true);
		tfFName.addValidator(new NullValidator("Muss vorhanden sein", false));

		this.popupDfBirthdate = new PopupDateField("Geburtstag (MM.TT.JJJJ)");
		popupDfBirthdate.setRequired(true);
		popupDfBirthdate.addValidator(new NullValidator("Muss vorhanden sein", false));

		this.tfStreet = new TextField("Strasse/Nr.");
		tfStreet.setRequired(true);
		tfStreet.addValidator(new NullValidator("Muss vorhanden sein", false));

		this.tfZIP = new TextField("PLZ");
		tfZIP.setRequired(true);
		tfZIP.addValidator(new IntegerRangeValidator("Beispiel: 3000", 1, 9999));

		this.tfPlaceOfLiving = new TextField("Wohnort");
		tfPlaceOfLiving.setRequired(true);
		tfPlaceOfLiving.addValidator(new NullValidator("Muss vorhanden sein", false));

		/// Adding button for importing data into data base ///
		this.add = new HorizontalLayout();

		this.addBtn = new Button(FontAwesome.CHECK);
		this.returnBtn = new Button(FontAwesome.ARROW_LEFT);

		/// ClickListener for buttons
		addBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.PATIENTDIRECTORY);
		});

		returnBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.PATIENTDIRECTORY);
		});

		add.addComponents(addBtn, returnBtn);
		add.setSpacing(true);

		this.addComponents(tfName, tfFName, popupDfBirthdate, tfStreet, tfZIP, tfPlaceOfLiving, add);
		this.setMargin(true);
		this.setSpacing(true);
	}

}
