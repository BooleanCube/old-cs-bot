package HelpLine;

import Secrets.Secret;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;

public class ExitHcCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        EmbedBuilder error = new EmbedBuilder();
        error.setColor(Color.red);
        String author = event.getAuthor().getName().toLowerCase();
        String mention = event.getAuthor().getAsMention();
        if(msg[0].equalsIgnoreCase(Secret.Prefix + "exithc") && msg.length == 2) {
            if((event.getChannel().getName().startsWith(author) && event.getChannel().getName().endsWith("hc"))) {
                String tctbd = msg[1];
                try {
                    TextChannel tc = event.getGuild().getTextChannelsByName(tctbd, true).get(0);
                    tc.delete().complete();
                } catch(Exception e) {
                    error.setTitle("Not an Identified Channel!");
                    error.setDescription("Please recite the exact name of the channel you are exiting!");
                }
            } else if((event.getChannel().getName().startsWith(author) && !event.getChannel().getName().endsWith("hc"))) {
                error.setTitle("Channel can't be exited!");
                error.setDescription("This isn't a temporary help channel");
                event.getChannel().sendMessage(error.build()).queue();
            } else {
                error.setTitle("No Permission!");
                error.setDescription("You don't have the permission to exit this channel!");
                event.getChannel().sendMessage(error.build()).queue();
            }
        } else if(msg[0].equalsIgnoreCase(Secret.Prefix + "exithc") && msg.length != 2) {
            error.setTitle("Invalid Channel Name!");
            error.setDescription("Your channel name can't be empty neither can it be more than one word!");
            event.getChannel().sendMessage(error.build()).queue();
        }
    }
}
