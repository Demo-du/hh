package com.cacheserverdeploy.deploy;
//Floyd最短路径算法
public class Floyd {
	public static int[][] floyd(int[][] G,int n){  
        int[][] Dis= new int[n][n];  
        for(int q=0;q<n;q++){  
            for(int w=0;w<n;w++){  
                Dis[q][w]=G[q][w];  
              //  Global.lujing[q][w]=Global.lujing[q][w]+String.valueOf(q)+" "+String.valueOf(w);
                Global.lujing[q][w]=String.valueOf(w);
            }  
        }  
              
        for(int k = 0; k < n; k++){  
            for(int i=0; i < n; i++ ){  
                for(int j=0; j < n; j++){  
                    if(Dis[i][j]>Dis[i][k]+Dis[k][j]){  
                        Dis[i][j]=Dis[i][k]+Dis[k][j];  
                        Global.lujing[i][j]=Global.lujing[i][k]+" "+Global.lujing[k][j];
                    }  
                }  
            }  
        }  
        for(int k=0;k<n;k++){
        	for(int i=0;i<n;i++){
        		//if(k!=Global.I)
        		Global.lujing[k][i]=String.valueOf(k)+" "+Global.lujing[k][i];
        	}
        }
        return Dis;  
    }  
}
