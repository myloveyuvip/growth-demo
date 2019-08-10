import com.yuliyao.spi.adaptive.AdaptiveExt;
import com.yuliyao.spi.adaptive.Car;
import com.yuliyao.spi.adaptive.CarMaker;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

/**
 * @author yuliyao
 * @date 2019/8/10
 */
public class AdaptiveTest {

    @Test
    public void testAdaptive() {
        ExtensionLoader<AdaptiveExt> extensionLoader = ExtensionLoader.getExtensionLoader(AdaptiveExt.class);

        AdaptiveExt adaptiveExtension = extensionLoader.getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test?adaptiveName=springboot");
        adaptiveExtension.sayHello("d",url);


    }

    @Test
    public void testAdaptiveSet() {
        ExtensionLoader<CarMaker> extensionLoader = ExtensionLoader.getExtensionLoader(CarMaker.class);
        CarMaker adaptiveExtension = extensionLoader.getExtension("raceCar");
        Car car = adaptiveExtension.makeCar(URL.valueOf("test://localhost?wheel.maker=michelin"));
        System.out.println(car);
    }
}
