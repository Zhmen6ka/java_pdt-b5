package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    app.initCreationNewContact();
    app.fillNewContactForm(new ContactData("Мирон", "Самойленко", "СПб, Кузнечный переулок, д. 6, кв. 155", "+79117654575", "Myron.Sam@gmail.com"));
    app.submitContactCreation();
  }

}
