/*
 * DO NOT DISTRIBUTE. ©2012 MG ENTERPRISES(MANUEL GAUTO)
 */
package org.mgenterprises.java.bukkit.gmcfps.Core;

import org.mgenterprises.java.bukkit.gmcfps.Core.Scores.ScoreManager;

/**
 *
 * @author Manuel Gauto
 */
public class FPSCore {
    private ScoreManager scoreManager = new ScoreManager();
    
    public ScoreManager getScoreManager(){
        return this.scoreManager;
    }
}
