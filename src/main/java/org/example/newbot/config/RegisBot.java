package org.example.newbot.config;

//import lombok.extern.log4j.Log4j2;
import org.example.newbot.bot.TelegramBot;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
//@Log4j2
public class RegisBot {

    private final TelegramBot bot;

    public RegisBot(TelegramBot bot) {
        this.bot = bot;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void init() {
        try {
            System.out.println(bot.toString());
            TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
            api.registerBot(bot);

            System.out.println(("✅ Telegram bot registered successfully: @"));
        } catch (Exception e) {
            System.out.println(("❌ Telegram bot registration failed: "+e.getMessage()));
        }
    }
}
