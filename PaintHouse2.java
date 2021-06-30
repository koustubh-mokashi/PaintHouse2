class Solution {
    public int minCostII(int[][] costs) {
        int hl = costs.length;
        int cl = costs[0].length;
        int[][] res = new int[hl][cl];
        int[][] stm = new int[hl][2];
        for(int[] a:stm) {
             Arrays.fill(a, Integer.MAX_VALUE);
        }
       
        for(int j=0;j<cl;j++) {
            res[0][j] = costs[0][j];
            if(res[0][j]<stm[0][1]) {
                stm[0][1] = res[0][j];
            }
            if(stm[0][1]<=stm[0][0]) {
                int temp = stm[0][0];
                stm[0][0] = stm[0][1];
                stm[0][1] = temp;
            }
        }
        
        
        for(int i=1;i<hl;i++){
            for(int j=0;j<cl;j++) {
                res[i][j]=costs[i][j];
                res[i][j] = (res[i-1][j] == stm[i-1][0]) ? res[i][j]+stm[i-1][1] :res[i][j]+stm[i-1][0];
                if(res[i][j]<stm[i][1]) {
                    stm[i][1] = res[i][j];
                }
                if(stm[i][1]<=stm[i][0]) {
                    int temp = stm[i][0];
                    stm[i][0] = stm[i][1];
                    stm[i][1] = temp;
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int k:res[hl-1]) {
            min = Math.min(min, k);
        }
        return min;
    }
}
