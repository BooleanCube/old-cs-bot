package OtherCommands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.List;

public class AutoClearCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        if(!event.getMessage().getAuthor().isBot()) {
            if(event.getMessage().getCategory().getName().equalsIgnoreCase("BOTS") || event.getChannel().getName().equalsIgnoreCase("cshelp") || event.getChannel().getName().equalsIgnoreCase("javahelp") || event.getChannel().getName().equalsIgnoreCase("pyhelp") || event.getChannel().getName().equalsIgnoreCase("cpphelp") || event.getChannel().getName().equalsIgnoreCase("bump")) {
                if(message.startsWith("cs!") || message.startsWith("--") || message.startsWith("<@555") || message.startsWith("c!") || message.startsWith("!d") || message.startsWith("!disboard") || message.startsWith("|") || message.startsWith("!") || message.startsWith("rr!") || message.startsWith("s/") || message.startsWith("$>") || message.startsWith("$")) {

                } else {
                    event.getChannel().sendMessage(".").queue();
                    List<Message> l = event.getChannel().getHistory().retrievePast(2).complete();
                    event.getChannel().deleteMessages(l).queue();
                    if(event.getChannel().getName().equalsIgnoreCase("cshelp")) {
                        event.getChannel().sendMessage("Wrong Format! Read #questionetiquette ").queue();
                    }
                }
            }
        }
    }
}
