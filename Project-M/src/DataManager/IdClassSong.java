/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataManager;

import java.util.*;

/**
 *
 * @author suryadev
 */

public class IdClassSong {

    
    private static Hashtable SongIdClass=new Hashtable();
    
    public void putKeyValue(String song,String classid){
        SongIdClass.put(song, classid);
    }
    
    
    public String getKeyValue(String song){
        
        String classid = (String)SongIdClass.get(song);
        if(classid == null){
            
            int num = (int) (Math.random()*1000);
            num = num%5;
            char id = (char) ('A'+num);
            classid = ""+id;
        }
        return classid;

    }
    
    
    
}
