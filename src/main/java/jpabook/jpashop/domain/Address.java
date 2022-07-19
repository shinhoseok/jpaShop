package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;
//엔티티나 임베디드 타입은 기본생성자를 public 또는
//protected로 설정해야한다. 무분별한 new를 막기위해 protectd로 설정하는것이
//그나마 더 안전하다. JPA의 리플렉션을 위함
@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
