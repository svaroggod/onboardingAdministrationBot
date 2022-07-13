package service;


import Parser.Parser;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class HandleMessage implements Literals {

    Parser parser = new Parser();
    HandleCallbackView hc = new HandleCallbackView();


    public List<List<InlineKeyboardButton>> caseStart() {

        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        List<InlineKeyboardButton> row3 = new ArrayList<>();

        row1.add(InlineKeyboardButton.builder().text(EMPLOYEES_LIST).callbackData(GET_EMPLOYEES).build());
        row2.add(InlineKeyboardButton.builder().text(CANDIDATES).callbackData(GET_EMPLOYEES2).build());
        row3.add(InlineKeyboardButton.builder().text(ADMIN).callbackData(GET_EMPLOYEES3).build());

        buttons.add(row1);
        buttons.add(row2);
        buttons.add(row3);

        return buttons;
    }


    public List<List<InlineKeyboardButton>> caseEmployees() {

        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

        buttons.add(Arrays.asList(
                InlineKeyboardButton.builder().text(HR_DEPT).callbackData(HR).build(),
                InlineKeyboardButton.builder().text(REC_DEPT).callbackData(REC).build(),
                InlineKeyboardButton.builder().text(LEAD_DEPT).callbackData(LEAD).build())
        );
        return buttons;
    }

    public List<List<InlineKeyboardButton>> caseEmployees2() {

        Map<String, String> listik = hc.caseCandidat();

        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

        for (Map.Entry<String, String> entry : listik.entrySet()) {

            buttons.add(List.of(
                    InlineKeyboardButton.builder().text(entry.getKey()).callbackData(entry.getValue()).build()));
        }

        return buttons;
    }


    public List<List<InlineKeyboardButton>> caseEmployees3() {

        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();

        keyboardButtonsRow1.add(InlineKeyboardButton.builder().text(ADD_EMPLOYEE).callbackData(ADD).build());
        keyboardButtonsRow2.add(InlineKeyboardButton.builder().text(DEL_EMPLOYEE).callbackData(DEL).build());
        keyboardButtonsRow3.add(InlineKeyboardButton.builder().text(CHANGE_EMPLOYEE).callbackData(CHANGE).build());

        buttons.add(keyboardButtonsRow1);
        buttons.add(keyboardButtonsRow2);
        buttons.add(keyboardButtonsRow3);

        return buttons;

    }

    public boolean checkFieldsCaseChange(String text, String field) {

        boolean valid = false;

        switch (field) {
            case SURENAME_ENG -> valid = parser.surnameChecking(text);
            case NAME_ENG -> valid = parser.nameChecking(text);
            case FATHERNAME_ENG -> valid = parser.fatherNameChecking(text);
            case TG_USER_ENG -> valid = parser.tgIdChecking(text);
        }

        return valid;
    }





}


