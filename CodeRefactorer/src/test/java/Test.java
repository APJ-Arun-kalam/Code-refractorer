class Solution {
    public String kthDistinct(String[] arr, int k) {
        int size = 0;int ki = 0;
        String a[] = new String[26];
        Boolean dup;
        for(int i = 0; i<arr.length; i++) {
            a[size] = "!";
            dup = false;
            for(int j = 0; j<size+1; j++) {
                if(a[j] ==" ") continue;
                if(arr[i].equals(a[j])) {
                    dup = true;
                    a[j] = " ";
                    break;
                }
            }
            if(dup == false) {
                a[size] = arr[i];
                size++;
            }
            if(dup == true) {
                a[size] = " ";
                size++;
            }
        }
        String lst[] = new String[a.length];
        for(int i = 0; i<a.length; i++) {
            if(a[i].equals(" ")) continue;
            else{
                lst[ki] = a[i];
                ki++;
            }
        }
        if(k>lst.length){
            return "";
        }
        return lst[k-1];

    }
}