package HelpLine;

import Secrets.Secret;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;

public class AddTQCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        EmbedBuilder error = new EmbedBuilder();
        error.setColor(Color.RED);
        if(msg[0].equalsIgnoreCase(Secret.Prefix + "addtq") && msg.length >= 3) {
            if(msg[1].equalsIgnoreCase("java") || msg[1].equalsIgnoreCase("cpp") || msg[1].equalsIgnoreCase("py")) {
                if(event.getChannel().getName().equalsIgnoreCase("cshelp")) {
                    if(msg[1].equalsIgnoreCase("java")) {
                        TextChannel tc = event.getGuild().getTextChannelsByName("javahelp", true).get(0);
                        String author = event.getMessage().getAuthor().getName();
                        String send = "";
                        for(int i=2; i<msg.length; i++) {
                            send += msg[i] + " ";
                        }
                        tc.sendMessage(author + " adds to his question!\n" + send.trim()).queue();
                        event.getChannel().sendMessage("``Message sent!``").queue();
                    } else if(msg[1].equalsIgnoreCase("py")) {
                        TextChannel tc = event.getGuild().getTextChannelsByName("pyhelp", true).get(0);
                        String author = event.getMessage().getAuthor().getName();
                        String send = "";
                        for(int i=2; i<msg.length; i++) {
                            send += msg[i] + " ";
                        }
                        tc.sendMessage(author + " adds to his question!\n" + send.trim()).queue();
                        event.getChannel().sendMessage("``Message sent!``").queue();
                    } else if(msg[1].equalsIgnoreCase("cpp")) {
                        TextChannel tc = event.getGuild().getTextChannelsByName("cpphelp", true).get(0);
                        String author = event.getMessage().getAuthor().getName();
                        String send = "";
                        for(int i=2; i<msg.length; i++) {
                            send += msg[i] + " ";
                        }
                        tc.sendMessage(author + " adds to his question!\n" + send.trim()).queue();
                        event.getChannel().sendMessage("``Message sent!``").queue();
                    }
                }
                else {
                    error.setTitle("Wrong Channel!");
                    error.setDescription("Try the using this command in the #cshelp channel!");
                    event.getChannel().sendMessage(error.build()).queue();
                }
            } else {
                error.setTitle("Selected type is incorrect!");
                error.setDescription("Try selecting type: `java`, `py`, `cpp`!");
                event.getChannel().sendMessage(error.build()).queue();
            }
        }
    }
}
