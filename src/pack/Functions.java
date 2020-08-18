package pack;

import java.util.*;

public class Functions {

    public HashMap<String, ArrayList<Object>> table = new HashMap<>();
    public ArrayList<Object> exceptions = new ArrayList<>();

    public void initList(String list) {
        table.put(list, new ArrayList<Object>());
    }

    public void update(String list, int index, Object val) {
        ArrayList<Object> L = (ArrayList<Object>)table.get(list);
        L.set(index, val);
    }

    public void addToList(String list, Object val) {
        ArrayList<Object> L = (ArrayList<Object>)table.get(list);
        L.add(val);
    }

    public ArrayList<Object> concatenate(ArrayList<Object> list1, ArrayList<Object> list2) {
        ArrayList<Object> res = new ArrayList<>();
        res.addAll(list1);
        res.addAll(list2);
        return res;
    }

    public void assignSlice(String list, String slice_list, String start, String end) {
        ArrayList<Object> S = table.get(slice_list);
        int st = 0;
        int en = S.size();
        if (start != null) {
            st = Integer.parseInt(start);
        }
        if (end != null) {
            en = Integer.parseInt(end);
        }
        ArrayList<Object> res = new ArrayList<>();
        for (int i=st; i<en; i++) {
            res.add(S.get(i));
        }
        table.put(list, res);
    }

    public boolean checkList(ArrayList<Object> L) {
        int n = L.size();
        for (int i=0; i<n; i++) {
            if (!(L.get(i) instanceof Integer)) {
                return false;
            }
        }
        return true;
    }

    public boolean isInteger(String s) {
        int n = s.length();
        for (int i=0; i<n; i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public void listComprehension(String list, String forList, ArrayList<Boolean> result) {
        ArrayList<Object> forL = table.get(forList);
        ArrayList<Object> res = new ArrayList<>();
        int n = forL.size();
        for (int i=0; i<n; i++) {
            if (result.get(i)) {
                res.add(forL.get(i));
            }
        }
        table.put(list, res);
    }

    public ArrayList<Boolean> logicBinaryEvaluate(ArrayList<Boolean> res1, ArrayList<Boolean> res2, String op) {
        ArrayList<Boolean> result = new ArrayList<>();
        int n = res1.size();
        for (int i=0; i<n; i++) {
            if (op.equals("and")) {
                result.add(res1.get(i) && res2.get(i));
            }
            else if (op.equals("or")) {
                result.add(res1.get(i) || res2.get(i));
            }
        }
        return result;
    }

    public ArrayList<Boolean> logicUnaryEvaluate(ArrayList<Boolean> res1, String op) {
        ArrayList<Boolean> result = new ArrayList<>();
        int n = res1.size();
        for (int i=0; i<n; i++) {
            if (op.equals("not")) {
                result.add(!(res1.get(i)));
            }
        }
        return result;
    }



    public ArrayList<Boolean> comparison(String list, String op1, String op2, String op, String x) {
        ArrayList<Object> L = table.get(list);
        ArrayList<Boolean> result = new ArrayList<>();
        int n = L.size();
        for (int i=0; i<n; i++) {
            boolean condition = false;
            if (isInteger(op1) && isInteger(op2)) {
                if (Integer.parseInt(op1) != Integer.parseInt(op2)) {
                    result.add(false);
                }
                else {
                    result.add(true);
                }
                continue;
            }
            else if (!isInteger(op1) && isInteger(op2)) {
                int num = Integer.parseInt(op2);
                if (!op1.equals(x)) {
                    System.out.println("Unknown variable " + op1 + ". Did you mean " + x);
                    result.add(false);
                }
                else if (!checkList(L)) {
                    System.out.println("List is not list of integers.");
                    result.add(false);
                }
                else if (op.equals("==")) {
                    result.add((int)L.get(i) == num);
                }
                else if (op.equals("!=")) {
                    result.add((int)L.get(i) != num);
                }
                else if (op.equals("<")) {
                    result.add((int)L.get(i) < num);
                }
                else if (op.equals("<=")) {
                    result.add((int)L.get(i) <= num);
                }
                else if (op.equals(">")) {
                    result.add((int)L.get(i) > num);
                }
                else if (op.equals(">=")) {
                    result.add((int)L.get(i) >= num);
                }
            }
            else if (isInteger(op1) && !isInteger(op2)) {
                int num = Integer.parseInt(op1);
                if (!op2.equals(x)) {
                    System.out.println("Unknown variable " + op2 + ". Did you mean " + x);
                    result.add(false);
                }
                else if (op.equals("==")) {
                    result.add((int)L.get(i) == num);
                }
                else if (op.equals("!=")) {
                    result.add((int)L.get(i) != num);
                }
                else if (op.equals("<")) {
                    result.add((int)L.get(i) > num);
                }
                else if (op.equals("<=")) {
                    result.add((int)L.get(i) >= num);
                }
                else if (op.equals(">")) {
                    result.add((int)L.get(i) < num);
                }
                else if (op.equals(">=")) {
                    result.add((int)L.get(i) <= num);
                }
            }
            else {
                if (op1.equals(x) && op1.equals(op2) ) {
                    result.add(true);
                }
                else {
                    result.add(false);
                }
            }
        }
        return result;
    }

    public void printList(String list) {
        System.out.println(list + " is " + table.get(list));
    }


}
