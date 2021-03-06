package com.practicaljava.lesson11;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

class MyObserver implements PropertyChangeListener {
		
	//positions currently occupied by X
	private int[] posX = {0,0,0,0,0,0,0,0,0};
	//positions currently occupied by O
	private int[] posO = {0,0,0,0,0,0,0,0,0};
    
    public MyObserver(TicTacToeApplet model) {
        model.addChangeListener(this);
    }
    
    void reset(){
    	for (int i=0;i<9;i++){
    		posX[i]=0;
    		posO[i]=0;
    	}
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
    	//PropertyName = X or O
    	//new value = position of move (integer)
       String newValueS = (String) event.getNewValue();
       String propertyName = event.getPropertyName();
       int newValue = Integer.parseInt(newValueS);
       System.out.println("Changed property: " + propertyName + " | [new -> " + newValueS +"]");
       if ("X".equals(propertyName)){
    	   posX[newValue] = 1;
       }
       else {
    	   posO[newValue] = 1;
       }
       System.out.println("PosX = " + toString(posX));
       System.out.println("PosO = " + toString(posO));
    }
    
    private String toString(int[] intArray){
    	String result = "";
    	for (int i=0; i<intArray.length; i++){
    		result = result.concat(String.valueOf(intArray[i])).concat(" ");
    	}
    	return result;
    }
    
    
    int minimaxComputerMove(){
 	   //http://www.youtube.com/watch?v=3sbGRBjsf0o
       //o = number of rows, columns or diagonals with two O's and no X
       //x = number of rows, columns or diagonals with one O and no X
       //z = number of rows, columns or diagonals with two X's and no O
       //y = number of rows, columns or diagonals with one X and no O
       //evaluationFunction = 3*o + x - (3*z + y)
    	
 	   int computerMove = 0;
 	   int[] simulatedPosO = new int[9];
 	   
 	   //initialize array of evaluation function values with 
 	   //something that can never be the result of an evaluation function
 	   int[] evaluationFunction = {-100,-100,-100,-100,-100,-100,-100,-100,-100};
 	 	   
 	   //calculate the evaluation function for each possible move of O
 	   for (int i=0; i<9; i++){
 		//if position is occupied move on   
 		   if ((posX[i] == 1) || (posO[i]==1)){
 			   continue;
 		   }
 		//copy posO array into a temporary array used for simulating a move
 	   for (int j=0; j<9; j++){
 		   simulatedPosO[j] = posO[j];
 	   }
 	   //pretend O moves to this position and apply evaluationFunction
 	   simulatedPosO[i] = 1;
 	   evaluationFunction[i] = minimaxEvaluationFunction(posX, simulatedPosO);
 	   }
 	   	   
 	   //pick move with maximum value of the evaluation function
 	   
 	  computerMove = indexOfMaxValueFrom(evaluationFunction);
 	   
 	  return computerMove;
    }
    
    private int indexOfMaxValueFrom(int[] evaluationFunction) {
    	int index = 0;
    	int max = evaluationFunction[0];
		for(int i=0; i<9; i++){
			if (evaluationFunction[i] > max) {
				max = evaluationFunction[i];
				index = i;	
			}
		}
		return index;
	}

	private int minimaxEvaluationFunction(int[] arrayX, int[] arrayO){
 	   //number of rows, columns or diagonals with two O's and no X
 	   int o = calcO(arrayX, arrayO);
 	   //number of rows, columns or diagonals with one O and no X
 	   int x = calcX(arrayX, arrayO);
 	   //number of rows, columns or diagonals with two X's and no O
 	   int z = calcZ(arrayX, arrayO);
 	   // number of rows, columns or diagonals with one X and no O
 	   int y = calcY(arrayX, arrayO);
 	   return 3*o + x - (3*z + y);	   
    }
    
