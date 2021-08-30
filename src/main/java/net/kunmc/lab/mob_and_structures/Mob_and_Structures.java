package net.kunmc.lab.mob_and_structures;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Objects;

public final class Mob_and_Structures extends JavaPlugin {

    public static Mob_and_Structures INSTANCE;
    public File schematicDirectory;

    @Override
    public void onEnable() {

        // config.ymlが存在しない場合はファイルに出力します。
        saveDefaultConfig();

        Bukkit.getPluginManager().registerEvents(new EventHandler(),this);

        Objects.requireNonNull(this.getCommand("mob_and_structures")).setExecutor(new Command());
        Objects.requireNonNull(this.getCommand("mob_and_structures")).setTabCompleter(new TabComp());

        INSTANCE = this;

        //schem用ディレクトリの生成
        schematicDirectory = new File(getDataFolder(),"schematics");
        schematicDirectory.mkdirs();

        getServer().getLogger().info(ChatColor.AQUA+"Mob_and_Structures"+ChatColor.WHITE+" by "+ChatColor.GREEN+"Yanaaaaa"+ChatColor.WHITE+" and "+ChatColor.LIGHT_PURPLE+"Yanyaa");
    }

}
