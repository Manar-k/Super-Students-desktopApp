/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package super_students;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author lokamloka
 */
public class acadmicController implements Initializable{
    @FXML
    private TextField id;
    @FXML
    private TextField subject;
    @FXML
    private TextField grade;
    @FXML
    private TextField attende;
    @FXML
    private TextField rate;
    
    @FXML
    private TableView <Record> table1;
    @FXML
    private TableColumn<Record,String> col_id;
    @FXML
    private TableColumn<Record,String> col_subject;
    @FXML
    private TableColumn<Record,String> col_grade;
    @FXML
    private TableColumn<Record,String> col_attende;
    @FXML
    private TableColumn<Record,String> col_rate;

    
    Record r=new Record();
    
    public void addRecord(){
        r.setID(id.getText());
        r.setSubject(subject.getText());
        r.setAttende(attende.getText());
        r.setGrade(grade.getText());
        r.setRate(rate.getText());
        
        Session session = HibernateUtil.getSessionFactory().openSession();//INSERT medicine 
        Transaction tx = session.beginTransaction();
        String cId1 = (String) session.save(r);
        tx.commit();
        session.close();
        System.out.println("inserted Record: \n"+r.getID()+""+r.getSubject());
    }
    

    public void select(){
        Record select=table1.getSelectionModel().getSelectedItem();
        id.setText(select.getID());
        subject.setText(select.getSubject());
        grade.setText(select.getGrade());
        attende.setText(select.getAttende());
        rate.setText(select.getRate());
    }
    
    
    public void updateRecord(){
        Record select=table1.getSelectionModel().getSelectedItem();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Record selected=null;
        
        String x=select.getID();
        selected= (Record)session.get(Record.class,x);
        
        selected.setID(id.getText());
        selected.setSubject(subject.getText());
        selected.setGrade(grade.getText());
        selected.setAttende(attende.getText());
        selected.setRate(rate.getText());
        
        session.update(selected);
        session.getTransaction().commit();
        session.close();
        System.out.println("Updated Record: \n"+r.getID()+""+r.getSubject());
        
    }
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
    private void teachAttendance(ActionEvent event)throws IOException{
        Parent page_parent=FXMLLoader.load(getClass().getResource("teacher.fxml"));
        Scene page_scene=new Scene(page_parent);
        Stage stage1=(Stage)((Node) event.getSource()).getScene().getWindow();
        stage1.setScene(page_scene);
        stage1.show();
    }
    
    
    ObservableList <Record> recordol= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Session session1 = HibernateUtil.getSessionFactory().openSession();
        List<Record> recordlist = null;
        String queryStr = "from Record";
        Query query = session1.createQuery(queryStr);
        recordlist = query.list();
        session1.close();
        
        System.out.println("Record list size: "+recordlist.size());
        for(Record rr: recordlist)
        { 
              recordol.add(rr);
        }//retrive from database to project
    
        col_id.setCellValueFactory(new PropertyValueFactory<>("ID"));
        col_subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        col_grade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        col_attende.setCellValueFactory(new PropertyValueFactory<>("attende"));
        col_rate.setCellValueFactory(new PropertyValueFactory<>("rate"));

        
        table1.setItems(recordol);
        table1.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
     
    }
}
