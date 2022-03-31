package com.example.example_nav;

import android.app.Application;

import java.lang.reflect.Array;
import java.util.List;

public class MyApplication extends Application {
    List<String[]> accList;

    public List<String[]> getAccList() {
        return accList;
    }

    public void addAccList(String usr, String psw) {
        accList.add(new String[] {usr, psw});
    }

    public boolean checkAccList(String usr, String psw) {
        for (String[] acc: accList) {
            if (acc[0].equals(usr) && acc[1].equals(psw)) return true;
        }
        return false;
    }
}
