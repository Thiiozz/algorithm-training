package fr.thiiozz.algorithm.unionfind;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractUFTest {
    protected UF uf;
    protected static final int NUMBER_OF_ELEMENTS = 10;
    protected List<String> unions = new ArrayList<>();

    protected void connect() {
        unions.forEach(
                u -> uf.union(
                        Integer.valueOf(u.split(",")[0]),
                        Integer.valueOf(u.split(",")[1])
                )
        );
    }
}
