package OtherCommands.Games;

import Secrets.Secret;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class FlipCoin extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();
        if(msg.equalsIgnoreCase(Secret.Prefix + "flipcoin")) {
            int ran = (int) (Math.random() * 10);
            if(ran % 2 == 0) {
                event.getChannel().sendMessage("You landed on **Tails**!").queue();
            } else {
                event.getChannel().sendMessage("You landed on **Heads**!").queue();
            }
        }
    }
}
