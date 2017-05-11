package com.cacheserverdeploy.deploy;

public class Robot {
	public static int num=1;//机器人数量
    public static void one_robot_go(){//最差的一种方法，只用一台
    	System.out.println(Global.Dist[Global.I][Global.park_paixu[0]]);
    	System.out.println(Global.lujing[Global.I][Global.park_paixu[0]]);
    //	Global.result[0]="1"
    	System.out.println(code.jiema_lujing(Global.lujing[Global.I][Global.park_paixu[0]]));
    	
    /*	for(int i=0;i<Global.num_car;i++){
    		if(Global.time+Global.Dist[Global.I][Global.park_paixu[i]]>0){
    			
    		}
    	}*/
    }
}
