package HelpCommands;

import Secrets.Secret;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class CHelp extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if(msg[0].equalsIgnoreCase(Secret.Prefix + "code") && msg[1].equalsIgnoreCase("help") && msg.length == 2) {
            event.getChannel().sendMessage("```" +
                    "Keys:\n" +
                    "   [] = input\n" +
                    "   () = comment\n" +
                    "These are the list of functions:\n" +
                    "   Java:\n" +
                    "       1) HelloWorld | Usage = `cs!java HelloWorld`\n" +
                    "       2) StringReverse | Usage = `cs!java StringReverse`\n" +
                    "       3) StringReverseMethod | Usage = `cs!java StringReverseMethod`\n" +
                    "       4) PrintStringRawCode | Usage = `cs!java StringReverseRawCode`\n" +
                    "       5) TenCount | Usage = `cs!java TenCount`\n" +
                    "       6) FractionsClass | Usage = `cs!java FractionsClass`\n" +
                    "       7) MinimumSpanningTree | Usage = `cs!java MST`\n" +
                    "   Cpp:\n" +
                    "       1) HelloWorld | Usage = `cs!cpp HelloWorld`\n" +
                    "       2) StringReverse | Usage = `cs!cpp StringReverse`\n" +
                    "   Python:\n" +
                    "       1) HelloWorld | Usage = `cs!py HelloWorld`\n" +
                    "       2) PrintString | Usage = `cs!py PrintString [WordToBePrinted] (Remember not to actually put brackets around the input)`\n" +
                    "       3) TenCount | Usage = `cs!py TenCount`\n" +
                    "       4) CoinFlipToss | Usage = `cs!py CoinFlipToss`\n" +
                    "```").queue();
        }
    }
}