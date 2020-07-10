package exercise2;

public class Types {
    //    This class has syntax errors, that will prevent your other classes from running.  So... work on this file first to resolve the issues.
        boolean number;
        int[] myArray = {3,4,5,6,76,12,2};
        String movieA = "Harry and the Hendersons";
        String movieB = "Star Wars";
        char male = 'm';
        char female = 'f';
        //the above instance variables have mistakes with their data types.  Fix the data types so the main method correctly displays the value of all of the variables
        
        public static void main(String[] args) {
            Types myTypes = new Types();
            System.out.println("There are variables that have been declared in this Accessible class.  Fix the code so that all the variables can be accessed by the main method.  print out the values of every variable once the code has been refactored.");
            for(int i: myTypes.myArray) {
                System.out.println(i);
            }
            System.out.println(myTypes.movieA);
            System.out.println(myTypes.movieB);
            System.out.println(myTypes.male);
            System.out.println(myTypes.female);
        }
    }