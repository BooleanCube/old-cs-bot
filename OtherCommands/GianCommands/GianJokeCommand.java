package OtherCommands.GianCommands;

import Secrets.Secret;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.ArrayList;

public class GianJokeCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();
        ArrayList<String> jokes = new ArrayList<String>();
        jokes.add("Fun Fact: Gian is nocturnal! Maybe he has insomnia?");
        jokes.add("All of Gian's friends are owls except me...");
        jokes.add("Gian resembles a monkey!");
        jokes.add("Gian is a nocturnal monkey!");
        jokes.add("Gian brain is tiny...");
        jokes.add("*Gian with the sandwhich*: fdkg slkdfhvskjdngf ojfd;v sjdfogjs;dkgjsiufdhb");
        jokes.add("Gian's passwords be like... `kajvhieuhkjnvasdufas;taesupqwe8uowe 58q95q9euf idiufhisugofiuearyidshjkhavuyiurdhgijkfdhviuyriejkfdjygisudfyvijshfkjdhglsiu`(I am not joking...)");
        jokes.add("Gian at night: https://giphy.com/gifs/s6NumZOl0HJdu");
        jokes.add("Gian is a meme!");
        jokes.add("Gian? Can you... https://cdn.discordapp.com/attachments/646481121487355925/651557488843423745/meme.png");
        jokes.add("Gian's minecraft skills are trash!");
        jokes.add("Gian studied minecraft for his test today!");
        jokes.add("Gian doesn't know how to cast!");
        jokes.add("Gian bad trash!");
        jokes.add("Gian calling everyone mad cringe...");
        jokes.add("I think Gian has insomnia because he drinks to much coke!");
        jokes.add("Gian = Coke addict");
        jokes.add("Gian is a nocturnal coke-hydrated monkey...");
        if(msg.equalsIgnoreCase(Secret.Prefix + "gianjoke")) {
            int ran = (int) (Math.random() * 100);
            ran %= jokes.size();
            EmbedBuilder joke = new EmbedBuilder();
            joke.setColor(Color.BLACK);
            joke.setTitle("Joke about Gena!");
            joke.setDescription(jokes.get(ran));
            joke.setFooter("Gian is bad!");
            event.getChannel().sendMessage(joke.build()).queue();
        }
    }
}
