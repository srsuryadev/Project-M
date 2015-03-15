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

public class UserSong {
    
    
     //private static Hashtable UserClassCount=new Hashtable();
	  
	  private static Hashtable UserClassCount = new Hashtable<String,int[]>();

     public int[] getClassCount(String user){
         
         return (int[]) UserClassCount.get(user);
     }
     
     public void putClassCount(String user,int[] classcount){
    	 
          UserClassCount.put(user,classcount);
         
     }
     
     
}
