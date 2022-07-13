package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "public", name = "candidates")
public class Candidates {

    public Candidates() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "increment")
    private int id;

    @Column(name = "tgId")
    private String tgId;

    @Column(name = "firstname")
    String firstname;

    @Column(name = "surname")
    String surname;

    @Column(name = "fathername")
    String fathername;

    @Column(name = "phone_number")
    String phone_number;

    @Column(name = "status")
    int status;

    @Column(name = "startbotdate")
    Date startbotdate;

    @Column(name = "startjobdate")
    Date startjobdate;

    @Column(name = "tg_username")
    String tg_username;

    @Column(name = "latinname")
    String latinname;

    @Column(name = "parking")
    String parking;

    @Column(name = "statusdate")
    Date statusdate;

    @Column( name = "employment")
    String employment;

    @Column ( name = "work_place")
    String  work_place;

    @Column (name = "name_and_phone_relative")
    String nameAndPhoneRelative;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hrs_id")
    private HRs hrs;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "leads_id")
    private Leads leads;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recruters_id")
    private Recruiters rec;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Documents documents;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Form form;

    public Candidates(String firstname, String surname,
                      String fathername, String tgId, String phone_number, int status, Date startbotdate,
                      Date startjobdate, String tg_username,String latinname, String parking,Date statusdate,String employment,String work_place) {
        this.tgId = tgId;
        this.tg_username = tg_username;
        this.firstname = firstname;
        this.surname = surname;
        this.fathername = fathername;
        this.phone_number = phone_number;
        this.status = status;
        this.startbotdate = startbotdate;
        this.startjobdate = startjobdate;
        this.latinname=latinname;
        this.parking=parking;
        this.statusdate=statusdate;
        this.employment=employment;
        this.work_place=work_place;
    }
    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }
    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public String getNameAndPhoneRelative() {
        return nameAndPhoneRelative;
    }

    public void setNameAndPhoneRelative(String nameAndPhoneRelative) {
        this.nameAndPhoneRelative = nameAndPhoneRelative;
    }

    public Documents getDocuments() {
        return documents;
    }

    public void setDocuments(Documents documents) {
        this.documents = documents;
    }

    public String getLatinname() {
        return latinname;
    }

    public void setLatinname(String latinname) {
        this.latinname = latinname;
    }

    public String getParking() {
        return parking;
    }

    public String getWork_place() {
        return work_place;
    }

    public void setWork_place(String work_place) {
        this.work_place = work_place;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public Date getStatusdate() {
        return statusdate;
    }

    public void setStatusdate(Date statusdate) {
        this.statusdate = statusdate;
    }

    public String getTg_username() {
        return tg_username;
    }

    public void setTg_username(String tg_username) {
        this.tg_username = tg_username;
    }

    public HRs getHrs() {
        return hrs;
    }

    public void setHrs(HRs hrs) {
        this.hrs = hrs;
    }

    public Leads getLeads() {
        return leads;
    }

    public void setLeads(Leads leads) {
        this.leads = leads;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTgId() {
        return tgId;
    }

    public void setTgId(String tgId) {
        this.tgId = tgId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getStartbotdate() {
        return startbotdate;
    }

    public void setStartbotdate(Date startbotdate) {
        this.startbotdate = startbotdate;
    }

    public Date getStartjobdate() {
        return startjobdate;
    }

    public void setStartjobdate(Date startjobdate) {
        this.startjobdate = startjobdate;
    }

    public HRs getHRs() {
        return hrs;
    }

    public void setHRs(HRs hrs) {
        this.hrs = hrs;
    }

    public Leads getLeeds() {
        return leads;
    }

    public void setLeeds(Leads leads) {
        this.leads = leads;
    }

    public Recruiters getRec() {
        return rec;
    }

    public void setRec(Recruiters rec) {
        this.rec = rec;
    }

    public String toString2() {
        return "\nКандидат:\n" +
                " Имя: " + firstname + '\n'
                + " Фамилия: " + surname + '\n'
                + " Отчество: " + fathername + '\n'
                + " tgName: " + tg_username+"\n"
                + " Номер телефона: " + phone_number + "\n"
                + " Hачало работы: " + startjobdate + "\n"
                + " Трудоустройство: " + employment+ "\n"
                + " Локация: " + work_place+ "\n"
                + " Статус: " + status+ "\n";
    }

    @Override
    public String toString() {
        return "\nКандидат:\n" +
                " Имя: " + firstname + '\n'
                +" Фамилия: " + surname + '\n'
                + " tgName: " + tg_username+ '\n';
    }
}