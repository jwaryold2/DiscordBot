package Main;

import java.util.Scanner;
import java.io.File;
import java.util.Scanner;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ImageCommands extends ListenerAdapter{
	public String prefix = "!";
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
		if(args[0].equalsIgnoreCase(prefix+"reco")){
			event.getChannel().sendMessage("Hello, Keep in Mind This is A Work In Progress still.").queue();
			event.getChannel().sendMessage("Let me help you with netflix series recommendations").queue();
			event.getChannel().sendMessage("Please Choose 1 Genres:"+"\n!Suspense\n!Horr\n!Romance\n!Crime").queue();
			MessageChannel channel = event.getChannel();
			String content = event.getMessage().getContentRaw();
			if(content.equalsIgnoreCase("suspense")) {
				event.getChannel().sendMessage("My Recommendation for Suspense is 'Wind River'").queue();
			}
			
		}
		 
	}
}
	