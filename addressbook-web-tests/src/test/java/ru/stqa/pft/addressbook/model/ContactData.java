package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {

  private int idEdit;
  private final String firstname;
  private final String lastname;
  private final String address;
  private final String mobileNumber;
  private final String email;
  private String group;

  public ContactData(String firstname, String lastname, String address, String mobileNumber,
                     String email, String group) {
    this.idEdit = 0;
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.mobileNumber = mobileNumber;
    this.email = email;
    this.group = group;
  }

  public ContactData(int idEdit, String firstname, String lastname, String address, String mobileNumber,
                     String email, String group) {
    this.idEdit = idEdit;
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.mobileNumber = mobileNumber;
    this.email = email;
    this.group = group;
  }

  public int getIdEdit() {
    return idEdit;
  }

  public void setIdEdit(int idEdit) {
    this.idEdit = idEdit;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "idEdit='" + idEdit + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return idEdit == that.idEdit &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idEdit, firstname, lastname);
  }

}
