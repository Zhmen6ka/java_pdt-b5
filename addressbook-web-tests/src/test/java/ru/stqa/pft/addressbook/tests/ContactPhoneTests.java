package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void insurePredictions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0){
      app.contact().create(new ContactData().withFirstname("Мирон").withLastname("Самойленко").
              withAddress("СПб, " + "Кузнечный переулок, д. 6, кв. 155").withMobileNumber("+79117654575").
              withEmail("Myron.Sam@gmail.com").withGroup("Test3"));
    }
  }

  @Test
  public void TestContactPhones(){
    ContactData contact = app.contact().all().iterator().next();
    
  }
}
