import java.util.*;
public class SmallestSufficientTeam_1125{

    public static  List<Integer> smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        // ( size , list ind)
        Map<Integer , List<Integer>> map = new HashMap<>();

        int minlen = 100;
        for(int i = 0 ; i< people.size(); i++){
            Set<String> set = new HashSet<>();
            List<Integer> list = new ArrayList<>();

            for(int j  = i ; j< people.size()  ; j++){
                for(String skill : people.get(j)){
                    set.add(skill);
                }
                list.add(j);
                if(set.size() == n){
                    minlen = Math.min(minlen , list.size());
                    map.put(list.size() , list);
                    break;

                }
            }
        }

        return map.get(minlen);
    }  





    public static void main(String[] args){
        // String[] req_skills = {"algorithms","math","java","reactjs","csharp","aws"};
        
        // List<List<String>> people  = new ArrayList<>();
        // people.add(Arrays.asList("algorithms","math","java" ));
        // people.add(Arrays.asList("algorithms","math","reactjs"));
        // people.add(Arrays.asList("java","csharp","aws"));
        // people.add(Arrays.asList("reactjs","csharp"));
        // people.add(Arrays.asList("csharp","math"));

        //  people.add(Arrays.asList("aws","java"));

        List<List<String>> people  = new ArrayList<>();
        people.add(Arrays.asList("java" ));
        people.add(Arrays.asList("nodejs"));
        people.add(Arrays.asList("nodejs","reactjs"));
        // people.add(Arrays.asList("reactjs","csharp"));
        // people.add(Arrays.asList("csharp","math"));

        //  people.add(Arrays.asList("aws","java"));





        String[] req_skills = {"java","nodejs","reactjs"};

        // people = [[],[],[]]


        System.out.println(smallestSufficientTeam(req_skills, people));
    }


}