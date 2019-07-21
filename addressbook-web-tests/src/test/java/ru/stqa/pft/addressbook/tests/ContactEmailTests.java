package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {

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
  public void testContactEmails(){
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().contactInfoFromEditForm(contact);

    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getFirstEmail(), contact.getSecondEmail(), contact.getThirdEmail())
            .stream().filter((s) -> ! s.equals("")).map(ContactEmailTests::cleaned)
            .collect(Collectors.joining("\n"));
  }


  public static String cleaned(String email){
    return email.replaceAll("\\s", "");
  }
}