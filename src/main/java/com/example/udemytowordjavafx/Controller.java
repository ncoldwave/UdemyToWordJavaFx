package com.example.udemytowordjavafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
// import javafx.scene.control.Label;

import javafx.scene.control.*;

import java.util.ArrayList;

public class Controller {

    @FXML
    private Button clearButton;

    @FXML
    private Label statusLabel;

    @FXML
    private Button PlusButton;

    @FXML
    private TextArea Heading3Box;

    @FXML
    private TextField Heading2Box;

    @FXML
    private TextField ProjectNameBox;

    @FXML
    private TextField WordDocPath;

    @FXML
    private Button GenerateButton;

    @FXML
    private Button MinusButton;

    @FXML
    private ScrollPane MainScrollPane;

    @FXML
    protected void doClearButtonClick() {
        Heading3Box.setText("");
        Heading2Box.setText("");
        statusLabel.setText("");
        Heading2Box.requestFocus();
    }

    @FXML
    protected void generateButtonClick() {

        statusLabel.setText("Generating...");

        // if TextArea not empty
        String path = WordDocPath.getText().trim();
        String heading3 = Heading3Box.getText().trim();
        String heading2 = Heading2Box.getText().trim();
        String heading1 = ProjectNameBox.getText().trim();

        if (!heading3.equals("") && !heading2.equals("") && !path.equals("")) {

            ArrayList<String> heading3s = new ArrayList<>();
            String [] heading3StrArray = heading3.split("\n");

            for (String h3: heading3StrArray) {
                if (h3.trim().equals("Play") || h3.trim().equals("Stop") || h3.trim().equals("Start") || h3.trim().matches("(\\d+hr )?\\d+min")) {

                } else {
                    System.out.println(h3.trim());
                    heading3s.add(h3);
                }
            }
            new DocxHandler(WordDocPath.getText(), heading1, heading2, heading3s);

            statusLabel.setText("Finished");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("ERROR");

            String alertMessage = "";
            if (heading3.equals("")) {
                alertMessage += "Heading 3\n";
            }
            if (heading2.equals("")) {
                alertMessage += "Heading 2\n";
            }
            if (path.equals("")) {
                alertMessage += "Path\n";
            }

            alertMessage += "TextBox(es) is/are empty!";
            alert.setContentText(alertMessage);

            alert.showAndWait();

            statusLabel.setText("Unfinished");
        }
    }
}