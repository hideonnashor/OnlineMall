package org.onlinemall.domain;

public class Customer {

    private int customerId;
    private String customerResidence;
    private String customerPhone;
    private String customerIc;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerResidence() {
        return customerResidence;
    }

    public void setCustomerResidence(String customerResidence) {
        this.customerResidence = customerResidence;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerIc() {
        return customerIc;
    }

    public void setCustomerIc(String customerIc) {
        this.customerIc = customerIc;
    }
}
