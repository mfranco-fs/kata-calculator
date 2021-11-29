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
        else if(!nums.contains(",")) {
            result = Long.parseLong(nums);
        } else if(nums.contains(",")){
            List<String> numList = List.of(nums.split(","));
            result = numList.stream()
                    .mapToLong(num -> Long.parseLong(num))
                    .sum();
        }
        return result;
    }

}
