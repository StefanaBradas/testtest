package tests;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class UserCreate {


    public String name;
    public String email;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    public static UserCreate getSpecificUser (int num) {
        UserCreate user= new UserCreate();
        try {
//            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("C:\\test.xlsx"));

            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("C:\\Users\\stefana.bradas\\IdeaProjects\\Projekat1\\src\\test\\resources\\Pera Peric.xlsx"));
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            XSSFRow row = sheet.getRow(num - 1);



            user.setName(row.getCell(0).getStringCellValue());
            user.setEmail(row.getCell(1).getStringCellValue());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }


}
