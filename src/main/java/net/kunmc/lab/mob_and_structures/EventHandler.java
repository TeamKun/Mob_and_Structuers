package net.kunmc.lab.mob_and_structures;

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.io.IOException;
import java.util.Random;

public class EventHandler implements Listener {
    @org.bukkit.event.EventHandler
    public void CreateStructures(EntityDamageByEntityEvent event){
        //攻撃を受ける側がLivingEntityかどうか
        if (!(event.getEntity() instanceof LivingEntity)){
            return;
            }
        //攻撃を受ける側がPlayerかどうか
        if (event.getEntity() instanceof Player){
            return;
            }
        //攻撃する側がPlayerかどうか
        if(!(event.getDamager() instanceof Player)){
            return;
            }

        LivingEntity mob = (LivingEntity) event.getEntity();

        if(!(mob.getHealth() - event.getDamage()>0)){
            Random random = new Random();
            int randomValue = random.nextInt(22);
            Integer num = Integer.valueOf(randomValue);
            String str = num.toString();
            Mob_and_Structures.INSTANCE.reloadConfig();
            Mob_and_Structures.INSTANCE.getConfig();

            if(Mob_and_Structures.INSTANCE.getConfig().getInt("probability") > random.nextInt(101)-1) {
                Location loc = event.getEntity().getLocation();
                loc.setY(loc.getY()-8);
                try {
                    WEUtil.createPlaceOperation(loc, "Mob_and_Structures_" + str);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }
    }

}
