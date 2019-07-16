package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() {
    app.contact().create(new ContactData().withFirstname("Мирон").withLastname("Самойленко").
            withAddress("СПб, " + "Кузнечный переулок, д. 6, кв. 155").withMobileNumber("+79117654575").
            withEmail("Myron.Sam@gmail.com").withGroup("test1"));
  }

}
