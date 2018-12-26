import buyHouse.BuyHouse;
import buyHouse.BuyHouseDelegation;
import buyHouse.BuyHouseProxy;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestBuyHouse {
    @Test
    public void testDoSelfBuyHouse(){  //委托人自己买房
        //创建委托人对象
        BuyHouseDelegation buyHouseDelegation = new BuyHouseDelegation();
         buyHouseDelegation.buyHouse();
    }

    @Test
    public void testDoProxy(){  //代理人购买
        BuyHouseDelegation buyHouseDelegation = new BuyHouseDelegation();
        BuyHouseProxy buyHouseProxy = new BuyHouseProxy();
        //委托人向代理人提需求  获取连接
        buyHouseProxy.setBuyHouseDelegation(buyHouseDelegation);
        //委托人出面买房
        buyHouseProxy.buyHouse();
    }

    /**
     * 动态代理技术 获取代理对象
     */
    @Test
    public void testDynamicProxy(){
        //委托人
        BuyHouse buyHouse=new BuyHouseDelegation();
       //获取动态代理对象
        BuyHouse proxyObj =(BuyHouse) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{BuyHouse.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result=null;
                //代理类执行额外服务
                System.out.println("请支付服务费2000元");
                //执行委托人请求
                 result= method.invoke(buyHouse, args);
                System.out.println("出卖个人信息");
                return result;
            }
        });
        proxyObj.buyHouse();
    }
}
