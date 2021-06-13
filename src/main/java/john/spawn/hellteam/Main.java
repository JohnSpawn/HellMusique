package john.spawn.hellteam;

import john.spawn.hellteam.exception.FileException;
import john.spawn.hellteam.file.UtilFile;

/**
 * Programme principal
 */
public class Main {

    /**
     * Fonction principale
     *
     * @param args
     * @throws FileException
     */
    public static void main(String[] args) throws FileException {
        UtilFile.getFile();
    }

}
