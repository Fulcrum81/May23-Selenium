package selenium.tests.page_objects.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Table {

    private WebElement table;

    public Table(WebElement table) {
        this.table = table;
    }

    public int getRowsCount() {
        List<WebElement> listOfRows = table.findElements(By.tagName("tr"));

        return listOfRows.size();
    }

    public int getColumnsCount() {
        WebElement headerRow = table.findElement(By.tagName("tr"));
        List<WebElement> listOfHeaders = headerRow.findElements(By.tagName("th"));

        return listOfHeaders.size();
    }

    public String getValueFromCell(int x, int y) {
        List<WebElement> listOfRows = table.findElements(By.tagName("tr"));

        WebElement cell = listOfRows.get(x).findElements(By.tagName("td")).get(y);

        return cell.getText();
    }
}
