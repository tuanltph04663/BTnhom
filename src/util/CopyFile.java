package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author RZ09
 */
public class CopyFile {

    public void copyFile(String sourcePath, String savePath, String fileName) throws IOException {
        InputStream input;
        OutputStream output;

        try {
            input = new FileInputStream(sourcePath);
            output = new FileOutputStream(savePath + fileName);

            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }

            output.close();
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

}
