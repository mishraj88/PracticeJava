package algos;

public class BinarySearchDemo {

    static int[] arr = { 2, 4, 6, 8, 10, 12, 16, 18, 21 };
    static int key = 12;

    public static void main(String[] args) {
        // int index = 2;
        //int index = binarySearchIterative(arr, key);

        int index = binarySearchRecursive(arr, 0, arr.length-1,key);

        if (index < 0) {
            System.out.println("index: " + index + "- key:  " + key + " not found");
        } else {
            System.out.println("Key: " + key + " found at index: " + index);
        }
    }

    static int binarySearchIterative(int[] a, int key) {
        // {2,4,6,8,10,12,16,18,21};
        int answer = -1; // we will return -1, if key not found in array

        int left = 0;
        int right = arr.length - 1;
        System.out.println("left: " + left + " right: " + right);
        if (a[right] < key)
            return answer;
        if (a[left] == key)
            return left;
        if (a[right] == key)
            return right;

        while (left <= right) {

            if (a[left] == key)
                return left;
            if (a[right] == key)
                return right;
            System.out.println("hello");
            int mid = left + (right - left) / 2;
            System.out.println("mid: " + mid);
            if (a[mid] == key) {
                answer = mid;
                return mid;
            }
            if (a[mid] > key) {
                right = mid - 1;
            }
            if (a[mid] < key) {
                left = mid + 1;
            }
            System.out.println("left: " + left);
            System.out.println("Right: " + right);

        }

        return answer;
    }

    static int binarySearchRecursive(int[] a, int start, int end, int key) {
        //int answer = -1;
        // {2,4,6,8,10,12,16,18,21};
        if (start <= end) {
            System.out.println("start: "+start+" end: "+end);
            System.out.println("Key: "+key);
            if (a[start] == key){
                System.out.println("a["+start+"] = "+a[start]);
                return start;
            }
                
            if (a[end] == key){
                System.out.println("a["+end+"] = "+a[end]);
                return end;
            }
               // return end;
            int mid = start + (end - start) / 2;
            System.out.println("mid: "+mid);
            if (a[mid] == key){
                System.out.println("a["+mid+"] = "+a[mid]);
                return mid;
            }
               //return mid;
            else {
                if (a[mid] > key){
                    end = mid-1;
                    return binarySearchRecursive(a, start, end, key);
                }else{
                    start = mid+1;
                    return binarySearchRecursive(a, start, end, key);
                }
                   
                
            }

        }
        return -1;

    }

}
