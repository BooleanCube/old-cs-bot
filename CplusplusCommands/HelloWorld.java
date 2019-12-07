package CplusplusCommands;

import Secrets.Secret;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class HelloWorld extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if(msg.length == 2 && msg[0].equalsIgnoreCase(Secret.Prefix + "cpp") && msg[1].equalsIgnoreCase("HelloWorld")) {
            event.getChannel().sendMessage("```cpp\n" +
                    "#include <iostream>\n" +
                    "using namespace std;\n" +
                    "int main() {\n" +
                    "\tcout << \"Hello World!\" << endl;\n" +
                    "\treturn 0;\n" +
                    "}" +
                    "```").queue();
        }
    }
}
