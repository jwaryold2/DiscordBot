package Main;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import APIs.AniAPI;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class AniChanCommands extends ListenerAdapter {
	private String prefix = "..";
	private static HttpClient HTTP_CLIENT = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2)
			.followRedirects(HttpClient.Redirect.NORMAL).build();
	private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();

	public void onMessageReceived(MessageReceivedEvent event) {
		String fullcommand = "";
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		for (int i = 0; i < args.length; i++) {
			fullcommand = fullcommand.concat(" " + args[i]);
		}
		if (args[0].equals(prefix + "aq")) {
			try {
				String url = "https://animechan.vercel.app/api/random";
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
				HttpResponse<String> response = HTTP_CLIENT.<String>send(request, BodyHandlers.ofString());
				String body = response.body();
				AniAPI anip = GSON.fromJson(body, AniAPI.class);
				EmbedBuilder embed = new EmbedBuilder().setTitle("AniQuote")
						.setDescription("\"" + anip.quote + "\" -" + anip.character)
						.setThumbnail("https://www.google.com/search?q=" + anip.character.replace("\s", "+"));
				event.getChannel().sendMessage(embed.build()).queue();
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		if (fullcommand.contains("cope") && !fullcommand.contains(".tallycope")) {
			BotStartup.tally += 1;
		}
		if (args[0].equals(".tallycope")) {
			BotStartup.write(BotStartup.tally);
			event.getChannel().sendMessage("Total number of copes used: " + BotStartup.tally).queue();
		}
		if (args[0].equals("bot")) {
			if (args[1].equals("go")) {
				if (args[2].equals("offline"))
					System.exit(0);
			}
		}
	} // onmessagerecieve

}
