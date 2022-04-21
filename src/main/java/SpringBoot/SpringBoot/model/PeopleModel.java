package SpringBoot.SpringBoot.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PeopleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String name;
    private String secondName;
    private String gender;
    private int age;
    private int seriesPassport;
    private int numberPassport;
    private String telephone;


    public PeopleModel() {
    }

    public PeopleModel(String name, String secondName, String gender, int age, int seriesPassport, int numberPassport, String telephone) {
        this.name = name;
        this.secondName = secondName;
        this.gender = gender;
        this.age = age;
        this.seriesPassport = seriesPassport;
        this.numberPassport = numberPassport;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSeriesPassport() {
        return seriesPassport;
    }

    public void setSeriesPassport(int seriesPassport) {
        this.seriesPassport = seriesPassport;
    }

    public int getNumberPassport() {
        return numberPassport;
    }

    public void setNumberPassport(int numberPassport) {
        this.numberPassport = numberPassport;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
