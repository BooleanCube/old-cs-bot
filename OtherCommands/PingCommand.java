package OtherCommands;

import Secrets.Secret;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class PingCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();
        if(msg.equalsIgnoreCase(Secret.Prefix + "ping")) {
            long ping = event.getJDA().getGatewayPing();
            event.getChannel().sendMessage(":ping_pong:  " + ping + "ms  :ping_pong:").queue();
        }
    }
}
