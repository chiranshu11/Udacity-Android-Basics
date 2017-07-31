package com.example.android.reportcard;

public class report_Card {
    public String subject_NAME1;
    public String Grade_Marks1;
	public String Standard1;
	public String NAME1;

    public report_Card(String Subject_M, String Grade_M,String STANDARDS,String name) {
        subject_NAME1 = Subject_M;
        Grade_Marks1 = Grade_M;
		STANDARD1 = STANDARDS;
		NAME1 = name;
    }

    public String getsubject_NAME() {
        return subject_NAME1;
    }

    public void setsubject_NAME(String subject_NAME2) {
        subject_NAME1 = subject_NAME2;
    }

    public String getGradeM() {
        return Grade_Marks1;
    }

    public void setGradeM(String grades_m) {
        Grade_Marks1 = grades_m;
    }
	public void getStandard(){
		return STANDARD1;
	}
	public void setStandard(String class_of){
		STANDARD1 = class_of;
	}
	public void getName(){
		return NAME1;
	}
	public void setName(String name_OF){
		NAME1 =  name_OF;
	}

    @Override
    public String toString() {
        return subject_NAME1 + "\n " + Grade_Marks1 + "\n " + STANDARD1 + " \n" + NAME1;
    }
}
