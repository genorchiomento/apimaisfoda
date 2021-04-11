package io.com.github.gginformatica.apimaisfoda;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public abstract class ApimaisfodaApplicationTests {

    @Before
    public abstract void init();

    @Before
    public void setUp() {
        FixtureFactoryLoader.loadTemplates("io.com.github.gginformatica.apimaisfoda");
    }

}
