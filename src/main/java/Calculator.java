public class Calculator {

    //Constructor would be implicit
    public Calculator(){

    }

    public long add(String numsStr){
        long [] numArray = new long[2];
        long result = 0;
        if(numsStr.isEmpty())
            return result;
        else if(!numsStr.contains(",")) {
            result = Long.parseLong(numsStr);
        } else if(numsStr.contains(",")){
            String [] numsStrArray = numsStr.split(",");
            for (int i = 0; i < numsStrArray.length; i++){
                numArray[i] = Long.parseLong(numsStrArray[i]);
                result += numArray[i];
            }

        }
        return result;
    }
}
