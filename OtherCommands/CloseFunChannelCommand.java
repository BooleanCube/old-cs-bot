package OtherCommands;

import net.dv8tion.jda.api.entities.Category;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import javax.xml.soap.Text;
import java.util.List;

public class CloseFunChannelCommand extends ListenerAdapter {

    @Override
    public void onGuildVoiceLeave(@Nonnull GuildVoiceLeaveEvent event) {
        String vc = event.getChannelLeft().getName();
        if(vc.equalsIgnoreCase("+ expandfc")) {
            Category cat = event.getGuild().getCategoriesByName("Other", true).get(0);
            TextChannel tc = null;
            try {
                tc = event.getGuild().getTextChannelsByName("FunChannel", true).get(0);
                tc.delete().complete();
            } catch(Exception e) {

            }
        }
    }
}
