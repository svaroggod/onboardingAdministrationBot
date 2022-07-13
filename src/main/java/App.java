
import BotUser.BotUser;
import Hibernate.HibernateConnect;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import service.Bot;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) throws TelegramApiException {

        Map<String, BotUser> userMap= new HashMap<>();
        Bot bot = new Bot(userMap);
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(bot);
    }
}
