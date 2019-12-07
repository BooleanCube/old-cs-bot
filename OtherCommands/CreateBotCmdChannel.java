package OtherCommands;

import net.dv8tion.jda.api.entities.Category;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class CreateBotCmdChannel extends ListenerAdapter {

    @Override
    public void onGuildVoiceJoin(@Nonnull GuildVoiceJoinEvent event) {
        String vc = event.getChannelJoined().getName();
        if(vc.equalsIgnoreCase("+ expandbc")) {
            Category cat = event.getGuild().getCategoriesByName("Bots", true).get(0);
            cat.createTextChannel("othercommands").setName("othercommands").complete();
            try{
                event.getGuild().getTextChannelsByName("othercommands", true).get(0).sendMessage(event.getMember().getAsMention() + " you created another bot command channel!").queue();
            } catch(Exception e) {

            }
        }
    }
}
