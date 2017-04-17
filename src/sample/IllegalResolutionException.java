package sample;

/**
 * Created by ChiChaChai on 17/4/2560.
 */
public class IllegalResolutionException extends Exception {

    private static String  except = "Wrong Resolution";
    public IllegalResolutionException() {
        super(except);

    }

}
