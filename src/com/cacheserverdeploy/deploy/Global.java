package com.cacheserverdeploy.deploy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Global {
      public static String ceshi ="";
      public static boolean map_flag;//地图有效标志
	  public static int k;//能耗系数k
	  public static int p;//罚时系数
	  public static int a;//泊车机器人系数
	  public static int b;//等待系数
	  public static int w;//地图宽
	  public static int h;//地图高
	  public static int num_car;//汽车数
	  public static int m;//质量
	  public static int time_wait;//最大等待时间
	  public static String[][] ditu;//地图
	  public static int [][] graph;//无向图.列：i×列数+j
	  public static int [][]info_car;//车辆信息
	  public static int [][] Dist;//Floyd算法求得到最短路径长度
	  public static String [][]lujing;
	  public static int I;//起点
	  public static int E;//终点
	  public static HashSet<Integer> park=new HashSet<Integer>();
}
