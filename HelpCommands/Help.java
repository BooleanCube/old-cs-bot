package HelpCommands;

import Secrets.Secret;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class Help extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();
        if(msg.equalsIgnoreCase(Secret.Prefix + "help")) {
            event.getChannel().sendMessage("```" + "Help Menu:\n" +
                    "   Code | Usage = `cs!code help`\n" +
                    "   HelpLine | Usage = `cs!help HelpLine`\n" +
                    "   Other | Usage = `cs!other help`\n" +
                    "```").queue();
        }
    }
}
