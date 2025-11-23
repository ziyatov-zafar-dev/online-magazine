package org.example.newbot.bot.roleuser;


import org.example.newbot.bot.Function;
import org.example.newbot.bot.TelegramBot;
import org.example.newbot.dto.ResponseDto;
import org.example.newbot.model.BotPrice;
import org.example.newbot.model.User;
import org.example.newbot.service.BotPriceService;
import org.example.newbot.service.UserService;
import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

import static org.example.newbot.bot.StaticVariable.*;

@Controller

public class UserFunction extends Function {
    public final TelegramBot bot;
    public final UserService userService;
    public final UserKyb kyb;
    private final BotPriceService botPriceService;

    public UserFunction(TelegramBot bot, UserService userService, UserKyb kyb, BotPriceService
            botPriceService) {
        super(userService);
        this.bot = bot;
        this.userService = userService;
        this.kyb = kyb;
        this.botPriceService = botPriceService;
    }

    public void start(User user) {
        eventCode(user, "menu");
        try {
            bot.sendMessage(user.getChatId(), """
                🖐 Salom xurmatli MRX . « Super Maker Bot | Konstruktor » ga xush kelibsiz
                
                Super Maker Bot | Konstruktor sizga telegram tarmog'ida mukammal telegram bot yaratish imkoniyatini beradi.
                
                📢 Yangiliklarni kuzating: @Super_Maker_News""", kyb.menu());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void menu(User user, String text) {
        if (text.equals(menu[0])) {
            ResponseDto<List<BotPrice>> all = botPriceService.findAll();
            try {
                bot.sendMessage(user.getChatId(),
                        "O'zingizga kerakli botni tanlang. 😊 Endi siz o'zingiz uchun mukammal" +
                                " botni yaratishga tayyormisiz? Tanlovni qiling va biz birgalikda noyob bot yaratish safarini boshlaymiz! Qani kettik 🚀", kyb.setBotTypes( all.getData()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            eventCode(user, "choose bot");
        } else {
            wrongBtn(user.getChatId(), kyb.menu());
        }
    }

    private void wrongBtn(Long chatId, ReplyKeyboardMarkup m) {
        try {
            bot.sendMessage(chatId, "❌ Iltimos, tugmalardan foydalaning", m);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void chooseBot(User user, String text) {
        if (text.equals(backButton)) {
            start(user);
        } else {
            ResponseDto<List<BotPrice>> list = botPriceService.findAll();
            ResponseDto<BotPrice> checkType = botPriceService.findByTypeText(text);
            if (checkType.isSuccess()) {
                BotPrice botPrice = checkType.getData();
                try {
                    bot.sendMessage(user.getChatId(), aboutBotPrice(botPrice, false) + "\n\n\uD83E\uDD16 **Ushbu Telegram Botni yaratmoqchimisiz?**\n", kyb.isBuyBot);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                eventCode(user , "is buy bot");
            } else {
                wrongBtn(user.getChatId(), kyb.setBotTypes(list.getData()));
            }
        }
    }
}
