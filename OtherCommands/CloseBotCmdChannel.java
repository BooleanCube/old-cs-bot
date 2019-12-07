package OtherCommands;

import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class CloseBotCmdChannel extends ListenerAdapter {

    @Override
    public void onGuildVoiceLeave(@Nonnull GuildVoiceLeaveEvent event) {
        String vc = event.getChannelLeft().getName();
        String member = event.getMember().getAsMention();
        if(vc.equalsIgnoreCase("+ expandbc")) {
            event.getGuild().getTextChannelsByName("othercommands", true).get(0).delete().complete();
        }
    }
}
