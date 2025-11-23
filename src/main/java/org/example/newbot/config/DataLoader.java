package org.example.newbot.config;

import org.example.newbot.model.BotInfo;
import org.example.newbot.model.BotPrice;
import org.example.newbot.repository.BotPriceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class DataLoader implements CommandLineRunner {
    private final BotPriceRepository botPriceRepository;

    public DataLoader(BotPriceRepository botPriceRepository) {
        this.botPriceRepository = botPriceRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (botPriceRepository.findAll().isEmpty()) {
            BotPrice botPrice = new BotPrice();
            botPrice.setPrice(0.0);
            botPrice.setDescription("📚 Online Magazine uchun boshlang'ich tarif — bepul va qulay ⭐");
            botPrice.setType("online-magazine");
            botPrice.setActive(true);
            botPrice.setStatus("open");
            botPrice.setTypeText("🌐 Online Magazine — Standart Paket 🚀");
            botPriceRepository.save(botPrice);
        }
    }
}
