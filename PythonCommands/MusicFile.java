package PythonCommands;

import Secrets.Secret;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class MusicFile extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if(msg.length == 2 && msg[0].equalsIgnoreCase(Secret.Prefix + "py") && msg[1].equalsIgnoreCase("MusicFile")) {
            event.getChannel().sendMessage("```py\n" +
                    "a = input(\"Your list of songs (separated by commas and no spaces): \")\n" +
                    "abba = open(\"abba.txt\", 'w')\n" +
                    "flag = True\n" +
                    "b = 0\n" +
                    "while True:\n" +
                    "    b = b + 1\n" +
                    "    c = a.find(\",\")\n" +
                    "    if c == -1:\n" +
                    "        abba.write(str(b) + \") \" + a + \"\\n\")\n" +
                    "        break\n" +
                    "    else:\n" +
                    "        abba.write(str(b) + \") \" + a[0:c] + \"\\n\")\n" +
                    "    d = c + 1\n" +
                    "    a = a[d:]\n" +
                    "abba.close()\n" +
                    "```").queue();
        }
    }
}
