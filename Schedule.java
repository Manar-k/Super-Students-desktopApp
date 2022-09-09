/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package super_students;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author lokamloka
 */
@Entity
@Table(name="Schedule")
public class Schedule {
   @Id
   @Column(name="subjectID")
   String subjectID;
   @Column(name="SubjectName")
   String SubjectName;
   @Column(name="teacherName")
   String teacherName;
   @Column(name="day")
   String day;
   @Column(name="classTime")
   String classTime;
   
   public Schedule(){
       
    }

    public Schedule(String subjectID, String SubjectName,String teacherName,String day,String classTime) {
        this.subjectID = subjectID;
        this.SubjectName = SubjectName;
        this.teacherName=teacherName;
        this.day=day;
        this.classTime=classTime;
    }
    
    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }
    
    public void setSubjectName(String SubjectName) {
        this.SubjectName = SubjectName;
    }
    
    public String getSubjectName() {
        return SubjectName;
    }
    
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    
    public String getDay() {
        return day;
    }
    
    public void setDay(String day) {
        this.day = day;
    }
    
    public String getTeacherName() {
        return teacherName;
    }
    
    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }
    
    public String getClassTime() {
        return classTime;
    }
}
