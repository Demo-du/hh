package com.cacheserverdeploy.deploy;


public class Deploy
{
    /**
     * 你需要完成的入口
     * <功能详细描述>
     * @param graphContent 用例信息文件
     * @return [参数说明] 输出结果信息
     * @see [类、类#方法、类#成员]
     */
    public static String[] deployServer(String[] graphContent)
    {
        /**do your work here**/
    	Init.data_init(graphContent);//初始化
    	String checkmap=Check.map_check();//判断地图是否有效
    	if(Global.map_flag){//有效
    		
    	}else{//无效
    		
    	}
    	//System.out.println(Global.graph[41][30]);
    //	System.out.println(Global.Dist[0][22]);
    	//System.out.println(Global.lujing[32][53]);
    	System.out.println(checkmap);
        return new String[]{"17","\r\n","0 8 0 20"};
    }
    
}