    private int calcO(int[] arrayX, int[] arrayO){
 	 //number of rows, columns or diagonals with two O's and no X
 	   int o = 0;
 	   if((arrayO[0]==1)&&(arrayO[1]==1)&&(arrayX[2]==0)||
 		  (arrayO[0]==1)&&(arrayX[1]==0)&&(arrayO[2]==1)||
 		  (arrayX[0]==0)&&(arrayO[1]==1)&&(arrayO[2]==1))
 		   o++;
 	   if((arrayO[3]==1)&&(arrayO[4]==1)&&(arrayX[5]==0)||
 		  (arrayO[3]==1)&&(arrayX[4]==0)&&(arrayO[5]==1)||
 		  (arrayX[3]==0)&&(arrayO[4]==1)&&(arrayO[5]==1))
 		   o++;
 	   if((arrayO[6]==1)&&(arrayO[7]==1)&&(arrayX[8]==0)||
 		  (arrayO[6]==1)&&(arrayX[7]==0)&&(arrayO[8]==1)||
 		  (arrayX[6]==0)&&(arrayO[7]==1)&&(arrayO[8]==1))
 		   o++;
 	   if((arrayO[0]==1)&&(arrayO[3]==1)&&(arrayX[6]==0)||
 		  (arrayO[0]==1)&&(arrayX[3]==0)&&(arrayO[6]==1)||
 		  (arrayX[0]==0)&&(arrayO[3]==1)&&(arrayO[6]==1))
 		   o++;
 	   if((arrayO[1]==1)&&(arrayO[4]==1)&&(arrayX[7]==0)||
 		  (arrayO[1]==1)&&(arrayX[4]==0)&&(arrayO[7]==1)||
 		  (arrayX[1]==0)&&(arrayO[4]==1)&&(arrayO[7]==1))
 		   o++;
 	   if((arrayO[2]==1)&&(arrayO[5]==1)&&(arrayX[8]==0)||
 		  (arrayO[2]==1)&&(arrayX[5]==0)&&(arrayO[8]==1)||
 		  (arrayX[2]==0)&&(arrayO[5]==1)&&(arrayO[8]==1))
 		   o++;
 	   if((arrayO[0]==1)&&(arrayO[4]==1)&&(arrayX[8]==0)||
 		   (arrayO[0]==1)&&(arrayX[4]==0)&&(arrayO[8]==1)||
 		   (arrayX[0]==0)&&(arrayO[4]==1)&&(arrayO[8]==1))
 		    o++;
 	   if((arrayO[2]==1)&&(arrayO[4]==1)&&(arrayX[6]==0)||
 		  (arrayO[2]==1)&&(arrayX[4]==0)&&(arrayO[6]==1)||
 		  (arrayX[2]==0)&&(arrayO[4]==1)&&(arrayO[6]==1))
 		   o++;
 	   return o;
    }
    
    private int calcX(int[] arrayX, int[] arrayO){
 	 //number of rows, columns or diagonals with one O and no X  
 	   int x = 0;
 	   if((arrayO[0]==1)&&(arrayX[1]==0)&&(arrayX[2]==0)||
 		  (arrayX[0]==0)&&(arrayO[1]==1)&&(arrayX[2]==0)||
 		  (arrayX[0]==0)&&(arrayX[1]==0)&&(arrayO[2]==1))
 		   x++;
 	   if((arrayO[3]==1)&&(arrayX[4]==0)&&(arrayX[5]==0)||
 		  (arrayX[3]==0)&&(arrayX[4]==0)&&(arrayO[5]==1)||
 		  (arrayX[3]==0)&&(arrayO[4]==1)&&(arrayX[5]==0))
 		   x++;
 	   if((arrayO[6]==1)&&(arrayX[7]==0)&&(arrayX[8]==0)||
 		  (arrayX[6]==0)&&(arrayX[7]==0)&&(arrayO[8]==1)||
 		  (arrayX[6]==0)&&(arrayO[7]==1)&&(arrayX[8]==0))
 		   x++;
 	   if((arrayO[0]==1)&&(arrayX[3]==0)&&(arrayX[6]==0)||
 		  (arrayX[0]==0)&&(arrayX[3]==0)&&(arrayO[6]==1)||
 		  (arrayX[0]==0)&&(arrayO[3]==1)&&(arrayX[6]==0))
 		   x++;
 	   if((arrayO[1]==1)&&(arrayX[4]==0)&&(arrayX[7]==0)||
 		  (arrayX[1]==0)&&(arrayX[4]==0)&&(arrayO[7]==1)||
 		  (arrayX[1]==0)&&(arrayO[4]==1)&&(arrayX[7]==0))
 		   x++;
 	   if((arrayO[2]==1)&&(arrayX[5]==0)&&(arrayX[8]==0)||
 		  (arrayX[2]==0)&&(arrayX[5]==0)&&(arrayO[8]==1)||
 		  (arrayX[2]==0)&&(arrayO[5]==1)&&(arrayX[8]==0))
 		   x++;
 	   if((arrayO[0]==1)&&(arrayX[4]==0)&&(arrayX[8]==0)||
 		   (arrayX[0]==0)&&(arrayX[4]==0)&&(arrayO[8]==1)||
 		   (arrayX[0]==0)&&(arrayO[4]==1)&&(arrayX[8]==0))
 		    x++;
 	   if((arrayO[2]==1)&&(arrayX[4]==0)&&(arrayX[6]==0)||
 		  (arrayX[2]==0)&&(arrayX[4]==0)&&(arrayO[6]==1)||
 		  (arrayX[2]==0)&&(arrayO[4]==1)&&(arrayX[6]==0))
 		   x++;
 	   return x;
    }

    private int calcZ(int[] arrayX, int[] arrayO){
 	 //number of rows, columns or diagonals with two X's and no O
 	   return calcO(arrayO, arrayX);
    }

    private int calcY(int[] arrayX, int[] arrayO){
 	// number of rows, columns or diagonals with one X and no O
 	   return calcX(arrayO, arrayX);
    }
} 
