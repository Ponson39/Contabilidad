/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author alex-arch
 */
public class PUC {
    public XSSFSheet PUC() throws IOException{
        XSSFSheet sheet = null;
        try {
            XSSFWorkbook wb = new XSSFWorkbook(
                    new FileInputStream("src/main/java/resources/PUC.xlsx"));
            sheet = wb.getSheet("PUC");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PUC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sheet;
    }
}
