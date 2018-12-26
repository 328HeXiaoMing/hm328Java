import buyHouse.BuyHouse;
import buyHouse.BuyHouseDelegation;
import factory.ProxyFactory;
import findWife.FindWIfeDelegation;
import findWife.FindWife;
import org.junit.Test;

public class MainTest {
    @Test
    public void testProxyBuyHouse(){
        //创建委托类   买房业务
        BuyHouse buyHouse= new BuyHouseDelegation();
        //获取动态代理对象  输入接口方法
        BuyHouse buyHouseProxy = (BuyHouse) ProxyFactory.getProxy(buyHouse);
        buyHouseProxy.buyHouse();
    }

    @Test
    public void testProxyFindWife(){
        //创建委托类  找媳妇  输入接口方法
        FindWife findWife=new FindWIfeDelegation();
        //获取动态代理
        FindWife findWifeProxy= (FindWife) ProxyFactory.getProxy(findWife);
        findWifeProxy.findWife();
    }

    @Test
    public void testbuyHouseProxyOnlyInteger(){
        //买房业务   类似于mybatis   SqlSession.getMapper("    ")  没有委托类只有接口  输入接口类
        BuyHouse buyHouse = (BuyHouse) ProxyFactory.getProxyOnlyInterface(BuyHouse.class);
        buyHouse.buyHouse();
    }

    @Test
    public void testfindWifeProxyOnlyInteger(){
        //找媳妇业务  只有接口   输入接口类
       FindWife proxyOnlyInterface = (FindWife) ProxyFactory.getProxyOnlyInterface(FindWife.class);
       proxyOnlyInterface.findWife();
    }
}
