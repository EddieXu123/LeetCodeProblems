/*
Consider a bank with some intial amount of money. Consider an array which represents list of transactions which are going to come through customers. + means deposit - means withdrawl. Bank can choose from which customer they want to start serving the customers and they can refuse any number of customers. But once they start they have to serve till the time its impossible to serve the customers. Maximize the total customers bank can serve.

Example :
Bank has 1 unit of money intially.
Customer transactions : [1, -3, 5, -2, 1]

answer = 3

Bank starts with customer with deposit of 5
1+ 5 = 6
6 - 2 = 4
4 + 1 =5

*/



public class MaxCustomersServed {

    public static int serveMaxCustomers(int[] transactions, int initialMoney) {
        int left = 0;
        int right = 0;
        int maxCustomersServed = 0;
        
        while (right < transactions.length) {
            initialMoney += transactions[right];
            if (initialMoney >= 0) {
                maxCustomersServed = Math.max(maxCustomersServed, right - left + 1);
            }
            while (left <= right && initialMoney < 0) {
                initialMoney -= transactions[left];
                left++;
            }
            right++;
        }
        
        return maxCustomersServed;
    }
    
    public static void main(String[] args) {
        System.out.println(serveMaxCustomers(new int[]{1, -3, 5, -2, 1}, 1));
    }
}
