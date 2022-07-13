package service;

import Hibernate.HibChangeCurrent;
import Hibernate.HibDelCurrent;
import Hibernate.HibWrite;
import Parser.Parser;
import entity.HRs;
import entity.Leads;
import entity.Recruiters;
import entity.Form;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public class HandleCallbackAdmin implements Literals {

    HibWrite hw = new HibWrite();
    Parser parser = new Parser();
    HibDelCurrent hdc = new HibDelCurrent();
    HibChangeCurrent hcc= new HibChangeCurrent();


    public List<List<InlineKeyboardButton>> caseAdd() {

        List<List<InlineKeyboardButton>> buttons4 = new ArrayList<>();

        buttons4.add(Arrays.asList(
                InlineKeyboardButton.builder().text(HR_DEPT).callbackData(ADD_HR).build(),
                InlineKeyboardButton.builder().text(REC_DEPT).callbackData(ADD_REC).build(),
                InlineKeyboardButton.builder().text(LEAD_DEPT).callbackData(ADD_LEAD).build())
        );
        return buttons4;
    }


    public List<List<InlineKeyboardButton>> caseDel() {

        List<List<InlineKeyboardButton>> buttons5 = new ArrayList<>();

        buttons5.add(Arrays.asList(
                InlineKeyboardButton.builder().text(HR_DEPT).callbackData(DEL_HR).build(),
                InlineKeyboardButton.builder().text(REC_DEPT).callbackData(DEL_REC).build(),
                InlineKeyboardButton.builder().text(LEAD_DEPT).callbackData(DEL_LEAD).build())
        );
        return buttons5;
    }


    public List<List<InlineKeyboardButton>> DelHRAccept() {

        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

        buttons.add(Arrays.asList(
                        InlineKeyboardButton.builder().text(YES).callbackData(ACCEPT_HR).build(),
                        InlineKeyboardButton.builder().text(NO).callbackData(DECLINE_HR).build()
                )
        );
        return buttons;
    }


    public List<List<InlineKeyboardButton>> DelRecAccept() {

        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

        buttons.add(Arrays.asList(
                        InlineKeyboardButton.builder().text(YES).callbackData(ACCEPT_REC).build(),
                        InlineKeyboardButton.builder().text(NO).callbackData(DECLINE_REC).build()
                )
        );
        return buttons;
    }

    public List<List<InlineKeyboardButton>> DelLeadAccept() {

        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

        buttons.add(Arrays.asList(
                        InlineKeyboardButton.builder().text(YES).callbackData(ACCEPT_LEAD).build(),
                        InlineKeyboardButton.builder().text(NO).callbackData(DECLINE_LEAD).build()
                )
        );
        return buttons;
    }


    public void caseHRtoDel(String name) {
        hdc.delHR(name);
    }

    public void caseRecToDel(String name) {
        hdc.delRec(name);
    }

    public void caseLeadToDel(String name) {
        hdc.delLead(name);
    }


    public boolean addHR(String text) {

        HRs hr = parser.textParserHR(text);

        if (hr == null) {
            return false;
        } else {
            hw.addHRs(hr);
            return true;
        }
    }

    public boolean addRec(String text) {

        Recruiters rec = parser.textParserRec(text);

        if (rec == null) {
            return false;
        } else {
            hw.addRec(rec);
            return true;
        }
    }


    public boolean addLead(String text) {

        Leads lead = parser.textParserLead(text);

        if (lead == null) {
            return false;
        } else {
            hw.addLead(lead);
            return true;
        }
    }


    public List<List<InlineKeyboardButton>> caseChange() {

        List<List<InlineKeyboardButton>> buttons6 = new ArrayList<>();

        buttons6.add(Arrays.asList(
                InlineKeyboardButton.builder().text(HR_DEPT).callbackData(CHANGE_HR).build(),
                InlineKeyboardButton.builder().text(REC_DEPT).callbackData(CHANGE_REC).build(),
                InlineKeyboardButton.builder().text(LEAD_DEPT).callbackData(CHANGE_LEAD).build())
        );
        return buttons6;
    }


    public List<List<InlineKeyboardButton>> caseChangeField() {

        List<List<InlineKeyboardButton>> buttons7 = new ArrayList<>();

        buttons7.add(Arrays.asList(
                InlineKeyboardButton.builder().text(NAME).callbackData(NAME_ENG).build(),
                InlineKeyboardButton.builder().text(SURENAME).callbackData(SURENAME_ENG).build(),
                InlineKeyboardButton.builder().text(FATHERNAME).callbackData(FATHERNAME_ENG).build(),
                InlineKeyboardButton.builder().text(TG_USER).callbackData(TG_USER_ENG).build())
        );
        return buttons7;
    }


    public List<String> caseChangeFieldAccept() {

        List<String> changes = new ArrayList<>();

        changes.add(NAME_ENG);
        changes.add(SURENAME_ENG);
        changes.add(FATHERNAME_ENG);
        changes.add(TG_USER_ENG);

        return changes;
    }


    public boolean  caseChangeHRAcceptInfo(String iD, String field, String newField ) {

        return  hcc.caseChangeHR(iD,field,newField);
    }


    public boolean  caseChangeRecAcceptInfo(String iD, String field, String newField ) {

        return  hcc.caseChangeRec(iD,field,newField);
    }



    public boolean  caseChangeLeadAcceptInfo(String iD, String field, String newField ) {

        return  hcc.caseChangeLead(iD,field,newField);
    }


}
