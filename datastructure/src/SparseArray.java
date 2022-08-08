public class SparseArray {
    public static void main(String[] args) {
//        1.create array
        int[][] array = new int[11][11];
        array[1][2] = 1 ;
        array[2][3] = 2 ;
        array[6][7] = 2 ;
        array[6][9] = 2 ;
        array[9][9] = 1 ;
        System.out.println("Print original Array:");
        for(int[] row : array){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
//        2.translate array to sparse array
//          get not null number in array
        int sum = 0 ;
        for (int i = 0 ; i < 11 ; i ++ ){
            for (int j = 0 ; j < 11 ; j ++ ){
                if (array[i][j] != 0){
                    sum ++;
                }
            }
        }
//        create sparse array
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        int count = 0;
        for (int i = 0 ; i < 11 ; i ++){
            for(int j = 0 ; j < 11 ; j ++ ){
                if (array[i][j] != 0 ){
                    count ++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = array[i][j];
                }
            }
        }

        System.out.println("Print Sparse Array:");
        for (int[] row : sparseArray){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
//        translate sparse array to normal array
        int[][] toArray = new int[11][11];
//        for(int i = 0; i < 11; i ++){
//            for( int j = 0; j < 11; j ++){
//                toArray[i][j] = 0;
//            }
//        }

       for(int i = 1 ; i < sparseArray.length; i++){
           toArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
       }

        System.out.println("Print toArray:");
       for (int[] row : toArray){
           for (int data : row){
               System.out.printf("%d\t",data);
           }
           System.out.println();
       }

    }
}
