package PythonCommands;

import Secrets.Secret;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class PrintStringCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if(msg.length >= 3 && msg[0].equalsIgnoreCase(Secret.Prefix + "py") && msg[1].equalsIgnoreCase("PrintString")) {
            String rest = "";
            for(int i=2; i<msg.length; i++) {
                rest += msg[i] + " ";
            }
            event.getChannel().sendMessage("```py\n" +
                    "print(\"" + rest.trim() + "\")" +
                    "```").queue();
        }
    }
}
