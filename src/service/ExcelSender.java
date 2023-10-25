package service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import classes.User;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class ExcelSender {
    public void generateExcel(TableView<User> tableView) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Excel");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Excel Files", "*.xlsx")
        );
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Sheet1");

            // Create header row
            Row headerRow = sheet.createRow(0);
            String[] headers = {
                "Username", "Email", "Mot de passe", "Role",
                "Image", "Age", "Sexe"
            };

            for (int i = 0; i < headers.length; i++) {
                Cell headerCell = headerRow.createCell(i);
                headerCell.setCellValue(headers[i]);
            }

            // Get the data from the TableView
            List<User> data = tableView.getItems();

            // Add data rows
            for (int i = 0; i < data.size(); i++) {
                Row row = sheet.createRow(i + 1); // Start from row 1 (skip header)

                User user = data.get(i);
                String[] values = {
                    user.getUsername(),
                    user.getMail(),
                    user.getMdp(),
                    user.getRole(),
                    user.getImage(),
                    Integer.toString(user.getAge()),
                    user.getSexe()
                };

                for (int j = 0; j < values.length; j++) {
                    Cell cell = row.createCell(j);
                    cell.setCellValue(values[j]);
                }
            }

            try (FileOutputStream fileOut = new FileOutputStream(file)) {
                workbook.write(fileOut);
                workbook.close();
                System.out.println("Excel generated successfully.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
