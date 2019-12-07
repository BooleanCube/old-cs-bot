import Secrets.Secret;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Main {

    public static void main(String[] args) throws Exception {
        JDA jda = new JDABuilder(Secret.Token).build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.playing("cs!help"));
        jda.addEventListener(new JavaCommands.HelloWorld());
        jda.addEventListener(new JavaCommands.StringReverse());
        jda.addEventListener(new JavaCommands.StringReverseMethod());
        jda.addEventListener(new JavaCommands.PrintStringRawCode());
        jda.addEventListener(new JavaCommands.tenCount());
        jda.addEventListener(new JavaCommands.FractionsClass());
        jda.addEventListener(new JavaCommands.MST());
        jda.addEventListener(new PythonCommands.HelloWorld());
        jda.addEventListener(new PythonCommands.PrintStringCommand());
        jda.addEventListener(new PythonCommands.TenCount());
        jda.addEventListener(new PythonCommands.CoinFlipToss());
        jda.addEventListener(new PythonCommands.MusicFile());
        jda.addEventListener(new CplusplusCommands.HelloWorld());
        jda.addEventListener(new CplusplusCommands.StringReverse());
        jda.addEventListener(new HelpCommands.Help());
        jda.addEventListener(new HelpCommands.CHelp());
        jda.addEventListener(new HelpCommands.OHelp());
        jda.addEventListener(new HelpCommands.HHelp());
        jda.addEventListener(new HelpLine.RequestCommand());
        jda.addEventListener(new HelpLine.ClrReplyCommand());
        jda.addEventListener(new HelpLine.ReplyCommand());
        jda.addEventListener(new HelpLine.CommentCommand());
        jda.addEventListener(new HelpLine.AddTQCommand());
        jda.addEventListener(new HelpLine.CreateHelpChannel());
        jda.addEventListener(new HelpLine.ExitHcCommand());
        jda.addEventListener(new OtherCommands.Shutdown());
        jda.addEventListener(new OtherCommands.Games.VerbalMemory());
        jda.addEventListener(new OtherCommands.Games.NumberMemory());
        jda.addEventListener(new OtherCommands.PingCommand());
        jda.addEventListener(new OtherCommands.ClearCommand());
        jda.addEventListener(new OtherCommands.Games.FlipCoin());
        jda.addEventListener(new OtherCommands.Games.RockPaperScissors());
        jda.addEventListener(new OtherCommands.Games.SimonSaysCommand());
        jda.addEventListener(new OtherCommands.EmojiMidCommand());
        jda.addEventListener(new OtherCommands.AutoClearCommand());
        jda.addEventListener(new OtherCommands.AutoBlackHoleCommand());
        jda.addEventListener(new OtherCommands.SpamCommand());
        jda.addEventListener(new OtherCommands.ThankCommand());
        jda.addEventListener(new OtherCommands.WelcomeCommand());
        jda.addEventListener(new OtherCommands.CreateFunChannelCommand());
        jda.addEventListener(new OtherCommands.CloseFunChannelCommand());
        jda.addEventListener(new OtherCommands.GianCommands.GianJokeCommand());
        jda.addEventListener(new OtherCommands.GianCommands.WhoIsGiancommand());
        jda.addEventListener(new OtherCommands.CreateBotCmdChannel());
        jda.addEventListener(new OtherCommands.CloseBotCmdChannel());
        jda.addEventListener(new OtherCommands.BruhCommand());
    }

}