public class SetMatrixZero{
    // set matrix to zero-- find 0's and for this marks that 0's row and col as 0

    // brute solution - TC - O(n*m)*O(n+m) +O(n*m)
    // traverse if ele in matrix 0 = marks row and col as -1 
    // again traverse whenever mat[i][j] = -1 marks it as 0
    public static void markRow(int[][] mat, int i){
        for(int j = 0; j<mat[0].length ;j++){
            if(mat[i][j] != 0){
                mat[i][j] = -1;
            }
        }
    }
    public static void markCol(int[][] mat, int j){
        for(int i = 0; i<mat.length ;i++){
            if(mat[i][j] != 0){
                mat[i][j] = -1;
            }
        }
    }
    public static void setMAtrix(int[][] mat){
        int  n = mat.length;
        int  m = mat[0].length;

        for(int i = 0; i< n ; i++){
            for(int j = 0; j<m ; j++){
                if(mat[i][j] == 0){
                    markRow(mat,i); // marks entire row as -1 if  != 0
                    markCol(mat,j);
                }
            }
        }

        for(int i = 0; i< n ; i++){
            for(int j = 0; j<m ; j++){
                if(mat[i][j] == -1){
                    mat[i][j] = 0;
                }
            }
        }

        // return  mat;
    }


    //better solution -- TC - O(n*m) + O(n*m) and SC = O(n) + O(m) for extra row and col array//za
    // create 2 Arrays - Row and Col- for track of row or col containns 0 or not
    // if at any pt 0 found marks row and col as true /1
    // now again traverse in matrix 
            // check if this row or col is marked or not if marked set this ele to 0

    public static void setMatrixToZero(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        // insted of boolean we can take int and marks 1 insteadd of true
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

        for(int i = 0; i < n ; i++){
            for(int j  = 0 ; j< m ; j++){
                if(mat[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for(int i= 0 ; i<n ; i++){
            for(int j = 0 ; j< m ; j++){
                if(row[i] || col[j]){
                    mat[i][j] = 0;
                }
            }
        }

    }


// optimal solution 

    public static void SetMatrix_Zero(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        int col0 = 1;
        // mat[0]{..} = col track
        // mat{...}[0] = row track

        for(int i = 0;i<n ; i++){
            for(int j = 0 ; j< m ; j++){
                if(mat[i][j] == 0){
                    // update row track
                        mat[i][0]= 0;
                    if(j != 0){
                        mat[0][j] = 0;
                    }else{
                        col0 = 0;
                    }
                }
            }
        }

        for(int i = 1; i< n ; i++){
            for(int j = 1 ; j< m ; j++){
                if(mat[i][j] != 0){
                    if(mat[0][j] == 0 || mat[i][0] == 0){
                        mat[i][j] = 0;
                    }
                }  
            }
        }
        if(mat[0][0] == 0){
            // set complete 1st row as 0
            for(int j = 0; j<m ; j++){
                mat[0][j] = 0;
            }

        }

        if(col0 == 0){
           // set commplete 1st col as 0
            for(int i = 0; i<n ; i++){
                mat[i][0] = 0;
            }
        }
    }


    public static void main(String[] args) {
        //int [][] mat = {{1,1,1,1},{1,0,0,1},{1,1,0,1},{1,1,1,1}};
        int [][] mat = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        //setMAtrix(mat);

        //setMatrixToZero(mat);

        SetMatrix_Zero(mat);


        int  n = mat.length;
        int  m = mat[0].length;

        for(int i = 0; i< n ; i++){
            for(int j = 0; j<m ; j++){
                System.out.print(mat[i][j] + "-");
            }
            System.out.println("");
        }

        
    }
}