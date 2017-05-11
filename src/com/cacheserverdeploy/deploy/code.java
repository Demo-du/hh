package com.cacheserverdeploy.deploy;
/*
 * 此类的函数用于地图与改进后的无向图进行编码解码
 */
public class code {
	/*
	 * 编码
	 */
	public static int bianma(int i,int j){
		return (i*Global.h+j);
	}
    /*
     * 解码
     */
    public static int jiema_w(int x){
    	  return (x/Global.h);
    }
    public static int jiema_h(int x){
    	 return (x%Global.h);
    }
    /*
     * 路径解码
     */
    public static String jiema_lujing(String bb){
    	String newlujing[];
    	newlujing=bb.split(" ");
    	int length=newlujing.length;
    	String route="";
    	int ax;
    	int ay;
    	ax=jiema_w(Integer.valueOf(newlujing[0]));
		ay=jiema_h(Integer.valueOf(newlujing[0]));
		route=route+"("+String.valueOf(ax)+","+String.valueOf(ay)+")";
    	for(int i=1;i<length;i++){
    		ax=jiema_w(Integer.valueOf(newlujing[i]));
    		ay=jiema_h(Integer.valueOf(newlujing[i]));
    		route=route+" "+"("+String.valueOf(ax)+","+String.valueOf(ay)+")";
    	}
    	return route;
    }
}
