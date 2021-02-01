package com.omtlab.algorithmrecipe.tree.dfs;

import org.apache.commons.collections4.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 690. Employee Importance
 * <p>
 * You are given a data structure of employee information, which includes the employee's unique id, their importance value and their direct subordinates' id.
 * <p>
 * For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.
 * <p>
 * Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all their subordinates.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * Output: 11
 * Explanation:
 * Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 * <p>
 * <p>
 * Note:
 * <p>
 * One employee has at most one direct leader and may have several subordinates.
 * The maximum number of employees won't exceed 2000.
 */
public class LC690 {


    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> idToEmpMap = new HashMap<>();
        for (Employee emp : employees) {
            idToEmpMap.put(emp.id, emp);
        }
        return dfs(idToEmpMap, id);
    }

    private int dfs(Map<Integer, Employee> idToEmpMap, int id) {
        int totalImportance = idToEmpMap.get(id).importance;
        if (CollectionUtils.isNotEmpty(idToEmpMap.get(id).subordinates)) {
            for (Integer empId : idToEmpMap.get(id).subordinates) {
                totalImportance += dfs(idToEmpMap, empId);
            }
        }
        return totalImportance;
    }

    // Definition for Employee.
    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

}
