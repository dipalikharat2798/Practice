package com.geico.adexpress.model;

public class FormDetails {
    String Description;
    String Form_Name;

    public FormDetails(String description, String form_Name) {
        Description = description;
        Form_Name = form_Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getForm_Name() {
        return Form_Name;
    }

    public void setForm_Name(String form_Name) {
        Form_Name = form_Name;
    }
}
