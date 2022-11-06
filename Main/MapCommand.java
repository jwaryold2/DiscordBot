package Main;

import APIs.DogAPICollect;
import APIs.WeatherResponse;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
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

import APIs.*;

public class MapCommand extends ListenerAdapter {
	private static HttpClient HTTP_CLIENT = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2)
			.followRedirects(HttpClient.Redirect.NORMAL).build();
	private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private String key = "4UvWAaof46Bm7DxUV3encQtydzEHgLqs";
	private String mapweather = ".mapw";
	private String url;
	private String center;
	private String city;
	private String url2;

	// 4UvWAaof46Bm7DxUV3encQtydzEHgLqs
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String fullcommand = "";
		String args1 = event.getMessage().getContentRaw();
		String[] args = event.getMessage().getContentRaw().split(" ");
		for (int i = 0; i < args.length; i++) {
			fullcommand = fullcommand.concat(" " + args[i]);
		}
		if (args[0].equals(".test")) {
			event.getChannel().sendMessage("success").queue();
		}
		if (args[0].equals(mapweather)) {
			
			try {
				this.center = args[1];
				this.url2 = "https://www.mapquestapi.com/staticmap/v5/map?key=" + key + "&center=" + center
						+ "&size=600,400@2x";
				//this.city = args[1];
				this.url = "http://api.openweathermap.org/data/2.5/weather?q=" + center
						+ "&APPID=9df7b4ccfa993b0d3ab4969ccc18ec98";
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
				//HttpRequest request2 = HttpRequest.newBuilder().uri(URI.create(url2)).build();
				HttpResponse<String> response = HTTP_CLIENT.<String>send(request, BodyHandlers.ofString());
				String body = response.body();
				//String body2 = response2.body();

				WeatherResponse we = GSON.fromJson(body, WeatherResponse.class);
				for (int i = 0; i < we.weather.length; i++) {
					event.getChannel()
							.sendMessage(
									"The main description of the weather in " + this.center + ": " + we.weather[i].main)
							.queue();
					event.getChannel().sendMessage("The secondary description of the weather in " + this.center + " :"
							+ we.weather[i].description).queue();

					double tempF = 1.8 * (we.main.temp - 273.15) + 32;
					double feelsF = 1.8 * (we.main.feels_like - 273.15) + 32;
					double min = 1.8 * (we.main.temp_min - 273.15) + 32;
					double max = 1.8 * (we.main.temp_max - 273.15) + 32;
					event.getChannel().sendMessageFormat("The temp is: %.2f", tempF).queue();
					event.getChannel().sendMessageFormat("Outside feels like: %.2f", feelsF).queue();
					event.getChannel().sendMessageFormat("Today's minimum temp is: %.2f", min).queue();
					event.getChannel().sendMessageFormat("Today's maximum temp is: %.2f", max).queue();
					event.getChannel().sendMessage(url2).queue();
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}

	}
}
