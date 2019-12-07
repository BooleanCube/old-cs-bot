package PythonCommands;

import Secrets.Secret;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;

public class CoinFlipToss extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if(msg.length == 2 && msg[0].equalsIgnoreCase(Secret.Prefix + "py") && msg[1].equalsIgnoreCase("CoinFlipToss")) {
            event.getChannel().sendMessage("```py\n" +
                    "import random\n" +
                    "\n" +
                    "num_toss = 0\n" +
                    "num_counter = 0\n" +
                    "\n" +
                    "num_flips = int(input(\"How Many Coin Flips Do You Want To Do? : \"))\n" +
                    "for i in range(0, num_flips):\n" +
                    "    coin_flip = random.randint(1, 3)\n" +
                    "    num_toss = num_toss + 1\n" +
                    "    if coin_flip == 1:\n" +
                    "        num_counter = num_counter + 1\n" +
                    "    else:\n" +
                    "        num_counter = num_counter - 1\n" +
                    "print(str(num_counter) + \" vs \" + str(num_toss))" +
                    "```").queue();
        }
    }
}
