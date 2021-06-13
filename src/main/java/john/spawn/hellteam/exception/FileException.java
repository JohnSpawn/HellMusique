package john.spawn.hellteam.exception;

/**
 * Erreurs sur les fichiers
 */
public class FileException extends Exception{

    /**
     * Erreur sur fichier
     *
     * @param message Message d'erreur
     */
    public FileException(String message){
        super(message);
    }

}
