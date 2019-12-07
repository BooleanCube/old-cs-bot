package JavaCommands;

import Secrets.Secret;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class StringReverse extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if(msg.length == 2 && msg[0].equalsIgnoreCase(Secret.Prefix + "java") && msg[1].equalsIgnoreCase("StringReverse")) {
            event.getChannel().sendMessage("```java\n" +
                    "public class StringReverse {\n" +
                    "\tpublic static void main(String[] args) {\n" +
                    "\t\tString r = \"Hello World.\";/*In String r you put whatever String you want that should be reverse*/\n" +
                    "\t\tint len = r.length();\n" +
                    "\t\tString reverse = \"\";\n" +
                    "\t\tfor(int i=len; i>0; i--)  {\n" +
                    "\t\t\treverse += r.substring(i-1, i);\n" +
                    "\t\t}\n" +
                    "\t\tSystem.out.println(reverse);\n" +
                    "\t}\n" +
                    "}" +
                    "```").queue();
        }
    }
}
