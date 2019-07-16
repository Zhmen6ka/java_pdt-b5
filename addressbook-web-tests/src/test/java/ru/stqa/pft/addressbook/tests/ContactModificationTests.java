package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void insurePredictions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0){
      app.contact().create(new ContactData().withFirstname("Мирон").
              withLastname("Самойленко").withAddress("СПб, " + "Кузнечный переулок, д. 6, кв. 155").
              withMobileNumber("+79117654575").withEmail("Myron.Sam@gmail.com").withGroup("test1"));
    }
  }

  @Test
  public void testContactModification() {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Мирон").
            withLastname("Самойленко").withAddress("СПб, " + "Кузнечный переулок, д. 6, кв. 155").
            withMobileNumber("+79117654575").withEmail("Myron.Sam@gmail.com").withGroup(null);
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
