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
public class firstschController implements Initializable{
    @FXML
    private TextField sID;
    @FXML
    private TextField subjectName;
    @FXML
    private TextField teacherName;
    @FXML
    private TextField day;
    @FXML
    private TextField classTime;
    
    @FXML
    private TableView <Schedule> table2;
    @FXML
    private TableColumn<Schedule,String> col_subjectId;
    @FXML
    private TableColumn<Schedule,String> col_subjectName;
    @FXML
    private TableColumn<Schedule,String> col_teacherName;
    @FXML
    private TableColumn<Schedule,String> col_day;
    @FXML
    private TableColumn<Schedule,String> col_classTime;
    
    Schedule s=new Schedule();
    
    public void addSchedule(){
        s.setSubjectID(sID.getText());
        s.setSubjectName(subjectName.getText());
        s.setTeacherName(teacherName.getText());
        s.setDay(day.getText());
        s.setClassTime(classTime.getText());
        
        Session session = HibernateUtil.getSessionFactory().openSession();//INSERT medicine 
        Transaction tx = session.beginTransaction();
        String cId1 = (String) session.save(s);
        tx.commit();
        session.close();
        System.out.println("inserted Schedule: \n"+s.getSubjectID()+""+s.getSubjectName());
    }
    public void selectSchedule(){
        Schedule select=table2.getSelectionModel().getSelectedItem();
        sID.setText(select.getSubjectID());
        subjectName.setText(select.getSubjectName());
        teacherName.setText(select.getTeacherName());
        day.setText(select.getDay());
        classTime.setText(select.getClassTime());
    }
    public void updateSchedule(){
        Schedule select=table2.getSelectionModel().getSelectedItem();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Schedule selected=null;
        
        String x=select.getSubjectID();
        selected= (Schedule)session.get(Schedule.class,x);
        
        selected.setSubjectID(sID.getText());
        selected.setSubjectName(subjectName.getText());
        selected.setTeacherName(teacherName.getText());
        selected.setDay(day.getText());
        selected.setClassTime(classTime.getText());
        
        session.update(selected);
        session.getTransaction().commit();
        session.close();
        System.out.println("Updated Schedule: \n"+s.getSubjectID()+""+s.getSubjectName());
        
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
    ObservableList <Schedule> Scheduleol= FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Session session1 = HibernateUtil.getSessionFactory().openSession();
        List<Schedule> Schedulelist = null;
        String queryStr = "from Schedule";
        Query query = session1.createQuery(queryStr);
        Schedulelist = query.list();
        session1.close();
        
        System.out.println("Schedule list size: "+Schedulelist.size());
        for(Schedule ss: Schedulelist)
        { 
              Scheduleol.add(ss);
        }//retrive from database to project
    
        col_subjectId.setCellValueFactory(new PropertyValueFactory<>("subjectID"));
        col_subjectName.setCellValueFactory(new PropertyValueFactory<>("SubjectName"));
        col_teacherName.setCellValueFactory(new PropertyValueFactory<>("teacherName"));
        col_day.setCellValueFactory(new PropertyValueFactory<>("day"));
        col_classTime.setCellValueFactory(new PropertyValueFactory<>("classTime"));

        
        table2.setItems(Scheduleol);
        table2.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
}
