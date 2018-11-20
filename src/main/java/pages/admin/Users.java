package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * @author: habin,
 * created on: 31/10/18 : 10:39 AM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Users extends SettingsPage {

    public Users(String username, String password) {
        super(username, password);
        clickUsersTab();
        PageFactory.initElements(driver, this);
    }

    protected String getUserName(String email) {
        WebElement element = driver.findElement(By.xpath("//div[@title='" + email + "']/parent::div/div[1]"));
        return element.getAttribute("title");
    }


    private boolean lastRecordVisibility()
    {
        try{
            WebElement lastRecord = driver.findElement(By.xpath("//div[@class='UsersManagerPage__noRecords___dy_tt']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastRecord);
            return true;}
        catch (Exception e){return false;}
    }

    //To be done
//    private void verifyRoleAdded(String email, String role){
//        WebElement roleAssigned = driver.findElement(By.xpath("//div[@title='" + email + "']/parent::div/parent::div/div[2]//span[@title ='"+role+"']"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", roleAssigned);
//        verifyText(roleAssigned.getAttribute("role"),role);
//    }

    protected void assignRole(String email, String assignRole) throws InterruptedException {
        try {
            for(int i=1;i<10;i++)
            {
                List<WebElement> usersList = driver.findElements(By.xpath("//div[@class='UsersManagerPage__userBox___1WIjO']"));
                int count = usersList.size();
                System.out.println(count);

                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", usersList.get(count - 1));
                ((JavascriptExecutor) driver).executeScript("window.scroll(0, 4800)");
                Thread.sleep(500);
                if(lastRecordVisibility()){
                    break;
                }
            }
            WebElement addRole = driver.findElement(By.xpath("//div[@title='" + email + "']/parent::div/parent::div/div[2]/div[2]/button[contains(.,'Click here to add new role…')]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addRole);

            Actions actions = new Actions(driver);
            actions.moveToElement(addRole);
            actions.click(addRole);
            actions.sendKeys(assignRole);
            actions.perform();
            Thread.sleep(2000);
            WebElement roleDropdownValueSelect = driver.findElement(By.xpath("//div[@title='" + assignRole + "']"));
            roleDropdownValueSelect.click();
//            verifyRoleAdded(email,assignRole);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
