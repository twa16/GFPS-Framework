/*
 * DO NOT DISTRIBUTE. ©2012 MG ENTERPRISES(MANUEL GAUTO)
 */
package org.mgenterprises.java.bukkit.gmcfps.Core.Scores;

import java.util.HashMap;
import org.mgenterprises.java.bukkit.gmcfps.Core.Weapons.Weapon;

/**
 *
 * @author Manuel Gauto
 */
public class PlayerStats {
    private int deaths = 0;
    private int kills = 0;
    private double killDeathRatio;
    private HashMap<Weapon, Integer> weaponKills = new HashMap<Weapon, Integer>();
   
    
}
