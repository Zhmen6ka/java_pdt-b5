package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {
  @Test

  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Мирон", "Самойленко", "СПб, " +
              "Кузнечный переулок, д. 6, кв. 155","+79117654575", "Myron.Sam@gmail.com",
              "test3"));
    }
    int before = app.getGroupHelper().getGroupCount();
    app.getContactHelper().initContactModification(before -1);
    app.getContactHelper().fillNewContactForm(new ContactData("Евгения", "Иванова",
            "СПб, улица Карбышева, д. 8, кв. 155", "+79129854565",
            "Zhmenka@gmail.com", null), false);
    app.getContactHelper().submitContactModification();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before);
  }
}
