package hooks;

import io.cucumber.java.Before;


import static base_urls.MedunnaBaseUrl.medunnaSetUp;

public class Hooks {//medunnaSetUp() mehodu calıssın diye bu hooks actık
    @Before("@TC01_Api")//tag koyarsak hangisinin once calısacagını soyleriz
    public void beforeApi(){
        medunnaSetUp();
    }
}
