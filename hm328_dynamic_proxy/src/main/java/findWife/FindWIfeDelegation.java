package findWife;

/**
 * 委托人  找媳妇
 */
public class FindWIfeDelegation  implements FindWife {
    @Override
    public void findWife() {
        System.out.println("上网填信息");
        System.out.println("网上咨询");
        System.out.println("面试相亲");
        System.out.println("举办婚礼");
        System.out.println("送入洞房");
    }
}
