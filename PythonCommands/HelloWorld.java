package PythonCommands;

import Secrets.Secret;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class HelloWorld extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if(msg.length == 2 && msg[0].equalsIgnoreCase(Secret.Prefix + "py") && msg[1].equalsIgnoreCase("HelloWorld")) {
            event.getChannel().sendMessage("```py\n" +
                    "print(\"Hello world!\")" +
                    "```").queue();
        }
    }

}
