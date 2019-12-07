package OtherCommands;

import Secrets.Secret;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class ThankCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if(msg[0].equalsIgnoreCase(Secret.Prefix + "thank") && msg.length == 1) {
            event.getChannel().sendMessage("Thank you!").queue();
        } else if(msg[0].equalsIgnoreCase(Secret.Prefix + "thank") && msg.length == 2 && msg[1].equalsIgnoreCase("java")) {
            TextChannel tc = event.getGuild().getTextChannelsByName("javahelp", true).get(0);
            tc.sendMessage(event.getMessage().getAuthor().getName() + " said: Thank you!").queue();
        } else if(msg[0].equalsIgnoreCase(Secret.Prefix + "thank") && msg.length == 2 && msg[1].equalsIgnoreCase("py")) {
            TextChannel tc = event.getGuild().getTextChannelsByName("pyhelp", true).get(0);
            tc.sendMessage(event.getMessage().getAuthor().getName() + " said: Thank you!").queue();
        } else if(msg[0].equalsIgnoreCase(Secret.Prefix + "thank") && msg.length == 2 && msg[1].equalsIgnoreCase("cpp")) {
            TextChannel tc = event.getGuild().getTextChannelsByName("cpphelp", true).get(0);
            tc.sendMessage(event.getMessage().getAuthor().getName() + " said: Thank you!").queue();
        }
    }
}
