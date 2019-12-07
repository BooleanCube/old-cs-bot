package JavaCommands;

import Secrets.Secret;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class HelloWorld extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if(msg.length == 2 && msg[0].equalsIgnoreCase(Secret.Prefix + "java") && msg[1].equalsIgnoreCase("HelloWorld")) {
            event.getChannel().sendMessage("```java\n" +
                    "public class HelloWorld {\n" +
                    "\tpublic static void main(String[] args) {\n" +
                    "\t\tSystem.out.println(\"Hello World!\");\n" +
                    "\t}\n" +
                    "}" +
                    "```").queue();
        }
    }
}
