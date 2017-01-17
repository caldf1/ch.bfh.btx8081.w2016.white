package ch.bfh.btx8053.w2016.white.HVmanager.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.btx8053.w2016.white.HVmanager.util.NavigateType;

/**
 * This class is for visualize purpose only that the customer sees how the
 * complete software might look like. It shows a menu, where bills are created.
 * 
 * @author degeg1, nallm1, caldf1
 * @version 0.1
 */
public class Statistics extends VerticalLayout implements View {

	
/*==============================================
 *    Attributes
 *==============================================
 */ 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4800182920725133591L;
	

	/*=========== Layouts ===========*/
	private VerticalLayout vertical1 = new VerticalLayout();
	private HorizontalLayout horizontal1 = new HorizontalLayout();
	private HorizontalLayout horizontal2 = new HorizontalLayout();
	private HorizontalLayout horizontal3 = new HorizontalLayout();
	private Label labelTitel = new Label("Statistik");

	/*=========== Images ===========*/
	private Image imageWorkinghours = new Image("", new ThemeResource("Workinghours.jpeg"));

	
	/*=========== View-Size ===========*/	
	final static String WIDTH= "280";
	final static String HEIGHT= "400";
	
	final static String BUTTONWIDTH = "50";
	final static String BUTTONHEIGHT = "50";
	
	
	/*=========== Buttons ===========*/	
	private Button homeBtn = new Button(FontAwesome.HOME);

	

	
/*==============================================
 *    Constructor
 *==============================================
 */
	

	/**
	 * 
	 * @param myui
	 */
	public Statistics(MyUI myui) {

		
		/*=========== set Layout / addComponents ===========*/
				
		horizontal1.addComponents(homeBtn);
		horizontal1.setSpacing(true);
		vertical1.addComponents(horizontal1, horizontal2, labelTitel, imageWorkinghours, horizontal3);
		
		
		/*=========== Root set Layout ===========*/
		this.addComponents(vertical1);
		this.setMargin(true);
		this.setSpacing(true);
		


		/*=========== addClickListener ===========*/

		homeBtn.addClickListener(e -> {
			myui.getNavigator().navigateTo(myui.setNavigaterString(NavigateType.HOMESCREEN));
		});

	}
	
	
/*==============================================
 *    Setter
 *==============================================
 */

		@Override
		public void enter(ViewChangeEvent event) {

		}
		
/*==============================================
 *    Helper
 *==============================================
 */
		
		
		
}
