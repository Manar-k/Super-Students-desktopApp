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
@Table(name="Record")
public class Record {
   @Id
   @Column(name="ID")
   String ID;
   @Column(name="Subject")
   String Subject;
   @Column(name="Grade")
   String Grade;
   @Column(name="Attende")
   String Attende;
   @Column(name="Rate")
   String Rate;
   
   public Record(){
       
    }

    public Record(String ID, String Subject,String Grade,String Attende,String Rate) {
        this.ID = ID;
        this.Subject = Subject;
        this.Grade=Grade;
        this.Attende=Attende;
        this.Rate=Rate;
    }
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public String getSubject() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }
    public String getGrade() {
        return Grade;
    }

    public void setGrade(String Grade) {
        this.Grade = Grade;
    }
    public String getAttende() {
        return Attende;
    }

    public void setAttende(String Attende) {
        this.Attende = Attende;
    }
    public String getRate() {
        return Rate;
    }

    public void setRate(String Rate) {
        this.Rate = Rate;
    }
}
