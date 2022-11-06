package Main;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Random;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class RandomCommands extends ListenerAdapter {
	public String prefix = "";
	private int totalCope = 0;
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
		String fullArgs = "";
		String fullM = "";
		int messages = 0;
		int messagesE = 0;
		Random rand = new Random();
		int watsonM = rand.nextInt(30);
		int evanM = rand.nextInt(30);
		for (int i = 0; i<args.length;i++) {
			fullM = fullM.concat(" "+args[i]);
		}
		if (args[0].equalsIgnoreCase("tanh")) {
			if (!args[1].equals(" ")) {
				for(int i = 0; i < args.length; i++) {
				fullArgs = fullArgs.concat(args[i]);
				}
				double x = Double.parseDouble(fullArgs);
				event.getMessage().reply(""+Math.tanh(x)).queue();
			}
			
			
		}
		if (args[0].equals("@LionOnIce")) {
			String textOne = args[0];
			//event.getMessage().sendMessage("@"+ Mal).queue();
			event.getChannel().sendMessage(args[0]).queue();
			}
		String mal = "321467507905134592";
		if (event.getMessage().getAuthor().getId().equals(mal)) {
			//event.getMessage().reply("https://tenor.com/view/spongebob-dance-gif-23278638").queue();
			//event.getMessage().reply("@321467507905134592 ").queue();
		}
			String evan = "549694705852481546";
		if (event.getMessage().getAuthor().getId().equals(evan)) {
			messagesE++; 
			if (messagesE == evanM) {
				if(!fullM.contains("cope")){
					//event.getMessage().reply("https://tenor.com/view/talk-to-em-angry-mad-fish-spongebob-gif-17712353").queue();
				}
				messagesE = 0;
			}
		}
		String jon = "380548913033117697";
		if (event.getMessage().getAuthor().getId().equals(jon)) {
			//event.getMessage().reply("https://tenor.com/view/talk-to-em-angry-mad-fish-spongebob-gif-17712353").queue();
		}
		
		String watson = "252523390043291649";
		if (event.getMessage().getAuthor().getId().equals(watson)) {
				messages++; 
				if (messages == watsonM) {
					if(!fullM.contains("cope")){
						event.getMessage().reply("https://tenor.com/view/talk-to-em-angry-mad-fish-spongebob-gif-17712353").queue();
					}
					messages = 0;
				}
		}
		String logan = "268171572022476800";
		if (event.getMessage().getAuthor().getId().equals(logan)) {
			//event.getMessage().reply("https://gfycat.com/harshlinearflickertailsquirrel").queue();
		}
		//use random num to generate a target number and if that target number is hit send gif not every message 
		String owner = "162295333873778689";
		if (event.getMessage().getAuthor().getId().equals(owner)) {
			
			if(!fullM.contains("cope")) {
				//event.getMessage().reply("https://gfycat.com/harshlinearflickertailsquirrel").queue();
			}
		}
		if (args[0].equalsIgnoreCase("mangadb")) {
			/*int chapters = Integer.parseInt(args[1]);
			String title = args[2];
			String genres = "";
			String reading_status = "";
			for (int i = 2; i < args.length; i++) {
				if(args[i].equalsIgnoreCase("dropped") || args[i].equalsIgnoreCase("completed")) {
					reading_status = args[i];
				}else {
					genres+= args[i];
				}
			} */
			String url = "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false";
			String user = "jwaryold";
			String password = "MMS1804121";
			try {
				Connection myConn = DriverManager.getConnection(url,user,password);
				Statement myStmt = myConn.createStatement();
				String sql = "select * from manga.list_mangas";
				ResultSet rs = myStmt.executeQuery(sql);
				
				while (rs.next()) {
					event.getMessage().reply(rs.getString("title")).queue();
				}
			} catch (Exception e) {
				System.out.println("Error");
			}
					
		}
	
	
	
	}
	
}