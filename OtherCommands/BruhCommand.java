package OtherCommands;

import Secrets.Secret;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;

public class BruhCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();
        if(msg.equalsIgnoreCase(Secret.Prefix + "bruh")) {
            EmbedBuilder bruh = new EmbedBuilder();
            bruh.setColor(Color.BLACK);
            bruh.setTitle("BRUH!");
            bruh.setDescription("https://steamuserimages-a.akamaihd.net/ugc/785237465823382315/23C44FA9648B9C5D7564D6F122EC226D4659F204/?imw=268&imh=268&ima=fit&impolicy=Letterbox&imcolor=%23000000&letterbox=true");
            event.getChannel().sendMessage(bruh.build()).queue();
        }
    }
}
