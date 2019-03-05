/**
 * The class  <b>Assignment</b> is used to
 * test our LinearRegression class. It uses the
 * provided class <b>Display</b> to show the results
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class Assignment {


 /** 
     * Random generator 
     */
 private static java.util.Random generator = new java.util.Random();

  /** 
     * In this second method, we will select a line at random.
     *  1) we select a line y = ax + b, with a randomly selected
     * between -100 and +100 and b randomly selected between 
     * -250 and +250
     *  2) we add 500 samples randomly selected on the line
     * between -100 and +300. For each sample we add a "noise" 
     * randomly selected between -1000 and +1000 (that is, for
     * each randomly selected x, we add the sample (x, ax+b+noise).
     * where "noise" is randomly selected between -1000 and 1000
     *  3) We create an instance of Display
     *  4) we iterate gradient descent (find a number of iterations,
     * a number of updates to the instance of Display, and a 
     * step alpha that seems to work
     */
 

 
 
 private static void randomLine(){
   
   LinearRegression linearRegression = new LinearRegression(500);
   java.util.Random generator = new java.util.Random();
   
   Display graph;
   graph = new Display(linearRegression);
   
   double a = (generator.nextDouble()*200 - 100);
   double b = (generator.nextDouble()*500 -250);
   graph.setTarget(a, b);
   
   for (int i=0; i<500; i++){
   double x = (generator.nextDouble()*400 - 100);
   double y = ( generator.nextDouble()*(a*x+b+2000) - (1000) );
   linearRegression.addSample(x,y);   
   }
   
   int iteration =  100;
   for (int j = 0; j<iteration; j++){
      System.out.println("Current hypothesis: " + linearRegression.currentHypothesis());
      System.out.println("Current cost: " + linearRegression.currentCost());
      graph.update();
   linearRegression.gradientDescent(0.000000003,500);
   graph.update();
   }
   
 }
 
 private static void setLine(){
   
   
   LinearRegression linearRegression = new LinearRegression(1000);
      
      for (int i = 0; i<=999; i++){
        linearRegression.addSample(i,i);
   }
      
    Display graph ; 
    graph = new Display(linearRegression);
    int iteration =  50;
    
    for (int j = 0; j<iteration; j++){
      System.out.println("Current hypothesis: " + linearRegression.currentHypothesis());
      System.out.println("Current cost: " + linearRegression.currentCost());
      graph.update();
      linearRegression.gradientDescent(0.000000003,100);
  }   
     
 }
 
 
 public static void main(String[] args) {

   StudentInfo.display();
   
   System.out.println("setLine");
   setLine();



 }

}