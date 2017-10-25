/**
 * Created by nimbekl on 6/14/17.
 */
import java.util.*;
public class trainingTheArmy {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int num_of_skill = in.nextInt();
        int num_of_Wizard = in.nextInt();
        HashMap<Integer, Integer> skill_mp = new HashMap<>();
        HashMap<Integer,ArrayList> wizard_mp= new HashMap<>();
        int totalSkills = 0;
        for(int i = 1 ;i<=num_of_skill;i++){
            skill_mp.put(i,in.nextInt());
        }
        for(int i=0;i<num_of_Wizard;i++){
            ArrayList<ArrayList> lst = new ArrayList<>();
            int totalA = in.nextInt();
            ArrayList<Integer> lstA = new ArrayList<>();
            for(int j=0;j<totalA;j++){
                lstA.add(in.nextInt());
            }
            int totalB = in.nextInt();
            ArrayList<Integer> lstB = new ArrayList<>();
            for(int j=0;j<totalB;j++){
                lstB.add(in.nextInt());
            }
            lst.add(lstA);
            lst.add(lstB);
            wizard_mp.put(i,lst);
        }
        for (Map.Entry<Integer, ArrayList> entryWiz : wizard_mp.entrySet()) {
            ArrayList<ArrayList> lst = (ArrayList) entryWiz.getValue();
            ArrayList<Integer> lstA = (ArrayList) lst.get(0);
            lstA = sortlstA(lstA,skill_mp);
            ArrayList<Integer> lstB = (ArrayList) lst.get(1);
            lstB = sortlstB(lstB,skill_mp);
            Iterator itA = lstA.iterator();
                while (itA.hasNext() && lstB.size()!=0) {
                    Iterator itB = lstB.iterator();
                    int nextA = (int) itA.next();
                    int countOfSkillA = skill_mp.get(nextA);
                    if (countOfSkillA != 0) {
                        int nextB = (int) itB.next();
                        int countOfSkillB = skill_mp.get(nextB);
                        skill_mp.put(nextA, countOfSkillA - 1);
                        skill_mp.put(nextB, countOfSkillB + 1);
                        itA.remove();
                        itB.remove();
                    }
                }
            }

        for (Map.Entry<Integer, Integer> entry : skill_mp.entrySet())
        {
            if(entry.getValue() != 0){
                totalSkills++;
            }
        }
        System.out.println(totalSkills);
    }

    protected static ArrayList sortlstA(ArrayList<Integer> lstA, HashMap<Integer, Integer> skill_mp){
        Comparator<Integer> comp = (Integer a, Integer b) -> {
        return skill_mp.get(b).compareTo(skill_mp.get(a));
        };
        Collections.sort(lstA, comp);
        return lstA;
        }

    protected static ArrayList sortlstB(ArrayList<Integer> lstB, HashMap<Integer, Integer> skill_mp){
        Comparator<Integer> comp = (Integer a, Integer b) -> {
        return skill_mp.get(a).compareTo(skill_mp.get(b));
        };
        Collections.sort(lstB, comp);
        return lstB;
        }
}
