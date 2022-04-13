package Main;

import java.awt.Color;
import java.util.List;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.JDAImpl;

public class Commands extends ListenerAdapter {
	public String prefix = ".";
	private int totalCope = 0;
	private int usage = 0;
	private boolean wait = false;
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String args = event.getMessage().getContentRaw();
		String[] args1 = event.getMessage().getContentRaw().split(" ");

		if (args.equalsIgnoreCase(prefix + "embed")) {
			EmbedBuilder embed = new EmbedBuilder();
			embed.setTitle("Embed Title", "");
			embed.setDescription("This is Embed Description");
			embed.addField("Embed field 1", "This is the content of field 1", false);
			embed.setColor(Color.GREEN);
			embed.setFooter("bot created by <@!162295333873778689>",
					event.getGuild().getOwner().getUser().getAvatarUrl());
			event.getChannel().sendMessage(embed.build()).queue();
			embed.clear();
		}
		if (args.equalsIgnoreCase(prefix + "status")) {
			// if you dont want it to reply do
			// event.getChannel().sendMessage("test").queue();
			event.getMessage().reply("This bot is working!").queue();
		}
		if (args.equalsIgnoreCase(prefix + "giverole")) {// give role
			if (event.getMessage().getMentionedRoles().toArray().length == 1) {// checking to see if the message has
																				// mentioned a role
				if (event.getMessage().getMentionedUsers().toArray().length == 1) {
					Member member = event.getGuild().getMember(event.getMessage().getMentionedUsers().get(0));
					Role roleToGive = event.getMessage().getMentionedRoles().get(0);
					event.getGuild().addRoleToMember(member, roleToGive).queue();// adds role
					event.getMessage()
							.reply("Gave the role " + roleToGive.getAsMention() + " to " + member.getAsMention())
							.queue();

				} else {
					event.getMessage().reply("Please mention only one role to give").queue();
				}
			} else {
				event.getMessage().reply("Please mention only one role to give").queue();
			}
		}
		if (args.equalsIgnoreCase(prefix + "removerole")) {// removed role
			if (event.getMessage().getMentionedRoles().toArray().length == 1) {// checking to see if the message has
																				// mentioned a role
				if (event.getMessage().getMentionedUsers().toArray().length == 1) {
					Member member = event.getGuild().getMember(event.getMessage().getMentionedUsers().get(0));
					Role roleToRemove = event.getMessage().getMentionedRoles().get(0);
					event.getGuild().removeRoleFromMember(member, roleToRemove).queue();// adds role
					event.getMessage()
							.reply("Removed the role " + roleToRemove.getAsMention() + " to " + member.getAsMention())
							.queue();
				} else {
					event.getMessage().reply("Please mention only one role to remove.").queue();
				}
			} else {
				event.getMessage().reply("Please mention only one role to remove.").queue();
			}
		}
		if (args.contains("cope")) {
			String adminId = "162295333873778689";
			String botId = "903516162988597260";
			// if you dont want it to reply do
			// event.getChannel().sendMessage("test").queue();
			// Member member =
			// event.getGuild().getMember(event.getMessage().getMentionedUsers().get(0));
			if (!event.getAuthor().getId().equals(adminId) && !event.getAuthor().getId().equals(botId)) {
				event.getMessage().reply("L+bozo+ratio").queue();
				event.getChannel()
						.sendMessage("https://tenor.com/view/talk-to-em-angry-mad-fish-spongebob-gif-17712353").queue();
			}
			this.totalCope += 1;
		}
		if (args.equalsIgnoreCase(prefix + "cope#")) {
			event.getMessage().reply("Total cope used in this server: " + this.totalCope).queue();
		}
		String codeword = "spam";
		codeword.concat(" mal");
		if ((args.contains(codeword) && event.getAuthor().getId().equals("162295333873778689"))) {
			// String result = event.getChannel().get
			int i = 0;
			/*
			 * while (i < 100 && !args.equals("stop")) {
			 * //event.getChannel().sendMessage("<@!321467507905134592>").queue();
			 * event.getChannel().sendMessage("<@!162295333873778689>").queue(); }
			 */
		}
		if (args1[0].equals("spam") /* && event.getAuthor().getId().equals("162295333873778689")*/){
			List<User> mentioned = event.getMessage().getMentionedUsers();
			if(usage < 1) {
				if (mentioned.size() == 1) {
					String mentioned_1 = mentioned.get(0).getId();
					int i = 0;
					while (i < 20) {
						// event.getChannel().sendMessage("<@!321467507905134592>").queue();
						event.getChannel().sendMessage("<@!" + mentioned_1 + ">").queue();
						i++;
					}
					event.getChannel().sendMessage("Spam has finished with a total for "+i+" messages.").queue();
					this.usage=1;
				}
				if (mentioned.size()>1) {
					event.getMessage().reply("Sorry please mention only 1 user at a time. Thank you.").queue();
					this.usage = 1;
				}
				wait(120000, TimeUnit.SECONDS);
			} else {
				event.getChannel().sendMessage("Please wait 2 minutes before using the command. If you spam the command it will reset the time to wait each time. Please only try once.").queue();
				wait(120000, TimeUnit.SECONDS);
			}
			
		}
		
	
		
	}
	private void wait(int timeoutMillis, TimeUnit seconds) {
		int time = 0;
		for (int i = 0; i<timeoutMillis;i++) {
			time += 1;
		}
		this.usage=0;
		this.wait= true;
	}
}
