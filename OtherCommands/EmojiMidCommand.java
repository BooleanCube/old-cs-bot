package OtherCommands;

import Secrets.Secret;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class EmojiMidCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] msg  = event.getMessage().getContentRaw().split(" ");
        if(msg[0].equalsIgnoreCase(Secret.Prefix + "emid") && msg.length >= 3) {
            if(msg.length == 3) {
                int len = msg[2].length();
                if(len == 1) {
                    event.getChannel().sendMessage(msg[2]).queue();
                } else {
                    String send = "";
                    for(int i=0; i<len; i++) {
                        if(i == len-1) {
                            send += msg[2].substring(i, i+1);
                        } else {
                            send += msg[2].substring(i, i + 1) + msg[1].toLowerCase();
                        }
                    }
                    event.getChannel().sendMessage(send).queue();
                }
            } else {
                int len = msg.length;
                String send = "";
                for(int i=2; i<len; i++) {
                    if(i == len-1) {
                        send += msg[i];
                    } else {
                        send += msg[i] + msg[1];
                    }
                }
                event.getChannel().sendMessage(send).queue();
            }
        } else if(msg[0].equalsIgnoreCase(Secret.Prefix + "emid") && msg.length < 3){
            event.getChannel().sendMessage("Use the help command(`cs!help`) in #helpcommands to figure out how to use this command!").queue();
        } else if(msg[0].equalsIgnoreCase(Secret.Prefix + "emid") && msg[1].startsWith(":") && msg[1].endsWith(":")) {
            event.getChannel().sendMessage("Use the help command(`cs!help`) in #helpcommands to figure out how to use this command!").queue();
        }
    }
}
