/**
* Author:  Yawo Amegadje
* Function: This class contains a very basic method that create a hard-pause. 
* Will not be used often but in rare cases. I used it this project for demo purpose
* ( to slow down some parts so that User to view results on browser)
*/
package com.omgeo.automationdemo;

import org.openqa.selenium.WebDriver;

public class Pause {

    public static void pause(WebDriver driver, int sec) throws Exception {
        Thread.sleep(sec * 1000);
    }
}
