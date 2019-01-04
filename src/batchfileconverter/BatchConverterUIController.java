/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batchfileconverter;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class BatchConverterUIController{

    FileChooser fileChooser = new FileChooser();
    DirectoryChooser directoryChooser = new DirectoryChooser();
    File selectedFile;
    File selectedFolder;
    Converter converter = new Converter();
    Stage controllerStage = new Stage();
    @FXML
    TextField inputFile = new TextField();
    @FXML
    TextField outputFolder = new TextField();
    @FXML
    TextField outputExtension = new TextField();
    @FXML
    TextField batchSize = new TextField();
    @FXML
    Button inputFileChooser = new Button();
    @FXML
    Button outputFolderChooser = new Button();
    @FXML
    Button convert = new Button();
    @FXML
    Label statusLabel = new Label();
    
    public void initialize() {
        System.out.println("Initialized");
    }

    public void open_input_file_chooser(ActionEvent e) {
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Files", "*"));
        selectedFile = fileChooser.showOpenDialog(controllerStage);
        controllerStage.setTitle("Choose a File");
        inputFile.setText(selectedFile.toString());
    }

    public void open_output_folder_chooser(ActionEvent e) {
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Files", "*"));
        selectedFolder = directoryChooser.showDialog(controllerStage);
        controllerStage.setTitle("Choose Output Folder");
        outputFolder.setText(selectedFolder.toString());
    }

    public void batch_convert(ActionEvent e) throws IOException {
        System.out.println("STARTED");
        statusLabel.setText("STARTED.....");
        String status = converter.convert(inputFile.getText(), outputFolder.getText(), batchSize.getText(), outputExtension.getText());
        statusLabel.setText(status);
    }


}
