/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataManager;

import java.util.Hashtable;

/**
 *
 * @author suryadev
 */

public class UserSong {
    
    
     private static Hashtable SongIdClass=new Hashtable();

     public int[] getClassCount(String user){
         
         return (int[]) SongIdClass.get(user);
     }
     
     public void putClassCount(String user,int[] classcount){
         
         SongIdClass.put(user, classcount);
         
     }
     
     
}
