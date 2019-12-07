package OtherCommands.Games;

import Secrets.Secret;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class SimonSaysCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();
        EmbedBuilder error = new EmbedBuilder();
        error.setColor(Color.red);
        if(msg.equalsIgnoreCase(Secret.Prefix + "simonsays")) {
            if(event.getChannel().getName().equalsIgnoreCase("funchannel")) {
                event.getChannel().sendMessage("You have dedicated this channel to the Simon Says game!").queue();
                event.getChannel().sendMessage("Leave the \"+ expandfc\" vc whenever you want to quit the game. Are you sure you want to begin? (yes/no)").queue();
                List<Message> msg1;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {

                }
                msg1 = event.getChannel().getHistory().retrievePast(1).complete();
                if(msg1.get(0).equals("yes")) {
                    event.getChannel().sendMessage("Get Ready!").queue();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {

                    }
                    ArrayList<String> commands = new ArrayList<>();
                    commands.add("Type: \"Hello World!\"");
                    commands.add("Don't type for 5 seconds...");
                    commands.add("Change nickname to beastCoder in 10 seconds");
                    commands.add("Use a CSBot command!");
                    commands.add("Use an Ozaru Command!");
                    commands.add("Select one: Communism, Capitalism, Socialism, or Marxism");
                    commands.add("Type: \"Simon is a god!\"");
                    while(true) {
                        int random = (int) (Math.random() * 100);
                        int ran = random % commands.size();
                        int random2 = (int) (Math.random() * 10);
                        int ran2 = random2 % 2;
                        String cmd = commands.get(ran);
                        if(ran2 == 0) {
                            cmd = "Simon Says: " + cmd;
                        }
                        event.getChannel().sendMessage(cmd).queue();
                        List<Message> msg2;
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {

                        }
                        msg2 = event.getChannel().getHistory().retrievePast(1).complete();
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {

                        }
                        if(ran == 0) {
                            if(!msg2.get(0).equals("Hello World!")) {
                                event.getChannel().sendMessage("OOOPS! You lost!").queue();
                                break;
                            }
                        } else if(ran == 1) {
                            if(!msg2.get(0).equals("")) {
                                event.getChannel().sendMessage("OOOPS! You lost!").queue();
                                break;
                            }
                        } else if(ran == 2) {
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {

                            }
                            if(!event.getMember().getNickname().equalsIgnoreCase("BeastCoder")) {
                                event.getChannel().sendMessage("OOOPS! You lost!").queue();
                                break;
                            }
                        } else if(ran == 3) {
                            if(!msg2.get(0).toString().startsWith("cs!")) {
                                event.getChannel().sendMessage("OOOPS! You lost!").queue();
                                break;
                            }
                        } else if(ran == 4) {
                            if(!msg2.get(0).toString().startsWith("$")) {
                                event.getChannel().sendMessage("OOOPS! You lost!").queue();
                                break;
                            }
                        } else if(ran == 5) {
                            if(!msg2.get(0).toString().equalsIgnoreCase("Communism") || !msg2.get(0).toString().equalsIgnoreCase("Capitalism") || !msg2.get(0).toString().equalsIgnoreCase("Socialism") || !msg2.get(0).toString().equalsIgnoreCase("Marxism")) {
                                event.getChannel().sendMessage("OOOPS! You lost!").queue();
                                break;
                            }
                        } else if(ran == 6) {
                            if(!msg2.get(0).toString().equalsIgnoreCase("Simon is a god!")) {
                                event.getChannel().sendMessage("OOOPS! You lost!").queue();
                                break;
                            }
                        }
                    }
                } else {
                    event.getChannel().sendMessage("Closing simon Says...").queue();
                }
            } else {
                error.setTitle("Can not dedicate this command to the server");
                error.setDescription("Try creating a new command by joining the \"+ expandfc\" vc!");
                event.getChannel().sendMessage(error.build()).queue();
            }
        }
    }
}