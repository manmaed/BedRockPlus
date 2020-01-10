package manmaed.bedrockplus.libs;

import manmaed.bedrockplus.libs.util.LogHelper;

/**
 * Created by manmaed on 23/07/2017.
 */
public class iChun {

    private static boolean devenv = false;
    private static boolean beta = false;
    private static boolean release = true;


    public static void setdev() {
        devenv = true;
        beta = false;
        release = false;

    }

    public static void RuniChunMagic() {
        if (release) {
            LogHelper.info("Lets hope it does not shoot fire and blow up");
            LogHelper.info("-iChun 2015");
            LogHelper.info("yes that is in evey mod manmaed makes!");
        }
        if (beta) {
            LogHelper.info("Lets hope it does not shoot fire and blow up");
            LogHelper.info("-iChun 2015");
            LogHelper.warn("This is a Beta Release so it may shoot fire and blow up!");
        }
        if (devenv) {

            LogHelper.fatal("If you can see this msg in a Release build manmaed forgot to turn the boolean off");
            LogHelper.fatal("Please Report This!");
        }
    }

}
