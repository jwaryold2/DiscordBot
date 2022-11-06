package Main;

import java.awt.Color;
import java.util.Random;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.Button;


public class ButtonListeners extends ListenerAdapter {
	String mid[] = { "annie", "diana", "zed", "viktor", "vex", "kassadin", "akshan", "qiyana", "anivia", "vladimir",
			"talon", "katarina", "fizz", "lux", "xerath", "cassiopeia", "ahri", "malzahar", "pyke", "tryndamere",
			"kayle", "velkoz", "zilean", "zoe", "ekko", "lissandra", "rumble", "graves", "renekton", "chogath", "ziggs",
			"malphite", "galio", "brand", "twitch", "twisted fate", "neeko", "gangplank", "veigar", "azir", "jayce",
			"lucian", "sylas", "orianna", "ryze", "syndra", "corki", "irelia", "akali", "leblanc", "yasuo", "yone",
			"mordekaiser" };
	Random rand = new Random();
	int upperboundMid = mid.length;
	int randomIntMid = rand.nextInt(upperboundMid);
	EmbedBuilder eb = new EmbedBuilder();
	Button reroll = Button.danger("reroller", "rerolls");
	
	public void mid(MessageChannel channel,int randomMid) {
		//int randomMid = randomIntMid;
		eb.setTitle(mid[randomMid], null);
		eb.setColor(Color.lightGray);
		eb.addBlankField(false);

		eb.setDescription("\n\n\nYou should play " + mid[randomMid] + " in the midlane." + "Here is the link to "
				+ mid[randomMid] + " in u.gg: " + "https://u.gg/lol/champions/" + mid[randomMid] + "/build?role=mid");
		eb.setImage("https://static.u.gg/assets/lol/riot_static/12.5.1/img/champion/" + mid[randomMid] + ".png");
		mid[randomMid] = mid[randomMid].substring(0, 1).toUpperCase() + mid[randomMid].substring(1).toLowerCase();
		channel.sendMessage(eb.build()).setActionRows(ActionRow.of(reroll)).queue();
	}
	@Override
	public void onButtonClick(ButtonClickEvent event) {
		if (event.getButton().getId().equals("reroller")) {
			int randomMid =rand.nextInt(upperboundMid);
			mid(event.getChannel(), randomMid);
			event.deferReply();
		}
		super.onButtonClick(event);
	}

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
		if (args[0].equals("..button")) {
			int randomMid = randomIntMid;
			mid(event.getChannel(), randomMid);
		}
	}
}
