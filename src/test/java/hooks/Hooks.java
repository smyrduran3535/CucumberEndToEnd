package hooks;

import io.cucumber.java.Before;


import static base_urls.MedunnaBaseUrl.medunnaSetUp;
import static base_urls.MedunnaBaseUrl.sdmedunnaSetUp;

public class Hooks {//medunnaSetUp() mehodu calıssın diye bu hooks actık
    @Before()//tag koyarsak hangisinin once calısacagını soyleriz
    public void beforeApi(){
        sdmedunnaSetUp();
    }
}
