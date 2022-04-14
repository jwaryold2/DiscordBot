package Main;

import java.util.Scanner;
import java.util.Random;
import java.awt.Color;
import java.io.File;
import java.util.Scanner;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GenreCommands extends ListenerAdapter{
    public String prefix = "~";
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        int upperbound=9;
        Random rand = new Random();
        int randomInt=rand.nextInt(upperbound);
        EmbedBuilder eb = new EmbedBuilder();
        
        if(args[0].equalsIgnoreCase(prefix+"reco")){
            event.getChannel().sendMessage("Hello, Keep in Mind This is A Work In Progress still.").queue();
            event.getChannel().sendMessage("Let me help you with netflix series recommendations").queue();
            event.getChannel().sendMessage("Please Choose 1 Genres:"+"\nSuspense\nHorror\nRomance\nCrime").queue();

        }
        if(args[0].equalsIgnoreCase(prefix+"suspense")) {
        	eb.setTitle("Wind River",null);
            eb.setColor(Color.lightGray);
            eb.addBlankField(false);
            eb.setDescription("My Recommendation for Suspense is 'Wind River'\nA tracker with the U.S Fish and Wildlife Service assists a rookie FBI agent who's investigating a teen girl's murder on a remote Wyoming reservation.");
            eb.setImage("https://www.nickcave.com/wp-content/uploads/2019/09/Wind-River-1.jpg");
            eb.setFooter("Rated 7.7/10* Directed by Taylor Sheridan, Staring Elizabeth Olsen, Jeremy Renner and Graham Greene");
           event.getChannel().sendMessage(eb.build()).queue();
           
        }
        if(args[0].equalsIgnoreCase(prefix+"horror")) {
        	eb.setTitle("The Ritual",null);
            eb.setColor(Color.white);
            eb.addBlankField(true);
            eb.setDescription("My Recommendation for Suspense is 'The Ritual'\nFour friends with a long-standing -- but strained -- connection take a hiking trip into the Swedish wilderness from which they may never return.");
            eb.setImage("https://m.media-amazon.com/images/M/MV5BMjAzMzAyMDI4Ml5BMl5BanBnXkFtZTgwODMwOTY2NDM@._V1_.jpg");
            eb.setFooter("Rated 6.3/10* Directed by David Bruckner, Staring Rafe Spall, Arsher Ali and Rober James-Collier");
           event.getChannel().sendMessage(eb.build()).queue();
        }
        if(args[0].equalsIgnoreCase(prefix+"romance")) {
        	int movieOption = randomInt;
        	//Random Number generation 0-9 in attempt to get a variety of recommendations rather than just a single recommendation gives the bot versatility
        	//9*4 genres = ~36 movie recommendations embeds

        	if(movieOption==0) {
        		eb.setTitle("La La Land",null);
                eb.setColor(Color.MAGENTA);
                eb.addBlankField(false);
                eb.setDescription("My Recommendation for Romance is 'La La Land'\nWhile navigating their careers in Los Angeles, a pianist and an actress fall in love while attempting to reconcile their aspirations for the future.");
                eb.setImage("https://www.goldenglobes.com/sites/default/files/articles/cover_images/2017-la_la_land.jpg?format=pjpg&auto=webp&optimize=high&width=850");
                eb.setFooter("Rated 8.0/10* Directed by Damien Chazelle, Staring Ryan Gosling, Emmma Stone, Rosemarie DeWitt and more!");
                event.getChannel().sendMessage(eb.build()).queue();
        		
        	}
        	if(movieOption==1) {
        		eb.setTitle("The Notebook",null);
                eb.setColor(Color.blue);
                eb.addBlankField(false);
                eb.setDescription("My Recommendation for Romance is 'The Notebook'\nA poor yet passionate young man falls in love with a rich young woman, giving her a sense of freedom, but they are soon separated because of their social differences.");
                eb.setImage("https://m.media-amazon.com/images/M/MV5BMTk3OTM5Njg5M15BMl5BanBnXkFtZTYwMzA0ODI3._V1_.jpg");
                eb.setFooter("Rated 7.8/10* Directed by Nick Cassavetes, Staring Ryan Gosling, Rachel McAdams, Gena Rowlands and more!");
                event.getChannel().sendMessage(eb.build()).queue();
        		
        	}
        	if(movieOption==2) {
        		event.getChannel().sendMessage("Movie "+movieOption).queue();
        	}
        	if(movieOption==3) {
        		event.getChannel().sendMessage("Movie "+movieOption).queue();
        	}
        	if(movieOption==4) {
        		event.getChannel().sendMessage("Movie "+movieOption).queue();
        	}
        	if(movieOption==5) {
        		event.getChannel().sendMessage("Movie "+movieOption).queue();
        	}
        	if(movieOption==6) {
        		event.getChannel().sendMessage("Movie "+movieOption).queue();
        	}
        	if(movieOption==7) {
        		event.getChannel().sendMessage("Movie "+movieOption).queue();
        	}
        	if(movieOption==8){
        		event.getChannel().sendMessage("Movie "+movieOption).queue();
        	}
        	if(movieOption==9) {
        		event.getChannel().sendMessage("Movie "+movieOption).queue();
        	}
        	
            /*event.getChannel().sendMessage("My Recommendation for Suspense is 'Wild Things'").queue();
            event.getChannel().sendMessage("I hope you enjoy it!").queue();*/
        }
        if(args[0].equalsIgnoreCase(prefix+"Crime")) {
            event.getChannel().sendMessage("My Recommendation for Suspense is 'Criminal Minds'").queue();
            event.getChannel().sendMessage("I hope you enjoy it!").queue();
        }
        

    }
} 
