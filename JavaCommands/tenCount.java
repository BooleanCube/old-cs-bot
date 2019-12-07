package JavaCommands;

import Secrets.Secret;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class tenCount extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if(msg.length == 2 && msg[0].equalsIgnoreCase(Secret.Prefix + "java") && msg[1].equalsIgnoreCase("TenCount")) {
            event.getChannel().sendMessage("```java\n" +
                    "public class tenCount {\n" +
                    "\tpublic static void main(String[] args) {\n" +
                    "\t\tfor(int i=0; i<=10; i++) {\n" +
                    "\t\t\tSystem.out.println(i);\n" +
                    "\t\t}\n" +
                    "\t}\n" +
                    "}" +
                    "```").queue();
        }
    }
}
