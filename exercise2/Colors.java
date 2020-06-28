package exercise2;

public class Colors {
    String[] colorful(String[] strings) {
        // For the given strings, keep all the strings that begin with a color ("red", "yellow", "green", "blue", etc.) return an array of strings that start with a color.  discard all the other strings.  If no strings start with a color in the input array, return an empty array.
        String[] colors = {"red", "blue", "green", "yellow", "purple", "black", "white", "orange", "pink"};
        int count = 0;
        String[] filtered = new String[strings.length];
        for(int i = 0; i < strings.length; i++) {
            for(String color: colors) {
                if(strings[i].indexOf(color) == 0) {
                    filtered[count] = strings[i];
                    count++;
                }
            }
        }
        String[] ret = new String[count];
        for(int i = 0; i < ret.length; i++) {
            ret[i] = filtered[i];
        }
        return ret;
    }
    
    public static void main(String[] args) {
        Colors code = new Colors();
        String[] answer = code.colorful(new String[]{"bluebird","red herring", "yellow bumblebee","black spider", "green monkey","pink","great gatsby","feeding frenzy","black bird","widowmaker","quran","bible","torah"});
        System.out.println("This is the Colors class");
        for(String s: answer) {
            System.out.println(s);
        }
    }
}