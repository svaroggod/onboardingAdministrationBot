package entity;

import javax.persistence.*;

@Entity
public class Form {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "increment")
    private int id;

    private String device;

    private String favorite_food;

    private String animal;

    private String achievement;

    private String stop_word;

    String come_around;

    @OneToOne(mappedBy = "form")
    private Candidates candidates;

    public int getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(int candidate_id) {
        this.candidate_id = candidate_id;
    }

    @Column(name = "candidate_id")
    private int candidate_id;

    public Candidates getCandidates() {
        return candidates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCome_around() {
        return come_around;
    }

    public void setCome_around(String come_around) {
        this.come_around = come_around;
    }

    public void setCandidates(Candidates candidates) {
        this.candidates = candidates;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getFavorite_food() {
        return favorite_food;
    }

    public void setFavorite_food(String favorite_food) {
        this.favorite_food = favorite_food;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getStop_word() {
        return stop_word;
    }

    public void setStop_word(String stop_word) {
        this.stop_word = stop_word;
    }

    public String getPleasure() {
        return pleasure;
    }

    public void setPleasure(String pleasure) {
        this.pleasure = pleasure;
    }

    private String pleasure;
}