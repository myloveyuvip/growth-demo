package com.yuliyao.growthdemo.proxy.jdk.custom;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author yuliyao
 * @date 2018/12/31
 * 手写Proxy类，自己实现动态代理
 */
public class LYProxy {

    public static final String LS = "\n";

    /**
     * 创建代理实例
     * 1. 生成代理类在磁盘上
     * 2. 加载到jvm中，并返回
     * 3. 删除代理类
     *
     * @return
     */
    public static Object newProxyInstance(Class[] interfaces, LYInvocationHandler invocationHandler) {
        //1.生成代理类源码
        String srcCode = generateSrcCode(interfaces, invocationHandler);
        System.out.println(srcCode);
        //2.将源码存储在磁盘中
        try {
            String fileName = LYProxy.class.getResource("").getPath() + "$Proxy0.java";
            FileWriter fw = new FileWriter(fileName);
            fw.write(srcCode);
            fw.flush();
            fw.close();

            //3.将类编译成class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> javaFileObjects = manager.getJavaFileObjects(new File(fileName));
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, javaFileObjects);
            task.call();

            //4.删除磁盘中的类

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 生成代码类源码
     */
    private static String generateSrcCode(Class[] interfaces, LYInvocationHandler invocationHandler) {
        StringBuffer stringBuffer = new StringBuffer("package com.yuliyao.growthdemo.proxy.jdk.custom;").append(LS);
        stringBuffer.append("import java.lang.reflect.Method;").append(LS);
        stringBuffer.append("public class $Proxy0 implements ");
        for (Class anInterface : interfaces) {
            stringBuffer.append(anInterface.getName()).append(",");
        }
        stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(",")).append("{").append(LS);
        stringBuffer.append("private LYInvocationHandler h ;").append(LS);
        //1 构造函数
        stringBuffer.append("public $Proxy0 (LYInvocationHandler h){").append(LS);
        stringBuffer.append("this.h = h; ").append(LS);
        stringBuffer.append("}").append(LS).append(LS);
        //2 实现所有接口中的方法
        for (Class anInterface : interfaces) {
            for (Method method : anInterface.getMethods()) {
                stringBuffer.append("@Override").append(LS);
                stringBuffer.append("public ").append(method.getReturnType().getName()).append(" ").append(method
                        .getName()).append("()")
                        .append("{").append(LS);
                stringBuffer.append("Method m = null;").append(LS);
                stringBuffer.append("try {").append(LS);
                stringBuffer.append("m = ").append(anInterface.getName()).append(".class.getMethod(\"").append
                        (method.getName()).append("\",null);").append(LS);
                stringBuffer.append("} catch (NoSuchMethodException e) {\n" +
                        "e.printStackTrace();\n" +
                        "}");
                stringBuffer.append("this.h.invoke(m,this,null);")
                        .append(LS);
                stringBuffer.append("}").append(LS);
            }
        }

        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
