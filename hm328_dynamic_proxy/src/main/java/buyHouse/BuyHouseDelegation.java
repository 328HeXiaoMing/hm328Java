package buyHouse;


/**
 * 委托人
 */
public class BuyHouseDelegation implements BuyHouse {
    @Override
    public void buyHouse() {
        System.out.println("寻找房源");
        System.out.println("商家谈判");
        System.out.println("房屋过户");
    }
}
