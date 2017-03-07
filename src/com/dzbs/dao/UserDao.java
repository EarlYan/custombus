package com.dzbs.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;  
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;  
import org.springframework.transaction.annotation.Transactional;

import com.dzbs.bean.common.DriverVO;
import com.dzbs.bean.security.Member;
import com.dzbs.bean.security.Role;


@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/** 
     * 根据用户名查询用户 
     * @param username 
     * @return 
     */  
    @SuppressWarnings("unchecked")  
    public Member findUserByUserName(String username){   
        List<Member> result =  this.sessionFactory.getCurrentSession().createQuery("from Member e where e.username = \'" + username + "\'").list();  
        if(result != null && !result.isEmpty())      
            return result.get(0);  
        return null ;  
    }  
    
    /**
     * 根据手机号查询用户
     */
    @SuppressWarnings("unchecked")  
    public Member findUserByMobile(String mobile){  
        List<Member> result =  this.sessionFactory.getCurrentSession().createQuery("from Member e where e.mobile = \'" + mobile + "\'").list();  
        if(result != null && !result.isEmpty())      
            return result.get(0);  
        return null ;  
    }
    
    /**
     * 根据用户名和手机号查询用户信息
     */
    @SuppressWarnings("unchecked")  
    public Member findUserByUserNameAndMobile(String username,String mobile){  
        List<Member> result =  this.sessionFactory.getCurrentSession().createQuery("from Member e where e.username = \'" +username + "\' and e.mobile = \'" + mobile + "\'").list();  
        if(result != null && !result.isEmpty())      
            return result.get(0);  
        return null ;  
    }
    
    /**
     * 根据id查找用户
     */
    @SuppressWarnings("unchecked")  
    public Member findUserById(int id){
        List<Member> result =  this.sessionFactory.getCurrentSession().createQuery("from Member e where e.id = " + id).list();  
        if(result != null && !result.isEmpty())      
            return result.get(0);  
        return null ;  
    }
    
    /**
     * 根据用户角色查找用户
     */
    @SuppressWarnings("unchecked")  
    public List<Member> findUserByRole(String roleCode){
    	List<Member> rolemembers = new ArrayList<Member>();
    	List<Member> allmembers =  this.sessionFactory.getCurrentSession().createQuery("from Member").list();
    	for(Member member: allmembers){
    		Set<Role> mRoles = member.getRoles();
    		Iterator<Role> it = mRoles.iterator();
    		while(it.hasNext()){
    			Role role = it.next();
    			if(role.getCode().equalsIgnoreCase(roleCode)){
    				rolemembers.add(member);
    				break;
    			}
    		}
    	}
    	return rolemembers;
    }
  
    /** 
     * 根据用户名和密码查询用户 
     * @param username 
     * @param password 
     * @return 
     */  
    @SuppressWarnings("unchecked")  
    public Member findUserBuNameAndPwd(String username , String password){  
        List<Member> result =  this.sessionFactory.getCurrentSession().createQuery("from Member e where e.username = \'" + username + "\' and e.password = \'" + password + "\'").list();  
        if(result != null && !result.isEmpty())    
            return result.get(0);  
        return null ;  
    } 
    
    /** 
     * 根据用户名和密码查询用户 
     * @param username 
     * @param password 
     * @return 
     */  
    public List<Member> findRandomDriver(){ 
    	String sql="SELECT * FROM t_member t WHERE t.license = '1' ORDER BY RAND() LIMIT 4";
    	Query query=this.sessionFactory.getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(Member.class));
		@SuppressWarnings("unchecked")
		List<Member> temp = query.list();
		return temp;
    }
    
    /** 
     * 查询暂无路线的司机 
     * @param username 
     * @param password 
     * @return 
     */  
    public List<DriverVO> findFreeDriver(){ 
    	String sql= "SELECT"+
		    			" m.realname,"+
		    			" m.email,"+
		    			" m.mobile,"+
		    			" b.plate_number,"+
		    			" b.seat_number,"+
		    			" m.id"+
		    		" FROM"+
		    			" t_member m,"+
		    			" t_route t,"+
		    			" t_bus b"+
		    		" WHERE"+
		    			" not t.member_id = m.id"+
		    			" and m.license=1"+
		    			" and b.member_id = m.id";
    	Query query=this.sessionFactory.getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(DriverVO.class));
		@SuppressWarnings("unchecked")
		List<DriverVO> temp = query.list();
		return temp;
    } 
    
    /** 
     * 查询暂无路线的司机 
     * @param username 
     * @param password 
     * @return 
     */  
    @SuppressWarnings("unchecked")
	public List<DriverVO> findFreeDriver(Integer pageNo,Integer pageSize){ 
    	String sql= "SELECT"+
		    			" m.realname,"+
		    			" m.email,"+
		    			" m.mobile,"+
		    			" b.plate_number,"+
		    			" b.seat_number,"+
		    			" m.id"+
		    		" FROM"+
		    			" t_member m,"+
		    			" t_route t,"+
		    			" t_bus b"+
		    		" WHERE"+
		    			" not t.member_id = m.id"+
		    			" and m.license=1"+
		    			" and b.member_id = m.id";
    	Query query=this.sessionFactory.getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(DriverVO.class));
		if(pageSize != -1 && pageNo != -1) {
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		List<DriverVO> temp = query.list();
		return temp;
    } 
  
    /**
     * 注册用户
     * @param member
     */
    public void saveUser(Member member){
    	sessionFactory.getCurrentSession().saveOrUpdate(member);
    }
    
    /**
     * 更新用户信息
     * @param member
     */
    public void updateUser(Member member){
    	sessionFactory.getCurrentSession().update(member);
    	sessionFactory.getCurrentSession().flush();
    }
    
    /**
     * 查询角色
     * @param roleCode
     * @return
     */
    @SuppressWarnings("unchecked")  
    public Role findRoleByRoleCode(String roleCode){
    	List<Role> result = this.sessionFactory.getCurrentSession().createQuery("from Role e where e.code = \'" +  roleCode + "\'").list();
        if(result != null && !result.isEmpty())    
            return result.get(0);  
        return null ; 
    }
    
    /** 
     * 查询众筹用户信息
     * @param username 
     * @param password 
     * @return 
     */  
    @SuppressWarnings("unchecked")
	public List<Member> findCrowdFuningMembers(Integer property_id){ 
    	String sql= "SELECT"+
		    			" m.*"+	    			
		    		" FROM"+
			    		" t_member m,"+
			    		" t_propertycf p"+
		    		" WHERE"+
		    			" p.member_id = m.id"+
		    			" and p.property_id = :property_id";
    	Query query=this.sessionFactory.getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(Member.class));
		query.setInteger("property_id", property_id);
    	List<Member> temp = query.list();
		return temp;
    } 
    
    /** 
     * 查询众筹用户信息分页
     * @param username 
     * @param password 
     * @return 
     */  
    @SuppressWarnings("unchecked")
	public List<Member> findCrowdFuningMembers(Integer property_id,Integer pageNo,Integer pageSize){ 
    	String sql= "SELECT"+
		    			" m.*"+	    			
		    		" FROM"+
			    		" t_member m,"+
			    		" t_propertycf p"+
		    		" WHERE"+
		    			" p.member_id = m.id"+
		    			" and p.property_id = :property_id";
    	Query query=this.sessionFactory.getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(Member.class));
		query.setInteger("property_id", property_id);
    	if(pageSize != -1 && pageNo != -1) {
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
    	List<Member> temp = query.list();
		return temp;
    } 
}