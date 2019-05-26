package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    initCreationNewContact();
    fillNewContactForm(new ContactData("Мирон", "Самойленко", "СПб, Кузнечный переулок, д. 6, кв. 155", "+79117654575", "Myron.Sam@gmail.com"));
    submitContactCreation();
  }

}
