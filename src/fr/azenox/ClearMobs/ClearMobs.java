package fr.azenox.ClearMobs;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.azenox.ClearMobs.commands.MainCommands;
import fr.azenox.ClearMobs.events.EntitySpawn;
import fr.azenox.ClearMobs.utils.Config;

public class ClearMobs extends JavaPlugin {
	
	
	public static final String prefix = "§8§l[§9§lClearMobs§8§l]";
	
	
	public static ClearMobs instance;
	public static ClearMobs getInstance(){
		return instance;
	}

	@Override
	public void onEnable(){
		Bukkit.getConsoleSender().sendMessage("§a" + this.getDescription().getName() + 
				" §b" + this.getDescription().getVersion() + "§a Enabled");
		
		instance = this;
		
		/*Command*/
		getCommand("clearmobs").setExecutor(new MainCommands());
		
		/*Files*/
		Config.init();
		
		
		/*Event*/
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new EntitySpawn(), getInstance());
		
	}
	
	@Override
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage("§a" + this.getDescription().getName() + "§c Disabled");
	}
	
}
