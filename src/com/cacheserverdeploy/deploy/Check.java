package com.cacheserverdeploy.deploy;

public class Check {
    /*
     * 检查图是否有效
     */
    public static String map_check(){
    	if(is_arrive()&&is_2()){
    		Global.map_flag=true;
    		return "YES";
    	}
    	else{
    		Global.map_flag=false;
    		return "NO";
    	}	
    }
    public static boolean is_arrive(){
    	boolean flag=true;
    	for(int a:Global.park){
    		if(Global.Dist[Global.I][a]>5000||Global.Dist[Global.E][a]>5000){//原点和终点不可到达停车出
    			flag=false;
    			break;
    		}
    	}
    	return flag;
    }
    public static boolean is_2(){
    	if(Global.I_num==1&&Global.E_num==1){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    public static boolean is_3(){
    	return true;
    }
}
