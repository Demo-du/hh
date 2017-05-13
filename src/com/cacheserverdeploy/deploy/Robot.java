package com.cacheserverdeploy.deploy;

public class Robot {
	public static int num=1;//机器人数量
    public static void one_robot_go(){//最差的一种方法，只用一台
    	System.out.println(Global.Dist[Global.I][Global.park_paixu[0]]);
    	System.out.println(Global.lujing[Global.I][Global.park_paixu[0]]);
    //	Global.result[0]="1"
    	System.out.println(code.jiema_lujing(Global.lujing[Global.I][Global.park_paixu[0]]));
    	int time_w=Global.p*(Global.num_car-1);//等待罚时
    	Global.m=Global.info_car[0][4];//第一辆车质量
        int nenghao=Global.k*Global.m*(Global.Dist[Global.I][Global.park_paixu[0]]+Global.Dist[Global.park_paixu[0]][Global.E]);
        System.out.println(nenghao);
    	Global.solusion="1"+" "+String.valueOf(time_w)+" "+nenghao;
    /*	for(int i=0;i<Global.num_car;i++){
    		if(Global.time+Global.Dist[Global.I][Global.park_paixu[i]]>0){
    			
    		}
    	}*/
    }
}
