package Main;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class BotStartup {
    public static void main(String[]args) throws LoginException {
        JDABuilder jda = JDABuilder.createDefault("OTAzNTE2MTYyOTg4NTk3MjYw.YXuG_w.LMusUx7PKjR80Rdx0r4MFWPiyAc");
        jda.setActivity(Activity.playing(".help"));
        jda.setStatus(OnlineStatus.ONLINE);//sets bots activity status
        jda.addEventListeners(new Commands());
        jda.setChunkingFilter(ChunkingFilter.ALL);
        jda.setMemberCachePolicy(MemberCachePolicy.ALL);//lets you see all members in server
        jda.enableIntents(GatewayIntent.GUILD_MEMBERS);
        jda.addEventListeners(new GenreCommands());
        jda.addEventListeners(new LeagueCommands());
        jda.addEventListeners(new MathCommands());
        jda.addEventListeners(new simpleCommands());
        jda.addEventListeners(new fortuneCommands());
        jda.addEventListeners(new DogAPICommand());
        jda.build();
       
    }
}
