package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {
  @Test

  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Мирон", "Самойленко", "СПб, " +
              "Кузнечный переулок, д. 6, кв. 155","+79117654575", "Myron.Sam@gmail.com",
              "test3"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification(before.size() -1);
    ContactData contact = new ContactData(before.get(before.size() -1).getId(), "Евгения",
            "Иванова","СПб, улица Карбышева, д. 8, кв. 155", "+79129854565",
            "Zhmenka@gmail.com", null);
    app.getContactHelper().fillNewContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() -1);
    before.add(contact);
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
