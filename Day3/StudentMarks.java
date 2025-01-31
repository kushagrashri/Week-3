

public class StudentMarks {

    public static void sort(int arr[]){

        for(int i=0;i< arr.length-1;i++){
            boolean isSwap=false;
            for(int j=0;j< arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j] = temp;
                    isSwap=true;
                }

            }
            if(!isSwap){
                return;
            }
        }
    }

    public static void main(String[] args) {
        int marks[] = {60,96,42,86,37};
        sort(marks);
     for(int i=0;i< marks.length;i++){
         System.out.print(marks[i]+" ");
     }
    }
}
