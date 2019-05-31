package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {
  @Test

  public void testContactModification() {
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillNewContactForm(new ContactData("Евгения", "Иванова", "СПб, улица Карбышева, д. 8, кв. 155", "+79129854565", "Zhmenka@gmail.com"));
    app.getContactHelper().submitContactModification();
  }
}
