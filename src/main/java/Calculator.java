import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {
    private long result;
    private String delimeters;
    //Constructor would be implicit
    public Calculator(){
        delimeters = ",|\n";
        result = 0;
    }

    public long add(String nums) throws Exception{
        if(nums.startsWith("//")){
           int endDel = nums.indexOf("\n");
           String difDels = nums.substring(2, endDel);
           updateDelimeters(difDels);
           nums = nums.substring(endDel + 1);
        }
       if(!nums.isEmpty()) {
            List<String> numList = List.of(nums.split(delimeters));
            findNegatives(numList);
            result = numList.stream()
                    .mapToLong(num -> Long.parseLong(num))
                    .filter(num -> num < 1000)
                    .sum();
        }
        return result;
    }

    private void findNegatives(List<String> numList) throws Exception{
        List<String> negList= numList.stream()
                .filter(neg -> neg.startsWith("-"))
                .collect(Collectors.toList());
        if(!negList.isEmpty()){
            String message = "Negatives not allowed: ";
            message = message.concat(String.join(",",negList));
            throw new Exception(message);
        }
    }

    private void updateDelimeters(String delimeters){
        if(delimeters.contains("[") && delimeters.contains("]")){
            Pattern pattern = Pattern.compile("\\[(.*?)\\]");
            Matcher matcher = pattern.matcher(delimeters);
            while( matcher.find() ) {
                this.delimeters = this.delimeters + "|" + matcher.group(1);
            }
        } else{
            this.delimeters = this.delimeters + "|" + delimeters;
        }
    }

}
