package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {

    /*
    A    | 50    | 3A for 130, 5A for 200 |
| B    | 30    | 2B for 45              |
| C    | 20    |                        |
| D    | 15    |                        |
| E    | 40    | 2E get one B free      |
| F    | 10    | 2F get one F free      |

| G    | 20    |                        |
| H    | 10    | 5H for 45, 10H for 80  |
| I    | 35    |                        |
| J    | 60    |                        |
| K    | 80    | 2K for 150             |

| L    | 90    |                        |
| M    | 15    |                        |
| N    | 40    | 3N get one M free      |
| O    | 10    |                        |
| P    | 50    | 5P for 200             |
| Q    | 30    | 3Q for 80
       |
| R    | 50    | 3R get one Q free      |
| S    | 30    |                        |
| T    | 20    |                        |
| U    | 40    | 3U get one U free      |
| V    | 50    | 2V for 90, 3V for 130  |

| W    | 20    |                        |
| X    | 90    |                        |
| Y    | 10    |                        |
| Z    | 50    |
     */
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

        item.put("G",20);
        item.put("H",10);
        item.put("I",35);
        item.put("J",60);
        item.put("K",80);
        item.put("L",90);

        item.put("M",15);
        item.put("N",40);
        item.put("O",10);
        item.put("P",50);
        item.put("Q",30);
        item.put("R",50);

        item.put("S",30);
        item.put("T",20);
        item.put("U",40);
        item.put("V",50);
        item.put("W",20);
        item.put("X",90);

        item.put("Y",10);
        item.put("Z",50);


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
        if(matchMap.containsKey("N")){
            int val= matchMap.get("N")/3;
            if(matchMap.containsKey("N")){
                if(matchMap.get("N")>=val){
                    if(matchMap.containsKey("M"))
                    matchMap.replace("M",matchMap.get("M"),matchMap.get("M")-val);
                }
            }
        }
        if(matchMap.containsKey("R")){
            int val= matchMap.get("R")/3;
            if(matchMap.containsKey("R")){
                if(matchMap.get("R")>=val){
                    if(matchMap.containsKey("Q"))
                    matchMap.replace("Q",matchMap.get("Q"),matchMap.get("Q")-val);
                }
            }
        }

        if(matchMap.containsKey("F")){
           if(matchMap.get("F")!=2) {
                int val = matchMap.get("F");
                int rem =0;
                if(val==3){
                    rem=1;
                }
                for(int i=3;i<=val ;i++){
                    if(i%2==0){
                        rem=rem+1;
                    }
                }
                    matchMap.replace("F", matchMap.get("F"), matchMap.get("F") - rem);
                }


        }
        if(matchMap.containsKey("U")){
            if(matchMap.get("U")!=3) {
                int val = matchMap.get("U");
                int rem =0;
                if(val==4){
                    rem=1;
                }
                for(int i=4;i<=val ;i++){
                    if(i%3==0){
                        rem=rem+1;
                    }
                }
                matchMap.replace("U", matchMap.get("U"), matchMap.get("U") - rem);
            }


        }


        int sum=0;
        int specialA=130;
        int specialA200=200;
        int specialB=45;
        int specialH5 =45;
        int special10H = 80;
        int special2K=150;
        int special5P=200;
        int special3Q=80;
        int special2V=90;
        int special3V=130;
        for (Map.Entry<String,Integer> entry:matchMap.entrySet()
             ) {
            sum = getSum(item, sum, specialA, specialA200, entry, entry.getKey().equals("A"), 5, 3, "A");
            sum = getSum(item, sum, specialB, entry, "B",2);
            sum = getSum(item, sum, entry, "C");
            sum = getSum(item, sum, entry, "D");
            sum = getSum(item, sum, entry, "E");
            sum = getSum(item, sum, entry, "F");
            sum = getSum(item, sum, entry, "G");

            sum = getSum(item, sum, specialH5, special10H, entry, matchMap.containsKey("H"), 10, 5, "H");
            sum = getSum(item, sum, entry, "I");
            sum = getSum(item, sum, entry, "J");

            sum = getSum(item, sum, special2K, entry, "K",2);
            sum = getSum(item, sum, entry, "L");
            sum = getSum(item, sum, entry, "M");
            sum = getSum(item, sum, entry, "N");
            sum = getSum(item, sum, special5P, entry, "P",5);
            sum = getSum(item, sum, special3Q, entry, "Q",3);
            sum = getSum(item, sum, entry, "R");
            sum = getSum(item, sum, entry, "S");
            sum = getSum(item, sum, entry, "T");
            sum = getSum(item, sum, entry, "U");
            sum = getSum(item, sum, special2V, special3V, entry, matchMap.containsKey("V"), 10, 5, "V");
            sum = getSum(item, sum, entry, "W");
            sum = getSum(item, sum, entry, "X");
            sum = getSum(item, sum, entry, "Y");
            sum = getSum(item, sum, entry, "Z");
        }

        return sum;
    }

    private int getSum(Map<String, Integer> item, int sum, int specialA, int specialA200, Map.Entry<String, Integer> entry, boolean a, int i2, int i3, String a2) {
        if (a) {
            if (entry.getValue() == i2) {
                sum = sum + specialA200;
            } else if (entry.getValue() > i2) {
                int round = Math.round(entry.getValue() / i2);
                sum = sum + round * specialA200;

                int bal = entry.getValue() % i2;
                if (bal >= i3) {

                    sum = sum + (bal / i3) * specialA;

                    // sum = sum +  Math.round(bal/3)*specialA;

                    sum = getSum(item, sum, bal % i3, a2);
                } else {
                    sum = getSum(item, sum, bal, "A");
                }

            } else if (entry.getValue() == i3) {
                sum = sum + specialA;
            } else if (entry.getValue() > i3 && entry.getValue() < i2) {

                sum = sum + specialA;
                int bal = entry.getValue() % i3;
                sum = getSum(item, sum, bal, a2);
            } else {
                sum = getSum(item, sum, entry.getValue(), a2);
            }
        }
        return sum;
    }

    private int getSum(Map<String, Integer> item, int sum, int specialB, Map.Entry<String, Integer> entry, String b,int value) {
        if (entry.getKey().equals(b)) {
            if (entry.getValue() == value) {
                sum = sum + specialB;
            } else if (entry.getValue() > value) {
                int round = Math.round(entry.getValue() / value);
                sum = sum + round * specialB;
                int bal = entry.getValue() % value;
                sum = getSum(item, sum, bal, b);

            } else {
                sum = getSum(item, sum, entry.getValue(), b);
            }

        }
        return sum;
    }

    private int getSum(Map<String, Integer> item, int sum, Map.Entry<String, Integer> entry, String c) {
        if (entry.getKey().equals(c)) {
            sum = getSum(item, sum, entry.getValue(), c);
        }
        return sum;
    }

    private int getSum(Map<String, Integer> item, int sum, Integer value, String f) {
        sum = sum + value * item.get(f);
        return sum;
    }

    public static void main(String[] args) {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        System.out.println(checkoutSolution.checkout("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        /*
        - {"method":"checkout","params":["ABCDEFGHIJKLMNOPQRSTUVWXYZ"],"id":"CHK_R4_033"}, expected: 965, got: 2455
 - {"method":"checkout","params":["UUUUU"],"id":"CHK_R4_056"}, expected: 160, got: 200
 - {"method":"checkout","params":["UUUUUUUU"],"id":"CHK_R4_057"}, expected: 240, got: 280

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
