package OtherCommands;

import Secrets.Secret;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class WelcomeCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if(msg[0].equalsIgnoreCase(Secret.Prefix + "welcome") && msg.length == 1) {
            event.getChannel().sendMessage("You are Welcome!").queue();
        } else if(msg[0].equalsIgnoreCase(Secret.Prefix + "welcome") && msg.length == 2 && msg[1].equalsIgnoreCase("cshelp")) {
            TextChannel tc = event.getGuild().getTextChannelsByName("cshelp", true).get(0);
            tc.sendMessage(event.getMessage().getAuthor().getName() + " said: You are Welcome!").queue();
        }
    }
}
