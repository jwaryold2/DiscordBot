package Main;

import java.util.Random;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class fortuneCommands extends ListenerAdapter {
	private String prefix = ".8ball";
	private char percent = '%';

	public void onMessageReceived(MessageReceivedEvent event) {
		String fullcommand = "";
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		for (int i = 0; i < args.length; i++) {
			fullcommand = fullcommand.concat(" " + args[i]);
		}
		String[] fortunes = { "It is certain\r\n", "Without a doubt\r\n", "You may rely on it\r\n",
				"Yes definitely\r\n", "It is decidedly so\r\n", "As I see it, yes\r\n", "Most likely\r\n", "Yes\r\n",
				"Outlook good\r\n", "Signs point to yes", "Reply hazy try again\r\n", "Better not tell you now\r\n",
				"Ask again later\r\n", "Cannot predict now\r\n", "Concentrate and ask again", "Don’t count on it\r\n",
				"Outlook not so good\r\n", "My sources say no\r\n", "Very doubtful\r\n", "My reply is no" };
		Random fortune = new Random();

		if (args[0].equals(prefix)) {
			int randomF = fortune.nextInt(fortunes.length);
			Runnable e = () -> event.getMessage().reply(fortunes[randomF].toString()).queue();
			if (args.length > 1) {
				Thread t = new Thread(e);
				t.setDaemon(true);
				t.start();
			} else {
				event.getChannel().sendMessage("Please ask the 8ball a question.").queue();
			}
		}
		if (args[0].charAt(0) == '%') {
			try {
			double percent;
			percent = Math.ceil(fortune.nextDouble() * 100.0);
			Runnable e = () -> event.getMessage().reply("It is about a "+ percent + "% chance.").queue();
			if (args.length > 1) {
				Thread t = new Thread(e);
				t.setDaemon(true);
				t.start();
			} else {
				event.getChannel().sendMessage("Please ask something for the percentage.").queue();
			}
			} catch (Exception e) {
				return;
			}
			
		}
		if (fullcommand.contains("forgor")) {
			event.getMessage().reply(":skull:").queue();
		}

	}
}
