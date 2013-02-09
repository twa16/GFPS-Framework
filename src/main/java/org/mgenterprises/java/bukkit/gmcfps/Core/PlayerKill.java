/*
 * DO NOT DISTRIBUTE. ©2012 MG ENTERPRISES(MANUEL GAUTO)
 */
package org.mgenterprises.java.bukkit.gmcfps.Core;

import javax.tools.JavaFileManager.Location;
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
}
