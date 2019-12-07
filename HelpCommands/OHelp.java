package HelpCommands;

import Secrets.Secret;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class OHelp extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if(msg.length == 2 && msg[0].equalsIgnoreCase(Secret.Prefix + "other") && msg[1].equalsIgnoreCase("help")) {
            event.getChannel().sendMessage("```" +
                    "List of Fun Commands (including games): \n" +
                    "   -Ping | Usage = `cs!ping`\n" +
                    "   -FlipCoin | Usage = `cs!flipcoin`\n" +
                    "   -RockPaperScissors | Usage = `cs!rps [choice]`\n" +
                    "   -EmojiMid | Usage = `cs!emid [emoji] [word/phrase]`\n" +
                    "   -Spam | Usage = `cs!spam [txt(optional)]`\n" +
                    "   -Thank | Usage = `cs!thank [lang.(optional)]`\n" +
                    "   -Welcome | Usage = `cs!welcome [\"cshelp\"(optional)]`\n" +
                    "List of Game's code available:\n" +
                    "   Java:\n" +
                    "       -VerbalMemory | Usage = `cs!javagame VerbalMemory`\n" +
                    "       -NumberMemory | Usage = `cs!javagame NumberMemory`\n" +
                    "```").queue();
        }
    }
}