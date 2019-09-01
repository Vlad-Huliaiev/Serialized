package com.gmail.gulyaev4420;

import java.io.FileWriter;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

class Serializer {
    public static void serializer(Object o, String p) {
        Class<?> cls = o.getClass();
        StringBuilder sb = new StringBuilder();

        Field[] fields = cls.getDeclaredFields();

        for (Field f : fields) {
            if (!f.isAnnotationPresent(Save.class)) {
                continue;
            }
            if (Modifier.isPrivate(f.getModifiers())) {
                f.setAccessible(true);
            }

            sb.append(f.getName() + "=");
            try {
                if (f.getType() == String.class) {
                    sb.append((String) f.get(o));
                } else if (f.getType() == int.class) {
                    sb.append(f.getInt(o));
                } else if (f.getType() == boolean.class) {
                    sb.append(f.getBoolean(o));
                } else if (f.getType() == long.class) {
                    sb.append(f.getLong(o));
                }
                sb.append(";");
            } catch (IllegalAccessException d) {
                d.printStackTrace();
            }
        }
        try (FileWriter pw = new FileWriter(p)) {
            pw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
