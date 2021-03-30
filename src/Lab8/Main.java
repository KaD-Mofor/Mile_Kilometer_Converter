package Lab8;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    private TextField tfMiles = new TextField();
    private TextField tfKilometer = new TextField();

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Create a pane and give it properties
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));
        pane.setVgap(5.5);
        pane.setHgap(5.5);

        //Setting text positioning in the Text fields
        tfMiles.setAlignment(Pos.BASELINE_RIGHT);
        tfKilometer.setAlignment(Pos.BASELINE_RIGHT);

        //Place nodes in grid
        pane.add(new Label("Mile"),0,0);
        pane.add(tfMiles,1,0);
        pane.add(new Label("Kilometer"),0,1);
        pane.add(tfKilometer,1,1);

        //Handling input
        tfKilometer.setOnAction(actionEvent -> convertToMiles());
        tfMiles.setOnAction(actionEvent -> convertToKilometer());

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise16-04");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void convertToKilometer(){
        String milesString = tfMiles.getText();
        try {
        //Get value from textFields
        double miles = Double.parseDouble(milesString);

        //Create a distance object
        double kilom = miles * 1.602307322544464;

        //Convert miles to kilometer
        tfKilometer.setText(String.format("%.15f",kilom));
    }catch (NumberFormatException e){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("INVALID INPUT!");
        alert.setContentText(String.format("You entered %s, which is invalid. ", milesString));
        alert.showAndWait();
    }

    }
    public void convertToMiles(){
        String kmString = tfKilometer.getText();
        try {
            //Get value from textFields
            double km = Double.parseDouble(kmString);

            //Create a distance object
            double miles = km * 0.62137119224;

            //Convert miles to kilometer
            tfMiles.setText(String.format("%.15f",miles));
        }catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("INVALID INPUT!");
            alert.setContentText(String.format("You entered %s, which is invalid. ", kmString));
            alert.showAndWait();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
