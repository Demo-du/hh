package com.cacheserverdeploy.deploy;
//┏┛┻━━━━━┛ ┻┓
//┃　　　　　　    ┃
//┃　　　━　　　   ┃
//┃　┳┛　  ┗┳　 ┃
//┃　　　　　　    ┃
//┃　　　┻　　　   ┃
//┃　　　　　　    ┃
//┗━┓　　　 ┏━━━┛
//  ┃　　　 ┃   神兽保佑
//  ┃　　　 ┃   代码无BUG！
//  ┃　　 　┗━━━━━━━━━┓
//  ┃　　　　　　　        ┣┓
//  ┃　　　　           ┏┛
//  ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
//    ┃ ┫ ┫   ┃ ┫ ┫
//    ┗━┻━┛   ┗━┻━┛

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
    			t190出发
    		}
    	}*/
    	int [] licheng=new int [Global.num_car];//每辆车的距离
    	int [] licheng2=new int [Global.num_car];//每辆车的距离
    	int itor=0;
    	int it2=0;
    	int num_q=0;//放弃到数量
    	Global.time=0;
    	int num=Global.num_car;
    	int n=num;
    	boolean []flag_1=new boolean[num];
    	for(int i=0;i<num;i++){
    		flag_1[i]=false;
    	}
    	for(int i=0;i<num;i++){
    		Global.state_car[i]=0;
    	}
    	//xiahcednale
    	int in_zuihou=0;
    	while(n>0){//入库
    		n--;
    		System.out.println("rukushijian"+Global.time);
    		if((Global.time>=Global.info_car[itor][1]+Global.info_car[itor][3])||it2>Global.park_paixu.length-1){//放弃
    			Global.state_car[itor]=4;
    			
    			num_q++;
    		}else{//正常入库
    			
    			if(Global.time<=Global.info_car[itor][1]){//入口等待
    				Global.time=Global.info_car[itor][1];
    				if(Global.time<Global.info_car[itor][1]){
    			//	   Global.wait_per[itor]=Global.wait_per[itor]-Global.b;
    				}
    			}
    			Global.in_time[itor]=Global.time;
    			Global.wait_per[itor]+=(Global.in_time[itor]-Global.info_car[itor][1])*Global.b;
    			Global.wait_per1[itor][0]+=(Global.in_time[itor]-Global.info_car[itor][1])*Global.b;
    			if(Global.wait_per[itor]!=0){
    				flag_1[itor]=true;
    			}
    			Global.time_wait_sum+=(Global.in_time[itor]-Global.info_car[itor][1])*Global.b;
    			Global.time+=Global.Dist[Global.I][Global.park_paixu[it2]]*2;//更新时间
    			if(n==0){//最后一辆车
    				System.out.println("最后一辆");
    				licheng[itor]+=Global.Dist[Global.I][Global.park_paixu[it2]];//停下后移动到第一个要移动到车位
    				in_zuihou=Global.park_paixu[it2];
    			}else{
    				licheng[itor]+=Global.Dist[Global.I][Global.park_paixu[it2]];//更新每辆车里程
    			}
    			
    			it2++;
        		Global.state_car[itor]=1;//已经入库
    		}  		
    		System.out.println("第"+itor+"辆车回来时间"+Global.time);
    		System.out.println("状态"+Global.state_car[itor]);
    		System.out.println("in"+Global.in_time[itor]);
    		System.out.println("等待时间"+Global.time_wait_sum);
    		itor++;//更新迭代
    	}
    	
    	System.out.println("stop"+Global.time);
    	int weizhi=in_zuihou;//初始化位置为入口
    	int huancun=0;
    	//重写,第一辆车绝对会停
    	if(Global.state_car[0]==1){
    		//离开到第一辆车不是从起点出发//前面可能也要改2017.5.17
    	//	licheng[0]=licheng[0]-Global.Dist[Global.I][Global.park_paixu[huancun]]+Global.Dist[Global.park_paixu[huancun+1]][Global.park_paixu[huancun]]+Global.Dist[Global.E][Global.park_paixu[huancun]];
    		licheng[0]+=Global.Dist[Global.E][Global.park_paixu[huancun]];
    		if(Global.time+Global.Dist[Global.E][Global.park_paixu[huancun]]+Global.Dist[Global.I][Global.park_paixu[huancun]]-Global.info_car[0][2]>=0){//判断是否到离开时间
    			Global.time=Global.time+Global.Dist[Global.E][Global.park_paixu[huancun]]+Global.Dist[Global.I][Global.park_paixu[huancun]];
    			Global.out_time[0]=Global.time-Global.Dist[Global.E][Global.park_paixu[huancun]];
    			Global.wait_per[0]+=(Global.time-Global.info_car[0][2])*Global.b;
    			Global.wait_per1[0][1]+=(Global.time-Global.info_car[0][2])*Global.b;
    			if(Global.wait_per1[0][1]==0&&flag_1[0]){
    				Global.wait_per[0]=Global.wait_per[0]-Global.b;
    			}
    			Global.time_wait_sum+=(Global.out_time[0]+Global.Dist[Global.E][Global.park_paixu[huancun]]-Global.info_car[0][2])*Global.b;
    			System.out.println("dengdai"+Global.time_wait_sum);
    		}else{
    			//Global.wait_per[0]=Global.wait_per[0]+Global.b;
    			if(flag_1[0]){
    				//System.out.println("标志是"+i);
    				Global.wait_per[0]=Global.wait_per[0]-Global.b;
    			}
    			Global.time=Global.info_car[0][2];//离开时间
    			Global.out_time[0]=Global.time-Global.Dist[Global.E][Global.park_paixu[huancun]];
    			
    		}
    		licheng2[0]+=Global.Dist[Global.I][Global.park_paixu[huancun]]+Global.Dist[Global.park_paixu[huancun]][Global.E];
    		Global.result[0]=String.valueOf(0+1)+" "+"no"+" "+"0"+" "+String.valueOf(Global.in_time[0])+" "+code.jiema_lujing(Global.lujing[Global.I][Global.park_paixu[huancun]])
 		    +" "+"0"+" "+String.valueOf(Global.out_time[0])+" "+code.jiema_lujing(Global.lujing[Global.park_paixu[huancun]][Global.E]);		
		    huancun++;
    	}
    	for(int i=1;i<num;i++){//遍历所有车
    		if(Global.state_car[i]==1){
    			
    			licheng[i]+=Global.Dist[Global.E][Global.park_paixu[huancun]];
        		if(Global.time+Global.Dist[Global.E][Global.park_paixu[huancun]]+Global.Dist[Global.E][Global.park_paixu[huancun]]-Global.info_car[i][2]>=0){//判断是否到离开时间
        			Global.time=Global.time+Global.Dist[Global.E][Global.park_paixu[huancun]]+Global.Dist[Global.E][Global.park_paixu[huancun]];
        			Global.out_time[i]=Global.time-Global.Dist[Global.E][Global.park_paixu[huancun]];
        			System.out.println(i+"等待啊"+Global.time_wait_sum);
        			Global.wait_per[i]+=(Global.time-Global.info_car[i][2])*Global.b;
        			Global.wait_per1[i][1]+=(Global.time-Global.info_car[i][2])*Global.b;
        			if(Global.wait_per1[i][1]==0&&flag_1[i]){
        				System.out.println("标志是"+i);
        				Global.wait_per[i]=Global.wait_per[i]-Global.b;
        			}
        			Global.time_wait_sum+=(Global.out_time[i]+Global.Dist[Global.E][Global.park_paixu[huancun]])*Global.b;
        			System.out.println((Global.time-Global.info_car[i][2]));
        			System.out.println("第二次"+Global.time_wait_sum);
        		}else{
        			//Global.wait_per[i]=Global.wait_per[i]+Global.b;
        			if(flag_1[i]){
        				//System.out.println("标志是"+i);
        				Global.wait_per[i]=Global.wait_per[i]-Global.b;
        			}
        			Global.time=Global.info_car[i][2];//离开时间
        			Global.out_time[i]=Global.time-Global.Dist[Global.E][Global.park_paixu[huancun]];
        			
        		}
        		licheng2[i]+=Global.Dist[Global.I][Global.park_paixu[huancun]]+Global.Dist[Global.park_paixu[huancun]][Global.E];
        		Global.result[i]=String.valueOf(i+1)+" "+"no"+" "+"0"+" "+String.valueOf(Global.in_time[i])+" "+code.jiema_lujing(Global.lujing[Global.I][Global.park_paixu[huancun]])
     		    +" "+"0"+" "+String.valueOf(Global.out_time[i])+" "+code.jiema_lujing(Global.lujing[Global.park_paixu[huancun]][Global.E]);
        		huancun++;
        	}else{
        		Global.result[i]=String.valueOf(i+1)+" "+"yes";
        	}
    	}
    	/*for(int i=0;i<num;i++){//遍历所有车
    		//System.out.println(i+"时间"+Global.time);
    		if(Global.state_car[i]==1){
    		    Global.time+=Global.Dist[weizhi][Global.park_paixu[huancun]];
    		    licheng[i]+=Global.Dist[weizhi][Global.park_paixu[huancun]];//更新每辆车里程
    		    weizhi=Global.E;
    		//    System.out.println("时间"+Global.Dist[weizhi][Global.park_paixu[huancun]]);
    		    Global.out_time[i]=Global.time;
    		    if(Global.out_time[i]+Global.Dist[Global.E][Global.park_paixu[huancun]]-Global.info_car[i][2]>0){//判断是否到离开时间//需要改
    		       Global.time_wait_sum+=(Global.out_time[i]+Global.Dist[Global.E][Global.park_paixu[huancun]]-Global.info_car[i][2])*Global.b;//更新等待时间//516改一下，可能还没到申请出库时间
    		       System.out.println(i+"jing时间"+Global.time_wait_sum);
    		    }else{
    		    	Global.time=Global.info_car[i][2];
    		    }
    		    Global.time+=Global.Dist[Global.E][Global.park_paixu[huancun]];
    		    licheng[i]+=Global.Dist[Global.E][Global.park_paixu[huancun]];//更新每辆车里程
    		  //  System.out.println(Global.Dist[Global.E][Global.park_paixu[huancun]]);
    		    //  System.out.println("ceshi");
    		    Global.result[i]=String.valueOf(i+1)+" "+"no"+" "+"0"+" "+String.valueOf(Global.in_time[i])+" "+code.jiema_lujing(Global.lujing[Global.I][Global.park_paixu[huancun]])
    		    +" "+"0"+" "+String.valueOf(Global.out_time[i])+" "+code.jiema_lujing(Global.lujing[Global.park_paixu[huancun]][Global.E]);
    		 // System.out.println(Global.result[i]);
    		huancun++;
    		
    		}else{
    			Global.result[i]=String.valueOf(i+1)+" "+"yes";
    		}
    	}*/
    	int nenghao=0;
    	//int nenghao=Global.k*Global.m*Global.time;//能耗
    	Global.time_wait_sum=0;
    	for(int i=0;i<Global.num_car;i++){
    		Global.time_wait_sum+=Global.wait_per[i];
    	}
    	Global.time_wait_sum+=num_q*Global.p;//加上罚时
    	
    	int jj=0;
    	System.out.println("ll"+Global.info_car[0][4]);
    	for(int i=0;i<num;i++){//计算能耗
    		if(Global.state_car[i]!=4){
    			nenghao=nenghao+Global.k*licheng[i]*Global.info_car[i][4];
    			System.out.println("nenghap"+nenghao);
    		}
    	}
    	Global.solusion="1"+" "+String.valueOf(Global.time_wait_sum)+" "+String.valueOf(nenghao);
    	//Global.solusion="1"+" "+"425"+" "+"526";//100 165
    	for(int i=0;i<num;i++){
    		Global.solusion=Global.solusion+"\n"+Global.result[i];
    	}
    	System.out.println("时间"+Global.time);
    	System.out.println(Global.solusion);
    	for(int i=0;i<Global.num_car;i++){
    		System.out.println("第"+i+"等待时间为"+Global.wait_per[i]);
    		System.out.println("第"+i+"等待时间为"+Global.wait_per1[i][0]);
    	}
    	System.out.println("标志"+flag_1[2]);
    }
}
