/**
 * 
 */
package org.syl.inaction.pattern.proxy.dynamic2;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

/**
 * 解释了代理原理<br/>
 * 生成动态代理类的Proxy静态类：代理产生器，根据传进来的参数Class Intface和InvocationHandler h，产生动态代理类；从而使intface中的所有方法都加上了h中invoke方法的自定义逻辑；为了便于代理类的组合和扩展，代理类也会实现Intface接口，最终返回一个代理类对象；
 * @author megapro
 *
 */
public class Proxy {
	public static Object newInstance(Class intface,InvocationHandler h) throws Exception {
        /*Generate the source code*/
        String rt = "\r\n";
        String methodStr = "";
        for (Method method:intface.getMethods()) {
            methodStr +=
            "    @Override"+rt+
            "    public void "+ method.getName() +"() {"+rt+
            "        try{"+rt+
            "            Method m = "+ intface.getName()+".class.getMethod(\""+ method.getName() +"\");" + rt+
            "            h.invoke(tank,m);"+rt+
            "        }catch(Exception e){e.printStackTrace();}"+rt+
            "    }"+rt
            ;
        }
        String src = 
            "package com.zec.disignmode;"+rt+
            "import java.util.Random;"+rt+
            "import java.lang.reflect.*;"+rt+
            "public class TankTimeProxy implements "+ intface.getName() +"{"+rt+
            "    "+ intface.getName() +" tank;"+rt+
            "    com.zec.disignmode.InvocationHandler h;"+rt+
            "    public TankTimeProxy("+ intface.getName() +" t,com.zec.disignmode.InvocationHandler h) {"+rt+
            "        tank = t;"+rt+
            "        this.h = h;"+rt+
            "    }"+rt+
            methodStr+
            "}";
        /*Generate the java file*/
        String fileName = System.getProperty("user.dir")+"/src/com/zec/disignmode/TankTimeProxy.java";
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(src);
        fw.flush();
        fw.close();
        /*Generate the class file*/
        JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager jfMgr = jc.getStandardFileManager(null, null, null);
        Iterable units = jfMgr.getJavaFileObjects(fileName);
        CompilationTask ct =  jc.getTask(null, jfMgr, null, null, null, units);
        ct.call();
        jfMgr.close();
        /*Load the class into the memory*/
        URL[] urls = new URL[]{new URL("file:/"+System.getProperty("user.dir")+"/src")};
        URLClassLoader urlLoader = new URLClassLoader(urls);
        Class c = urlLoader.loadClass("com.zec.disignmode.TankTimeProxy");
        /*Generate the object*/
        Constructor constructor = c.getConstructor(IMoveable.class,InvocationHandler.class);
        Object moveable = constructor.newInstance(new Tank(),h);
        return moveable;
    }
}
