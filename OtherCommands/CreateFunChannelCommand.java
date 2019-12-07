package OtherCommands;

import net.dv8tion.jda.api.entities.Category;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class CreateFunChannelCommand extends ListenerAdapter {

    @Override
    public void onGuildVoiceJoin(@Nonnull GuildVoiceJoinEvent event) {
        String vc = event.getChannelJoined().getName();
        String author = event.getMember().getAsMention();
        if(vc.equalsIgnoreCase("+ expandfc")) {
            Category cat = event.getGuild().getCategoriesByName("Other", true).get(0);
            cat.createTextChannel("FunChannel").setName("FunChannel").complete();
            int a = 1;
            while(true) {
                try {
                    if(event.getGuild().getTextChannelsByName("funchannel" + a, true).get(0) != null) {
                        a++;
                    }
                } catch(Exception e) {
                    TextChannel tc = event.getGuild().getTextChannelsByName("funchannel", true).get(0);
                    tc.sendMessage(author + " you have created a #funchannel for yourself, this channel will close when you leave the voice channel!\n" +
                            "Do not ping Anybody in this channel!").queue();
                    break;
                }
            }

        }
    }
}
