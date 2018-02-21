 package helgalis.selfreview.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
 @Table(name="directors")
public class Director {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@ManyToMany
	@JoinTable(name="filmsdirectors",joinColumns=@JoinColumn(name="director_id"),
	inverseJoinColumns=@JoinColumn(name="film_id"))
	List<Film> films = new ArrayList<Film>();
	public Director() {
		
	}
	public Director(String name) {
		setName(name);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return getName();
	}
	@Override
	public boolean equals(Object obj) {
		return false;
	}
	@Override 
	public int hashCode() {
		return 0;
	}
}
