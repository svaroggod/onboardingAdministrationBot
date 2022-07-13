package service;

import Hibernate.HibGetAll;
import Hibernate.HibGetCurrent;
import entity.*;
import entity.Form;

import java.util.Date;

public class BotService {

    HibGetAll hibGetAll = new HibGetAll();
    HibGetCurrent hibGetCurrent = new HibGetCurrent();


    public String textCurrentHR(String name) {

        HRs hr = hibGetCurrent.getCurrentHR(name);

        String firstname = hr.getFirstname();
        String surName = hr.getSurname();
        String fathersName = hr.getFathername();
        String tgName = hr.getTg_username();

        return "Фамилия: " + surName + '\n' + "Имя: " + firstname + '\n'
                + "Отчество: " + fathersName + '\n' + "tgName: @" + tgName;
    }


    public String textCurrentRec(String name) {

        Recruiters rec = hibGetCurrent.getCurrentRec(name);

        String firstname = rec.getFirstname();
        String surName = rec.getSurname();
        String fathersName = rec.getFathername();
        String tgName = rec.getTg_username();

        return "Фамилия: " + surName + '\n' + "Имя: " + firstname + '\n' +
                "Отчество: " + fathersName + '\n'
                + "tgName: @" + tgName;
    }


    public String textCurrentLead(String name) {

        Leads lead = hibGetCurrent.getCurrentLead(name);

        String firstname = lead.getFirstname();
        String surName = lead.getSurname();
        String fathersName = lead.getFathername();
        String tgName = lead.getTg_username();

        return "Фамилия: " + surName + '\n' + "Имя: " + firstname + '\n'
                + "Отчество: " + fathersName + '\n'
                + "tgName: @" + tgName;
    }


    public String textCurrentCandidat(String name) {

        Candidates candidat = hibGetCurrent.getCurrentCanndidat(name);
        Form form = hibGetCurrent.getCurrentForm(name);

        String firstname = candidat.getFirstname();
        String surName = candidat.getSurname();
        String fathersName = candidat.getFathername();
        String tgID = candidat.getTgId();
        String phoneNumber = candidat.getPhone_number();
        String hrName = candidat.getHRs().getFirstname();
        String hrSureName = candidat.getHRs().getSurname();
        String startDate = String.valueOf(candidat.getStartbotdate());
        String jobDate = String.valueOf(candidat.getStartjobdate());
        String tgName = candidat.getTg_username();
        String latinName = candidat.getLatinname();
        String parking = candidat.getParking();
        Date status = candidat.getStatusdate();
        String employment = candidat.getEmployment();
        String workPlace = candidat.getWork_place();
        String status2 = String.valueOf(candidat.getStatus());





       String device;
       String favorite_food;
       String animal;
       String achievement;
       String stop_word;
       String come_around;
       String pleasure;

        if (form.getDevice() == null){
            device = "информация еще не заполнена";
        }
        else device = form.getDevice();

        if (form.getAnimal() == null){
            animal = "информация еще не заполнена";
        }
        else animal = form.getAnimal();;

        if (form.getFavorite_food() == null){
            favorite_food = "информация еще не заполнена";
        }
        else favorite_food = form.getFavorite_food();

        if (form.getAchievement() == null){
            achievement = "информация еще не заполнена";
        }
        else achievement = form.getAchievement();

        if (form.getStop_word() == null){
            stop_word = "информация еще не заполнена";
        }
        else stop_word = form.getStop_word();


        if (form.getCome_around() == null){
            come_around = "информация еще не заполнена";
        }
        else come_around = form.getCome_around();

        if (form.getPleasure() == null){
            pleasure = "информация еще не заполнена";
        }
        else pleasure = form.getPleasure();


        String leedName;
        String leedSureName;

        if (candidat.getLeeds() == null) {
            leedName = "null";
            leedSureName = "null";
        } else {
            leedName = candidat.getLeeds().getFirstname();
            leedSureName = candidat.getLeeds().getSurname();
        }

        String recrutName;
        String recrutSureName;

        if (candidat.getRec() == null) {
            recrutName = "null";
            recrutSureName = "null";

        } else {

            recrutName = candidat.getRec().getFirstname();
            recrutSureName = candidat.getRec().getSurname();

        }


        return "Фамилия: " + surName + '\n' + "Имя: " + firstname + '\n' + "Отчество: "
                + fathersName + '\n' + "tgID: " + tgID + '\n' + "Телефон: " + phoneNumber + '\n'
                + "Рекрутёр: " + recrutName + " " + recrutSureName + '\n'
                + "HR: " + hrName + " " + hrSureName + '\n'
                + "Тим лид: " + leedName + " " + leedSureName + '\n'
                + "Начало трудоустройства: " + startDate + '\n'
                + "Начало работы: " + jobDate + '\n'
                + "Имя в TG: @" + tgName + '\n'
                + "Имя латиницей: " + latinName + '\n'
                + "Парковка: " + parking + '\n'
                + "Дата: " + status + '\n'
                + "Отдел: " + employment + '\n'
                + "Рабочее место: " + workPlace + '\n'
                + "Статус: " + status2 + '\n' + '\n' + '\n'
                + "Личная информация о кандидате: " + '\n'
                + "Рабочий девайс: " + device +'\n'
                + "Любимая еда: " + favorite_food + '\n'
                + "Животное: " + animal + '\n'
                + "Стоп-слово: " + stop_word + '\n'
                + "Pleasure: " + pleasure + '\n'
                + "Достижение: " + achievement + '\n'
                + "Come_around: " + come_around;


    }

}
