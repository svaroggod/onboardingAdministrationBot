package service;

import BotUser.BotUser;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public class Bot extends TelegramLongPollingBot implements Config, Literals {


    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {

        if (update.hasCallbackQuery()) {
            handleCallback(update.getCallbackQuery());

        } else if (update.hasMessage()) {
            handleMessage(update.getMessage());
        }
    }


    private void handleMessage(Message message) throws TelegramApiException {

        User user = message.getFrom();   // проверку пользователя нужно доделать
        String iD = user.getUserName();

        if (message.hasText() && message.hasEntities()) {
            Optional<MessageEntity> commandEntity =
                    message.getEntities()
                            .stream()
                            .filter(e -> BOT_COMMAND
                                    .equals(e.getType()))
                            .findFirst();

            if (commandEntity.isPresent()) {
                String command = message.getText().substring(commandEntity.get().getOffset(), commandEntity.get().getLength());

                switch (command) {
                    case START -> handleMessageCaseStart(message);
                    case GET_EMPLOYEES -> handleMessageCaseEmployees(message, iD);
                    case GET_EMPLOYEES2 -> handleMessageCaseEmployees2(message, iD);
                    case GET_EMPLOYEES3 -> handleMessageCaseEmployees3(message);
                }
            }
        }


        if (userMap.get(iD).isAddHR()) handleCallbackCaseAddHRAccept(message, iD);
        if (userMap.get(iD).isAddRec()) handleCallbackCaseAddRecAccept(message, iD);
        if (userMap.get(iD).isAddLead()) handleCallbackCaseAddLeadAccept(message, iD);
        if (userMap.get(iD).isHRInfo()) handleCallbackCaseChangeHRInfo(message, iD);
        if (userMap.get(iD).isRecInfo()) handleCallbackCaseChangeRecInfo(message, iD);
        if (userMap.get(iD).isLeadInfo()) handleCallbackCaseChangeLeadInfo(message, iD);
    }


    private void handleCallback(CallbackQuery callbackQuery) throws TelegramApiException {


        Message message = callbackQuery.getMessage();
        String[] data = callbackQuery.getData().split(":");
        String action = data[0];

        User user = callbackQuery.getFrom();
        String iD = user.getUserName();

        switch (action) {
            case START -> handleMessageCaseStart(message);
            case GET_EMPLOYEES -> handleMessageCaseEmployees(message, iD);
            case GET_EMPLOYEES2 -> handleMessageCaseEmployees2(message, iD);
            case GET_EMPLOYEES3 -> handleMessageCaseEmployees3(message);
            case HR -> handleCallbackCaseHR(message, iD);
            case REC -> handleCallbackCaseRec(message, iD);
            case LEAD -> handleCallbackCaseLead(message, iD);
            case ADD -> handleCallbackCaseAdd(message, iD);
            case DEL -> handleCallbackCaseDel(message, iD);
            case DEL_HR, DECLINE_HR -> handleCallbackCaseDelHR(message, iD);
            case DEL_REC, DECLINE_REC -> handleCallbackCaseDelRec(message, iD);
            case DEL_LEAD, DECLINE_LEAD -> handleCallbackCaseDelLead(message, iD);
            case CHANGE -> handleCallbackCaseChange(message, iD);
            case ACCEPT_HR -> handleCallbackCaseDelHRacceptTrue(message, iD);
            case ACCEPT_REC -> handleCallbackCaseDelRecAcceptTrue(message, iD);
            case ACCEPT_LEAD -> handleCallbackCaseDelLeadAcceptTrue(message, iD);
            case CHANGE_HR -> handleCallbackCaseChangeHR(message, iD);
            case CHANGE_REC -> handleCallbackCaseChangeRec(message, iD);
            case CHANGE_LEAD -> handleCallbackCaseChangeLead(message, iD);
            case ADD_HR -> handleCallbackCaseAddHR(message, iD);
            case ADD_REC -> handleCallbackCaseAddRecruiter(message, iD);
            case ADD_LEAD -> handleCallbackCaseAddLead(message, iD);

        }


        if (userMap.get(iD).isHR()) handleCallbackCaseHRview(action, message);
        if (userMap.get(iD).isRec()) handleCallbackCaseRecView(action, message);
        if (userMap.get(iD).isLead()) handleCallbackCaseLeadView(action, message);
        if (userMap.get(iD).isCandidates()) handleCallbackCaseCandidatesView(action, message);

        if (userMap.get(iD).isDelHR()) handleCallbackCaseDelHRaccept(action, message, iD);
        if (userMap.get(iD).isDelRec()) handleCallbackCaseDelRecAccept(action, message, iD);
        if (userMap.get(iD).isDelLead()) handleCallbackCaseDelLeadAccept(action, message, iD);

        if (userMap.get(iD).isChangeHR()) handleCallbackCaseChangeHRAccept(action, message, iD);
        if (userMap.get(iD).isChangeHRAccept()) handleCallbackCaseChangeHRAcceptTrue(action, iD);
        if (userMap.get(iD).isChangeHRAcceptInfo()) handleCallbackCaseChangeHRAcceptTrueInfo(message, iD);

        if (userMap.get(iD).isChangeRec()) handleCallbackCaseChangeRecAccept(action, message, iD);
        if (userMap.get(iD).isChangeRecAccept()) handleCallbackCaseChangeRecAcceptTrue(action, iD);
        if (userMap.get(iD).isChangeRecAcceptInfo()) handleCallbackCaseChangeRecAcceptTrueInfo(message, iD);

        if (userMap.get(iD).isChangeLead()) handleCallbackCaseChangeLeadAccept(action, message, iD);
        if (userMap.get(iD).isChangeLeadAccept()) handleCallbackCaseChangeLeadAcceptTrue(action, iD);
        if (userMap.get(iD).isChangeLeadAcceptInfo()) handleCallbackCaseChangeLeadAcceptTrueInfo(message, iD);


    }




    private void handleMessageCaseStart(Message message) throws TelegramApiException {

//        checkUser(message);

        User user = message.getFrom();
        if (!userMap.containsKey(user.getUserName())) {
            userMap.put(user.getUserName(), new BotUser());
        }

        deleteMessage(message.getChatId(), message.getMessageId());
        List<List<InlineKeyboardButton>> buttons = handleMessage.caseStart();
        execute(SendMessage.builder()
                .text(HELLO + user.getFirstName() + WHAT_WE_SHOULD)
                .chatId(message.getChatId().toString())
                .replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttons).build())
                .build());

    }


    private void handleMessageCaseEmployees(Message message, String iD) throws TelegramApiException {

        userMap.get(iD).setFlags();
        deleteMessage(message.getChatId(), message.getMessageId());
        List<List<InlineKeyboardButton>> buttons = handleMessage.caseEmployees();
        sendMessageAndKeyboard(message, WHAT_CATEGORIES, buttons);
    }

    private void handleMessageCaseEmployees2(Message message, String iD) throws TelegramApiException {

        userMap.get(iD).setCandidates(true);
        deleteMessage(message.getChatId(), message.getMessageId());
        List<List<InlineKeyboardButton>> buttons = handleMessage.caseEmployees2();
        sendMessageAndKeyboard(message, CANDIDATES, buttons);

    }


    private void handleMessageCaseEmployees3(Message message) throws TelegramApiException {

        deleteMessage(message.getChatId(), message.getMessageId());
        List<List<InlineKeyboardButton>> buttons = handleMessage.caseEmployees3();
        sendMessageAndKeyboard(message, SELECT_ACTION, buttons);

    }

    private void handleCallbackCaseCandidatesView(String action, Message message) throws TelegramApiException {

        Map<String, String> listik = handleCallbackView.caseCandidat();
        for (Map.Entry<String, String> entry : listik.entrySet()) {
            if (action.equals(entry.getValue())) {
                String candidatData = handleCallbackView.caseCandidadIfMatch(action);
                sendMessage(message, candidatData);

            }
        }
    }


    private void handleCallbackCaseHR(Message message, String iD) throws TelegramApiException {

        userMap.get(iD).setHR(true);
        deleteMessage(message.getChatId(), message.getMessageId());
        Map<String, String> listik = handleCallbackView.caseHR();
        List<List<InlineKeyboardButton>> buttons = handleCallbackView.caseHRbuttons(listik);
        sendMessageAndKeyboard(message, HR_LIST, buttons);

    }

    private void handleCallbackCaseHRview(String action, Message message) throws TelegramApiException {

        Map<String, String> listik = handleCallbackView.caseHR();
        for (Map.Entry<String, String> entry : listik.entrySet()) {
            if (action.equals(entry.getValue())) {
                String candidatData = handleCallbackView.caseHRifMatch(action);
                sendMessage(message, candidatData);
            }
        }
    }


    private void handleCallbackCaseRec(Message message, String iD) throws TelegramApiException {

        userMap.get(iD).setRec(true);
        deleteMessage(message.getChatId(), message.getMessageId());
        Map<String, String> listik = handleCallbackView.caseRec();
        List<List<InlineKeyboardButton>> buttons = handleCallbackView.caseRecButtons(listik);
        sendMessageAndKeyboard(message, REC_LIST, buttons);
    }


    private void handleCallbackCaseRecView(String action, Message message) throws TelegramApiException {

        Map<String, String> listik = handleCallbackView.caseRec();
        for (Map.Entry<String, String> entry : listik.entrySet()) {
            if (action.equals(entry.getValue())) {
                String recData = handleCallbackView.caseRECifMatch(action);
                sendMessage(message, recData);

            }
        }
    }


    private void handleCallbackCaseLead(Message message, String iD) throws TelegramApiException {

        userMap.get(iD).setLead(true);
        deleteMessage(message.getChatId(), message.getMessageId());
        Map<String, String> listik = handleCallbackView.caseLead();
        List<List<InlineKeyboardButton>> buttons = handleCallbackView.caseLeadButtons(listik);
        sendMessageAndKeyboard(message, LEAD_LIST, buttons);

    }


    private void handleCallbackCaseLeadView(String action, Message message) throws TelegramApiException {

        Map<String, String> listik = handleCallbackView.caseLead();
        for (Map.Entry<String, String> entry : listik.entrySet()) {
            if (action.equals(entry.getValue())) {
                String leadData = handleCallbackView.caseLeadIfMatch(action);
                sendMessage(message, leadData);
            }
        }
    }


    private void handleCallbackCaseDel(Message message, String iD) throws TelegramApiException {

        userMap.get(iD).setFlags();
        deleteMessage(message.getChatId(), message.getMessageId());
        List<List<InlineKeyboardButton>> buttons = handleCallbackAdmin.caseDel();
        sendMessageAndKeyboard(message, DEPARTMENT_TO_DEL, buttons);
    }


    private void handleCallbackCaseDelHR(Message message, String iD) throws TelegramApiException {

        userMap.get(iD).setDelHR(true);
        deleteMessage(message.getChatId(), message.getMessageId());
        Map<String, String> listik = handleCallbackView.caseHR();
        List<List<InlineKeyboardButton>> buttons = handleCallbackView.caseHRbuttons(listik);
        sendMessageAndKeyboard(message, HR_LIST, buttons);

    }


    private void handleCallbackCaseDelHRaccept(String action, Message message, String iD) throws TelegramApiException {

        deleteMessage(message.getChatId(), message.getMessageId());
        Map<String, String> listik = handleCallbackView.caseHR();
        for (Map.Entry<String, String> entry : listik.entrySet()) {
            if (action.equals(entry.getValue())) {
                userMap.get(iD).setHrName(action);
                System.out.println(action);
                List<List<InlineKeyboardButton>> buttons = handleCallbackAdmin.DelHRAccept();
                sendMessageAndKeyboard(message, U_SURE, buttons);

            }
        }
    }


    private void handleCallbackCaseDelHRacceptTrue(Message message, String iD) throws TelegramApiException {

        deleteMessage(message.getChatId(), message.getMessageId());
        handleCallbackAdmin.caseHRtoDel(userMap.get(iD).getHrName());
        sendMessage(message, EMPLOYEE_DEL);
        userMap.get(iD).setDelHR(false);
        userMap.get(iD).setHrName(null);
        handleCallbackCaseHR(message, iD);
    }


    private void handleCallbackCaseDelRec(Message message, String iD) throws TelegramApiException {

        userMap.get(iD).setDelRec(true);
        deleteMessage(message.getChatId(), message.getMessageId());
        Map<String, String> listik = handleCallbackView.caseRec();
        List<List<InlineKeyboardButton>> buttons = handleCallbackView.caseRecButtons(listik);
        sendMessageAndKeyboard(message, REC_LIST, buttons);
    }


    private void handleCallbackCaseDelRecAccept(String action, Message message, String iD) throws TelegramApiException {

        deleteMessage(message.getChatId(), message.getMessageId());
        Map<String, String> listik = handleCallbackView.caseRec();
        for (Map.Entry<String, String> entry : listik.entrySet()) {
            if (action.equals(entry.getValue())) {
                userMap.get(iD).setRecName(action);
                List<List<InlineKeyboardButton>> buttons = handleCallbackAdmin.DelRecAccept();
                sendMessageAndKeyboard(message, U_SURE, buttons);
            }
        }
    }


    private void handleCallbackCaseDelRecAcceptTrue(Message message, String iD) throws TelegramApiException {

        deleteMessage(message.getChatId(), message.getMessageId());
        System.out.println(userMap.get(iD).getRecName());
        handleCallbackAdmin.caseRecToDel(userMap.get(iD).getRecName());
        sendMessage(message, EMPLOYEE_DEL);
        userMap.get(iD).setDelRec(false);
        userMap.get(iD).setRecName(null);
        handleCallbackCaseRec(message, iD);

    }

    private void handleCallbackCaseDelLead(Message message, String iD) throws TelegramApiException {

        userMap.get(iD).setDelLead(true);
        deleteMessage(message.getChatId(), message.getMessageId());
        Map<String, String> listik = handleCallbackView.caseLead();
        List<List<InlineKeyboardButton>> buttons = handleCallbackView.caseLeadButtons(listik);
        sendMessageAndKeyboard(message, LEAD_LIST, buttons);

    }

    private void handleCallbackCaseDelLeadAccept(String action, Message message, String iD) throws TelegramApiException {

        deleteMessage(message.getChatId(), message.getMessageId());
        Map<String, String> listik = handleCallbackView.caseLead();
        for (Map.Entry<String, String> entry : listik.entrySet()) {
            if (action.equals(entry.getValue())) {
                userMap.get(iD).setLeadName(action);
                List<List<InlineKeyboardButton>> buttons = handleCallbackAdmin.DelLeadAccept();
                sendMessageAndKeyboard(message, U_SURE, buttons);

            }
        }
    }


    private void handleCallbackCaseDelLeadAcceptTrue(Message message, String iD) throws TelegramApiException {

        deleteMessage(message.getChatId(), message.getMessageId());
        handleCallbackAdmin.caseLeadToDel(userMap.get(iD).getLeadName());
        sendMessage(message, EMPLOYEE_DEL);
        userMap.get(iD).setDelLead(false);
        userMap.get(iD).setLeadName(null);
        handleCallbackCaseLead(message, iD);

    }


    private void handleCallbackCaseChange(Message message, String iD) throws TelegramApiException {

        userMap.get(iD).setFlags();
        deleteMessage(message.getChatId(), message.getMessageId());
        List<List<InlineKeyboardButton>> buttons = handleCallbackAdmin.caseChange();
        sendMessageAndKeyboard(message, WHERE_CHANGE, buttons);

    }


    private void handleCallbackCaseChangeHR(Message message, String iD) throws TelegramApiException {

        userMap.get(iD).setChangeHR(true);
        deleteMessage(message.getChatId(), message.getMessageId());
        Map<String, String> listik = handleCallbackView.caseHR();
        List<List<InlineKeyboardButton>> buttons = handleCallbackView.caseHRbuttons(listik);
        sendMessageAndKeyboard(message, HR_LIST, buttons);
    }

    private void handleCallbackCaseChangeHRAccept(String action, Message message, String iD) throws TelegramApiException {

        deleteMessage(message.getChatId(), message.getMessageId());
        Map<String, String> listik = handleCallbackView.caseHR();
        for (Map.Entry<String, String> entry : listik.entrySet()) {
            if (action.equals(entry.getValue())) {
                userMap.get(iD).setHrName(action);
                userMap.get(iD).setChangeHR(false);
                List<List<InlineKeyboardButton>> buttons = handleCallbackAdmin.caseChangeField();
                sendMessageAndKeyboard(message, WHERE_CHANGE, buttons);
                userMap.get(iD).setChangeHRAccept(true);
            }
        }
    }


    private void handleCallbackCaseChangeHRAcceptTrue(String action, String iD) {

        List<String> changes = handleCallbackAdmin.caseChangeFieldAccept();
        for (String str : changes) {
            if (action.equals(str)) {
                userMap.get(iD).setInfoToChange(action);
                userMap.get(iD).setChangeHRAccept(false);
                userMap.get(iD).setChangeHRAcceptInfo(true);
            }
        }
    }


    private void handleCallbackCaseChangeHRAcceptTrueInfo(Message message, String iD) throws TelegramApiException {

        deleteMessage(message.getChatId(), message.getMessageId());
        sendMessage(message, NEW_VALUE);
        userMap.get(iD).setChangeHRAcceptInfo(false);
        userMap.get(iD).setHRInfo(true);

    }


    private void handleCallbackCaseChangeHRInfo(Message message, String iD) throws TelegramApiException {

        String newField = message.getText();
        String id = userMap.get(iD).getHrName();
        String infToChange = userMap.get(iD).getInfoToChange();
        if (handleMessage.checkFieldsCaseChange(newField, infToChange)) {
            boolean success = handleCallbackAdmin.caseChangeHRAcceptInfo(id, infToChange, newField);
            if (success) {
                sendMessage(message, SUCCESS);
                userMap.get(iD).setHRInfo(false);
                handleCallbackCaseHR(message, iD);
            } else {
                sendMessage(message, FAIL);
            }
        } else sendMessage(message, FAIL);

    }


    public void handleCallbackCaseChangeRec(Message message, String iD) throws TelegramApiException {

        userMap.get(iD).setChangeRec(true);
        deleteMessage(message.getChatId(), message.getMessageId());
        Map<String, String> listik = handleCallbackView.caseRec();
        List<List<InlineKeyboardButton>> buttons = handleCallbackView.caseRecButtons(listik);
        sendMessageAndKeyboard(message, REC_LIST, buttons);

    }


    private void handleCallbackCaseChangeRecAccept(String action, Message message, String iD) throws TelegramApiException {


        deleteMessage(message.getChatId(), message.getMessageId());
        Map<String, String> listik = handleCallbackView.caseRec();
        for (Map.Entry<String, String> entry : listik.entrySet()) {
            if (action.equals(entry.getValue())) {
                userMap.get(iD).setRecName(action);
                userMap.get(iD).setChangeRec(false);
                List<List<InlineKeyboardButton>> buttons = handleCallbackAdmin.caseChangeField();
                sendMessageAndKeyboard(message, WHAT_TO_CHANGE, buttons);
                userMap.get(iD).setChangeRecAccept(true);

            }
        }
    }

    private void handleCallbackCaseChangeRecAcceptTrue(String action, String iD) {

        List<String> changes = handleCallbackAdmin.caseChangeFieldAccept();
        for (String str : changes) {
            if (action.equals(str)) {
                userMap.get(iD).setInfoToChange(action);
                userMap.get(iD).setChangeRecAccept(false);
                userMap.get(iD).setChangeRecAcceptInfo(true);
            }
        }
    }


    private void handleCallbackCaseChangeRecAcceptTrueInfo(Message message, String iD) throws TelegramApiException {

        deleteMessage(message.getChatId(), message.getMessageId());
        sendMessage(message, NEW_VALUE);
        userMap.get(iD).setChangeRecAcceptInfo(false);
        userMap.get(iD).setRecInfo(true);

    }


    private void handleCallbackCaseChangeRecInfo(Message message, String iD) throws TelegramApiException {

        String id = userMap.get(iD).getRecName();
        String infToChange = userMap.get(iD).getInfoToChange();
        String newField = message.getText();

        if (handleMessage.checkFieldsCaseChange(newField, infToChange)) {
            boolean success = handleCallbackAdmin.caseChangeRecAcceptInfo(id, infToChange, newField);
            if (success) {
                sendMessage(message, SUCCESS);
                userMap.get(iD).setRecInfo(false);
                handleCallbackCaseRec(message, iD);
            } else {
                sendMessage(message, FAIL);
            }
        } else sendMessage(message, FAIL);
    }


    public void handleCallbackCaseChangeLead(Message message, String iD) throws TelegramApiException {

        userMap.get(iD).setChangeLead(true);
        deleteMessage(message.getChatId(), message.getMessageId());
        Map<String, String> listik = handleCallbackView.caseLead();
        List<List<InlineKeyboardButton>> buttons = handleCallbackView.caseLeadButtons(listik);
        sendMessageAndKeyboard(message, LEAD_LIST, buttons);
    }


    private void handleCallbackCaseChangeLeadAccept(String action, Message message, String iD) throws TelegramApiException {

        deleteMessage(message.getChatId(), message.getMessageId());
        Map<String, String> listik = handleCallbackView.caseLead();
        for (Map.Entry<String, String> entry : listik.entrySet()) {
            if (action.equals(entry.getValue())) {
                userMap.get(iD).setLeadName(action);
                userMap.get(iD).setChangeLead(false);
                List<List<InlineKeyboardButton>> buttons = handleCallbackAdmin.caseChangeField();
                sendMessageAndKeyboard(message, WHAT_TO_CHANGE, buttons);
                userMap.get(iD).setChangeLeadAccept(true);

            }
        }
    }


    private void handleCallbackCaseChangeLeadAcceptTrue(String action, String iD) {

        List<String> changes = handleCallbackAdmin.caseChangeFieldAccept();
        for (String str : changes) {
            if (action.equals(str)) {
                userMap.get(iD).setInfoToChange(action);
                userMap.get(iD).setChangeLeadAccept(false);
                userMap.get(iD).setChangeLeadAcceptInfo(true);
            }
        }
    }


    private void handleCallbackCaseChangeLeadAcceptTrueInfo(Message message, String iD) throws TelegramApiException {

        deleteMessage(message.getChatId(), message.getMessageId());
        sendMessage(message, NEW_VALUE);
        userMap.get(iD).setChangeLeadAcceptInfo(false);
        userMap.get(iD).setLeadInfo(true);

    }


    private void handleCallbackCaseChangeLeadInfo(Message message, String iD) throws TelegramApiException {

        String newField = message.getText();
        String id = userMap.get(iD).getLeadName();
        String infToChange = userMap.get(iD).getInfoToChange();
        if (handleMessage.checkFieldsCaseChange(newField, infToChange)) {
            boolean success = handleCallbackAdmin.caseChangeLeadAcceptInfo(id, infToChange, newField);
            if (success) {
                sendMessage(message, SUCCESS);
                userMap.get(iD).setLeadInfo(false);
                handleCallbackCaseLead(message, iD);
            } else {
                sendMessage(message, FAIL);
            }
        } else sendMessage(message, FAIL);

    }


    private void handleCallbackCaseAdd(Message message, String iD) throws TelegramApiException {

        userMap.get(iD).setFlags();
        deleteMessage(message.getChatId(), message.getMessageId());
        List<List<InlineKeyboardButton>> buttons = handleCallbackAdmin.caseAdd();
        sendMessageAndKeyboard(message, WHAT_TO_ADD, buttons);

    }

    private void handleCallbackCaseAddHR(Message message, String iD) throws TelegramApiException {

        userMap.get(iD).setAddHR(true);
        deleteMessage(message.getChatId(), message.getMessageId());
        sendMessage(message, TABLE);
        sendMessage(message, TABLE2);

    }


    private void handleCallbackCaseAddHRAccept(Message message, String iD) throws TelegramApiException {

        String text = message.getText();
        boolean isAdded = handleCallbackAdmin.addHR(text);
        if (isAdded) {
            sendMessage(message, EMPLOYEE_ADD);
            userMap.get(iD).setAddHR(false);
            handleCallbackCaseHR(message, iD);
        } else sendMessage(message, BAD_FORM);

    }


    private void handleCallbackCaseAddRecruiter(Message message, String iD) throws TelegramApiException {

        userMap.get(iD).setAddRec(true);
        deleteMessage(message.getChatId(), message.getMessageId());
        sendMessage(message, TABLE);
        sendMessage(message, TABLE2);
    }


    private void handleCallbackCaseAddRecAccept(Message message, String iD) throws TelegramApiException {

        String text = message.getText();
        boolean isAdded = handleCallbackAdmin.addRec(text);
        if (isAdded) {
            sendMessage(message, EMPLOYEE_ADD);
            userMap.get(iD).setAddRec(false);
            handleCallbackCaseRec(message, iD);
        } else sendMessage(message, BAD_FORM);

    }


    private void handleCallbackCaseAddLead(Message message, String iD) throws TelegramApiException {

        userMap.get(iD).setAddLead(true);
        deleteMessage(message.getChatId(), message.getMessageId());
        sendMessage(message, TABLE);
        sendMessage(message, TABLE2);
    }

    private void handleCallbackCaseAddLeadAccept(Message message, String iD) throws TelegramApiException {

        String text = message.getText();
        boolean isAdded = handleCallbackAdmin.addLead(text);
        if (isAdded) {
            sendMessage(message, EMPLOYEE_ADD);
            userMap.get(iD).setAddLead(false);
            handleCallbackCaseLead(message, iD);
        } else sendMessage(message, BAD_FORM);
    }


    private void deleteMessage(Long chatID, Integer messageID) {

        try {
            for (int i = 0; i < 10; i++) {

                execute(DeleteMessage.builder().chatId(String.valueOf(chatID))
                        .messageId(messageID - i)
                        .build());
            }

        } catch (TelegramApiException e) {
            System.out.println(". ");
        }
    }


    private void sendMessage(Message message, String text) throws TelegramApiException {

        execute(SendMessage.builder()
                .text(text)
                .chatId(message.getChatId().toString())
                .build());

    }

    private void sendMessageAndKeyboard(Message message, String text, List<List<InlineKeyboardButton>> buttons) throws TelegramApiException {

        execute(SendMessage.builder()
                .text(text)
                .chatId(message.getChatId().toString())
                .replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttons).build())
                .build());

    }

//    private void checkUser(Message message) {
//
//        User user = message.getFrom();
//
//
//
//        if (!userMap.containsKey(user.getUserName())) {
//            userMap.put(user.getUserName(), new BotUser());
//        }
//
//    }


    Map<String, BotUser> userMap;
    HandleMessage handleMessage = new HandleMessage();
    HandleCallbackView handleCallbackView = new HandleCallbackView();
    HandleCallbackAdmin handleCallbackAdmin = new HandleCallbackAdmin();

    public Bot(Map<String, BotUser> userMap) {
        this.userMap = userMap;
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

}
