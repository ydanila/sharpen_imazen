package sharpen.ui.tests;

import org.junit.Test;
import sharpen.core.Configuration;

public class MappingsTestCase extends AbstractConversionTestCase {

    @Test
    public void testRemovedConstructor() throws Throwable {
        runResourceTestCase("mappings/RemovedConstructor");
    }

    @Override
    protected Configuration getConfiguration() {
        final Configuration config = super.getConfiguration();
        config.mapMethod("mappings.Foo.Foo", "");
        return config;
    }

}
