import com.yuliyao.spi.java.Robot;
import org.junit.Test;

import java.util.ServiceLoader;

/**
 * @author yuliyao
 * @date 2019/8/10
 */
public class JavaSpiTest {

    @Test
    public void testJavaSpi() {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        serviceLoader.forEach(Robot::sayHello);

    }
}
