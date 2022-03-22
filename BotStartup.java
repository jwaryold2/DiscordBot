package Main;

import java.io.InputStream;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.Request;
import net.dv8tion.jda.api.requests.Response;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import okhttp3.OkHttpClient;

public class BotStartup {
    public static void main(String[]args) throws LoginException {
        JDABuilder jda = JDABuilder.createDefault("OTAzNTE2MTYyOTg4NTk3MjYw.YXuG_w.LMusUx7PKjR80Rdx0r4MFWPiyAc");
        jda.setActivity(Activity.playing("~reco"));
        jda.setStatus(OnlineStatus.ONLINE);//sets bots activity status
        jda.addEventListeners(new Commands());
        jda.setChunkingFilter(ChunkingFilter.ALL);
        jda.setMemberCachePolicy(MemberCachePolicy.ALL);//lets you see all members in server
        jda.enableIntents(GatewayIntent.GUILD_MEMBERS);
        jda.addEventListeners(new GenreCommands());
        jda.addEventListeners(new LeagueCommands());
        jda.addEventListeners(new ButtonTest());
        jda.build();
       
    }
}
