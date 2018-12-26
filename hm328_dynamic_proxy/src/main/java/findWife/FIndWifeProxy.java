package findWife;

/**
 * 代理类  接收委托类请求
 */
public class FIndWifeProxy implements FindWife {
    //将委托人请求传递给代理人
    private FindWife findWifeDelegation;

    /**
     * 实现set方法  为外部提供使用窗口
     * @param findWifeDelegation
     */
    public void setFindWifeDelegation(FindWife findWifeDelegation) {
        this.findWifeDelegation = findWifeDelegation;
    }

    @Override
    public void findWife() {
        System.out.println("请交注册费!");
        findWifeDelegation.findWife();
        System.out.println("恭喜你,配对成功!祝你们恩爱白头,早生贵子!");
    }
}
