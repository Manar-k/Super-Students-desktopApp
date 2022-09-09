/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package super_students;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author lokamloka
 */
public class schudulesController implements Initializable{
   @FXML
    private void Home(ActionEvent event)throws IOException{
        Parent page_parent=FXMLLoader.load(getClass().getResource("Home-A.fxml"));
        Scene page_scene=new Scene(page_parent);
        Stage stage1=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(page_scene);
        stage1.show();
    }
    @FXML
    private void community(ActionEvent event)throws IOException{
        Parent page_parent=FXMLLoader.load(getClass().getResource("School-Community.fxml"));
        Scene page_scene=new Scene(page_parent);
        Stage stage1=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(page_scene);
        stage1.show();
    }
    @FXML
    private void acadmicRecords(ActionEvent event)throws IOException{
        Parent page_parent=FXMLLoader.load(getClass().getResource("acadmic-records.fxml"));
        Scene page_scene=new Scene(page_parent);
        Stage stage1=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(page_scene);
        stage1.show();
    }
    @FXML
    private void ads(ActionEvent event)throws IOException{
        Parent page_parent=FXMLLoader.load(getClass().getResource("Advertisement.fxml"));
        Scene page_scene=new Scene(page_parent);
        Stage stage1=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(page_scene);
        stage1.show();
    }
    @FXML
    private void schudules(ActionEvent event)throws IOException{
        Parent page_parent=FXMLLoader.load(getClass().getResource("Schudules.fxml"));
        Scene page_scene=new Scene(page_parent);
        Stage stage1=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(page_scene);
        stage1.show();
    }
    @FXML
    private void primary(ActionEvent event)throws IOException{
        Parent page_parent=FXMLLoader.load(getClass().getResource("Primary-class.fxml"));
        Scene page_scene=new Scene(page_parent);
        Stage stage1=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(page_scene);
        stage1.show();
    }
    @FXML
    private void teachAttendance(ActionEvent event)throws IOException{
        Parent page_parent=FXMLLoader.load(getClass().getResource("teacher.fxml"));
        Scene page_scene=new Scene(page_parent);
        Stage stage1=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(page_scene);
        stage1.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
