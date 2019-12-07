package JavaCommands;

import Secrets.Secret;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class PrintStringRawCode extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if(msg.length == 2 && msg[0].equalsIgnoreCase(Secret.Prefix + "java") && msg[1].equalsIgnoreCase("PrintStringRawCode")) {
            event.getChannel().sendMessage("```java\n" +
                    "public static void PrintStringRawCode(String line) {\n" +
                    "\t\tString[] msg = line.split(\" \");\n" +
                    "\t\tif(msg.length == 2 && msg[0].equalsIgnoreCase(\"cs!\" + \"java\") && msg[1].equalsIgnoreCase(\"PrintStringRawCode\")) {\n" +
                    "\t\t\tString rest = \"\";\n" +
                    "            for(int i=2; i<msg.length; i++) {\n" +
                    "                rest += msg[i] + \" \";\n" +
                    "            }\n" +
                    "            System.out.println(\"```lua\\n\"\n" +
                    "            \t\t+ \"print(\\\" + rest.trim() + \\\")\\n\"\n" +
                    "            \t\t+ \"```\");\n" +
                    "\t\t}\n" +
                    "\t}" +
                    "```").queue();
        }
    }
}
