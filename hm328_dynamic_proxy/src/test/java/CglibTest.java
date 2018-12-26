import cglib.Book;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;

public class CglibTest {
    /**
     * cglib 动态代理  只有类 没有接口
     */
    @Test
    public void testCglib(){
     //创建委托类
        Book book = new Book();
        //获取动态代理类对象
        Book bookProxy = (Book) Enhancer.create(book.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object result = null;
                //在原有逻辑之前执行
                System.out.println("执行之前");
                //执行原有方法
                result = method.invoke(book, objects);
                //在原有逻辑之后执行
                System.out.println("执行之后");
                return result;
            }
        });
        bookProxy.addBook();
    }
}
