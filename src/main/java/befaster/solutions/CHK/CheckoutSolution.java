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
        item.put("E",40);
        item.put("F",10);
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
        if(matchMap.containsKey("E")){
           int val= matchMap.get("E")/2;
           if(matchMap.containsKey("B")){
               if(matchMap.get("B")>=val){
                   matchMap.replace("B",matchMap.get("B"),matchMap.get("B")-val);
               }
           }
        }
        if(matchMap.containsKey("F")){
           if(matchMap.get("F")!=2) {
                int val = matchMap.get("F");
                int rem =0;
                for(int i=1;i<=val ;i++){
                    if(i/2==0){
                        rem=rem+1;
                    }
                }
               // if (matchMap.get("F") >= val) {
                    matchMap.replace("F", matchMap.get("F"), matchMap.get("F") - rem);
                }


        }


        int sum=0;
        int specialA=130;
        int specialA200=200;
        int specialB=45;
        for (Map.Entry<String,Integer> entry:matchMap.entrySet()
             ) {
            if(entry.getKey().equals("A")){
                if(entry.getValue()==5){
                    sum = sum + specialA200;
                }
                else if(entry.getValue()>5){
                    int round = Math.round(entry.getValue()/5);
                    sum = sum + round*specialA200;

                    int bal = entry.getValue()%5;
                    if(bal>=3){

                        sum=sum+(bal/3)*specialA;

                       // sum = sum +  Math.round(bal/3)*specialA;

                        sum= sum+bal%3*item.get("A");
                    }else{
                        sum=sum+bal*item.get("A");
                    }

                }else if(entry.getValue()==3){
                    sum=sum+specialA;
                }else if(entry.getValue()>3 && entry.getValue()<5){

                    sum = sum+ specialA;
                    int bal = entry.getValue()%3;
                    sum= sum+bal*item.get("A");
                }
                else{
                    sum= sum+entry.getValue()*item.get("A");
                }
            }if(entry.getKey().equals("B")){
                if(entry.getValue()==2){
                    sum = sum+specialB;
                }else if(entry.getValue()>2){
                    int round = Math.round(entry.getValue()/2);
                    sum = sum+round*specialB;
                    int bal = entry.getValue()%2;
                    sum= sum+bal*item.get("B");

                }else {
                    sum=sum+entry.getValue()*item.get("B");
                }

        }
            if(entry.getKey().equals("C")){
                sum=sum+entry.getValue()*item.get("C");
            }
            if(entry.getKey().equals("D")){
                sum=sum+entry.getValue()*item.get("D");
            }
            if(entry.getKey().equals("E")){

                    sum=sum+entry.getValue()*item.get("E");
            }
            if(entry.getKey().equals("F")){

                sum=sum+entry.getValue()*item.get("F");
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        System.out.println(checkoutSolution.checkout("FFFFFF"));
        /*
        Some requests have failed (7/46). Here are some of them:
 - {"method":"checkout","params":["FF"],"id":"CHK_R3_039"}, expected: 20, got: 10
 - {"method":"checkout","params":["FFFF"],"id":"CHK_R3_041"}, expected: 30, got: 20
 - {"method":"checkout","params":["FFFFFF"],"id":"CHK_R3_042"}, expected: 40, got: 30
You

        - {"method":"checkout","params":["AAA"],"id":"CHK_R2_015"}, expected: 130, got: 150
 - {"method":"checkout","params":["AAAA"],"id":"CHK_R2_016"}, expected: 180, got: 200
 - {"method":"checkout","params":["AAAAAA"],"id":"CHK_R2_018"}, expected: 250, got: 200
You ha
- {"method":"checkout","params":["AAAAAAAA"],"id":"CHK_R2_020"}, expected: 330, got: 460
 - {"method":"checkout","params":["AAAAAAAAA"],"id":"CHK_R2_021"}, expected: 380, got: 510
 - {"method":"checkout","params":["EEB"],"id":"CHK_R2_024"}, expected: 80, got: 110
         */
    }
}
