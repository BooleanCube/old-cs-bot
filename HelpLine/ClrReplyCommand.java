package HelpLine;

import Secrets.Secret;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class ClrReplyCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();
        if(msg.equalsIgnoreCase(Secret.Prefix + "clrreply")) {
            TextChannel tc = event.getGuild().getTextChannelsByName("cshelp", true).get(0);
            tc.sendMessage(Secret.Prefix + "clear 2").queue();
        }
    }
}
