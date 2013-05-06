package edu.ycp.cs320.gamingwebsite.client;


import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;

import edu.ycp.cs320.gamingwebsite.shared.Login;

import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.event.logical.shared.AttachEvent;

public class loginView extends Composite{
	private TextBox usernameTextBox;
	private Label errorLabel;
	private LayoutPanel layoutPanel;
	private MainWorld main; 
	private PasswordTextBox passwordTextBox;
	private LayoutPanel layoutPanel_1;
	private Button btnNewButton;
	private Button NewUser;


	
	public loginView() {
		main = new MainWorld();
		layoutPanel = new LayoutPanel();
		initWidget(layoutPanel);
		layoutPanel.setSize("1000px", "800px");
		
		layoutPanel_1 = new LayoutPanel();
		layoutPanel.add(layoutPanel_1);
		layoutPanel.setWidgetLeftWidth(layoutPanel_1, 92.0, Unit.PX, 400.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(layoutPanel_1, 21.0, Unit.PX, 415.0, Unit.PX);
		layoutPanel_1.setVisible(false);
		
		
		// logining into the website
		btnNewButton = new Button("Sign in");
		btnNewButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				handleLogInClicked();
			}
		});
		
		btnNewButton.setText("log in");
		layoutPanel.add(btnNewButton);
		layoutPanel.setWidgetLeftWidth(btnNewButton, 162.0, Unit.PX, 81.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(btnNewButton, 284.0, Unit.PX, 30.0, Unit.PX);
		
		final Label lblPassword = new Label("Password :");
		layoutPanel.add(lblPassword);
		layoutPanel.setWidgetLeftWidth(lblPassword, 124.0, Unit.PX, 68.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblPassword, 213.0, Unit.PX, 34.0, Unit.PX);
		
		final Label lblUserName = new Label("User Name :");
		layoutPanel.add(lblUserName);
		layoutPanel.setWidgetLeftWidth(lblUserName, 124.0, Unit.PX, 81.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblUserName, 153.0, Unit.PX, 18.0, Unit.PX);
		
		usernameTextBox = new TextBox();
		usernameTextBox.setName("User name");
		layoutPanel.add(usernameTextBox);
		layoutPanel.setWidgetLeftWidth(usernameTextBox, 219.0, Unit.PX, 173.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(usernameTextBox, 153.0, Unit.PX, 34.0, Unit.PX);
		
		Label lblGamingWebSite = new Label("Gaming Web Site");
		lblGamingWebSite.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		lblGamingWebSite.setStyleName("Main Game");
		layoutPanel.add(lblGamingWebSite);
		layoutPanel.setWidgetLeftWidth(lblGamingWebSite, 162.0, Unit.PX, 271.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(lblGamingWebSite, 53.0, Unit.PX, 49.0, Unit.PX);
		
		errorLabel = new Label();
		layoutPanel.add(errorLabel);
		layoutPanel.setWidgetLeftWidth(errorLabel, 20.0, Unit.PX, 566.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(errorLabel, 341.0, Unit.PX, 23.0, Unit.PX);
		
		// creating new account
		NewUser = new Button("Sign up");
		NewUser.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				handleSignInClicked();
			}
		});
		layoutPanel.add(NewUser);
		layoutPanel.setWidgetLeftWidth(NewUser, 302.0, Unit.PX, 90.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(NewUser, 284.0, Unit.PX, 30.0, Unit.PX);
		
		passwordTextBox = new PasswordTextBox();
		layoutPanel.add(passwordTextBox);
		layoutPanel.setWidgetLeftWidth(passwordTextBox, 219.0, Unit.PX, 173.0, Unit.PX);
		layoutPanel.setWidgetTopHeight(passwordTextBox, 213.0, Unit.PX, 32.0, Unit.PX);
	}
	
	protected void handleLogInClicked() {
		// RPC call to server to see if username/password is valid
		
		RPC.loginService.findLogin(usernameTextBox.getText(), passwordTextBox.getText(), new AsyncCallback<Login>() {
			
			@Override
			public void onSuccess(Login result) {
				if (result == null) {
					errorLabel.setText("No such username/password");
				} else {
					errorLabel.setText("Success (should go to home page)" );
					NextPanel(); 
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				//  display error (e.g., in a label)
				errorLabel.setText("Error logging in (could not contact server)");
			}
		});
	}
	
	protected void handleSignInClicked() {
		// RPC call to server to see if username/password is valid
		
		RPC.loginService.addLogin(usernameTextBox.getText(), passwordTextBox.getText(), new AsyncCallback<Login>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				errorLabel.setText("Error logging in (could not contact server)");
			}

			@Override
			public void onSuccess(Login result) {
				if(result == null){
					errorLabel.setText("No can not create");
				} else {
					System.out.println(result.getUser() + result.getPassword() + result.getMemscore());
					errorLabel.setText("Created New User");
					
				}
			}
		});
	}
	
	public void	NextPanel(){
		layoutPanel.clear();
		layoutPanel.add(main); 
		main.update();
	}
	
	public String getUsernameTextBox() {
		return usernameTextBox.getText();
	}
}
