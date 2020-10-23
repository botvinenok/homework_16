package AccountData;

public class AccountBuilder {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String postcode;
    private String phoneMobile;
    private String alias;

    public AccountBuilder withFirstNameField(String firstName){
        this.firstName = firstName;
        return this;
    }

    public AccountBuilder withLastNameField(String lastName){
        this.lastName = lastName;
        return this;
    }

    public AccountBuilder withAddressField(String address){
        this.address = address;
        return this;
    }

    public AccountBuilder withCityField(String city){
        this.city = city;
        return this;
    }

    public AccountBuilder withPostcodeField(String postcode){
        this.postcode = postcode;
        return this;
    }

    public AccountBuilder withPhoneMobileField(String phoneMobile){
        this.phoneMobile = phoneMobile;
        return this;
    }

    public AccountBuilder withAliasField(String alias){
        this.alias = alias;
        return this;
    }

    public Account build(){
        return new Account(firstName, lastName, city, address, postcode, phoneMobile, alias);
    }

}
