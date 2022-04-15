package Main;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.constant.Platform;

import org.apache.commons.collections4.queue.AbstractQueueDecorator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DogAPICommand extends ListenerAdapter {
	private static HttpClient HTTP_CLIENT = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2)
			.followRedirects(HttpClient.Redirect.NORMAL).build();
	private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private String prefix = ".dog";
	private String prefixMast = ".mastery";

	public void onMessageReceived(MessageReceivedEvent event) {
		String fullcommand = "";
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		for (int i = 0; i < args.length; i++) {
			fullcommand = fullcommand.concat(" " + args[i]);
		}
		if (args[0].equals(prefix)) {
			try {
				String url = "https://dog.ceo/api/breeds/image/random";
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
				// event.getChannel().sendMessage(request);
				HttpResponse<String> response = HTTP_CLIENT.<String>send(request, BodyHandlers.ofString());
				String body = response.body();
				// event.getChannel().sendMessage(body);
				DogAPICollect dog = GSON.fromJson(body, DogAPICollect.class);
				event.getChannel().sendMessage("Dog API call status: " + dog.status).queue();
				event.getChannel().sendMessage(dog.message).queue();
			} catch (Exception e) {
				System.err.println(e);
			}

		}
		if (args[0].equals(prefixMast)) {
			String username = "";
			if (args.length > 1) {
				for (int i = 1; i < args.length; i++) {
					username.concat(args[i] + "_");
					if (i == args.length - 1) {
						username.concat(args[i]);
					}
				}
			} else {
				//event.getChannel().sendMessage(username).queue();

				try {
					/* get new api key here https://developer.riotgames.com/ */
					ApiConfig config = new ApiConfig().setKey("RGAPI-5d3ca6d7-932f-4cea-ac8b-20ca5813db98");
					RiotApi api = new RiotApi(config);

					Summoner summoner = api.getSummonerByName(Platform.NA, username);
					event.getChannel().sendMessage("Name: " + summoner.getName()).queue();
					event.getChannel().sendMessage("Summoner ID: " + summoner.getId()).queue();
					event.getChannel().sendMessage("Account ID: " + summoner.getAccountId()).queue();
					event.getChannel().sendMessage("PUUID: " + summoner.getPuuid()).queue();
					event.getChannel().sendMessage("Summoner Level: " + summoner.getSummonerLevel()).queue();
					event.getChannel().sendMessage("Profile Icon ID: " + summoner.getProfileIconId()).queue();
				} catch (Exception e) {
					System.err.println(e);
				}

			}
		}
	}
}
