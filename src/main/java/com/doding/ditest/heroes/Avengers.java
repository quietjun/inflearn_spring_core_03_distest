package com.doding.ditest.heroes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Avengers {
    IronMan iman;
    Hulk hulk;
    HulkBuster hb;

    // @Autowired // 생성자가 하나만 있는 경우는 생략 가능
    public Avengers(@Qualifier("ironMan") IronMan iman, Hulk hulk) {
        this.iman = iman;
        this.hulk = hulk;
    }

    @Autowired
    public void setHulkBuster(HulkBuster hb) {
        this.hb = hb;
    }
}
