class ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int N) {
        int ans=0;
        int n = 1;
        int temp = N;
        while(temp>0){
            if(temp%(n)==0) ans++;
            temp-=n;
            n++;
        }
        return ans;
    }
}
