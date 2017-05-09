package com.cacheserverdeploy.deploy;

import java.util.Arrays;
import java.util.Queue;

public class Init {
	/*
     * 数据初始化
     */
    public static void data_init(String[] graphContent){
    	String [] num1=new String [4];
    	String [] num2=new String [2];
    	//第一行初始化
    	num1=graphContent[0].split(" ");
    	Global.k=Integer.valueOf(num1[0]);
    	Global.p=Integer.valueOf(num1[1]);
    	Global.a=Integer.valueOf(num1[2]);
    	Global.b=Integer.valueOf(num1[3]);
    	//第二行初始化
    	num2=graphContent[1].split(" ");
    	Global.w=Integer.valueOf(num2[0]);
    	Global.h=Integer.valueOf(num2[1]);
    	//图初始化
    	Global.ditu=new String [Global.w][Global.h];
    	int width=Global.w;
    	int heigtht=Global.h;
    	for(int i=0;i<width;i++){
    		Global.ditu[i]=graphContent[i+2].split(" ");
    	}
    	//第四部分初始化
    	Global.num_car=Integer.valueOf(graphContent[2+width]);
    	//车相关信息初始化
    	Global.info_car=new int [Global.num_car][5];
    	String [][]info=new String [Global.num_car][5];
    	int numcar=Global.num_car;
    	for(int i=0;i<numcar;i++){
    		info[i]=graphContent[i+2+width+1].split(" ");
    	}
    	for(int i=0;i<numcar;i++){
    		for(int j=0;j<5;j++){
    			Global.info_car[i][j]=Integer.valueOf(info[i][j]);
    		}
    	}
    	//无向图初始化
    	Global.graph=new int [Global.w*Global.h][Global.w*Global.h];//定义无向图大小
    	int MAX=65535;//最大值
    	int lenth_graph=Global.w*Global.h;
    	for(int i=0;i<lenth_graph;i++){//赋初值
    		for(int j=0;j<lenth_graph;j++){
    			Global.graph[i][j]=MAX;
    		}
    	}
    	for(int i=0;i<width;i++){//横向扫描
    		for(int j=0;j<heigtht-1;j++){
    			if(Global.ditu[i][j].equals("P")){
    				Global.park.add(code.bianma(i, j));
    			}
    			if(Global.ditu[i][j].equals("X")&&Global.ditu[i][j+1].equals("X")){//连续两个X
    				Global.graph[i*heigtht+j][i*heigtht+j+1]=1;
    				Global.graph[i*heigtht+j+1][i*heigtht+j]=1;
    			}else if(Global.ditu[i][j].equals("X")&&Global.ditu[i][j+1].equals("P")){
    				Global.graph[i*heigtht+j][i*heigtht+j+1]=1;
    				Global.graph[i*heigtht+j+1][i*heigtht+j]=1;
    			}else if(Global.ditu[i][j].equals("P")&&Global.ditu[i][j+1].equals("X")){
    				Global.graph[i*heigtht+j][i*heigtht+j+1]=1;
    				Global.graph[i*heigtht+j+1][i*heigtht+j]=1;
    			}else if((Global.ditu[i][j].equals("I")||Global.ditu[i][j].equals("E"))){
    				if(j>0&&(!Global.ditu[i][j-1].equals("B"))){
    					Global.graph[i*heigtht+j][i*heigtht+j-1]=1;
    					Global.graph[i*heigtht+j-1][i*heigtht+j]=1;
    				}
    				if(!Global.ditu[i][j+1].equals("B")){
    					Global.graph[i*heigtht+j][i*heigtht+j+1]=1;
        				Global.graph[i*heigtht+j+1][i*heigtht+j]=1;
    				}
    				if(Global.ditu[i][j].equals("I")){
    					Global.I=code.bianma(i, j);
    				}
    				if(Global.ditu[i][j].equals("E")){
    					Global.E=code.bianma(i, j);
    				}
    			}
    		}
    	}
    	for(int i=0;i<width;i++){//横向扫描最后一列
    		if((Global.ditu[i][heigtht-1].equals("I")||Global.ditu[i][heigtht-1].equals("E"))){
    			if((!Global.ditu[i][heigtht-1-1].equals("B"))){
					Global.graph[i*heigtht+heigtht-1][i*heigtht+heigtht-1-1]=1;
					Global.graph[i*heigtht+heigtht-1-1][i*heigtht+heigtht-1]=1;
				}
    		}
    		if(Global.ditu[i][heigtht-1].equals("P")){
				Global.park.add(code.bianma(i, heigtht-1));
			}
    		if(Global.ditu[i][heigtht-1].equals("I")){
				Global.I=code.bianma(i, heigtht-1);
			}
			if(Global.ditu[i][heigtht-1].equals("E")){
				Global.E=code.bianma(i, heigtht-1);
			}
    	}
    	for(int j=0;j<heigtht;j++){//纵向扫描
    		for(int i=0;i<width-1;i++){
    			if(Global.ditu[i][j].equals("X")&&Global.ditu[i+1][j].equals("X")){//连续两个X
    				Global.graph[i*heigtht+j][i*heigtht+j+heigtht]=1;
    				Global.graph[i*heigtht+j+heigtht][i*heigtht+j]=1;
    			}else if(Global.ditu[i][j].equals("X")&&Global.ditu[i+1][j].equals("P")){
    				Global.graph[i*heigtht+j][i*heigtht+j+heigtht]=1;
    				Global.graph[i*heigtht+j+heigtht][i*heigtht+j]=1;
    			}else if(Global.ditu[i][j].equals("P")&&Global.ditu[i+1][j].equals("X")){
    				Global.graph[i*heigtht+j][i*heigtht+j+heigtht]=1;
    				Global.graph[i*heigtht+j+heigtht][i*heigtht+j]=1;
    			}else if((Global.ditu[i][j].equals("I")||Global.ditu[i][j].equals("E"))){
    				if(i>0&&(!Global.ditu[i-1][j].equals("B"))){
    					Global.graph[i*heigtht+j][i*heigtht+j-heigtht]=1;
    					Global.graph[i*heigtht+j-heigtht][i*heigtht+j]=1;
    				}
    				if(!Global.ditu[i+1][j].equals("B")){
    					Global.graph[i*heigtht+j][i*heigtht+j+heigtht]=1;
        				Global.graph[i*heigtht+j+heigtht][i*heigtht+j]=1;
    				}
    			}
    		}
    	}
    	for(int j=0;j<heigtht;j++){//纵向扫描最后一行
    		if((Global.ditu[width-1][j].equals("I")||Global.ditu[width-1][j].equals("E"))){
    			if((!Global.ditu[width-1-1][j].equals("B"))){
					Global.graph[(width-1-1)*heigtht+j][(width-1)*heigtht+j]=1;
					Global.graph[(width-1)*heigtht+j][(width-1-1)*heigtht+j]=1;
				}
    		}
    	}
    	//最短路径初始化
    	Global.Dist=new int [Global.w*Global.h][Global.w*Global.h];
    	Global.lujing=new String [Global.w*Global.h][Global.w*Global.h];
    	for(int i=0;i<Global.w*Global.h;i++){
    		for(int j=0;j<Global.w*Global.h;j++){
    			Global.lujing[i][j]="";
    		}
    	}
    	Global.Dist=Arrays.copyOf(Floyd.floyd(Global.graph, Global.w*Global.h),Global.w*Global.h);
    	
    }


    
}
