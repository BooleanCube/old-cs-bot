package OtherCommands.Games;

import Secrets.Secret;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;

public class RockPaperScissors extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String[] msg = event.getMessage().getContentRaw().split(" ");
        if(msg[0].equalsIgnoreCase(Secret.Prefix + "rps") && msg.length == 2) {
            if(msg[1].equalsIgnoreCase("rock") || msg[1].equalsIgnoreCase("paper") || msg[1].equalsIgnoreCase("scissors")) {
                EmbedBuilder play = new EmbedBuilder();
                play.setColor(Color.GREEN);
                int ran = (int) (Math.random() * 10);
                String botPlay = "";
                String personPlay = msg[1];
                botPlay = setBotPlay(ran);
                if(personPlay.equalsIgnoreCase(botPlay)) {
                    play.setTitle("Tie!");
                    play.setDescription("You chose **" + personPlay + "** and I chose **" + botPlay + "**!\n" +
                            "We tied! Try Again!");
                    event.getChannel().sendMessage(play.build()).queue();
                } else if(personPlay.equalsIgnoreCase("rock") && botPlay.equalsIgnoreCase("scissors")) {
                    play.setTitle("You win!");
                    play.setDescription("You chose **" + personPlay + "** and I chose **" + botPlay + "**!\n" +
                            "You win! Congrats!");
                    event.getChannel().sendMessage(play.build()).queue();
                } else if(botPlay.equalsIgnoreCase("rock") && personPlay.equalsIgnoreCase("scissors")) {
                    play.setTitle("I win!");
                    play.setDescription("You chose **" + personPlay + "** and I chose **" + botPlay + "**!\n" +
                            "I win! Try Again!");
                    event.getChannel().sendMessage(play.build()).queue();
                } else if(personPlay.length() > botPlay.length()) {
                    play.setTitle("You win!");
                    play.setDescription("You chose **" + personPlay + "** and I chose **" + botPlay + "**!\n" +
                            "You win! Congrats!");
                    event.getChannel().sendMessage(play.build()).queue();
                } else {
                    play.setTitle("I win!");
                    play.setDescription("You chose **" + personPlay + "** and I chose **" + botPlay + "**!\n" +
                            "I win! Try Again!");
                    event.getChannel().sendMessage(play.build()).queue();
                }
            } else {
                EmbedBuilder error = new EmbedBuilder();
                error.setColor(Color.RED);
                error.setTitle("Specified choice is incorrect");
                error.setDescription("Your choice can be either \"rock\", \"paper\", or \"scissors\"!\n" +
                        "Usage = `cs!rps [choice]`");
                event.getChannel().sendMessage(error.build()).queue();
            }
        } else if(msg[0].equalsIgnoreCase(Secret.Prefix + "rps") && msg.length != 2) {
            EmbedBuilder error = new EmbedBuilder();
            error.setColor(Color.RED);
            error.setTitle("Unspecified choice");
            error.setDescription("Specify the choice you made.\n" +
                    "Usage = `cs!rps [choice]`\n" +
                    "Your choice can be either \"rock\", \"paper\", or \"scissors\"!");
            event.getChannel().sendMessage(error.build()).queue();
        }
    }

    public static String setBotPlay(int ran) {
        if(ran % 3 == 0) {
            return "paper";
        } else if(ran % 3 == 1) {
            return "scissors";
        }
        return "rock";
    }
}
