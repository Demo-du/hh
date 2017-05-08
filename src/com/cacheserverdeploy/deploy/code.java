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
}
