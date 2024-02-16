package com.epam;

public class WaterArea {

    public static int waterArea(int[] heights) {
        int n = heights.length;
        if(n==0){
            return 0;
        }
        int maxHeightIndex = n-1;
        int fgr[] = new int[n];
        fgr[n-1] = -1;
        for(int i =n-2; i>=0; i--) {
            if(heights[i] < heights[maxHeightIndex])
                fgr[i] = maxHeightIndex;
            else {
                fgr[i] = -1;
                maxHeightIndex = i;
            }
        }
        maxHeightIndex = 0;
        int fgl[] = new int[n];
        fgl[0] = -1;
        for(int i = 1; i < n; i++) {
            if(heights[i] < fgl[maxHeightIndex])
                fgl[i] = maxHeightIndex;
            else {
                fgl[i] = -1;
                maxHeightIndex = i;
            }
        }
        for(int i = 0;i< n;i++)
            System.out.println(fgr[i]);

        for(int i = 0;i< n;i++)
            System.out.println(fgl[i]);

        int waterArea = 0;
        for(int i = 1; i < n-1; i++) {
            if(fgl[i] > -1 && fgr[i] > -1){
                waterArea += Math.min(heights[fgr[i]],heights[fgl[i]]) - heights[i];
            }
        }
        return waterArea;
    }
}
