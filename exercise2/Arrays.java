package exercise2;

public class Arrays {
    //Take the arrays.js file, and refactor the code into Java in this file.
    int[] nums = {10, 23, 3, 4, 5, 2, 1};
    String[] greetings = {"hello", "howdy", "hallo", "hola", "bonjour", "ciao", "أهلا"};
    boolean[] binaries = {false,true,true,true,false,false,false,true,true,true,true,true,false,true,false,false,true,false};
    void printNums() {
        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    };
    
    void printGreetings() {
        for(int i = 0; i < greetings.length; i++) {
            System.out.println(greetings[i]);
        }
    };
    
    void printBinaries() {
        for(int i = 0; i < binaries.length; i++) {
            System.out.println(binaries[i]);
        }
    };

    public static void main(String[] args) {
        Arrays arrays = new Arrays();

        arrays.printNums();
        arrays.printGreetings();
        arrays.printBinaries();
    }
}
/*
const nums = [10,23,3,4,5,2,1];
const greetings = ["hello","howdy","hallo","hola","bonjour","ciao","أهلا"];
const binaries = [0,1,1,1,0,0,0,1,1,1,1,1,0,1,0,0,1,0];
nums.forEach(n => console.log(n));
greetings.forEach(g => console.log(g));
binaries.forEach(b => console.log(!!b));
 */






