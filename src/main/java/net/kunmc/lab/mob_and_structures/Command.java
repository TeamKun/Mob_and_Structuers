package net.kunmc.lab.mob_and_structures;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class Command implements org.bukkit.command.CommandExecutor{

    public static boolean game = false;

    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (cmd.getName().equals("mob_and_structures")) {
            //ゲームの開始に関する処理
            if(args[0].equals("start")&&args.length==1){
                if(!game){
                    game = true;
                    sender.sendMessage(ChatColor.GREEN+"[Plugin]ゲームを開始しました");
                }else{
                    sender.sendMessage(ChatColor.RED+"[Plugin]ゲームはすでに開始しています");
                }
            }
            //ゲームのストップに関する処理
            else if(args[0].equals("stop")&&args.length==1){
                if(game){
                    game = false;
                    sender.sendMessage(ChatColor.GREEN+"[Plugin]ゲームを停止しました");
                }else{
                    sender.sendMessage(ChatColor.RED+"[Plugin]ゲームは終了しています");
                }
            }
            //確立に関する処理
            else if(args[0].equals("probability")&&args.length==2) {
                if(args.length==2){
                    if(args[1].equals("nowValue")){
                        Mob_and_Structures.INSTANCE.reloadConfig();
                        Mob_and_Structures.INSTANCE.getConfig();
                        sender.sendMessage(ChatColor.GREEN+"[Plugin]現在の生成確率は"+Mob_and_Structures.INSTANCE.getConfig().get("probability")+"%です");
                    }else if(args[1].matches("[+-]?\\d*(\\.\\d+)?")){
                        if(100>=Integer.parseInt(args[1])&&Integer.parseInt(args[1])>=0){
                            Mob_and_Structures.INSTANCE.reloadConfig();
                            Mob_and_Structures.INSTANCE.getConfig();
                            int num = Integer.parseInt(args[1]);
                            Mob_and_Structures.INSTANCE.getConfig().set("probability",num);
                            Mob_and_Structures.INSTANCE.saveConfig();
                            sender.sendMessage(ChatColor.GREEN+"[Plugin]生成確率を"+args[1]+"%に変更しました");
                        }else{
                            sender.sendMessage(ChatColor.RED+"[Plugin]コマンドの形式が異なります:");
                            sender.sendMessage(ChatColor.RED+"/mob_and_structures probability <確率:0~100の整数>");
                        }
                    }else{
                        sender.sendMessage(ChatColor.RED+"[Plugin]コマンドの形式が異なります:");
                        sender.sendMessage(ChatColor.RED+"/mob_and_structures probability <確率:0~100の整数>");
                        sender.sendMessage(ChatColor.RED+"/mob_and_structures probability nowValue");
                    }
                }
                else{
                    sender.sendMessage(ChatColor.RED+"[Plugin]コマンドの形式が異なります:");
                    sender.sendMessage(ChatColor.RED+"/mob_and_structures probability <確率:0~100の整数>");
                    sender.sendMessage(ChatColor.RED+"/mob_and_structures probability nowValue");
                }
            }
            else if(args[0].equals("help")&&args.length==1){
                sender.sendMessage(ChatColor.GREEN+"-----------------コマンド一覧-----------------");
                sender.sendMessage(ChatColor.GOLD+"・ゲームの開始");
                sender.sendMessage("/mob_and_structures start");
                sender.sendMessage(ChatColor.GOLD+"・ゲームの停止");
                sender.sendMessage("/mob_and_structures stop");
                sender.sendMessage(ChatColor.GOLD+"・コマンド一覧の表示");
                sender.sendMessage("/mob_and_structures help");
                sender.sendMessage(ChatColor.GOLD+"・構造物の生成確立の設定");
                sender.sendMessage("/mob_and_structures probability <確率:0~100の整数>");
                sender.sendMessage(ChatColor.GOLD+"・構造物の生成確率の表示");
                sender.sendMessage("/mob_and_structures probability nowValue");
                sender.sendMessage(ChatColor.GREEN+"-----------------コマンド一覧-----------------");
            }else{
                sender.sendMessage(ChatColor.RED+"[Plugin]コマンドの形式が異なります.コマンド一覧の確認:");
                sender.sendMessage(ChatColor.RED+"/mob_and_structures help");
            }
        }
        return true;
    }

}
