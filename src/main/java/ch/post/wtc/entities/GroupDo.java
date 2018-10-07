package ch.post.wtc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GroupDo {

	private int m_id;
	private String m_name;
	
	@Id
	@Column(name="GRP_ID",nullable=false )
	public int getId() {
		return m_id;
	}
	public void setId(int id) {
		m_id = id;
	}
	@Column(name="GRP_NAME",length=50,nullable=false)
	public String getName() {
		return m_name;
	}
	public void setName(String name) {
		m_name = name;
	}
	@Override
	public String toString() {
		return "GroupDo [m_id=" + m_id + ", m_name=" + m_name + "]";
	}
	
}
