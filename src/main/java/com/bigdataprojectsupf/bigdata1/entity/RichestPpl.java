package com.bigdataprojectsupf.bigdata1.entity;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "richestppl")
public class RichestPpl {
    @PrimaryKey("id")
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID id;
    private String name;
    private int age;
    private String country;
    private String industry;
    private String networth;
    private String source;
    
    
    public RichestPpl() {
    }

    public RichestPpl(String name, int age, String country, String industry, String networth, String source) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.age = age;
        this.country = country;
        this.industry = industry;
        this.networth = networth;
        this.source = source;
    }

    public RichestPpl(UUID id, String name, int age, String country, String industry, String networth, String source) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.country = country;
        this.industry = industry;
        this.networth = networth;
        this.source = source;
    }

    public UUID getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getIndustry() {
        return industry;
    }
    public void setIndustry(String industry) {
        this.industry = industry;
    }
    public String getNetworth() {
        return networth;
    }
    public void setNetworth(String networth) {
        this.networth = networth;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "RichestPpl [id=" + id + ", name=" + name + ", age=" + age + ", country=" + country + ", industry="
                + industry + ", networth=" + networth + ", source=" + source + "]";
    }
    
}
