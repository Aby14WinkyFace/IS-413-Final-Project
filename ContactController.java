package com.example.mvcfinal_2023;

public class ContactController implements Listener{

    private ContactView contactView;
    private ContactModel contactModel;
    public ContactController(ContactView contactView, ContactModel contactModel){
        this.contactView = contactView;
        this.contactModel = contactModel;
        //contactView.setListener(this);
        //contactView.start();

    }






    @Override
    public void entryEntered(String name, String phone, String email) {
        contactModel.changeName(name);
        contactModel.changePhone(phone);
        contactModel.changeEmail(email);
    }
}
