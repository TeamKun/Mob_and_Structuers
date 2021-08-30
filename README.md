# Mob_and_Structuers
このプラグインはMobを倒すと構造物が生成されるPluginです。  
生成確率はconfig.yml,コマンドから変更することが可能です。  
動作環境 : PaperMC1.16.5 , Minecraft1.16.5  
前提プラグイン : WorldEdit (worldedit-bukkit-7.2.5-dist.jar)  
遊ぶ際は、schematics.zipを解凍して、サーバー内のplugins-Mob_and_Structuersに生成されたschematicsディレクトリに中身を入れてください。  
  
## コマンド一覧  
・ゲームの開始  
 　 /mob_and_structures start  
  
・ゲームの停止  
 　 /mob_and_structures stop  
  
・コマンド一覧の表示  
  　/mob_and_structures help  
  
・構造物の生成確立の設定  
  　/mob_and_structures probability <確率:0~100の整数>  　
   ＊生成確率は生成毎に取得しているためリロードの必要はありません
  
・構造物の生成確率の表示  
 　 /mob_and_structures probability nowValue  
