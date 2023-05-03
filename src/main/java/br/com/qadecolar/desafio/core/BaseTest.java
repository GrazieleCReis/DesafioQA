package br.com.qadecolar.desafio.core;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    @Rule
    public TestName testName = new TestName();

    @After
    public void finalizar() throws IOException {
        TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
        File file = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("target/screenshot/" +
               testName.getMethodName() + ".jpg"));

        if(Propriedades.FECHAR_BROWSER) DriverFactory.killDriver();
    }
}
