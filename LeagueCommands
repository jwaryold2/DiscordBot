package Main;

import java.awt.Color;
import java.util.*;
import java.util.Random;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.Button;

public class LeagueCommands extends ListenerAdapter {
	public String prefix = "~";

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");

		Random rand = new Random();

		EmbedBuilder eb = new EmbedBuilder();
		String mid[] = { "annie", "diana", "zed", "viktor", "vex", "kassadin", "akshan", "qiyana", "anivia", "vladimir",
				"talon", "katarina", "fizz", "lux", "xerath", "cassiopeia", "ahri", "malzahar", "pyke", "tryndamere",
				"kayle", "velkoz", "zilean", "zoe", "ekko", "lissandra", "rumble", "graves", "renekton", "chogath",
				"ziggs", "malphite", "galio", "brand", "twitch", "twisted fate", "neeko", "gangplank", "veigar", "azir",
				"jayce", "lucian", "sylas", "orianna", "ryze", "syndra", "corki", "irelia", "akali", "leblanc", "yasuo",
				"yone", "mordekaiser" };
		String jungle[] = { "shaco", "khazix", "nunu", "diana", "hecarim", "xinzhao", "vi", "trundle", "reksai", "zac",
				"fiddlesticks", "rammus", "amumu", "warwick", "ekko", "poppy", "kindred", "sejuani", "yi", "jarvaniv",
				"gwen", "taliyah", "skarner", "udyr", "talon", "elise", "olaf", "ivern", "shyvana", "kayn", "nidalee",
				"volibear", "karthus", "rengar", "gragas", "lillia", "qiyana", "nocturne", "graves", "zed", "viego",
				"leesin", };
		String top[] = { "tahmkench", "darius", "shen", "tryndamere", "akshan", "camille", "fiora", "garen", "nasus",
				"drmundo", "teemo", "malphite", "riven", "urgot", "kayle", "poppy", "trundle", "vayne", "yorick",
				"warwick", "ornn", "kled", "chogath", "singed", "cassiopeia", "quinn", "wukong", "pantheon",
				"mordekaiser", "vladimir", "aatrox", "illaoi", "sion", "heimerdinger", "gragas", "viktor", "sett",
				"gnar", "rengar", "ryze", "rumble", "jax", "kennen", "gwen", "sylas", "graves", "volibear", "akali",
				"irelia", "renekton", "yasuo", "jayce", "gangplank", "yone" };
		int upperboundTop = top.length;
		int randomIntTop = rand.nextInt(upperboundTop);
		int upperboundMid = mid.length;
		int randomIntMid = rand.nextInt(upperboundMid);
		int upperboundJng = jungle.length;
		int randomIntJng = rand.nextInt(upperboundJng);
		if (args[0].equalsIgnoreCase(prefix + "mid")) {
			int randomMid = randomIntMid;

			eb.setTitle(mid[randomMid], null);
			eb.setColor(Color.lightGray);
			eb.addBlankField(false);
			
			eb.setDescription("\n\n\nYou should play "+mid[randomMid]+" in the midlane." +"Here is the link to " + top[randomMid] + " in u.gg: "
					+ "https://u.gg/lol/champions/" + mid[randomMid] + "/build?role=mid");
			eb.setImage("https://static.u.gg/assets/lol/riot_static/12.5.1/img/champion/"+mid[randomMid]+".png");
			//event.getChannel().sendMessage("You should play " + top[randomMid] + " in toplane.").queue();
			//event.getChannel().sendMessage("Here is the link to " + top[randomMid] + " in u.gg: "
				//	+ "https://u.gg/lol/champions/" + top[randomMid] + "/build?role=top").queue();
			mid[randomMid] = mid[randomMid].substring(0, 1).toUpperCase() + mid[randomMid].substring(1).toLowerCase();

			//eb.setThumbnail(
				//	"https://static.u.gg/assets/lol/riot_static/12.1.1/img/champion/" + top[randomMid] + ".png");
			event.getChannel().sendMessage(eb.build()).queue();
		}
		if (args[0].equalsIgnoreCase(prefix + "jungle")) {
			int randomMid = randomIntJng;

			eb.setTitle(jungle[randomMid], null);
			eb.setTitle(jungle[randomMid], null);
			eb.setColor(Color.lightGray);
			eb.addBlankField(false);
			eb.setDescription("\n\n\nYou should play "+jungle[randomMid]+" in the jungle." +"Here is the link to " + jungle[randomMid] + " in u.gg: "
					+ "https://u.gg/lol/champions/" + jungle[randomMid] + "/build?role=jungle");
			eb.setThumbnail("https://static.u.gg/assets/lol/riot_static/12.5.1/img/champion/"+jungle[randomMid]+".png");

			//event.getChannel().sendMessage("You should play " + top[randomMid] + " in toplane.").queue();
			//event.getChannel().sendMessage("Here is the link to " + top[randomMid] + " in u.gg: "
				//	+ "https://u.gg/lol/champions/" + top[randomMid] + "/build?role=top").queue();
			jungle[randomMid] = jungle[randomMid].substring(0, 1).toUpperCase() + jungle[randomMid].substring(1).toLowerCase();

			eb.setThumbnail(
					"https://static.u.gg/assets/lol/riot_static/12.1.1/img/champion/" + top[randomMid] + ".png");
			event.getChannel().sendMessage(eb.build()).queue();
		}
		if (args[0].equalsIgnoreCase(prefix + "top")) {
			int randomMid = randomIntTop;
			eb.setTitle(top[randomMid], null);
			eb.setColor(Color.lightGray);
			eb.addBlankField(false);
			eb.setDescription("\n\n\nYou should play "+top[randomMid]+" in the toplane." +"Here is the link to " + top[randomMid] + " in u.gg: "
					+ "https://u.gg/lol/champions/" + top[randomMid] + "/build?role=top");
			eb.setImage("https://static.u.gg/assets/lol/riot_static/12.5.1/img/champion/"+top[randomMid]+".png");

			//event.getChannel().sendMessage("You should play " + top[randomMid] + " in toplane.").queue();
			//event.getChannel().sendMessage("Here is the link to " + top[randomMid] + " in u.gg: "
				//	+ "https://u.gg/lol/champions/" + top[randomMid] + "/build?role=top").queue();
			top[randomMid] = top[randomMid].substring(0, 1).toUpperCase() + top[randomMid].substring(1).toLowerCase();

			//eb.setThumbnail(
				//	"https://static.u.gg/assets/lol/riot_static/12.1.1/img/champion/" + top[randomMid] + ".png");
			event.getChannel().sendMessage(eb.build()).queue();

		}
		if (args[0].equalsIgnoreCase(prefix+"play")) {
		 Scanner input = new Scanner(System.in);
		 //event.getChannel().sendMessage("What lane do you want it to be in?");
		 event.getMessage().reply("Who do you want to play?");
		 Message champ = event.getMessage();
		// eb.setTitle(champ, null);
			eb.setColor(Color.lightGray);
			eb.addBlankField(false);
			eb.setDescription("\n\n\nYou should play "+champ+"." +"Here is the link to " + champ + " in u.gg: "
					+ "https://u.gg/lol/champions/" + champ + "/build?role=top");
		 
			
		}
		if(args[0].equalsIgnoreCase("op.gg")) {
			if (args.length > 1) {
				String userName = args[1];
				if(args[2].equals("ingame")) {
					event.getChannel().sendMessage("https://na.op.gg/summoners/na/"+userName+"/ingame").queue();
				}else {
					userName = userName.concat(" "+args[2]);
					event.getChannel().sendMessage("https://na.op.gg/summoners/na/"+userName).queue();
					/*if (args[3].equals("ingame")) {
						event.getChannel().sendMessage("https://na.op.gg/summoners/na/"+userName+"/ingame").queue();
					} else if (!args[3].equals("ingame")){
						event.getChannel().sendMessage("https://na.op.gg/summoners/na/"+userName).queue();
					}*/
				}
			}
		}
		
		}
	}
