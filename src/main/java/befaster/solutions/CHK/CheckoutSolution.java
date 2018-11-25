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
        Map <String,Integer> matchMap = new HashMap();

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

        for (String match:list
             ) {
            if(matchMap.containsKey(match)){
                matchMap.replace(match,matchMap.get(match),matchMap.get(match)+1);
            }
            else {
                if(item.containsKey(match)) {
                    matchMap.put(match, 1);
                }else{
                    return  -1;
                }
            }
        }


        int sum=0;
        int specialA=130;
        int specialB=45;
        for (Map.Entry<String,Integer> entry:matchMap.entrySet()
             ) {
            if(entry.getKey().equals("A")){
                if(entry.getValue()==3){
                    sum = sum+specialA;
                }else if(entry.getValue()>3){
                    int round = Math.round(entry.getValue()/3);
                    sum = sum+round*specialA;
                    int bal = entry.getValue()%3;
                    sum= sum+item.get("A");

                }
            }if(entry.getKey().equals("B")){
                if(entry.getValue()==2){
                    sum = sum+specialB;
                }else if(entry.getValue()>2){
                    int round = Math.round(entry.getValue()/3);
                    sum = sum+round*specialB;
                    int bal = entry.getValue()%3;
                    sum= sum+item.get("A");

                }
            }
            sum=sum+item.get(entry.getKey())*entry.getValue();
        }
        /*for (String val:list
             ) {
            if(item.containsKey(val)){
                sum= sum+item.get(val);
            }else{
                sum= -1;
                break;
            }
        }*/

        return sum;
    }
}
