package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        if(skus==null){
            return -1;
        }

        Map <String,Integer> item = new HashMap();

        item.put("A",50);
        item.put("B",30);
        item.put("C",20);
        item.put("D",15);
        String[] list =skus.split(",");
        if(list.length==1){
            return item.get(skus);
        }
        for (String val:list
             ) {
            if(item.containsKey(val)){
                return item.get(val);
            }
        }

        return -1;
    }
}
