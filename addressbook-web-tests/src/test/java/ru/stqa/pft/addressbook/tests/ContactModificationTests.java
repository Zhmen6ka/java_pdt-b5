package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void insurePredictions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0){
      app.contact().create(new ContactData().withFirstname("Мирон").withLastname("Самойленко").
              withAddress("СПб, " + "Кузнечный переулок, д. 6, кв. 155").withMobilePhone("+79117654575").
              withFirstEmail("Myron.Sam@gmail.com").withSecondEmail("My_ron@yandex.ru")
              .withThirdEmail("Sam.Myron@mail.ru"). withGroup("Test3").withHomePhone("7053756").withWorkPhone("68989"));
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withFirstname("Миса").withLastname("Ушастая").
            withAddress("СПб, " + "Мискин дом, кв. 155").withMobilePhone("+79703478362")
            .withWorkPhone("5234").withHomePhone("33500").
                    withFirstEmail("Mysa_Durisa@gmail.com").withSecondEmail("Miss_Misa@yandex.ru")
            .withThirdEmail("Myssandeya@mail.ru").withGroup(null);
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo((before).without(modifiedContact).withAdded(contact)));
  }
}
