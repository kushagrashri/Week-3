

public class ExamMarks {
   public static void sort(int marks[]){

       for(int i=0;i< marks.length-1;i++){
           int smallestIdx = i;
           for(int j=i+1;j< marks.length;j++){
               if(marks[j]<marks[smallestIdx]){
                   smallestIdx=j;
               }
           }
           int temp = marks[i];
           marks[i]= marks[smallestIdx];
           marks[smallestIdx]=temp;
       }
   }

    public static void main(String[] args) {
      int marks[] = {56,89,45,33,66,21};
        sort(marks);
        for (int i =0;i< marks.length;i++){
            System.out.print(marks[i]+",");
        }
    }
}
