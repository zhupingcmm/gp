package com.func;

import com.MengNiu;
import com.Milk;

public class MengNiuFactory implements Factory {
    public Milk getMilk() {
        return new MengNiu();
    }
}
