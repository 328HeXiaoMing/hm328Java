import findWife.FIndWifeProxy;
import findWife.FindWIfeDelegation;
import org.junit.Test;

public class TestFindWife {
    /**
     * 委托人自己做事!找媳妇!
     */
    @Test
    public void findWifeDoSelf(){
        FindWIfeDelegation findWIfeDelegation = new FindWIfeDelegation();
        findWIfeDelegation.findWife();
    }

    /**
     * 代理人接受委托人请求
     */
    @Test
    public void findWifeProxy(){
        FindWIfeDelegation findWIfeDelegation = new FindWIfeDelegation();
        FIndWifeProxy fIndWifeProxy = new FIndWifeProxy();
        //代理人收到委托人请求,并出面办事
          fIndWifeProxy.setFindWifeDelegation(findWIfeDelegation);
          fIndWifeProxy.findWife();
    }
}
