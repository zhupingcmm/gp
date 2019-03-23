package com.func;

import com.Milk;
import com.YiLi;

public class YiLiFactory implements Factory {
    public Milk getMilk() {
        return new YiLi();
    }
}
