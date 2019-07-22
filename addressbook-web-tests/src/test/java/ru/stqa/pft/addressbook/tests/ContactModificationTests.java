package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void insurePredictions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      File photo = new File("src/test/resources/Myron.jpg");
      app.contact().create(new ContactData().withFirstname("Мирон").withLastname("Самойленко").
              withAddress("СПб, " + "Кузнечный переулок, д. 6, кв. 155").withMobilePhone("+79117654575").
              withFirstEmail("Myron.Sam@gmail.com").withSecondEmail("My_ron@yandex.ru")
              .withThirdEmail("Sam.Myron@mail.ru").withHomePhone("7053756").withWorkPhone("68989")
              .withGroup("test 0").withPhoto(photo));
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    File photo = new File("src/test/resources/Myron.jpg");
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Миса").
            withLastname("Ушастая").withAddress("СПб, " + "Мискин дом, кв. 155").
            withMobilePhone("+79119654765").withFirstEmail("Myssandeya@gmail.com").withGroup(null);
    app.contact().modify(contact.withPhoto(photo));
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}
