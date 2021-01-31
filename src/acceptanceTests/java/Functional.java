import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Created by drekerd (Mário Silva) or 10/01/2021
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        monochrome = true,
        features = {
                "src/acceptanceTests/features"
        },
        glue = {"com.drekerd.papitest"},
        tags = {
                "@GetProduct"
        }
)
public class Functional {
}
