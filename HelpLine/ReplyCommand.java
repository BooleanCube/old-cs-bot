package HelpLine;

import Secrets.Secret;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;

public class ReplyCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        EmbedBuilder error = new EmbedBuilder();
        error.setColor(Color.RED);
        if(msg[0].equalsIgnoreCase(Secret.Prefix + "reply") && msg.length >= 3) {
            if(msg[1].startsWith("<")) {
                if(event.getChannel().getName().equalsIgnoreCase("cpphelp") || (event.getChannel().getName().equalsIgnoreCase("javahelp") || (event.getChannel().getName().equalsIgnoreCase("pyhelp") || (event.getChannel().getName().equalsIgnoreCase("hwhelp"))))) {
                    String send = "";
                    for(int i=2; i<msg.length; i++) {
                        send += msg[i] + " ";
                    }
                    send = send.trim();
                    TextChannel tc = event.getGuild().getTextChannelsByName("cshelp", true).get(0);
                    tc.sendMessage(msg[1] + " you have been replied to: \n" + send).queue();
                    event.getChannel().sendMessage("``Message sent!``").queue();
                } else {
                    error.setTitle("Wrong Channel!");
                    error.setDescription("Try the using this command in one of the help channels!");
                    event.getChannel().sendMessage(error.build()).queue();
                }
            } else {
                error.setTitle("No Ping!");
                error.setDescription("You must ping the person so he knows his message has been replied to.");
                event.getChannel().sendMessage(error.build()).queue();
            }
        }
    }
}
