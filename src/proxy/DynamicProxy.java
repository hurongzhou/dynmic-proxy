package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler{

    //被代理的对象
    private Object object;

    /**
     * 传入需要代理的对象，并与object进行绑定
     * @param o 需要代理的对象
     * @return 返回接口对象
     */
    public Object bind(Object o){
        this.object=o;
        Class clazz=o.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("删除之前----");
        System.out.println(args[0]);
        //反射调用被代理对象执行的方法
        Object returnO=method.invoke(object,args);
        System.out.println("删除之后----");
        return returnO;
    }
}
