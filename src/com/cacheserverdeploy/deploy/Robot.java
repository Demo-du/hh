package com.cacheserverdeploy.deploy;

public class Robot {
	public static int num=1;//机器人数量
    public static void one_robot_go(){//最差的一种方法，只用一台
    //	System.out.println(Global.Dist[Global.I][Global.park_paixu[0]]);
    	//System.out.println(Global.lujing[Global.I][Global.park_paixu[0]]);
    	//System.out.println(code.jiema_lujing(Global.lujing[Global.I][Global.park_paixu[0]]));
    //	int time_w=Global.p*(Global.num_car-1);//等待罚时
    //	Global.m=Global.info_car[0][4];//第一辆车质量
      //  int nenghao=Global.k*Global.m*(Global.Dist[Global.I][Global.park_paixu[0]]+Global.Dist[Global.park_paixu[0]][Global.E]);
     //   System.out.println(nenghao);
    	//Global.solusion="1"+" "+String.valueOf(time_w)+" "+nenghao;
    /*	for(int i=0;i<Global.num_car;i++){
    		if(Global.time+Global.Dist[Global.I][Global.park_paixu[i]]>0){
    			
    		}
    	}*/
    	int itor=0;
    	int it2=0;
    	int num_q=0;//放弃到数量
    	Global.time=0;
    	int num=Global.num_car;
    	int n=num;
    	for(int i=0;i<num;i++){
    		Global.state_car[i]=0;
    	}
    	while(n>0){//入库
    		n--;
    		if(Global.time>Global.info_car[itor][1]+Global.info_car[itor][3]||it2>Global.park_paixu.length-1){//放弃
    			Global.state_car[itor]=4;
    			num_q++;
    		}else{
    			Global.in_time[itor]=Global.time;
    			if(Global.time<Global.info_car[itor][1])//入口等待
    				Global.time=Global.info_car[itor][1];
    			Global.time_wait_sum+=Global.time-Global.info_car[itor][1];
    			Global.time+=Global.Dist[Global.I][Global.park_paixu[it2]]*2;//更新时间
    			it2++;
        		Global.state_car[itor]=1;//已经入库
    		}  		
    		System.out.println("第"+itor+"辆车回来时间"+Global.time);
    		System.out.println("状态"+Global.state_car[itor]);
    		System.out.println("in"+Global.in_time[itor]);
    		System.out.println("等待时间"+Global.time_wait_sum);
    		itor++;//更新迭代
    	}
    	System.out.println("stop");
    	int weizhi=Global.I;//初始化位置为入口
    	int huancun=0;
    	for(int i=0;i<num;i++){//遍历所有车
    		if(Global.state_car[i]==1){
    		    Global.time+=Global.Dist[weizhi][Global.park_paixu[huancun]];
    		    Global.out_time[i]=Global.time;
    		    Global.time+=Global.Dist[Global.E][Global.park_paixu[huancun]];
    		    //  System.out.println("ceshi");
    		    Global.result[i]=String.valueOf(i+1)+" "+"no"+" "+"0"+" "+String.valueOf(Global.in_time[i])+" "+code.jiema_lujing(Global.lujing[Global.I][Global.park_paixu[huancun]])
    		    +" "+"0"+" "+String.valueOf(Global.out_time[i])+" "+code.jiema_lujing(Global.lujing[Global.park_paixu[huancun]][Global.E]);
    		 // System.out.println(Global.result[i]);
    		huancun++;
    		}else{
    			Global.result[i]=String.valueOf(i+1)+" "+"yes";
    		}
    	}
    	for(int i=0;i<num;i++){
    		System.out.println(Global.result[i]);
    	}
    	System.out.println(Global.time);
    }
}
