package OtherCommands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.List;

public class AutoBlackHoleCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        Message msg = event.getMessage();
        if(event.getChannel().getName().equalsIgnoreCase("blackhole") && !event.getMessage().getAuthor().getName().equalsIgnoreCase("csbot") && !event.getMessage().getContentRaw().equalsIgnoreCase(".")) {
            TextChannel tc = event.getGuild().getTextChannelsByName("whitehole", true).get(0);
            event.getChannel().sendMessage(".").queue();
            List<Message> list = event.getChannel().getHistory().retrievePast(2).complete();
            event.getChannel().deleteMessages(list).queue();
            tc.sendMessage(msg).queue();
        }
    }
}
