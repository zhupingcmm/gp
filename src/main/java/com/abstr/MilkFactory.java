package com.abstr;

import com.MengNiu;
import com.Milk;
import com.Telunsu;
import com.YiLi;

public class MilkFactory extends AbstractFactory {
    public Milk getMengNiu() {
        return new MengNiu();
    }

    public Milk getYiLi() {
        return new YiLi();
    }

    public Milk getTelunsu() {
        return new Telunsu();
    }
}
