package com.example.array;

public class ValidMountainArray_941 {
    public boolean validMountainArray(int[] arr) {
        if(arr.length <= 2) return false;

        int i = 0;
        boolean ascent = false;
        while(i <= arr.length - 2){
            if(arr[i] >= arr[i + 1]){
                break;
            }
            ascent = true;
            i++;
        }

        boolean descent = false;
        while(i < arr.length - 1){
            descent = true;
            if(arr[i] <= arr[i+1])
                return false;
            i++;
        }

        return ascent & descent;
    }

    public static void main(String[] args) {
        ValidMountainArray_941 v = new ValidMountainArray_941();
        System.out.println(v.validMountainArray(new int[]{0,3,2,1}));
    }
}
