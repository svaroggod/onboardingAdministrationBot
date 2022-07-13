package Parser;

import entity.HRs;
import entity.Leads;
import entity.Recruiters;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;


// Парсер принимает на вход из бота STR текстовую форму в формате:
// Фамилия : str
// Имя : str
// Отчество : str
// Tg_username : str

// проверяет валидность заполнения самой формы, и преобразует входящий STR в единую строку убирая пробелы, переносы;
// сепарирует STR на нужные части в соответствии со входящей формой;
// отдельно вырезает поле Фамилия нс учетом допустимости фамилий, пишущихся через пробелы
// повторно проверяет каждую часть на валидность заполнения;

//    Отдельные требования к нику в Телеграмм:
//    Длина. Минимальное количество символов в логине должно равняться 5 единицам;
//    Язык. Название должно быть написано на латинском алфавите;
//    Дополнительные символы. Компания telegram разрешила использовать цифры от 0 до 9, а также нижнее подчеркивание.

// создает и возвращает новый объект класса Entity либо возвращает null;
// Имеет отдельные методы для проверки каждого поля при изменении Администратором учетных данных


public class Parser {
    Logger logger = LogManager.getLogger(Parser.class);
    ParserRegex parserRegex = new ParserRegex();

    public HRs textParserHR(String text) {
        if ((text.startsWith("Фамилия")) && text.length() > 8) {
            String tmp = text.substring(0, text.indexOf('\n'));
            String[] parts = (text.replaceAll(" ", "")).split((":|\n"));

            String surname = tmp.substring(tmp.indexOf(":")+1);
            // рабочая версия с дефисами но БЕЗ пробелов
            // String surname = parts[parts.length -7];
            String name = parts[parts.length - 5];
            String fatherName = parts[parts.length - 3];
            String tg_username = parts[parts.length - 1];

            Matcher surnameCase = parserRegex.cirillicAndSymbolsPattern.matcher(surname);
            Matcher nameCase = parserRegex.cirillicAndSymbolsPattern.matcher(name);
            Matcher fatherNameCase = parserRegex.cirillicAndEmptyPattern.matcher(fatherName);
            Matcher tg_usernameCase = parserRegex.telegramNickNamePattern.matcher(tg_username);


            if ((!surnameCase.matches() || surname.isEmpty())
                    || (!nameCase.matches() || name.isEmpty())
                    || (!fatherNameCase.matches())
                    || (!tg_usernameCase.matches()) || tg_username.isEmpty()) {
                logger.info("Ошибки в заполнении полей формы");
                return null;
            }

            String short_tg_username = tg_username.replaceAll("[@]","");
            logger.info("форма заполнена верно");
            return new HRs(short_tg_username, name, surname, fatherName);

        } else {
            logger.info("Неверная форма");
            return null;

        }
    }



    public Recruiters textParserRec(String text) {
        if ((text.startsWith("Фамилия")) && (text.length() > 8)) {

            String tmp = text.substring(0, text.indexOf('\n'));
            String[] parts = (text.replaceAll(" ", "")).split((":|\n"));

            String surname = tmp.substring(tmp.indexOf(":")+1);
            // рабочая версия БЕЗ пробелов
            // String surname = parts[parts.length -7];
            String name = parts[parts.length - 5];
            String fatherName = parts[parts.length - 3];
            String tg_username = parts[parts.length - 1];


            Matcher surnameCase = parserRegex.cirillicAndSymbolsPattern.matcher(surname);
            Matcher nameCase = parserRegex.cirillicAndSymbolsPattern.matcher(name);
            Matcher fatherNameCase = parserRegex.cirillicAndEmptyPattern.matcher(fatherName);
            Matcher tg_usernameCase = parserRegex.telegramNickNamePattern.matcher(tg_username);


            if ((!surnameCase.matches() || surname.isEmpty())
                    || (!nameCase.matches() || name.isEmpty())
                    || (!fatherNameCase.matches())
                    || (!tg_usernameCase.matches()) || tg_username.isEmpty()) {
                logger.info("Ошибки в заполнении полей формы");
                return null;
            }

            String short_tg_username = tg_username.replaceAll("[@]","");
            logger.info("форма заполнена верно");
            return new Recruiters(short_tg_username, name, surname, fatherName);

        } else {
            logger.info("Неверная форма");
            return null;

        }
    }


    public Leads textParserLead(String text) {
        if ((text.startsWith("Фамилия")) && (text.length() > 8)) {

            String tmp = text.substring(0, text.indexOf('\n'));
            String[] parts = (text.replaceAll(" ", "")).split((":|\n"));

            String surname = tmp.substring(tmp.indexOf(":")+1);
            // рабочая версия БЕЗ пробелов
            // String surname = parts[parts.length -7];
            String name = parts[parts.length - 5];
            String fatherName = parts[parts.length - 3];
            String tg_username = parts[parts.length - 1];


            Matcher surnameCase = parserRegex.cirillicAndSymbolsPattern.matcher(surname);
            Matcher nameCase = parserRegex.cirillicAndSymbolsPattern.matcher(name);
            Matcher fatherNameCase = parserRegex.cirillicAndEmptyPattern.matcher(fatherName);
            Matcher tg_usernameCase = parserRegex.telegramNickNamePattern.matcher(tg_username);


            if ((!surnameCase.matches() || surname.isEmpty())
                    || (!nameCase.matches() || name.isEmpty())
                    || (!fatherNameCase.matches())
                    || (!tg_usernameCase.matches()) || tg_username.isEmpty()) {
                logger.info("Ошибки в заполнении полей формы");
                return null;
            }

            String short_tg_username = tg_username.replaceAll("[@]","");
            logger.info("форма заполнена верно");
            return new Leads(short_tg_username, name, surname, fatherName);

        } else {
            logger.info("Неверная форма");
            return null;

        }
    }


    public boolean nameChecking(String text) {


        Matcher check = parserRegex.cirillicAndSymbolsPattern.matcher(text);

        if(check.matches()){

        return true;}
        else {
            return false;}
        }

    public boolean surnameChecking(String text) {


        Matcher check = parserRegex.cirillicAndSymbolsPattern.matcher(text);

        if(check.matches()){

            return true;}
        else {
            return false;}
    }

    public boolean fatherNameChecking(String text) {


        Matcher check = parserRegex.cirillicAndEmptyPattern.matcher(text);

        if(check.matches()){

            return true;}
        else {
            return false;}
    }

    public boolean tgIdChecking(String text) {

        Matcher check = parserRegex.telegramNickNameWithoutSymbolsPattern.matcher(text);

        if(check.matches()){

            return true;}
        else {
            return false;}
    }
    public String tgUsernameRemove(String text) {
        String text2 = text.replaceAll("[@]","");

       return text2;
    }
}

