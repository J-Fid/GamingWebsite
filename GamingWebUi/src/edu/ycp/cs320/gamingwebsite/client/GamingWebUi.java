package edu.ycp.cs320.gamingwebsite.client;



import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.RootLayoutPanel;





/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GamingWebUi implements EntryPoint {

	
	 //timer refresh rate, in milliseconds   
	static final int refreshRate = 25; 
	
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		

		RootLayoutPanel rootLayoutPanel = RootLayoutPanel.get();

		
		loginView view = new loginView();
		
		
		
			rootLayoutPanel.add(view);
			RootLayoutPanel.get().setWidgetTopBottom(view, 0.0, Unit.PX, 0.0, Unit.PX);
			RootLayoutPanel.get().setWidgetLeftRight(view, 0.0, Unit.PX, 0.0, Unit.PX);
			
		
	} 
	
	public void usingView(){
		
	}
	
	private void Update() {
		// TODO Auto-generated method stub this is where cody says memgame is going to go
		
	} 
}
