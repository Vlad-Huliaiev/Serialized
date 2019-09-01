package com.gmail.gulyaev4420;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class deSerializer {
    public static void deserializer(Object o, String p) {
        try (BufferedReader bf = new BufferedReader(new FileReader(new File(p)))) {
            String str = "";
            for (; (str = bf.readLine()) != null;) {
                String[] pair = str.split("/");
                Field fld = o.getClass().getDeclaredField(pair[0]);
                if (Modifier.isPrivate(fld.getModifiers())){
                    fld.setAccessible(true);
                }
                if (fld.isAnnotationPresent(Save.class)){
                    Write(o,fld,pair[1]);
                }
            }
        } catch (IOException | NoSuchFieldException  e) {
            e.printStackTrace();
        }
    }

    private static void Write(Object o, Field fld, String s) {
        try {
            if (fld.getType() == String.class) {
                fld.set(o, s);
            } else if (fld.getType() == int.class) {
                fld.set(o, Integer.parseInt(s));
            } else if (fld.getType() == long.class) {
                fld.set(o, Long.parseLong(s));
            } else if (fld.getType() == short.class) {
                fld.set(o, Short.parseShort(s));
            } else if (fld.getType() == boolean.class) {
                fld.set(o, Boolean.parseBoolean(s));
            }
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
