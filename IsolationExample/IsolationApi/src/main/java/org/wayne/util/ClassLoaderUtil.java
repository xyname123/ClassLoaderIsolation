package org.wayne.util;


import org.wayne.classloader.ClassLoaderFactory;
import org.wayne.classloader.SelfDefinedClassLoader;
import org.wayne.enums.EnvEnum;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ClassLoaderUtil {
    public static <T> T getPluginInstance(Class<T> type){
        EnvEnum env = EnvironmentUtil.getEnv();
        T t = ClassLoaderUtil.getPluginInstanceByEnvironment(type, env);
        return t;
    }

    public static <T> T getPluginInstanceByEnvironment(Class<T> type, EnvEnum envEnum){
        SelfDefinedClassLoader loader = ClassLoaderFactory.getSelfDefinedClassLoader(envEnum);
        Class<?> aClass = null;
        Object newInstance = null;
        try {
            aClass = loader.loadClass(type.getName());
            newInstance = aClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        T cast = type.cast(newInstance);
        return cast;
    }




    public static SelfDefinedClassLoader getSelfDefinedClassLoader(){
        EnvEnum env = EnvironmentUtil.getEnv();
        SelfDefinedClassLoader loader = ClassLoaderFactory.getSelfDefinedClassLoader(env);
        return loader;
    }

    public static String getRelativePath(EnvEnum envEnum){
//        System.out.println("getRelativePath");
        String[] strings = {
                "target",
                envEnum.toString(),
                envEnum.toString() + "_Driver_WithDenpendency.jar"
        };
        String collect = Arrays.stream(strings)
                .collect(Collectors.joining(File.separator));
        return collect;
    }

}
