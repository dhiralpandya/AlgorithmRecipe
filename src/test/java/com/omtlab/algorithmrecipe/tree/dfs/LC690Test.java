package com.omtlab.algorithmrecipe.tree.dfs;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class LC690Test {

    @Test
    public void getImportance() {
        LC690 lc690 = new LC690();

        LC690.Employee emp5 = new LC690.Employee();
        emp5.id = 5;
        emp5.importance = 10;

        LC690.Employee emp1 = new LC690.Employee();
        emp1.id = 1;
        emp1.importance = 5;
        emp1.subordinates = Lists.newArrayList(2, 3);

        LC690.Employee emp2 = new LC690.Employee();
        emp2.id = 2;
        emp2.importance = 3;
        emp2.subordinates = Lists.newArrayList(5);

        LC690.Employee emp3 = new LC690.Employee();
        emp3.id = 3;
        emp3.importance = 3;

        LC690.Employee emp4 = new LC690.Employee();
        emp4.id = 4;
        emp4.importance = 30;

        int totalImportance =
                lc690.getImportance(Lists.newArrayList(emp1, emp2, emp3, emp4, emp5), 1);

        Assertions.assertEquals(21, totalImportance);

    }
}