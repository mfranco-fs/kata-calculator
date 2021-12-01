import java.util.List;

public class Calculator {
    private long result;
    private String delimeters;
    //Constructor would be implicit
    public Calculator(){
        delimeters = ",|\n";
        result = 0;
    }

    public long add(String nums){
        if(nums.startsWith("//")){
           int endDel = nums.indexOf("\n");
           String difDel = nums.substring(2, endDel);
           delimeters = delimeters + "|" + difDel;
           nums = nums.substring(endDel + 1);
        }
        if(nums.isEmpty())
            return result;
       else {
            List<String> numList = List.of(nums.split(delimeters));
            result = numList.stream()
                    .mapToLong(num -> Long.parseLong(num))
                    .sum();
        }
        return result;
    }

}
