package CplusplusCommands;

import Secrets.Secret;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class StringReverse extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if(msg[0].equalsIgnoreCase(Secret.Prefix + "cpp") && msg[1].equalsIgnoreCase("StringReverse") && msg.length == 2) {
            event.getChannel().sendMessage("```cpp\n" +
                    "#include <iostream>\n" +
                    "using namespace std;\n" +
                    "int main(){\n" +
                    "    string s, output;\n" +
                    "    getline(cin, s);\n" +
                    "    for (int i=s.length()-1;i>=0;i--){\n" +
                    "        output+=s.at(i);\n" +
                    "    }\n" +
                    "    cout<<output;\n" +
                    "    return 0;\n" +
                    "}" +
                    "```").queue();
        }
    }
}
