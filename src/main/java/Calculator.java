import java.util.List;

public class Calculator {
    private long result;
    //Constructor would be implicit
    public Calculator(){
        result = 0;
    }

    public long add(String nums){
        if(nums.isEmpty())
            return result;
       else {
            List<String> numList = List.of(nums.split(",|\n"));
            result = numList.stream()
                    .mapToLong(num -> Long.parseLong(num))
                    .sum();
        }
        return result;
    }

}
