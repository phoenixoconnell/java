package exercise2;

public class Monkeys {
    boolean monkeyBusiness(Monkey[] monkeys) {
        //BONUS EXERCISE
        //We have a set of monkeys.  Each Monkey has a boolean smile property, which indicates if that particular monkey is smiling.  Determine whether or not the majority of monkeys are smiling.  If the majority are smiling, return true.  if the majority are not smiling, return false.  If it is a tie, return true.
        boolean allSmiles;
        int smiles = 0;
        for(Monkey monkey: monkeys) {
            if(monkey.smile) {
                smiles++;
            }
        }
        allSmiles = smiles >= (double) monkeys.length / 2;
        return allSmiles;
    }
    
    class Monkey {
        String name;
        boolean smile;
    }
    
    public static void main(String[] args) {
        //Bonus exercise instructions:  create an array of at least 3 monkeys, utilizing the nested Monkey class, and determine whether the majority of them are smiling or not.
        //required monkey data:
        // Rafiqi is smiling
        // Curious George is smiling
        // King Kong is not smiling
        //You are NOT allowed to move the Monkey class.  Keep it where it is.
        Monkeys monkeys = new Monkeys();
        Monkeys.Monkey rafiqi = monkeys.new Monkey();
        rafiqi.name = "Rafiqi";
        rafiqi.smile = true;
        Monkeys.Monkey curiousGeorge = monkeys.new Monkey();
        curiousGeorge.name = "Curious George";
        curiousGeorge.smile = true;
        Monkeys.Monkey kingKong = monkeys.new Monkey();
        kingKong.name = "King Kong";
        kingKong.smile = false;
        Monkeys.Monkey harambe = monkeys.new Monkey();
        harambe.name = "Harambe";
        harambe.smile = false;
        Monkey[] monkeyList = {rafiqi, curiousGeorge, kingKong, harambe};
        System.out.println(monkeys.monkeyBusiness(monkeyList));
    }
}