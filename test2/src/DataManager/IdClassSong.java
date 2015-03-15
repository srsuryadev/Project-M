package DataManager;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



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
        
    	String classid;
    	boolean keyexist=SongIdClass.containsKey(song);
        if(keyexist)
        {
        	 classid = (String)SongIdClass.get(song);
        }
        else{
            
            int num = (int) (Math.random()*1000);
            num = num%5;
            char id = (char) ('A'+num);
            classid = ""+id;
        }
        return classid;

    }
    
    
    
}
