package HelpLine;

import Secrets.Secret;
import com.sun.deploy.security.SessionCertStore;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.List;

public class CommentCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if(msg[0].equalsIgnoreCase(Secret.Prefix + "comment") && msg.length >= 2) {
            String send = "";
            for(int i=1; i<msg.length; i++) {
                send += msg[i] + " ";
            }
            event.getChannel().sendMessage(".").queue();
            List<Message> l = event.getChannel().getHistory().retrievePast(2).complete();
            event.getChannel().deleteMessages(l).queue();
            event.getChannel().sendMessage(send.trim()).queue();
        }
    }
}
