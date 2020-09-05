package fr.azenox.ClearMobs.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import fr.azenox.ClearMobs.ClearMobs;

public class Config {
	
	private static File configFile = new File(ClearMobs.getInstance().getDataFolder().getPath() + "/config.yml");
	private static FileConfiguration config;
	
	public static void init(){
		if(!ClearMobs.getInstance().getDataFolder().exists()){
			ClearMobs.getInstance().getDataFolder().mkdir();
		}
		
		if(!configFile.exists()){
			try {
				configFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		config = YamlConfiguration.loadConfiguration(configFile);
		defaultValues();
		saveFile();
	}
	
	public static void defaultValues(){
		if(!config.contains("PreventSpawn")){
			ArrayList<String> entity = new ArrayList<String>(){
				private static final long serialVersionUID = -8749897756730774330L;
				{
					add("zombie");
					add("sheep");
				}
			};
			config.set("PreventSpawn", entity);
		}
	}
	
	
	public static FileConfiguration getFile(){
		return config;
	}

	@SuppressWarnings("deprecation")
	public static void reloadFile(){
	    if (configFile == null) {
	    	configFile = new File(ClearMobs.getInstance().getDataFolder(), "config.yml");
	        }
	        config = YamlConfiguration.loadConfiguration(configFile);
	     
	        // Look for defaults in the jar
	        InputStream defConfigStream = ClearMobs.getInstance().getResource("config.yml");
	        if (defConfigStream != null) {
	            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	            config.setDefaults(defConfig);
	        }
	}
	
	public static void saveFile(){
		try {
			config.save(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
