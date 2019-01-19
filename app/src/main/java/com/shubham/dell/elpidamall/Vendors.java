package com.shubham.dell.elpidamall;

public class Vendors {

    private String vendor_name;
    private String firm_name;
    private String vendor_email;
    private String vendor_phone_no;
    private String vendor_address;
    private String vendor_turnover;
    private String business_start_date;
    private String selectedRadioButton;

    public Vendors() {
    }

    public Vendors(String vendor_name, String firm_name, String vendor_email, String vendor_phone_no, String vendor_address, String vendor_turnover, String business_start_date, String selectedRadioButton) {
        this.vendor_name = vendor_name;
        this.firm_name = firm_name;
        this.vendor_email = vendor_email;
        this.vendor_phone_no = vendor_phone_no;
        this.vendor_address = vendor_address;
        this.vendor_turnover = vendor_turnover;
        this.business_start_date = business_start_date;
        this.selectedRadioButton = selectedRadioButton;
    }

    public String getVendor_name() {
        return vendor_name;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    public String getFirm_name() {
        return firm_name;
    }

    public void setFirm_name(String firm_name) {
        this.firm_name = firm_name;
    }

    public String getVendor_email() {
        return vendor_email;
    }

    public void setVendor_email(String vendor_email) {
        this.vendor_email = vendor_email;
    }

    public String getVendor_phone_no() {
        return vendor_phone_no;
    }

    public void setVendor_phone_no(String vendor_phone_no) {
        this.vendor_phone_no = vendor_phone_no;
    }

    public String getVendor_address() {
        return vendor_address;
    }

    public void setVendor_address(String vendor_address) {
        this.vendor_address = vendor_address;
    }

    public String getVendor_turnover() {
        return vendor_turnover;
    }

    public void setVendor_turnover(String vendor_turnover) {
        this.vendor_turnover = vendor_turnover;
    }

    public String getBusiness_start_date() {
        return business_start_date;
    }

    public void setBusiness_start_date(String business_start_date) {
        this.business_start_date = business_start_date;
    }

    public String getRadioButtonText() {
        return selectedRadioButton;
    }

    public void setRadioButtonText(String radioButtonText) {
        this.selectedRadioButton = radioButtonText;
    }
}
