package com.noman.dialogues;

public class StudentModel {
    String id;
    String reg_no;
    String name;
    String created_at;

    public StudentModel() {
        this.id = "";
        this.reg_no = "";
        this.name = "";
        this.created_at = "";
    }

    public StudentModel(String id, String reg_no, String name, String created_at) {
        this.id = id;
        this.reg_no = reg_no;
        this.name = name;
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public String getReg_no() {
        return reg_no;
    }

    public String getName() {
        return name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
