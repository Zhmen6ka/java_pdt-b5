package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Мирон").withLastname("Самойленко").
            withAddress("СПб, " + "Кузнечный переулок, д. 6, кв. 155").withMobileNumber("+79117654575").
            withEmail("Myron.Sam@gmail.com").withGroup("test1");
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(before
            .withAdded(contact.withId(after.stream().mapToInt(c -> c.getId()).max().getAsInt()))));
  }
}
