package com.WQL.pojo;

/*
 * @Author WQL-KXJ
 * @ProjectName SpringBoot-dome
 * @PackageName com.WQL.pojo
 * @Date 2024/3/19 15:05
 * @Version 1.0
 */
public class LaserRecognitionResult {

    private final Class<?> objectType;
    private final Object object;

    public LaserRecognitionResult(Class<?> objectType, Object object) {
        this.objectType = objectType;
        this.object = object;
    }

    public Class<?> getObjectType() {
        return objectType;
    }

    public Object getObject() {
        return object;
    }

}
