package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "public", name = "leads")
public class Leads {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "tgId")
    private String  tgId;


    @Column(name = "firstname")
    String firstname;

    @Column(name = "surname")
    String surname;

    @Column(name = "fathername")
    String fathername;

    @Column(name = "status")
   int status;

    @Column(name = "tg_username")
    String tg_username;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "leads",
            fetch = FetchType.EAGER)
    private List<Candidates> candidatesList;

    public Leads() {
    }

    public Leads(String tg_username, String firstname,
                 String surname, String fathername) {
        this.tg_username = tg_username;
        this.firstname = firstname;
        this.surname = surname;
        this.fathername = fathername;

    }

    public Leads(String tgId, String firstname, String surname,
               String fathername, int status) {
        this.tgId = tgId;
        this.firstname = firstname;
        this.surname = surname;
        this.fathername = fathername;
        this.status = status;


    }

    public void addCandidateLeads(Candidates candidates) {
        if (candidatesList == null) {
            candidatesList = new ArrayList<>();
        }
        candidatesList.add(candidates);
        candidates.setLeeds(this);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String  getTgId() {
        return tgId;
    }
    public void setTgId(String  tgId) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Candidates> getCandidatesList() {
        return candidatesList;
    }

    public String getTg_username() {
        return tg_username;
    }

    public void setTg_username(String tg_username) {
        this.tg_username = tg_username;
    }

    public void setCandidatesList(List<Candidates> candidatesList) {
        this.candidatesList = candidatesList;
    }

    public List<Candidates> getCandidates() {
        return candidatesList;
    }

    public void setCandidates(List<Candidates> candidates) {
        this.candidatesList = candidates;
    }

    @Override
    public String toString() {
        return "Leeds{" +
                "tgId=" + tgId +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", fathername='" + fathername + '\'' +
                ", candidates=" + candidatesList +
                '}';
    }
}
