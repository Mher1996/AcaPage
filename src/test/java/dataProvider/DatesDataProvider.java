package dataProvider;

import base.Helper;
import org.testng.annotations.DataProvider;

public class DatesDataProvider {
    @DataProvider(name = "InvalidEmails")
    public Object[][] invalidEmails() {
        return new Object[][]{

                {"asb@"},
                {"@asb"},
                {"asb"},
                {"asb.com"},
                {".acb@com"}
        };
    }

    @DataProvider(name = "Indexes")
    public Object[][] indexProvider() {
        int bound=5;
        Helper helper = new Helper();
        return helper.index(bound);
    }

}

