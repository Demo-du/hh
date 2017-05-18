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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Global {
      public static String ceshi ="";
      public static boolean map_flag;//地图有效标志
      public static int [] car_p;//车停靠到车位
      public static int Z;//费用
	  public static int k;//能耗系数k
	  public static int p;//罚时系数
	  public static int a;//泊车机器人系数
	  public static int b;//等待系数
	  public static int w;//地图宽
	  public static int h;//地图高
	  public static int num_car;//汽车数
	//  public static int m;//质量//不要用
	  public static int time_wait_max;//最大等待时间
	  public static int time_wait_sum=0;//最大等待时间
	  public static String[][] ditu;//地图
	  public static int [][] graph;//无向图.列：i×列数+j
	  public static int [][]info_car;//车辆信息//编号，申请进入，离开，最大等待，质量
	  public static int [][] Dist;//Floyd算法求得到最短路径长度
	  public static String [][]lujing;
	  public static int I;//起点
	  public static int I_num=0;
	  public static int E;//终点
	  public static int E_num=0;
	  public static HashSet<Integer> park=new HashSet<Integer>();//车位
	 // public static ArrayList<Integer> park_paixu=new ArrayList<Integer>();
	  public static int[] park_paixu;
	  public static int time=0;//时间
	  public static int [][] car_sesult;
	  public static String [] result;
	  public static int [] state_car;//0代表入库，1代表停车，2代表离开
	  public static int [] in_time;
	  public static int [] out_time;
	  public static String solusion="";
	  public static int[] wait_per;//每辆车等待时间
	  public static int[][] wait_per1;//每辆车等待时间
	  
}
