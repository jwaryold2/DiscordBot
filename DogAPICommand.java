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
	private String weatherPrefix = ".weather";
	private String url = "";
	private String city = "";

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
		if (args[0].equals(weatherPrefix)) {
			try {
				
				if (args.length == 2) {
					this.city = args[1];
					//int lan = Integer.parseInt(args[1]);
					//int lon = Integer.parseInt(args[2]);
					//String url2 = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=d4ab93c5782186c7435ffc4d50f40f29";
					this.url = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=9df7b4ccfa993b0d3ab4969ccc18ec98";
					//event.getChannel().sendMessage(url).queue();
				} else if (args.length == 3) {
					//Unable to work gets an
					this.city = args[1];
					//city = city.substring(0,1).toUpperCase()+city.substring(1,city.length());
					String state = args[2];
					this.url = "http://api.openweathermap.org/data/2.5/weather?q="+city+","+state+"&APPID=9df7b4ccfa993b0d3ab4969ccc18ec98";
				}
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
				// event.getChannel().sendMessage(request);
				HttpResponse<String> response = HTTP_CLIENT.<String>send(request, BodyHandlers.ofString());
				String body = response.body();
				//System.out.println();
				
				
				WeatherResponse we = GSON.fromJson(body, WeatherResponse.class);
				for(int i=0; i < we.weather.length;i++) {
					event.getChannel().sendMessage("The main description of the weather in "+this.city+": "+we.weather[i].main).queue();
					event.getChannel().sendMessage("The secondary description of the weather in "+this.city+" :"+we.weather[i].description).queue();
					
					double tempF = 1.8*(we.main.temp-273.15)+32;
					double feelsF = 1.8*(we.main.feels_like-273.15)+32;
					double min = 1.8*(we.main.temp_min-273.15)+32;
					double max = 1.8*(we.main.temp_max-273.15)+32;
					event.getChannel().sendMessageFormat("The temp is: %2f",tempF).queue();
					event.getChannel().sendMessageFormat("Outside feels like: %2f",feelsF).queue();
					event.getChannel().sendMessageFormat("Today's minimum temp is: %2f",min).queue();
					event.getChannel().sendMessageFormat("Today's maximum temp is: %2f",max).queue();
					
				}
				
			} catch (Exception e) {
				System.err.println(e);
			}

		}
		
		
		
		
	}
}
