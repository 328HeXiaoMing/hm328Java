package buyHouse;


/**
 * 代理人
 */
public class BuyHouseProxy implements BuyHouse {
    //接受委托人的强请求  与委托人达成协议
    private BuyHouse buyHouseDelegation;

    //给委托人提供接口  服务窗口  set方法
    public void setBuyHouseDelegation(BuyHouse buyHouseDelegation) {
        this.buyHouseDelegation = buyHouseDelegation;
    }

    @Override
    public void buyHouse() {
        System.out.println("请先交服务费10000元");
        buyHouseDelegation.buyHouse();
        System.out.println("将信息卖到互联网");
    }
}
