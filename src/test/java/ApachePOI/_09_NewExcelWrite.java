package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _09_NewExcelWrite {
    public static void main(String[] args) throws IOException {

        // hafızada  yeni workbook oluştur, sonra sheet oluştur, sonra row oluştur, sonra cell oluştur.
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Sayfa1");

        // HAFIZADA oluşturma ve yazma işlemelri yapılıyor
        Row yeniSatir= sheet.createRow(0); // satır oluşturuldu 0.yerde
        Cell yeniHucre= yeniSatir.createCell(0); // yeni satırda ilk hucre oluşturuldu
        yeniHucre.setCellValue("Merhaba Dünya"); // bilgi yazıldı.

        for (int i = 1; i < 10 ; i++) {
            yeniSatir.createCell(i).setCellValue(i);
        }

        // Yazma işlemini YAZMA modunda açıp öyle yapacağız.
        String yeniExcelPath="src/test/java/ApachePOI/resource/YeniExcel.xlsx";
        FileOutputStream outputStream=new FileOutputStream(yeniExcelPath);
        workbook.write(outputStream);
        workbook.close();  // hafıza boşaltıldı
        outputStream.close();
        System.out.println("işlem tamamlandı");
    }
}
