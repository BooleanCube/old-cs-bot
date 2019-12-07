package OtherCommands;

import Secrets.Secret;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class SpamCommand extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if(msg[0].equalsIgnoreCase(Secret.Prefix + "spam")) {
            if(event.getChannel().getName().equalsIgnoreCase("spam")) {
                if(msg.length == 1) {
                    for(int i=0; i<100; i++) {
                        event.getChannel().sendMessage("spam").queue();
                    }
                } else {
                    String send = "";
                    for (int i = 1; i < msg.length; i++) {
                        send += msg[i] + " ";
                    }
                    for (int i = 0; i < 100; i++) {
                        event.getChannel().sendMessage(send.trim()).queue();
                    }
                    event.getChannel().addReactionById("651231127167565845", ":spam:").queue();
                }
            } else {
                EmbedBuilder error = new EmbedBuilder();
                error.setColor(Color.RED);
                error.setTitle("Wrong channel!");
                error.setDescription("This command can only be used in the #spam channel!");
                error.setFooter("SPAM!");
                event.getChannel().sendMessage(error.build()).queue();
            }
        }
    }

}
