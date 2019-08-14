import com.yuliyao.spi.java.Robot;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

/**
 * @author yuliyao
 * @date 2019/8/10
 */
public class DubboSpiTest {

    @Test
    public void testDubboSpiTest() {
        Robot bumblebee = ExtensionLoader.getExtensionLoader(Robot.class).getExtension("bumblebee");
        bumblebee.sayHello();
        Robot defaultExtension = ExtensionLoader.getExtensionLoader(Robot.class).getDefaultExtension();
        defaultExtension.sayHello();
        ExtensionLoader.getExtensionLoader(Robot.class).getLoadedExtensions();
    }

}
