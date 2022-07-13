package service;

public interface Literals {

    String BOT_COMMAND = "bot_command";

    String START = "/start";
    String GET_EMPLOYEES = "/get_employees";
    String GET_EMPLOYEES2 = "/get_employees2";
    String GET_EMPLOYEES3 = "/get_employees3";

    String YES= "Да";
    String NO= "Нет";
    String HR = "HR";
    String REC = "Rec";
    String LEAD = "Lead";
    String ADD = "Add";
    String DEL = "Del";
    String DEL_HR = "delHR";
    String DEL_REC = "delRec";
    String DEL_LEAD = "delLead";
    String CHANGE = "Change";
    String ADD_HR = "addHR";
    String ADD_REC = "addRec";
    String ADD_LEAD = "addLead";
    String ACCEPT_HR = "AcceptHR";
    String DECLINE_HR = "DeclineHR";
    String ACCEPT_REC = "AcceptRec";
    String DECLINE_REC = "DeclineRec";
    String ACCEPT_LEAD = "AcceptLead";
    String DECLINE_LEAD = "DeclineLead";
    String CHANGE_HR = "changeHR";
    String CHANGE_REC = "changeRec";
    String CHANGE_LEAD = "changeLead";
    String NAME_ENG= "firstname";
    String SURENAME_ENG= "surname";
    String FATHERNAME_ENG= "fathername";
    String TG_USER_ENG=  "tg_username";

    String NAME= "Имя";
    String SURENAME= "Фамилия";
    String FATHERNAME= "Отчество";
    String TG_USER= "tgName";
    String HELLO = "Привет, ";
    String WHAT_WE_SHOULD = "! Чем будем заниматься?";
    String WHAT_CATEGORIES = "Какие категории Вам бы хотелось увидеть?";
    String WHERE_CHANGE = "Где будем вносить изменения?";
    String WHAT_TO_CHANGE = "Выберите, что будем менять";
    String WHAT_TO_ADD = "В какой отдел будем добавлять?";
    String SELECT_ACTION = "Выберите действие";
    String HR_LIST = "Список HR ";
    String HR_DEPT = "HR отдел";
    String LEAD_LIST = "Cписок лидов";
    String LEAD_DEPT = "Тим лиды";
    String REC_LIST = "Список рекрутёров";
    String REC_DEPT = "Рекрутёры";
    String CANDIDATES = "Список кандидатов";
    String EMPLOYEES_LIST = "Список сотрудников";
    String ADMIN = "Администрирование";
    String DEPARTMENT_TO_DEL = "Из какого отдела будем удалять?";
    String U_SURE = "Вы уверены? ";
    String DEL_EMPLOYEE = "Удалить сотрудника";
    String EMPLOYEE_DEL = "Сотрудник удалён";
    String EMPLOYEE_ADD = "Сотрудник добавлен";
    String ADD_EMPLOYEE = "Добавить сотрудника";
    String NEW_VALUE = "Введите новое значение";
    String CHANGE_EMPLOYEE = "Изменить сотрудника";
    String SUCCESS = "Изменения внесены успешно";
    String FAIL = "Некорректно введена информация";
    String BAD_FORM = "Некорректно заполнена форма";


    String TABLE = "Заполните пожалуйста данные по следующему шаблону" + '\n'
            + "и отправьте в этот же чат";
    String TABLE2 = "Фамилия : " + '\n' +
            "Имя : " + '\n' +
            "Отчество : " + '\n' +
            "TgName : ";


}
