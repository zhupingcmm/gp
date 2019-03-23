package com.func;

import com.Milk;
import com.Telunsu;

public class TelunsuFactory implements Factory {
    public Milk getMilk() {
        return new Telunsu();
    }
}
