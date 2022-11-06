package Main;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import APIs.*;

public class SimpleMovieC extends ListenerAdapter {
	private static HttpClient HTTP_CLIENT = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2)
			.followRedirects(HttpClient.Redirect.NORMAL).build();
	private String query = "";
	private int usage = 0;
	// 4UvWAaof46Bm7DxUV3encQtydzEHgLqs
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String fullcommand = "";
		String args1 = event.getMessage().getContentRaw();
		String[] args = event.getMessage().getContentRaw().split(" ");
		for (int i = 0; i < args.length; i++) {
			fullcommand = fullcommand.concat(" " + args[i]);
		}
		if (args[0].equals(".msearch")) {
			for (int i = 1; i < args.length; i++) { 
				if (i == args.length - 1) {
					this.query = query.concat(args[i]);
				} else {
					this.query = query.concat(args[i]+"-");
				}
			}
			event.getChannel().sendMessage("https://ev01.to/search/"+this.query).queue();
		}
		if (args[0].equals("spam2")  && event.getAuthor().getId().equals("162295333873778689")){
			List<User> mentioned = event.getMessage().getMentionedUsers();
			if(usage < 1) {
				if (mentioned.size() == 1) {
					String mentioned_1 = mentioned.get(0).getId();
					int i = 0;
					while (i < 200) {
						// event.getChannel().sendMessage("<@!321467507905134592>").queue();
						event.getChannel().sendMessage("<@!" + mentioned_1 + ">").queue();
						i++;
					}
					event.getChannel().sendMessage("Spam has finished with a total for "+i+" messages.").queue();
					this.usage=1;
				}
				if (mentioned.size()>1) {
					event.getMessage().reply("Sorry please mention only 1 user at a time. Thank you.").queue();
					this.usage = 1;
				}
			} else {
				event.getChannel().sendMessage("Please wait 2 minutes before using the command. If you spam the command it will reset the time to wait each time. Please only try once.").queue();
				
			}
			
		}
		
	}
}
