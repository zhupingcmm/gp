package com.delegate.leader;

import java.util.HashMap;
import java.util.Map;

public class Leader implements ITTarget{

    private static Map<String, ITTarget> handlerMapping = new HashMap<String, ITTarget>();
    private static volatile Leader leader;


    static {
        handlerMapping.put("login", new TargetA());
        handlerMapping.put("security", new TargetB());
    }

    private Leader() {
    }

    public static synchronized Leader getInstance(){
        if(leader == null){
            leader = new Leader();
        }
        return leader;
    }
    public Object doing(String commond) {

        return handlerMapping.get(commond).doing(commond);
    }
}
