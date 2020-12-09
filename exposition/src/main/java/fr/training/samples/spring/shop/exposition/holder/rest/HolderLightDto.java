package fr.training.samples.spring.shop.exposition.holder.rest;

import java.io.Serializable;

public class HolderLightDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String account;
    private String name;
    private String mailAdress;

    /**
     * No-arg constructor for JavaBean tools
     */
    public HolderLightDto() {

    }

    /**
     * @param account
     * @param name
     * @param mailAdress
     */
    public HolderLightDto(String account, String name, String mailAdress) {
        this.account = account;
        this.name = name;
        this.mailAdress = mailAdress;
    }

    /**
     * @return the account
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the mailadress
     */
    public String getMailAdress() {
        return mailAdress;
    }

    /**
     * @param mailAdress the mailadress to set
     */
    public void setMailAdress(String mailAdress) {
        this.mailAdress = mailAdress;
    }
}
