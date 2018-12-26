package factory;

import buyHouse.BuyHouse;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂类
 */
public class ProxyFactory {

    /**
     * 动态代理技术获取代理对象
     * @param obj
     * @return
     */
public static Object getProxy(Object obj){
    //获取动态代理对象
   return Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(),obj.getClass().getInterfaces(), new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result=null;
     //判断当前动态代理调用的接口方法
            // 获取当前method所属的接口类路径
            String className = method.getDeclaringClass().getName();
            //获取当前调用执行的方法名
            String methodName = method.getName();

            //执行条件判断
            if("buyHouse.BuyHouse".equalsIgnoreCase(className)){
                if("buyHouse".equalsIgnoreCase(methodName)){
                    //说明当前调用的是买房buyHouse的接口方法
                    System.out.println("我是房屋中介,请支付服务费2000元");
                    result= method.invoke(obj, args);
                    System.out.println("出卖委托人信息到互联网,卖了三分钱");
                }
            }
            if("findWife.FindWife".equalsIgnoreCase(className)){
                if("findWife".equalsIgnoreCase(methodName)){
                    //说明当前调用的是找媳妇findWife接口方法
                    System.out.println("我是婚姻中介,请缴纳服务费2000元");
                    result = method.invoke(obj, args);
                    System.out.println("出卖婚姻双方信息到互联网,卖了三毛钱");
                }
            }
            return result;
        }
    });
}

    /**
     * 只有接口类,没有实现类,返回代理对象完成功能
     * @param intf  接口类
     * @return
     */
  public static Object getProxyOnlyInterface(Class intf){
    return Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(), new Class[]{intf}, new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result=null;
            //判断当前动态代理调用的接口方法
            // 获取当前method所属的接口类路径
            String className = method.getDeclaringClass().getName();
            //获取当前调用执行的方法名
            String methodName = method.getName();

            //执行条件判断
            if("buyHouse.BuyHouse".equalsIgnoreCase(className)){
                if("buyHouse".equalsIgnoreCase(methodName)){
                    //说明当前调用的是买房buyHouse的接口方法
                    System.out.println("我是房屋中介,请支付服务费2000元");
                    //result= method.invoke(obj, args);
                    System.out.println("寻找房源");
                    System.out.println("商家谈判");
                    System.out.println("房屋过户");
                    System.out.println("出卖委托人信息到互联网,卖了三分钱");
                }
            }
            if("findWife.FindWife".equalsIgnoreCase(className)){
                if("findWife".equalsIgnoreCase(methodName)){
                    //说明当前调用的是找媳妇findWife接口方法
                    System.out.println("我是婚姻中介,请缴纳服务费2000元");
                    //result = method.invoke(obj, args);
                    System.out.println("上网填信息");
                    System.out.println("网上咨询");
                    System.out.println("面试相亲");
                    System.out.println("举办婚礼");
                    System.out.println("送入洞房");
                    System.out.println("出卖婚姻双方信息到互联网,卖了三毛钱");
                }
            }
            return result;
        }
    });
  }
}
