package OtherCommands;

import Secrets.Secret;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.List;

public class ClearCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if(msg[0].equalsIgnoreCase(Secret.Prefix + "clear") && msg.length == 2) {
            try {
                List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(msg[1])).complete();
                event.getChannel().deleteMessages(messages).queue();
                EmbedBuilder success = new EmbedBuilder();
                success.setColor(Color.GREEN);
                success.setTitle("Success");
                success.setDescription("Successfully cleared " + msg[1] + " messages :white_check_mark:");
                event.getChannel().sendMessage(success.build()).queue();
            } catch(IllegalArgumentException e) {
                if(e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
                    EmbedBuilder error = new EmbedBuilder();
                    error.setColor(Color.RED);
                    error.setTitle("Too may messages selected!");
                    error.setDescription("Between 1-100 messages only can be cleared!");
                    event.getChannel().sendMessage(error.build()).queue();
                } else {
                    EmbedBuilder error = new EmbedBuilder();
                    error.setColor(Color.RED);
                    error.setTitle("Selected messages are older than 2 weeks!");
                    error.setDescription("Messages older than 2 weeks can not be cleared!");
                    event.getChannel().sendMessage(error.build()).queue();
                }
            }
        }
    }
}
