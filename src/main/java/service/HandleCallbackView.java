package service;

import Hibernate.HibGetAll;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HandleCallbackView {

    HibGetAll hibGetAll = new HibGetAll();
    BotService botService = new BotService();



    public List<List<InlineKeyboardButton>> caseHRbuttons(Map<String, String> listik) {

        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

        for (Map.Entry<String, String> entry : listik.entrySet()) {

            buttons.add(List.of(
                    InlineKeyboardButton.builder().text(entry.getKey()).callbackData(entry.getValue()).build()));
        }
        return buttons;
    }


    public List<List<InlineKeyboardButton>> caseRecButtons(Map<String, String> listik) {

        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

        for (Map.Entry<String, String> entry : listik.entrySet()) {

            buttons.add(List.of(
                    InlineKeyboardButton.builder().text(entry.getKey()).callbackData(entry.getValue()).build()));
        }

        return buttons;
    }


    public List<List<InlineKeyboardButton>> caseLeadButtons(Map<String, String> listik) {

        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

        for (Map.Entry<String, String> entry : listik.entrySet()) {

            buttons.add(List.of(
                    InlineKeyboardButton.builder().text(entry.getKey()).callbackData(entry.getValue()).build()));
        }
        return buttons;
    }


    public Map<String, String> caseHR() {
        return hibGetAll.getHRs();
    }

    public Map<String, String> caseRec() {
        return hibGetAll.getRecruiters();
    }

    public Map<String, String> caseLead() {
        return hibGetAll.getLeads();
    }

    public Map<String, String> caseCandidat() {
        return hibGetAll.getCandidates();
    }

    public String caseHRifMatch(String name) {
        return botService.textCurrentHR(name);
    }

    public String caseRECifMatch(String name) {
        return botService.textCurrentRec(name);
    }

    public String caseLeadIfMatch(String name) {
        return botService.textCurrentLead(name);
    }

    public String caseCandidadIfMatch(String name) {
        return botService.textCurrentCandidat(name);
    }


}


