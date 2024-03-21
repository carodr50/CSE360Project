package application.healthSoftware.views;

import application.healthSoftware.DataController;
import application.healthSoftware.ScreenController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class VisitExamRoom implements IScreen {
	public static String ScreenID = "visitExamRoom";
	
	private ScreenController screenController;
	private DataController dataController;
	
	public VisitExamRoom(ScreenController sc) {
		screenController = sc;
		dataController = DataController.getInstance();
	}
	
	public void refreshData() {
		
	}
	
	public Region getLayout() {
		VBox layout = new VBox();
		
		HBox titleRow = new HBox();
		titleRow.setAlignment(Pos.CENTER);
		Label title = new Label("Patient Registration Complete");
		title.setFont(new Font(48));
		titleRow.getChildren().add(title);
		layout.getChildren().add(titleRow);
		
		VBox content = new VBox();
		content.setAlignment(Pos.CENTER);
		content.setPrefHeight(500);
		content.setSpacing(15);
		layout.getChildren().add(content);

		HBox announceRow = new HBox();
		announceRow.setAlignment(Pos.CENTER);
		Label announcement = new Label("Initial data collection complete. Please escort the patient to the examination room.");
		announcement.setFont(new Font(30));
		announcement.setWrapText(true);
		announcement.setMaxWidth(500);
		announceRow.getChildren().add(announcement);
		content.getChildren().add(announceRow);
		
		Button proceedButton = new Button("Proceed");
		proceedButton.setOnMouseClicked((e) -> {
			screenController.moveToScreen("visitExamQuestions");
		});
		HBox row = new HBox(proceedButton);
		row.setAlignment(Pos.CENTER);
		content.getChildren().add(row);
		
		return layout;
	}
}
