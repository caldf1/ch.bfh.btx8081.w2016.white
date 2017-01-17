package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8053.w2016.white.HVmanager.util.NavigateType;

/**
 * This class is for visualize purpose only that the customer sees how the
 * complete software might look like. It shows a menu, where bills are created.
 * 
 * @author degeg1, nallm1
 * @version 0.1
 */
public class Statistics extends VerticalLayout implements View {

	/**
	 * 
	 */
	private ThemeResource resource;
	private Image image;
	private HorizontalLayout horizontal;
	private Button homeBtn;

	@Override
	public void enter(ViewChangeEvent event) {

	}

	/**
	 * 
	 * @param myui
	 */
	public Statistics(MyUI myui) {

	///// Working Hours 2016 /////
			this.resource = new ThemeResource("Workinghours.jpeg");
			this.image = new Image("", resource);
			//////////////////////////////////////////////////////

			///// Home Button /////
			this.horizontal = new HorizontalLayout();
			this.homeBtn = new Button(FontAwesome.HOME);

			homeBtn.addClickListener(e -> {
				myui.getNavigator().navigateTo(myui.setNavigaterString(NavigateType.HOMESCREEN));
			});

			horizontal.addComponents(homeBtn);
			horizontal.setSpacing(true);
			//////////////////////////////////////////////////////

			///// Root /////
			this.addComponents(image, horizontal);
			this.setMargin(true);
			this.setSpacing(true);

	}
}
