package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        if(skus.isEmpty()){
            return 0;
        }

        Map <String,Integer> item = new HashMap();

        item.put("A",50);
        item.put("B",30);
        item.put("C",20);
        item.put("D",15);
        String[] list =skus.split("");
        if(list.length==1){
            if(item.containsKey(skus)) {
                return item.get(skus);
            }else
                return -1;
        }
        int sum=0;
        for (String val:list
             ) {
            if(item.containsKey(val)){
                sum= sum+item.get(val);
            }else{
                sum= -1;
            }
        }

        return sum;
    }
}
