public class Calculator {

    //Constructor would be implicit
    public Calculator(){

    }

    public long add(String numbers){
        long result = 0;
        if(numbers.isEmpty())
            return 0;
        else if(!numbers.contains(",")) {
            result = Long.parseLong(numbers);
            return result;
        }
        return 0;
    }
}
