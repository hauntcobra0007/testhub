package ut.jp.co.kodnet.plugins.sample;

import org.junit.Test;
import jp.co.kodnet.plugins.sample.MyPluginComponent;
import jp.co.kodnet.plugins.sample.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}