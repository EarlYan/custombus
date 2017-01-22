package com.dzbs.bean.security;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 角色*/
@Entity  
@Table(name = "t_role") 
public class Role {
	
	@Id  
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;  
    
    private String code;  
      
    private String name;  
      
    @ManyToMany(targetEntity = Member.class,fetch = FetchType.EAGER, mappedBy = "roles")
    private Set<Member> members = new HashSet<Member>();
    
    public boolean equals(Object other) {
        if (this == other){
        	return true;
        }else {
        	return false;
        }

    }
    
    public int hashCode() {
        return this.id; //any primenumber 
    }
    /*******************SET GET METHOD***********************************************/
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public Set<Member> getMembers() {
		return members;
	}

	public void setMembers(Set<Member> members) {
		this.members = members;
	}

}
