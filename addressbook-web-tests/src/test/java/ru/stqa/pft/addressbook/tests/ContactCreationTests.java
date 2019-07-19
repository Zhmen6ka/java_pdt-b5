package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() {
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/Myron.jpg");
    ContactData contact = new ContactData().withFirstname("Мирон").withLastname("Самойленко").
            withAddress("СПб, " + "Кузнечный переулок, д. 6, кв. 155").withMobilePhone("+79117654575")
            .withWorkPhone("877589").withHomePhone("56545657").
            withFirstEmail("Myron.Sam@gmail.com").withSecondEmail("My_ron@yandex.ru")
            .withThirdEmail("Sam.Myron@mail.ru").withGroup("Test3").withPhoto(photo);
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before
            .withAdded(contact.withId(after.stream().mapToInt(c -> c.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadContactCreation() {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Мирон'").withLastname("Самойленко").
            withAddress("СПб, " + "Кузнечный переулок, д. 6, кв. 155").withMobilePhone("+79117654575")
            .withWorkPhone("877589").withHomePhone("56545657").
                    withFirstEmail("Myron.Sam@gmail.com").withSecondEmail("My_ron@yandex.ru")
            .withThirdEmail("Sam.Myron@mail.ru").withGroup("Test3");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }

  /*
  @Test
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/Myron.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
  */
}
