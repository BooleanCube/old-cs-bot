package OtherCommands.Games;

import Secrets.Secret;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class VerbalMemory extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if(msg.length == 2 && msg[0].equalsIgnoreCase(Secret.Prefix + "javagame") && msg[1].equalsIgnoreCase("VerbalMemory")) {
            event.getChannel().sendMessage("```\n" +
                    "Code in here =>\n" +
                    "https://pastebin.com/7QGxAV7Q" +
                    "```").queue();
        }
    }
}