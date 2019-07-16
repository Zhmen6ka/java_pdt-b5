package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void insurePredictions() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0){
      app.contact().create(new ContactData().withFirstname("Мирон").
              withLastname("Самойленко").withAddress("СПб, " + "Кузнечный переулок, д. 6, кв. 155").
              withMobileNumber("+79117654575").withEmail("Myron.Sam@gmail.com").withGroup("test1"));
    }
  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.contact().list();
    int index = before.size() -1;
    ContactData contact = new ContactData().withId(before.get(index).getId()).withFirstname("Мирон").
            withLastname("Самойленко").withAddress("СПб, " + "Кузнечный переулок, д. 6, кв. 155").
            withMobileNumber("+79117654575").withEmail("Myron.Sam@gmail.com").withGroup(null);
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
