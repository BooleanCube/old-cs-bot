package HelpLine;

import Secrets.Secret;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Category;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.Locale;

public class CreateHelpChannel extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();
        EmbedBuilder error = new EmbedBuilder();
        String author = event.getMessage().getAuthor().getName();
        error.setColor(Color.red);
        if(msg.equalsIgnoreCase(Secret.Prefix + "createhc")) {
            Category cat = event.getGuild().getCategoriesByName("ComputerScience", true).get(0);
            cat.createTextChannel(author).setName(author + "hc").complete();
            TextChannel tc = event.getGuild().getTextChannelsByName(author + "hc", true).get(0);
            tc.sendMessage(event.getMessage().getAuthor().getAsMention() + " created a __H__elp __C__hannel!").queue();
        }
    }
}
