/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xor;
import java.util.Arrays;

/**
 *
 * @author nuhin13
 */
public class Xor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int [][] Training_input = {{0,0},{0,1},{1,0},{1,1}};
        int [] Traing_output = {0,0,0,1};
        
       /* int [][][][] three_input;
        three_input = {
        {0,0,0},{0},
        {0,0,1},{0},
        {0,1,0},{0},
        {0,1,1},{0},
        {1,0,0},{0},
        {1,0,1},{0},
        {1,1,0},{0},
        {1,1,1},{1},
    };*/
    
    //};
        
        double Learning = 0.2;
        double Thresold = 1;
        
        double  [] weight = {0.0,0.0};
        
       int iteration =1;
       // for(int k=0;k<=100;k++){
        while(true){
        
            boolean err = true;
            int error= 0;
            int output;
            
            
            System.out.println("Iteration :" + iteration );
            System.out.println();
            
            for(int i= 0; i<Training_input.length ;i++ ){
  
                System.out.println("Starting Weights :" +Arrays.toString(weight));
                System.out.println();
                
                double SumWeight =0;
                for(int j=0; j<weight.length;j++){
                               
                    SumWeight +=weight[j]*Training_input[i][j];
                
                }
                
                output=0;
                
                if(SumWeight>=Thresold){
                    output=1;
                }
                
                System.out.println("Main Output :" + Traing_output[i] + "    " + " Gained Output " + output );
                System.out.println();
                error = Traing_output[i]-output;
                
                if(error !=0){
                       err=false;
                }
                
                System.out.println("Error :" + error );
                System.out.println();
                
                for(int j=0;j<weight.length;j++){
                
                    weight[j]+=Learning*error*Training_input[i][j];
                 
                 
                }
                
                System.out.println("Updated weight :" + Arrays.toString(weight) );
                System.out.println();
            
            
            
            }
            if(err==true){
                
            System.out.println("Final :" +Arrays.toString(weight));
            System.exit(0);
            
            }
        //k++;
    
        iteration++;
        }
        
    }
}
