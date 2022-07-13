package entity;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "documents")
public class Documents {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "increment")
    private int id;

    @Column(name = "candidate_id")
    private int candidate_id;

    public int getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(int candidate_id) {
        this.candidate_id = candidate_id;
    }

    @Column(name = "pasport")
    boolean pasport;

    @Column(name = "inn")
    boolean inn;

    @Column(name = "diplom")
    boolean diplom;

    @Column(name = "card_details")
    boolean card_details;

    @Column(name = "photo")
    boolean photo;

    @Column(name = "certification_registration_ip")
    boolean certification;

    @Column(name = "snils")
    boolean snils;

    @Column(name = "millitary_id")
    boolean millitary_id;

    @Column(name = "employment_records")
    boolean employment_records;

    @Column(name = "referance_182n")
    boolean referance;

    public Candidates getCandidates() {
        return candidates;
    }

    public void setCandidates(Candidates candidates) {
        this.candidates = candidates;
    }

    @OneToOne(mappedBy = "documents")
    private Candidates candidates;

    public Documents documentsIP(){
        Documents documents = new Documents();
        documents.setMillitary_id(true);
        documents.setSnils(true);
        documents.setEmployment_records(true);
        documents.setReferance(true);
        documents.setDiplom(true);
        return documents;
    }

    public boolean trueAll() {
        return card_details &&
                pasport &&
                inn &&
                diplom &&
                photo &&
                certification &&
                snils &&
                millitary_id &&
                employment_records &&
                referance;
    }

    public Documents documentsTK(){
        Documents documents = new Documents();
        documents.setCertification(true);
        return documents;
    }

    public Documents() {
    }

    public boolean isDiplom() {
        return diplom;
    }

    public void setDiplom(boolean diplom) {
        this.diplom = diplom;
    }

    public boolean isPasport() {
        return pasport;
    }

    public void setPasport(boolean pasport) {
        this.pasport = pasport;
    }

    public boolean isSnils() {
        return snils;
    }

    public void setSnils(boolean snils) {
        this.snils = snils;
    }

    public boolean isInn() {
        return inn;
    }

    public void setInn(boolean inn) {
        this.inn = inn;
    }

    public boolean isMillitary_id() {
        return millitary_id;
    }

    public void setMillitary_id(boolean millitary_id) {
        this.millitary_id = millitary_id;
    }

    public boolean isEmployment_records() {
        return employment_records;
    }

    public void setEmployment_records(boolean employment_records) {
        this.employment_records = employment_records;
    }

    public boolean isPhoto() {
        return photo;
    }

    public void setPhoto(boolean photo) {
        this.photo = photo;
    }

    public boolean isCard_details() {
        return card_details;
    }

    public void setCard_details(boolean card_details) {
        this.card_details = card_details;
    }

    public boolean isReferance() {
        return referance;
    }

    public void setReferance(boolean referance) {
        this.referance = referance;
    }

    public boolean isCertification() {
        return certification;
    }

    public void setCertification(boolean certification) {
        this.certification = certification;
    }
}