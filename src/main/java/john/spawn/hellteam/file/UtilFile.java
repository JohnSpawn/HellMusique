package john.spawn.hellteam.file;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import john.spawn.hellteam.bean.BeanFile;
import john.spawn.hellteam.exception.FileException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Classe récupérant les fichiers
 */
public class UtilFile {

    /**
     * Constructor (not used)
     */
    private UtilFile(){}

    /**
     * Récupération d'un fichier
     *
     * @throws FileException Erreur sur le fichier
     */
    public static void getFile() throws FileException {

        List<BeanFile> beansFile = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(UtilFile.getProperty().getProperty("fileCsv.path")))) {
            List<String[]> lines = reader.readAll();

            lines.forEach(line -> {
                String[] bean = Arrays.toString(line).split(";");
                beansFile.add(addNewBean(bean));
            });

        } catch (FileException ex) {
            throw new FileException(ex.getMessage());
        } catch (FileNotFoundException ex) {
            throw new FileException("Fichier csv non trouvé : " + ex.getMessage());
        } catch (IOException e) {
            throw new FileException(("Erreur de récupéraiton du fichier csv"));
        } catch (CsvException ex) {
            throw new FileException("Erreur de parsing du fichier csv");
        }
    }

    /**
     * Récupération d'un fichier de propriétés
     *
     * @return Fichier de propriétés
     * @throws FileException Erreur sur les fichiers
     */
    public static Properties getProperty() throws FileException {

        try (InputStream inputStream = new FileInputStream("src/main/resources/properties/file.properties")) {

            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;

        } catch (FileNotFoundException ex) {
            throw new FileException("Fichier de proprietes de fichier non trouvé : " + ex.getMessage());
        } catch (IOException ex) {
            throw new FileException(("Erreur de récupération du fichier de propriétés de fichier : " + ex.getMessage()));
        }
    }

    /**
     * Valorisation d'un nouveau bean
     *
     * @param bean Bean à valoriser
     * @return Bean valorisé
     */
    private static BeanFile addNewBean(String[] bean) {
        BeanFile beanFile = new BeanFile();
        beanFile.setTitle(bean[0]);
        beanFile.setAlbum(bean[1]);
        beanFile.setInterpret(bean[2]);
        return beanFile;
    }

}
