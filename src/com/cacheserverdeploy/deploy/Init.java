package com.cacheserverdeploy.deploy;

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
    	int heigtht=Global.h;
    	for(int i=0;i<heigtht;i++){
    		Global.ditu[i]=graphContent[i+2].split(" ");
    	}
    	//第四部分初始化
    	Global.num_car=Integer.valueOf(graphContent[2+heigtht]);
    	//车相关信息初始化
    	Global.info_car=new int [Global.num_car][5];
    	String [][]info=new String [Global.num_car][5];
    	int numcar=Global.num_car;
    	for(int i=0;i<numcar;i++){
    		info[i]=graphContent[i+2+heigtht+1].split(" ");
    	}
    	for(int i=0;i<numcar;i++){
    		for(int j=0;j<5;j++){
    			Global.info_car[i][j]=Integer.valueOf(info[i][j]);
    		}
    	}
    }
    
    /*
     * 检查图是否有效
     */
    public static String map_check(){
    	
    	return "YES";
    }
}
