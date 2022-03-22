package Main;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Guild.Ban;

public class Commands extends ListenerAdapter {
	public String prefix = "~";
	private int totalCope = 0;
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String args = event.getMessage().getContentRaw();
		
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
		if (args.equalsIgnoreCase("cope")) {
			String adminId = "162295333873778689";
			// if you dont want it to reply do
			// event.getChannel().sendMessage("test").queue();
			// Member member =
			// event.getGuild().getMember(event.getMessage().getMentionedUsers().get(0));
			if(!event.getAuthor().getId().equals(adminId)) {
			event.getMessage().reply("L+bozo+ratio").queue();
			event.getChannel().sendMessage("https://tenor.com/view/talk-to-em-angry-mad-fish-spongebob-gif-17712353")
					.queue();
			}
			this.totalCope += 1;
		}
		if (args.equalsIgnoreCase(prefix + "cope#")) {
			event.getMessage().reply("Total cope used in this server: "+this.totalCope).queue();
		}

	}

}
