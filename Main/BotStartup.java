package Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class BotStartup {
	static int tally;
	static File file = new File("data.txt");
	static void write(int tally) {
		try {
			PrintWriter pw = new PrintWriter(file);
			pw.print(tally);
			pw.close();
		} catch (Exception e) {
			
		}
	}
	//OTAzNTE2MTYyOTg4NTk3MjYw.YXuG_w.LMusUx7PKjR80Rdx0r4MFWPiyAc
    public static void main(String[]args) throws LoginException {
        JDABuilder jda = JDABuilder.createDefault("OTAzNTE2MTYyOTg4NTk3MjYw.GR1m7n.KovqVhHS7dExTOp7ilMTc84btzePPg_7KZdCLA");
        jda.setActivity(Activity.playing("working"));
        jda.setStatus(OnlineStatus.ONLINE);//sets bots activity status
        jda.addEventListeners(new Commands());
        jda.setChunkingFilter(ChunkingFilter.ALL);
        jda.setMemberCachePolicy(MemberCachePolicy.ALL);//lets you see all members in server
        jda.enableIntents(GatewayIntent.GUILD_MEMBERS);
        jda.addEventListeners(new GenreCommands());
        jda.addEventListeners(new LeagueCommands());
        //jda.addEventListeners(new MathCommands());
        //jda.addEventListeners(new simpleCommands());
        jda.addEventListeners(new fortuneCommands());
        jda.addEventListeners(new DogAPICommand());
        jda.addEventListeners(new MapCommand());
        jda.addEventListeners(new SimpleMovieC());
        jda.addEventListeners(new AniChanCommands());
        jda.addEventListeners(new ButtonListeners());
        jda.build();
        try {
			System.out.println(System.getProperty("user.dir"));
			Scanner sc = new Scanner(file);
			tally = sc.nextInt();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
    }
}
