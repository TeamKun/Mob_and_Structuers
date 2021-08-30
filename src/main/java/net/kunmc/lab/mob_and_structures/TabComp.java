package net.kunmc.lab.mob_and_structures;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TabComp implements TabCompleter {
    /**
     * Tab補完の生成
     */
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args){
        if(cmd.getName().equals("mob_and_structures")){
            if(args.length==1){
                return (sender.hasPermission("mob_and_structures")
                        ? Stream.of("probability","start","stop","help")
                        : Stream.of("probability","start","stop","help"))
                        .filter(e -> e.startsWith(args[0])).collect(Collectors.toList());
            }
            if(args.length==2&&args[0].equals("probability")){
                return (sender.hasPermission("mob_and_structures")
                        ? Stream.of("<確率:0~100の整数>","nowValue")
                        : Stream.of("<確率:0~100の整数>","nowValue"))
                        .filter(e -> e.startsWith(args[1])).collect(Collectors.toList());

            }
        }
        return new ArrayList<>();
    }
}
