/*
 * DO NOT DISTRIBUTE. ©2012 MG ENTERPRISES(MANUEL GAUTO)
 */
package org.mgenterprises.java.bukkit.gmcfps.Core;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.mgenterprises.java.bukkit.gmcfps.Core.Weapons.Weapon;

/**
 *
 * @author Manuel Gauto
 */
public class PlayerKill {
    private Weapon weaponUsed;
    private Player victim;
    private Player killer;
    private Location location;
    
    public PlayerKill(Weapon weapon, Player victim, Player killer, Location loc){
        this.weaponUsed = weapon;
        this.victim = victim;
        this.killer = killer;
        this.location = loc;
    }
    
    public Weapon getWeaponUsed(){
        return this.weaponUsed;
    }
    
    public Player getVictim(){
        return this.victim;
    }
    
    public Player getKiller(){
        return this.killer;
    }
    
    public Location getKillLocation(){
        return this.location;
    }
}
