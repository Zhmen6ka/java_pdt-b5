package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


import java.util.List;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void insurePredictions() {
    app.goTo().homePage();
    if (! app.contact().isThereAContact()){
      app.contact().create(new ContactData().withFirstname("Мирон").withLastname("Самойленко").
              withAddress("СПб, " + "Кузнечный переулок, д. 6, кв. 155").withMobileNumber("+79117654575").
              withEmail("Myron.Sam@gmail.com").withGroup("test1"));
    }
  }

  @Test
  public void testContactDeletion() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }
}
