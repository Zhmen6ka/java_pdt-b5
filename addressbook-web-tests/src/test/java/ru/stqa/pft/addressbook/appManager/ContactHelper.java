package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillNewContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobileNumber());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initCreationNewContact() {
    click(By.linkText("add new"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void closeDialogWindow() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification(int index) {
    wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
  }

  public void submitContactModification() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void createContact(ContactData contactData) {
    List<ContactData> before = getContactList();
    initCreationNewContact();
    fillNewContactForm(contactData, true);
    submitContactCreation();
    List<ContactData> after = getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    contactData.setId(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getId());
    before.add(contactData);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

  private int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, firstname, lastname, null, null, null,
              null);
      contacts.add(contact);
    }
    return contacts;
  }
}
