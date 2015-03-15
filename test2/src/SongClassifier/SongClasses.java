package SongClassifier;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author suryadev
 */

import java.util.*;

public class SongClasses {

    
    public SongClass A,B,C,D,E;
    public Random r=new Random();
    double min=0.1,max=1.0;
    
    SongClasses(){
        
        A = new SongClass();
        B = new SongClass();
        C = new SongClass();
        D = new SongClass();
        E = new SongClass();
        
        A.artistFamilarity=min+(max-min)*r.nextDouble();
        A.danceAbility=min+(max-min)*r.nextDouble();
        A.energy=min+(max-min)*r.nextDouble();
        A.liveness=min+(max-min)*r.nextDouble();
        A.loudness=min+(max-min)*r.nextDouble();
        A.mode=0;
        
        B.artistFamilarity=min+(max-min)*r.nextDouble();
        B.danceAbility=min+(max-min)*r.nextDouble();
        B.energy=min+(max-min)*r.nextDouble();
        B.liveness=min+(max-min)*r.nextDouble();
        B.loudness=min+(max-min)*r.nextDouble();
        B.mode=1;
        
        
        C.artistFamilarity=min+(max-min)*r.nextDouble();
        C.danceAbility=min+(max-min)*r.nextDouble();
        C.energy=min+(max-min)*r.nextDouble();
        C.liveness=min+(max-min)*r.nextDouble();
        C.loudness=min+(max-min)*r.nextDouble();
        C.mode=1;
        
        
        D.artistFamilarity=min+(max-min)*r.nextDouble();
        D.danceAbility=min+(max-min)*r.nextDouble();
        D.energy=min+(max-min)*r.nextDouble();
        D.liveness=min+(max-min)*r.nextDouble();
        D.loudness=min+(max-min)*r.nextDouble();
        D.mode=0;
        
        E.artistFamilarity=min+(max-min)*r.nextDouble();
        E.danceAbility=min+(max-min)*r.nextDouble();
        E.energy=min+(max-min)*r.nextDouble();
        E.liveness=min+(max-min)*r.nextDouble();
        E.loudness=min+(max-min)*r.nextDouble();
        E.mode=1;
        
    }
    
}
