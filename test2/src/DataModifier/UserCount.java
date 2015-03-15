package DataModifier;

import DataManager.*;

import java.util.*;

public class UserCount {
	
	 private static Hashtable userc=new Hashtable();
	 
	 public void put_keyval(String classid,int count){
		 
		 userc.put(classid,count);
	 }
	 
	 public int get_keyval(String classid) {
		 
		 if(userc.containsKey(classid)){
		 
		 return (int)userc.get(classid);
		 
		 }
		 
		 return 0;
	 }

}
