package org.wayne.util;


import org.wayne.enums.EnvEnum;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ClassLoaderUtil {

    public String getModuleName(EnvEnum envEnum){
        String[] strings = {
                "target",
                envEnum.getEnv(),
                envEnum.getEnv() + "_Driver_WithDenpendency.jar"
        };
        String collect = Arrays.stream(strings)
                .collect(Collectors.joining(File.separator));
        return collect;
    }

}
