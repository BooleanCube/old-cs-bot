package HelpCommands;

import Secrets.Secret;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;

public class HHelp extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if(msg[0].equalsIgnoreCase(Secret.Prefix + "help") && msg[1].equalsIgnoreCase("HelpLine") && msg.length == 2) {
            EmbedBuilder em = new EmbedBuilder();
            em.setColor(Color.black);
            em.setTitle("**Help with HelpLine? Ironic...**");
            em.setDescription("Commands: \n" +
                              "    -Send `cs!request [type] [msg]` to ask a question.\n" +
                              "    With `type` being the type of help you need: `cpp`, `py`, `java`.\n" +
                              "    And `msg` being the msg saying what you need to get done or what you need help with.\n" +
                              "    -Send `cs!addtq [type] [msg]` to add on to your question.\n" +
                              "    With `type` being the type of help you need: `cpp`, `py`, `java`.\n" +
                              "    And `msg` being the addition to the question.\n" +
                              "    -Send `cs!createhc` when #cshelp is getting spammy and you want to ask privately!\n" +
                              "    But, don't forget to exit the channel by using: `cs!exithc [#channelname]` when you are done!" +
                              "    -Helpers, send `cs!reply [ping] [msg]` to reply back and help them.\n" +
                              "    With `msg` being the the answer to their question.\n" +
                              "    Also remember to `ping` the right person in your reply.\n" +
                              "    -Helpers, if you want to clear you reply, use `cs!clrreply` to clear the most recent reply.\n");
            event.getChannel().sendMessage(em.build()).queue();
        }
    }
}
