/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiexec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author senooken
 */
public class mainController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML private TextField path;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    public void run(){
      try {
        // Process process = new ProcessBuilder("sh", "/usr/local/bin/shellScript.sh").start();

        Process process = new ProcessBuilder("pwd").start();

        String text;
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        BufferedReader reader = new BufferedReader(isr);
        StringBuilder builder = new StringBuilder();
        int c;
        while ((c = reader.read()) != -1) {
          builder.append((char)c);
        }
        // 実行結果を格納
        text = builder.toString();
        int ret = process.waitFor();

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setContentText(text);
        
        alert.showAndWait();
//        System.out.println(text);
//        System.out.println(ret);

      } catch (IOException | InterruptedException e) {
        e.printStackTrace();
      }    
    }
    
    public void fileSelect(){
        
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
