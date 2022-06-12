public class AltemetrikTest {
    /*
     * Given a sorted Array of integers, an integer X which is already present in
     * array and an integer K,
     * find K nearest difference elements to X in the array.
     * Arr = {2, 5, 8, 10, 13, 17, 19, 25, 27, 32}
     * X = 19
     * K = 4
     * 
     * O/P: {13, 17, 25, 27}
     */
    static int[] arr = { 2, 5, 8, 10, 13, 17, 19, 25, 27, 32 };
    static int input = 17;
    static int k = 4;

    static int[] result = new int[k];

    static int count = 0;

    public static void main(String[] args) {
        int left = 0;
        int right = 0;

        int indexInput = findIndex(arr, input);

        left = indexInput - 1;
        right = indexInput + 1;
        //System.out.println(left);
        //System.out.println(right);
        if (left == arr.length) {
            for (int i = 0; i < k; i++) {
                result[i] = arr[--left];
            }
        }
        int leftDiff = 0;
            int rightDiff =0;
            
         //   { 2, 5, 8, 10, 13, 17, 19, 25, 27, 32 };
        for (int i = 0; i < k; i++) {
            
            if (left > 0 && right < arr.length) {
                leftDiff = input - arr[left];
                //System.out.println("diff1: "+leftDiff);

                rightDiff = arr[right] - input;
                //System.out.println("diff2: "+rightDiff);
                if (leftDiff < rightDiff) {
                    result[i] = arr[left];
                    left--;
                    //i++;
                    count++;
                } else {
                    //System.out.print("h");
                    result[i] = arr[right];
                    //System.out.println(arr[right]);
                    right++;
                    count++;
                    // i++;
                }
            }
            if(right == arr.length && count< k){
                result[count] = arr[left];
                left--;
                count++;
            }
            if(left == 0 && count < k){
                result[count] = arr[right];
                right++; //count++;
            }


        }

        for (int i : result) {
            System.out.println(i);
        }

    }

    private static int findIndex(int[] arr2, int input2) {
        int answer = -1;
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] == input2) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
