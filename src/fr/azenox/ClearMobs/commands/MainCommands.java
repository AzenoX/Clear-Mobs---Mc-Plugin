package fr.azenox.ClearMobs.commands;

import java.util.ArrayList;
import java.util.Collections;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import fr.azenox.ClearMobs.ClearMobs;

public class MainCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(sender instanceof Player){
			
			Player p = (Player)sender;
			
			if(p.hasPermission("clearmobs.use")){
				
				if(args.length >= 1){
					
					if(!args[0].equalsIgnoreCase("?")){
						
						String target = args[0];
						
						for(Entity entity : p.getLocation().getWorld().getEntities()){
							
							String entity_name = entity.getType().name();
							
							if(entity_name.equalsIgnoreCase(target)){
								if(!target.equalsIgnoreCase("player")){
									entity.remove();
								}
								else{
									p.sendMessage(ClearMobs.prefix + " §alul, never...");
									return true;
								}
							}
							
						}
						
						p.sendMessage(ClearMobs.prefix + " §aEntities §b" + target.toUpperCase() + " §acleared !");
						
					}
					else{
						if(args.length == 1){
							p.sendMessage("");
							p.sendMessage("§8§l<========== §9§lClearMobs §8§l==========>");
							p.sendMessage("");
							p.sendMessage("§a§l➤ EntityTypes");
							ArrayList<String> names = new ArrayList<String>();
							for(EntityType ent : EntityType.values()){
								if(!ent.equals(EntityType.PLAYER)){
									names.add(ent.name().toUpperCase());
								}
							}
							Collections.sort(names);
							for(String entity : names){
								p.sendMessage("§a§l➥ §b§l" + entity);
							}
							p.sendMessage("");
							p.sendMessage("§8§l<========== §9§lClearMobs §8§l==========>");
						}
						else{
							String page = args[1];
							
							if(page.equalsIgnoreCase("1")){
								p.sendMessage("§8§l<========== §9§lClearMobs §8§l==========>");
								p.sendMessage("");
								p.sendMessage("§a§l➤ EntityTypes :");
								ArrayList<String> names = new ArrayList<String>();
								for(EntityType ent : EntityType.values()){
									if(!ent.equals(EntityType.PLAYER)){
										names.add(ent.name().toUpperCase());
									}
								}
								Collections.sort(names);
								for(String entity : names){
									p.sendMessage("§a§l➥ §b§l" + entity);
								}
								p.sendMessage("");
								p.sendMessage("§8§l<========== §9§lClearMobs §8§l==========>");
							}
							else if(page.equalsIgnoreCase("2")){
								p.sendMessage("");
								p.sendMessage("§8§l<========== §9§lClearMobs §8§l==========>");
								p.sendMessage("");
								p.sendMessage("§a§l➤ Commands :");
								p.sendMessage("§a§l➥ §b§l" + "/clearmobs <entity>");
								p.sendMessage("");
								p.sendMessage("§8§l<========== §9§lClearMobs §8§l==========>");
							}
							else if(page.equalsIgnoreCase("3")){
								p.sendMessage("");
								p.sendMessage("§8§l<========== §9§lClearMobs §8§l==========>");
								p.sendMessage("");
								p.sendMessage("§a§l➤ Configuration :");
								p.sendMessage("§a§l➥ §b§l" + "Prevent Mobs Spawn in config file by put entity type on a new line");
								p.sendMessage("");
								p.sendMessage("§8§l<========== §9§lClearMobs §8§l==========>");
							}
						}
					}
					
				}
				else{
					p.sendMessage(ClearMobs.prefix + " §cUse §b/clearmobs <entity>");
				}
				
			}
			
		}
		
		return true;
	}

}
