package com.yuliyao.growthdemo.proxy.jdk.custom;

import java.io.*;

/**
 * @author yuliyao
 * @date 2019/1/6
 * 将磁盘中的类加载到jvm中
 */
public class LYClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String baseDir = this.getClass().getResource("").getPath();
        File file = new File(baseDir, name + ".class");
        String className = LYClassLoader.class.getPackage().getName() + "." + name;
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                byte[] bytes = new byte[1024];
                int len;
                while ((len=fileInputStream.read(bytes)) != -1) {
                    out.write(bytes, 0, len);
                }
                return defineClass(className, out.toByteArray(), 0, out.size());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

}
